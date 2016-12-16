package sif3.hits.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.StaffPersonalCollectionType;
import sif.dd.au30.model.StaffPersonalType;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.StaffPersonalConverter;
import sif3.hits.domain.dao.StaffPersonalDAO;
import sif3.hits.domain.dao.StaffPersonalOtherIdDAO;
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.dao.filter.StaffPersonalFilterDAO;
import sif3.hits.domain.model.StaffPersonal;
import sif3.hits.domain.model.StaffPersonalOtherId;
import sif3.hits.rest.dto.RequestDTO;

@Service
public class StaffPersonalService extends BaseService<StaffPersonalType, StaffPersonalCollectionType, StaffPersonal> {

  @Autowired
  private StaffPersonalConverter staffPersonalConverter;

  @Autowired
  private StaffPersonalDAO staffPersonalDAO;

  @Autowired
  private StaffPersonalFilterDAO staffPersonalFilterDAO;

  @Autowired
  private StaffPersonalOtherIdDAO staffPersonalOtherIdDAO;

  @Override
  protected StaffPersonalCollectionType getCollection(List<StaffPersonalType> items) {
    StaffPersonalCollectionType result = new StaffPersonalCollectionType();
    if (items != null && !items.isEmpty()) {
      result.getStaffPersonal().addAll(items);
    }
    return result;
  }

  @Override
  protected HitsConverter<StaffPersonalType, StaffPersonal> getConverter() {
    return staffPersonalConverter;
  }

  @Override
  protected JpaRepository<StaffPersonal, String> getDAO() {
    return staffPersonalDAO;
  }

  @Override
  protected FilterableRepository<StaffPersonal> getFilterableDAO() {
    return staffPersonalFilterDAO;
  }

  @Override
  protected void deleteChildObjects(StaffPersonal hitsObject) {
    staffPersonalOtherIdDAO.deleteAllWithStaffPersonal(hitsObject);
  }

  @Override
  protected boolean hasChildObjects(StaffPersonal hitsObject) {
    return hitsObject != null && hitsObject.getOtherIds() != null && !hitsObject.getOtherIds().isEmpty();
  }

  @Override
  protected StaffPersonal saveWithChildObjects(StaffPersonal hitsObject, RequestDTO<StaffPersonalType> dto, String zoneId, boolean create) {
    StaffPersonal result = null;
    Set<StaffPersonalOtherId> otherIds = new HashSet<StaffPersonalOtherId>();
    otherIds.addAll(hitsObject.getOtherIds());
    hitsObject.getOtherIds().clear();
    result = super.saveWithChildObjects(hitsObject, dto, zoneId, create);
    for (StaffPersonalOtherId otherId : otherIds) {
      otherId.setStaffPersonal(hitsObject);
      staffPersonalOtherIdDAO.save(otherId);
    }
    result.setOtherIds(otherIds);
    return result;
  }
}
