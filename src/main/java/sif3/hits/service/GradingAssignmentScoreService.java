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
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.dao.filter.GradingAssignmentScoreFilterDAO;
import sif3.hits.domain.dao.filter.StudentPersonalFilterDAO;
import sif3.hits.domain.dao.filter.TeachingGroupFilterDAO;
import sif3.hits.domain.model.GradingAssignmentScore;
import sif3.hits.rest.dto.RequestDTO;

@Service
public class GradingAssignmentScoreService extends BaseService<GradingAssignmentScoreType, GradingAssignmentScoreCollectionType, GradingAssignmentScore> {

  @Autowired
  private GradingAssignmentScoreConverter gradingAssignmentConverter;

  @Autowired
  private GradingAssignmentScoreDAO gradingAssignmentScoreDAO;

  @Autowired
  private GradingAssignmentScoreFilterDAO gradingAssignmentScoreFilterDAO;

  @Autowired
  private StudentPersonalFilterDAO studentPersonalFilterDAO;

  @Autowired
  private TeachingGroupFilterDAO teachingGroupFilterDAO;

  @Override
  protected GradingAssignmentScoreCollectionType getCollection(List<GradingAssignmentScoreType> items) {
    GradingAssignmentScoreCollectionType result = new GradingAssignmentScoreCollectionType();
    if (items != null && !items.isEmpty()) {
      result.getGradingAssignmentScore().addAll(items);
    }
    return result;
  }

  @Override
  protected HitsConverter<GradingAssignmentScoreType, GradingAssignmentScore> getConverter() {
    return gradingAssignmentConverter;
  }

  @Override
  protected JpaRepository<GradingAssignmentScore, String> getDAO() {
    return gradingAssignmentScoreDAO;
  }

  @Override
  protected FilterableRepository<GradingAssignmentScore,GradingAssignmentScoreType> getFilterableDAO() {
    return gradingAssignmentScoreFilterDAO;
  }
  
  @Override
  protected boolean hasChildObjects(GradingAssignmentScore hitsObject) {
    return true;
  }
  
  @Override
  protected GradingAssignmentScore saveWithChildObjects(GradingAssignmentScore hitsObject, RequestDTO<GradingAssignmentScoreType> dto, String zoneId, boolean create) {
    if (hitsObject.getTeachingGroup() != null && hitsObject.getTeachingGroup().getRefId() != null) {
      hitsObject.setTeachingGroup(teachingGroupFilterDAO.findOneWithZone(hitsObject.getTeachingGroup().getRefId(), zoneId));
    } else {
      hitsObject.setTeachingGroup(null);
    }
    if (hitsObject.getStudentPersonal() != null && hitsObject.getStudentPersonal().getRefId() != null) {
      hitsObject.setStudentPersonal(studentPersonalFilterDAO.findOneWithZone(hitsObject.getStudentPersonal().getRefId(), zoneId));
    } else {
      hitsObject.setStudentPersonal(null);
    }
    return super.saveWithChildObjects(hitsObject, dto, zoneId, create);
  }
}
