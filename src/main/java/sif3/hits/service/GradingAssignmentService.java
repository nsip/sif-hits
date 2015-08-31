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
import sif3.hits.domain.dao.TeachingGroupDAO;
import sif3.hits.domain.dao.ZoneFilterableRepository;
import sif3.hits.domain.model.GradingAssignment;
import sif3.hits.rest.dto.RequestDTO;

@Service
public class GradingAssignmentService extends BaseService<GradingAssignmentType, GradingAssignmentCollectionType, GradingAssignment> {

  @Autowired
  private GradingAssignmentDAO gradingAssignmentDAO;
  
  @Autowired
  private GradingAssignmentConverter gradingAssignmentConverter;
  
  @Autowired
  private TeachingGroupDAO teachingGroupDAO;

  @Override
  public JpaRepository<GradingAssignment, String> getDAO() {
    return gradingAssignmentDAO;
  }

  @Override
  public ZoneFilterableRepository<GradingAssignment> getZoneFilterableDAO() {
    return gradingAssignmentDAO;
  }

  @Override
  public HitsConverter<GradingAssignmentType, GradingAssignment> getConverter() {
    return gradingAssignmentConverter;
  }

  @Override
  protected GradingAssignmentCollectionType getCollection(List<GradingAssignmentType> items) {
    GradingAssignmentCollectionType result = new GradingAssignmentCollectionType();
    if (items != null && !items.isEmpty()) {
      result.getGradingAssignment().addAll(items);
    }
    return result;
  }

  @Override
  protected GradingAssignment getFiltered(String refId, List<String> schoolRefIds) {
    GradingAssignment result = null;
    if (schoolRefIds != null && !schoolRefIds.isEmpty()) {
      result = gradingAssignmentDAO.findOneWithFilter(refId, schoolRefIds);
    }
    return result;
  }

  @Override
  protected void delete(GradingAssignment hitsObject, RequestDTO<GradingAssignmentType> dto) {
    deleteOtherIds(hitsObject);
    super.delete(hitsObject, dto);
  }

  private void deleteOtherIds(GradingAssignment hitsObject) {
    
  }
  
  @Override
  protected GradingAssignment save(GradingAssignment hitsObject, RequestDTO<GradingAssignmentType> dto, String zoneId,
      boolean create) {
    
    if (hitsObject.getTeachingGroup() != null && hitsObject.getTeachingGroup().getRefId() != null) {
      hitsObject.setTeachingGroup(teachingGroupDAO.findOneWithFilter(hitsObject.getTeachingGroup().getRefId(), getSchoolRefIds(zoneId)));
    }
    
    return super.save(hitsObject, dto, zoneId, create);
  }
}
