package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.TeachingGroupType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.SchoolInfo;

@Component
public class TeachingGroupSchoolInfoConverter extends HitsConverter<TeachingGroupType, SchoolInfo> {

  public TeachingGroupSchoolInfoConverter() {
    super(null, SchoolInfo.class);
  }

  @Override
  public void toSifModel(SchoolInfo source, TeachingGroupType target) {
    if (source != null && target != null) {
      IObjectFactory objectFactory = getObjectFactory();
      target.setSchoolInfoRefId(objectFactory.createTeachingGroupTypeSchoolInfoRefId(source.getRefId()));
      target.setSchoolLocalId(objectFactory.createTeachingGroupTypeSchoolLocalId(source.getLocalId()));
    }
  }

  @Override
  public void toHitsModel(TeachingGroupType source, SchoolInfo target) {
    if (source != null && target != null) {
      target.setRefId(getJAXBValue(source.getSchoolInfoRefId()));
      target.setLocalId(getJAXBValue(source.getSchoolLocalId()));
    }
  }
}
