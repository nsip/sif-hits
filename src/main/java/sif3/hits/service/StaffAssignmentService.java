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
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.dao.filter.StaffAssignmentFilterDAO;
import sif3.hits.domain.model.StaffAssignment;

@Service
public class StaffAssignmentService extends BaseService<StaffAssignmentType, StaffAssignmentCollectionType, StaffAssignment> {

  @Autowired
  private StaffAssignmentConverter staffAssignmentConverter;

  @Autowired
  private StaffAssignmentDAO staffAssignmentDAO;

  @Autowired
  private StaffAssignmentFilterDAO staffAssignmentFilterDAO;

  @Override
  protected StaffAssignmentCollectionType getCollection(List<StaffAssignmentType> items) {
    StaffAssignmentCollectionType result = new StaffAssignmentCollectionType();
    if (items != null && !items.isEmpty()) {
      result.getStaffAssignment().addAll(items);
    }
    return result;
  }

  @Override
  protected HitsConverter<StaffAssignmentType, StaffAssignment> getConverter() {
    return staffAssignmentConverter;
  }

  @Override
  protected JpaRepository<StaffAssignment, String> getDAO() {
    return staffAssignmentDAO;
  }

  @Override
  protected FilterableRepository<StaffAssignment,StaffAssignmentType> getFilterableDAO() {
    return staffAssignmentFilterDAO;
  }
}
