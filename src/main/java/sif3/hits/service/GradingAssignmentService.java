package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.GradingAssignmentCollectionType;
import sif.dd.au30.model.GradingAssignmentType;
import sif3.hits.domain.converter.GradingAssignmentConverter;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.dao.GradingAssignmentDAO;
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.dao.filter.GradingAssignmentFilterDAO;
import sif3.hits.domain.dao.filter.TeachingGroupFilterDAO;
import sif3.hits.domain.model.GradingAssignment;
import sif3.hits.rest.dto.RequestDTO;

@Service
public class GradingAssignmentService extends BaseService<GradingAssignmentType, GradingAssignmentCollectionType, GradingAssignment> {

  @Autowired
  private GradingAssignmentConverter gradingAssignmentConverter;

  @Autowired
  private GradingAssignmentDAO gradingAssignmentDAO;

  @Autowired
  private GradingAssignmentFilterDAO gradingAssignmentFilterDAO;

  @Autowired
  private TeachingGroupFilterDAO teachingGroupFilterDAO;

  @Override
  protected GradingAssignmentCollectionType getCollection(List<GradingAssignmentType> items) {
    GradingAssignmentCollectionType result = new GradingAssignmentCollectionType();
    if (items != null && !items.isEmpty()) {
      result.getGradingAssignment().addAll(items);
    }
    return result;
  }

  @Override
  protected HitsConverter<GradingAssignmentType, GradingAssignment> getConverter() {
    return gradingAssignmentConverter;
  }

  @Override
  protected JpaRepository<GradingAssignment, String> getDAO() {
    return gradingAssignmentDAO;
  }

  @Override
  protected FilterableRepository<GradingAssignment> getFilterableDAO() {
    return gradingAssignmentFilterDAO;
  }
  
  @Override
  protected boolean hasChildObjects(GradingAssignment hitsObject) {
    return true;
  }
  
  @Override
  protected GradingAssignment saveWithChildObjects(GradingAssignment hitsObject, RequestDTO<GradingAssignmentType> dto, String zoneId, boolean create) {
    if (hitsObject != null && hitsObject.getTeachingGroup() != null && hitsObject.getTeachingGroup().getRefId() != null) {
      hitsObject.setTeachingGroup(teachingGroupFilterDAO.findOneWithZone(hitsObject.getTeachingGroup().getRefId(),zoneId));
    }
    return super.saveWithChildObjects(hitsObject, dto, zoneId, create);
  }
}