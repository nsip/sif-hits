package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.StaffAssignmentCollectionType;
import sif.dd.au30.model.StaffAssignmentType;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.StaffAssignmentConverter;
import sif3.hits.domain.dao.StaffAssignmentDAO;
import sif3.hits.domain.dao.ZoneFilterableRepository;
import sif3.hits.domain.model.StaffAssignment;

@Service
public class StaffAssignmentService extends
    BaseService<StaffAssignmentType, StaffAssignmentCollectionType, StaffAssignment> {

  @Autowired
  StaffAssignmentDAO staffAssignmentDAO;

  @Autowired
  StaffAssignmentConverter staffAssignmentConverter;

  @Override
  public JpaRepository<StaffAssignment, String> getDAO() {
    return staffAssignmentDAO;
  }

  @Override
  public ZoneFilterableRepository<StaffAssignment> getZoneFilterableDAO() {
    return staffAssignmentDAO;
  }

  @Override
  public HitsConverter<StaffAssignmentType, StaffAssignment> getConverter() {
    return staffAssignmentConverter;
  }

  @Override
  protected StaffAssignmentCollectionType getCollection(List<StaffAssignmentType> items) {
    StaffAssignmentCollectionType result = new StaffAssignmentCollectionType();
    if (items != null && !items.isEmpty()) {
      result.getStaffAssignment().addAll(items);
    }
    return result;
  }

  @Override
  protected StaffAssignment getFiltered(String refId, List<String> schoolRefIds) {
    StaffAssignment result = null;
    if (schoolRefIds != null && !schoolRefIds.isEmpty()) {
      result = staffAssignmentDAO.findOne(refId);
      if (result != null) {
        if (!schoolRefIds.contains(result.getSchoolInfoRefId())) {
          result = null;
        }
      }
    }
    return result;
  }
}
