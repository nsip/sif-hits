package sif3.hits.domain.converter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.GradingAssignmentType;
import sif3.hits.domain.converter.factory.ObjectFactory;
import sif3.hits.domain.model.GradingAssignment;
import sif3.hits.domain.model.TeachingGroup;

@Component
public class GradingAssignmentConverter extends HitsConverter<GradingAssignmentType, GradingAssignment> {

  public GradingAssignmentConverter() {
    super(GradingAssignmentType.class, GradingAssignment.class);
  }

  @Override
  public void toSifModel(GradingAssignment source, GradingAssignmentType target) {
    if (source != null && target != null) {
      ObjectFactory objectFactory = getObjectFactory();
      
      target.setRefId(source.getRefId());
      
      if (source.getTeachingGroup() != null) {
        target.setTeachingGroupRefId(objectFactory.createGradingAssignmentTypeTeachingGroupRefId(source.getTeachingGroup().getRefId()));
        
        if (source.getTeachingGroup().getSchoolInfo() != null) {
          target.setSchoolInfoRefId(objectFactory.createGradingAssignmentTypeSchoolInfoRefId(source.getTeachingGroup().getSchoolInfo().getRefId()));
        }
      }
      
      target.setGradingCategory(objectFactory.createGradingAssignmentTypeGradingCategory(source.getGradingCategory()));
      target.setDescription(source.getDescription());
      target.setPointsPossible(getLongValue(source.getPointsPossible()));
      target.setCreateDate(objectFactory.createGradingAssignmentTypeCreateDate(getDateValue(source.getCreateDate())));
      target.setDueDate(objectFactory.createGradingAssignmentTypeDueDate(getDateValue(source.getDueDate())));
      target.setWeight(objectFactory.createGradingAssignmentTypeWeight(getBigDecimalValue(source.getWeight())));
      target.setMaxAttemptsAllowed(objectFactory.createGradingAssignmentTypeMaxAttemptsAllowed(getBigIntegerValue(source.getMaxAttemptsAllowed())));
      target.setDetailedDescriptionURL(objectFactory.createGradingAssignmentTypeDetailedDescriptionURL(source.getDetailedDescriptionURL()));
    }
  }

  @Override
  public void toHitsModel(GradingAssignmentType source, GradingAssignment target) {
    if (source != null && target != null) {
      target.setRefId(source.getRefId());
      
      String teachingGroupRefId = getJAXBValue(source.getTeachingGroupRefId());
      if (StringUtils.isNotBlank(teachingGroupRefId)) {
        TeachingGroup teachingGroup = new TeachingGroup();
        teachingGroup.setRefId(teachingGroupRefId);
        target.setTeachingGroup(teachingGroup);
      }
      
      target.setGradingCategory(getJAXBValue(source.getGradingCategory()));
      target.setDescription(source.getDescription());
      target.setPointsPossible(getLongValue(source.getPointsPossible()));
      target.setCreateDate(getDateValue(getJAXBValue(source.getCreateDate())));
      target.setDueDate(getDateValue(getJAXBValue(source.getDueDate())));
      target.setWeight(getBigDecimalValue(getJAXBValue(source.getWeight())));
      target.setMaxAttemptsAllowed(getBigIntegerValue(getJAXBValue(source.getMaxAttemptsAllowed())));
      target.setDetailedDescriptionURL(getJAXBValue(source.getDetailedDescriptionURL()));
    }
  }
}
