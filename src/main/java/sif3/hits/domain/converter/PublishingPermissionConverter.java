package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;
import sif.dd.au30.model.AUCodeSetsPermissionCategoryCodeType;
import sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType;
import sif.dd.au30.model.PublishingPermissionType;
import sif3.hits.domain.model.PublishingPermission;

@Component
public class PublishingPermissionConverter extends HitsConverter<PublishingPermissionType, PublishingPermission> {

    public PublishingPermissionConverter() {
        super(PublishingPermissionType.class, PublishingPermission.class);
    }

    @Override
    public void toSifModel(PublishingPermission source, PublishingPermissionType target) {
        if (source != null && target != null) {
            target.setPermissionCategory(getEnumValue(source.getPermissionCategory(), AUCodeSetsPermissionCategoryCodeType.class));
            target.setPermissionValue(getEnumValue(source.getPermissionValue(), AUCodeSetsYesOrNoCategoryType.class));
        }
    }

    @Override
    public void toHitsModel(PublishingPermissionType source, PublishingPermission target) {
        if (source != null && target != null) {
            target.setPermissionCategory(getEnumValue(source.getPermissionCategory()));
            target.getPermissionValue(getEnumValue(source.getPermissionValue());
        }
    }

}
