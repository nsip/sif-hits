package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.StaffCollectionType;
import sif.dd.au30.model.StaffPersonalType;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.StaffPersonalConverter;
import sif3.hits.domain.dao.StaffPersonalDAO;
import sif3.hits.domain.dao.ZoneFilterableRepository;
import sif3.hits.domain.model.StaffPersonal;

@Service
public class StaffPersonalService extends BaseService<StaffPersonalType, StaffCollectionType, StaffPersonal> {

  @Autowired
  StaffPersonalDAO staffPersonalDAO;

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
      result = staffPersonalDAO.findOne(refId);
      if (result != null) {
        if (!schoolRefIds.contains(result.getSchoolInfoRefId())) {
          result = null;
        }
      }
    }
    return result;
  }
}
