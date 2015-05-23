package sif3.hits.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.StaffCollectionType;
import sif.dd.au30.model.StaffPersonalType;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.StaffPersonalConverter;
import sif3.hits.domain.dao.StaffPersonalDAO;
import sif3.hits.domain.dao.StaffPersonalOtherIdDAO;
import sif3.hits.domain.dao.ZoneFilterableRepository;
import sif3.hits.domain.model.StaffPersonal;
import sif3.hits.domain.model.StaffPersonalOtherId;
import sif3.hits.rest.dto.RequestDTO;

@Service
public class StaffPersonalService extends BaseService<StaffPersonalType, StaffCollectionType, StaffPersonal> {

  @Autowired
  private StaffPersonalDAO staffPersonalDAO;

  @Autowired
  private StaffPersonalOtherIdDAO staffPersonalOtherIdDAO;

  @Autowired
  private StaffPersonalConverter staffPersonalConverter;

  @Override
  public JpaRepository<StaffPersonal, String> getDAO() {
    return staffPersonalDAO;
  }

  @Override
  public ZoneFilterableRepository<StaffPersonal> getZoneFilterableDAO() {
    return staffPersonalDAO;
  }

  @Override
  public HitsConverter<StaffPersonalType, StaffPersonal> getConverter() {
    return staffPersonalConverter;
  }

  @Override
  protected StaffCollectionType getCollection(List<StaffPersonalType> items) {
    StaffCollectionType result = new StaffCollectionType();
    if (items != null && !items.isEmpty()) {
      result.getStaffPersonal().addAll(items);
    }
    return result;
  }

  @Override
  protected StaffPersonal getFiltered(String refId, List<String> schoolRefIds) {
    StaffPersonal result = null;
    if (schoolRefIds != null && !schoolRefIds.isEmpty()) {
      result = staffPersonalDAO.findOneWithFilter(refId, schoolRefIds);
    }
    return result;
  }

  @Override
  protected void delete(StaffPersonal hitsObject, RequestDTO<StaffPersonalType> dto) {
    deleteOtherIds(hitsObject);
    super.delete(hitsObject, dto);
  }

  private void deleteOtherIds(StaffPersonal hitsObject) {
    staffPersonalOtherIdDAO.deleteAllWithStaffPersonal(hitsObject);
  }

  @Override
  protected StaffPersonal save(StaffPersonal hitsObject, RequestDTO<StaffPersonalType> dto, String zoneId,
      boolean create) {
    StaffPersonal result = null;
    if (!create) {
      deleteOtherIds(hitsObject);
    }
    if (hitsObject.getOtherIds() != null && hitsObject.getOtherIds().size() > 0) {
      Set<StaffPersonalOtherId> otherIds = new HashSet<StaffPersonalOtherId>();
      otherIds.addAll(hitsObject.getOtherIds());
      hitsObject.getOtherIds().clear();
      result = super.save(hitsObject, dto, zoneId, create);
      for (StaffPersonalOtherId otherId : otherIds) {
        otherId.setStaffPersonal(hitsObject);
        staffPersonalOtherIdDAO.save(otherId);
      }
      result.setOtherIds(otherIds);
    } else {
      result = super.save(hitsObject, dto, zoneId, create);
    }
    return result;
  }
}
