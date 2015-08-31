package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.GradingAssignmentScoreCollectionType;
import sif.dd.au30.model.GradingAssignmentScoreType;
import sif3.hits.domain.converter.GradingAssignmentScoreConverter;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.dao.GradingAssignmentScoreDAO;
import sif3.hits.domain.dao.StudentPersonalDAO;
import sif3.hits.domain.dao.TeachingGroupDAO;
import sif3.hits.domain.dao.ZoneFilterableRepository;
import sif3.hits.domain.model.GradingAssignmentScore;
import sif3.hits.rest.dto.RequestDTO;

@Service
public class GradingAssignmentScoreService extends BaseService<GradingAssignmentScoreType, GradingAssignmentScoreCollectionType, GradingAssignmentScore> {

  @Autowired
  private GradingAssignmentScoreDAO gradingAssignmentDAO;
  
  @Autowired
  private GradingAssignmentScoreConverter gradingAssignmentConverter;
  
  @Autowired
  private TeachingGroupDAO teachingGroupDAO;

  @Autowired
  private StudentPersonalDAO studentPersonalDAO;
  
  @Override
  public JpaRepository<GradingAssignmentScore, String> getDAO() {
    return gradingAssignmentDAO;
  }

  @Override
  public ZoneFilterableRepository<GradingAssignmentScore> getZoneFilterableDAO() {
    return gradingAssignmentDAO;
  }

  @Override
  public HitsConverter<GradingAssignmentScoreType, GradingAssignmentScore> getConverter() {
    return gradingAssignmentConverter;
  }

  @Override
  protected GradingAssignmentScoreCollectionType getCollection(List<GradingAssignmentScoreType> items) {
    GradingAssignmentScoreCollectionType result = new GradingAssignmentScoreCollectionType();
    if (items != null && !items.isEmpty()) {
      result.getGradingAssignmentScore().addAll(items);
    }
    return result;
  }

  @Override
  protected GradingAssignmentScore getFiltered(String refId, List<String> schoolRefIds) {
    GradingAssignmentScore result = null;
    if (schoolRefIds != null && !schoolRefIds.isEmpty()) {
      result = gradingAssignmentDAO.findOneWithFilter(refId, schoolRefIds);
    }
    return result;
  }

  @Override
  protected void delete(GradingAssignmentScore hitsObject, RequestDTO<GradingAssignmentScoreType> dto) {
    deleteOtherIds(hitsObject);
    super.delete(hitsObject, dto);
  }

  private void deleteOtherIds(GradingAssignmentScore hitsObject) {
    
  }
  
  @Override
  protected GradingAssignmentScore save(GradingAssignmentScore hitsObject, RequestDTO<GradingAssignmentScoreType> dto, String zoneId,
      boolean create) {
    
    if (hitsObject.getTeachingGroup() != null && hitsObject.getTeachingGroup().getRefId() != null) {
      hitsObject.setTeachingGroup(teachingGroupDAO.findOneWithFilter(hitsObject.getTeachingGroup().getRefId(), getSchoolRefIds(zoneId)));
    } else {
      hitsObject.setTeachingGroup(null);
    }
    if (hitsObject.getStudentPersonal() != null && hitsObject.getStudentPersonal().getRefId() != null) {
      hitsObject.setStudentPersonal(studentPersonalDAO.findOneWithFilter(hitsObject.getStudentPersonal().getRefId(), getSchoolRefIds(zoneId)));
    } else {
      hitsObject.setStudentPersonal(null);
    }
    return super.save(hitsObject, dto, zoneId, create);
  }
}
