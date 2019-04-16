package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;
import sif.dd.au30.model.AUCodeSetsPermissionCategoryCodeType;
import sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType;
import sif.dd.au30.model.PublishingPermissionType;
import sif3.hits.domain.model.PersonPicturePublishingPermission;

@Component
public class PersonPicturePublishingPermissionConverter extends HitsConverter<PublishingPermissionType, PersonPicturePublishingPermission> {

    public PersonPicturePublishingPermissionConverter() {
        super(PublishingPermissionType.class, PersonPicturePublishingPermission.class);
    }

    @Override
    public void toSifModel(PersonPicturePublishingPermission source, PublishingPermissionType target) {
        if (source != null && target != null) {
            target.setPermissionCategory(getEnumValue(source.getPermissionCategory(), AUCodeSetsPermissionCategoryCodeType.class));
            target.setPermissionValue(getEnumValue(source.getPermissionValue(), AUCodeSetsYesOrNoCategoryType.class));
        }
    }

    @Override
    public void toHitsModel(PublishingPermissionType source, PersonPicturePublishingPermission target) {
        if (source != null && target != null) {
            target.setPermissionCategory(getEnumValue(source.getPermissionCategory()));
            target.setPermissionValue(getEnumValue(source.getPermissionValue()));
        }
    }

}
