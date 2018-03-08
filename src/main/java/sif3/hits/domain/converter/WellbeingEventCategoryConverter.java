package sif3.hits.domain.converter;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.WellbeingEventCategoryType;
import sif.dd.au30.model.WellbeingEventSubCategoryListType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.WellbeingEventCategory;
import sif3.hits.domain.model.WellbeingEventSubcategory;

@Component
public class WellbeingEventCategoryConverter extends HitsConverter<WellbeingEventCategoryType, WellbeingEventCategory> {
    public WellbeingEventCategoryConverter() {
        super(WellbeingEventCategoryType.class, WellbeingEventCategory.class);
    }

    @Override
    public void toSifModel(WellbeingEventCategory source, WellbeingEventCategoryType target) {
        if (source != null && target != null) {
            IObjectFactory objectFactory = getObjectFactory();
            target.setEventCategory(source.getEventCategory());
            if (source.getSubcategories() != null && !source.getSubcategories().isEmpty()) {
                List<String> subcategories = getSubCategories(source.getSubcategories());
                if (subcategories != null && !subcategories.isEmpty()) {
                    WellbeingEventSubCategoryListType subcategoryList = objectFactory.createWellbeingEventSubCategoryListType();
                    subcategoryList.getWellbeingEventSubCategory().addAll(subcategories);
                    target.setWellbeingEventSubCategoryList(objectFactory.createWellbeingEventCategoryTypeWellbeingEventSubCategoryList(subcategoryList));
                }
            }
        }
    }

    @Override
    public void toHitsModel(WellbeingEventCategoryType source, WellbeingEventCategory target) {
        if (source != null && target != null) {
            target.setEventCategory(source.getEventCategory());
            if (target.getSubcategories() == null) {
                target.setSubcategories(new ArrayList<WellbeingEventSubcategory>());
            }
            target.getSubcategories().clear();
            WellbeingEventSubCategoryListType subCategoryList = getJAXBValue(source.getWellbeingEventSubCategoryList());
            if (subCategoryList != null && !subCategoryList.getWellbeingEventSubCategory().isEmpty()) {
                for (String subCategory : subCategoryList.getWellbeingEventSubCategory()) {
                    if (StringUtils.isNotBlank(subCategory)) {
                        WellbeingEventSubcategory wellbeingEventSubcategory = new WellbeingEventSubcategory();
                        wellbeingEventSubcategory.setEventCategory(subCategory);
                        wellbeingEventSubcategory.setWellbeingEventCategory(target);
                        target.getSubcategories().add(wellbeingEventSubcategory);
                    }
                }
            }
        }
    }

    private List<String> getSubCategories(List<WellbeingEventSubcategory> subcategories) {
        List<String> result = null;
        if (subcategories != null) {
            result = new ArrayList<String>();
            for (WellbeingEventSubcategory subcategory : subcategories) {
                if (subcategory != null && StringUtils.isNotBlank(subcategory.getEventCategory())) {
                    result.add(subcategory.getEventCategory());
                }
            }
        }
        return result;
    }
}
