package sif3.hits.domain.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.*;
import sif.dd.au30.model.PersonPictureType.ParentObjectRefId;
import sif.dd.au30.model.PersonPictureType.PictureSource;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.PersonPicture;
import sif3.hits.domain.model.PersonPicturePublishingPermission;
import sif3.hits.domain.model.StudentSchoolEnrollmentPublishingPermission;
import sif3.hits.utils.UsesConstants;

import java.util.ArrayList;

@Component
public class PersonPictureConverter extends HitsConverter<PersonPictureType, PersonPicture> implements UsesConstants {

    @Autowired
    PersonPicturePublishingPermissionConverter publishingPermissionConverter;

    public PersonPictureConverter() {
        super(PersonPictureType.class, PersonPicture.class);
    }

    @Override
    public void toSifModel(PersonPicture source, PersonPictureType target) {
        if (source != null && target != null) {
            IObjectFactory objectFactory = getObjectFactory();

            target.setRefId(source.getRefId());
            target.setSchoolYear(getYearValue(source.getSchoolYear()));
            target.setOKToPublish(objectFactory.createPersonPictureTypeOKToPublish(getEnumValue(source.getOkToPublish(), AUCodeSetsYesOrNoCategoryType.class)));

            if (source.getParentObjectRefId() != null && source.getParentObjectRefObject() != null) {
                ParentObjectRefId parentObjectRefId = new ParentObjectRefId();
                parentObjectRefId.setValue(source.getParentObjectRefId());
                parentObjectRefId.setSIFRefObject(source.getParentObjectRefObject());
                target.setParentObjectRefId(parentObjectRefId);
            }

            if (source.getPictureSource() != null || source.getPictureSourceType() != null) {
                PictureSource pictureSource = objectFactory.createPersonPictureTypePictureSource();
                pictureSource.setValue(source.getPictureSource());
                pictureSource.setType(getEnumValue(source.getPictureSourceType(), AUCodeSetsPictureSourceType.class));
                target.setPictureSource(pictureSource);
            }

            if (source.getPublishingPermissions() != null && !source.getPublishingPermissions().isEmpty()) {
                PublishingPermissionListType publishingPermissionListType = objectFactory.createPublishingPermissionListType();
                for (PersonPicturePublishingPermission publishingPermission : source.getPublishingPermissions()) {
                    publishingPermissionListType.getPublishingPermission().add(publishingPermissionConverter.toSifModel(publishingPermission));
                }
                target.setPublishingPermissionList(objectFactory.createStudentSchoolEnrollmentTypePublishingPermissionList(publishingPermissionListType));
            }
        }
    }

    @Override
    public void toHitsModel(PersonPictureType source, PersonPicture target) {
        if (source != null && target != null) {
            target.setRefId(source.getRefId());
            target.setSchoolYear(getYearValue(source.getSchoolYear()));
            target.setOkToPublish(getJAXBEnumValue(source.getOKToPublish()));

            ParentObjectRefId parentObject = source.getParentObjectRefId();
            if (parentObject != null) {
                target.setParentObjectRefId(parentObject.getValue());
                target.setParentObjectRefObject(parentObject.getSIFRefObject());
            } else {
                target.setParentObjectRefId(null);
                target.setParentObjectRefObject(null);
            }

            PictureSource pictureSource = source.getPictureSource();
            if (pictureSource != null) {
                target.setPictureSource(pictureSource.getValue());
                target.setPictureSourceType(getEnumValue(pictureSource.getType()));
            } else {
                target.setPictureSource(null);
                target.setPictureSourceType(null);
            }

            if (target.getPublishingPermissions() == null) target.setPublishingPermissions(new ArrayList<>());
            target.getPublishingPermissions().clear();

            PublishingPermissionListType publishingPermissionList = getJAXBValue(source.getPublishingPermissionList());
            if (publishingPermissionList != null) {
                for (PublishingPermissionType publishingPermissionType : publishingPermissionList.getPublishingPermission()) {
                    PersonPicturePublishingPermission publishingPermission = publishingPermissionConverter.toHitsModel(publishingPermissionType);
                    publishingPermission.setPersonPicture(target);
                    target.getPublishingPermissions().add(publishingPermission);
                }
            }
        }
    }

}
