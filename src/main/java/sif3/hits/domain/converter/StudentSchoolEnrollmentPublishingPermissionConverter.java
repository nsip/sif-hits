package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.AUCodeSetsPermissionCategoryCodeType;
import sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType;
import sif.dd.au30.model.PublishingPermissionType;
import sif3.hits.domain.model.StudentSchoolEnrollmentPublishingPermission;

@Component
public class StudentSchoolEnrollmentPublishingPermissionConverter extends HitsConverter<PublishingPermissionType, StudentSchoolEnrollmentPublishingPermission> {

    public StudentSchoolEnrollmentPublishingPermissionConverter() {
        super(PublishingPermissionType.class, StudentSchoolEnrollmentPublishingPermission.class);
    }

    @Override
    public void toSifModel(StudentSchoolEnrollmentPublishingPermission source, PublishingPermissionType target) {
        if (source != null && target != null) {
            target.setPermissionCategory(getEnumValue(source.getPermissionCategory(), AUCodeSetsPermissionCategoryCodeType.class));
            target.setPermissionValue(getEnumValue(source.getPermissionValue(), AUCodeSetsYesOrNoCategoryType.class));
        }
    }

    @Override
    public void toHitsModel(PublishingPermissionType source, StudentSchoolEnrollmentPublishingPermission target) {
        if (source != null && target != null) {
            target.setPermissionCategory(getEnumValue(source.getPermissionCategory()));
            target.setPermissionValue(getEnumValue(source.getPermissionValue()));
        }
    }

}
