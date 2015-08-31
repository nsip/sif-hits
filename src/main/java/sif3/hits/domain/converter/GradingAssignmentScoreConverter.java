package sif3.hits.domain.converter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.GradingAssignmentScoreType;
import sif3.hits.domain.converter.factory.ObjectFactory;
import sif3.hits.domain.model.GradingAssignmentScore;
import sif3.hits.domain.model.StudentPersonal;
import sif3.hits.domain.model.TeachingGroup;

@Component
public class GradingAssignmentScoreConverter extends HitsConverter<GradingAssignmentScoreType, GradingAssignmentScore> {

  public GradingAssignmentScoreConverter() {
    super(GradingAssignmentScoreType.class, GradingAssignmentScore.class);
  }

  @Override
  public void toSifModel(GradingAssignmentScore source, GradingAssignmentScoreType target) {
    if (source != null && target != null) {
      ObjectFactory objectFactory = getObjectFactory();
      
      target.setRefId(source.getRefId());
      target.setGradingAssignmentRefId(source.getGradingAssignmentRefId());
      if (source.getTeachingGroup() != null) {
        target.setTeachingGroupRefId(objectFactory.createGradingAssignmentScoreTypeTeachingGroupRefId(source.getTeachingGroup().getRefId()));
        
        if (source.getTeachingGroup().getSchoolInfo() != null) {
          target.setSchoolInfoRefId(objectFactory.createGradingAssignmentScoreTypeSchoolInfoRefId(source.getTeachingGroup().getSchoolInfo().getRefId()));
        }
      }
      if (source.getStudentPersonal() != null) {
        target.setStudentPersonalLocalId(source.getStudentPersonal().getLocalId());
        target.setStudentPersonalRefId(objectFactory.createGradingAssignmentScoreTypeStudentPersonalRefId(source.getStudentPersonal().getRefId()));
      }
      
      target.setScorePoints(objectFactory.createGradingAssignmentScoreTypeScorePoints(getLongValue(source.getScorePoints())));
      target.setScorePercent(objectFactory.createGradingAssignmentScoreTypeScorePercent(getBigDecimalValue(source.getScorePercent())));
      target.setScoreLetter(objectFactory.createGradingAssignmentScoreTypeScoreLetter(source.getScoreLetter()));
      target.setScoreDescription(objectFactory.createGradingAssignmentScoreTypeScoreDescription(source.getScoreDescription()));
    }
  }

  @Override
  public void toHitsModel(GradingAssignmentScoreType source, GradingAssignmentScore target) {
    if (source != null && target != null) {
      target.setRefId(source.getRefId());
      target.setGradingAssignmentRefId(source.getGradingAssignmentRefId());
      String teachingGroupRefId = getJAXBValue(source.getTeachingGroupRefId());
      if (StringUtils.isNotBlank(teachingGroupRefId)) {
        TeachingGroup teachingGroup = new TeachingGroup();
        teachingGroup.setRefId(teachingGroupRefId);
        target.setTeachingGroup(teachingGroup);
      }
      String studentPersonalRefId = getJAXBValue(source.getStudentPersonalRefId());
      if (StringUtils.isNotBlank(studentPersonalRefId)) {
        StudentPersonal studentPersonal = new StudentPersonal();
        studentPersonal.setRefId(studentPersonalRefId);
        target.setStudentPersonal(studentPersonal);
      }
      
      target.setScorePoints(getLongValue(getJAXBValue(source.getScorePoints())));
      target.setScorePercent(getBigDecimalValue(getJAXBValue(source.getScorePercent())));
      target.setScoreLetter(getJAXBValue(source.getScoreLetter()));
      target.setScoreDescription(getJAXBValue(source.getScoreDescription()));
    }
  }
}
