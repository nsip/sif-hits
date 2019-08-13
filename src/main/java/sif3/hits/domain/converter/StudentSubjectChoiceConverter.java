package sif3.hits.domain.converter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import sif.dd.au30.model.StudentSubjectChoiceType;
import sif.dd.au30.model.SubjectAreaType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.StudentSubjectChoice;

@Component
public class StudentSubjectChoiceConverter extends HitsConverter<StudentSubjectChoiceType, StudentSubjectChoice> {

    public StudentSubjectChoiceConverter() {
        super(StudentSubjectChoiceType.class, StudentSubjectChoice.class);
    }

    @Override
    public void toSifModel(StudentSubjectChoice source, StudentSubjectChoiceType target) {
        if (source != null && target != null) {
            IObjectFactory objectFactory = getObjectFactory();
            target.setSubjectLocalId(source.getSubjectLocalId());
            target.setOtherSchoolLocalId(objectFactory.createStudentSubjectChoiceTypeOtherSchoolLocalId(source.getOtherSchoolLocalId()));
            target.setPreferenceNumber(objectFactory.createStudentSubjectChoiceTypePreferenceNumber(getLongValue(source.getPreferenceNumber())));

            if (StringUtils.isNotBlank(source.getStudyDescription())) {
                SubjectAreaType subjectAreaType = objectFactory.createSubjectAreaType();
                subjectAreaType.setCode(source.getStudyDescription());
                target.setStudyDescription(objectFactory.createStudentSubjectChoiceTypeStudyDescription(subjectAreaType));
            }
        }
    }

    @Override
    public void toHitsModel(StudentSubjectChoiceType source, StudentSubjectChoice target) {
        if (source != null && target != null) {
            target.setSubjectLocalId(source.getSubjectLocalId());
            target.setOtherSchoolLocalId(getJAXBValue(source.getOtherSchoolLocalId()));
            target.setPreferenceNumber(getLongValue(getJAXBValue(source.getPreferenceNumber())));

            SubjectAreaType subjectAreaType = getJAXBValue(source.getStudyDescription());
            if (subjectAreaType != null) {
                target.setStudyDescription(subjectAreaType.getCode());
            } else {
                target.setStudyDescription(null);
            }
        }
    }

}
