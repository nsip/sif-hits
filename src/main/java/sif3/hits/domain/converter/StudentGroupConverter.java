package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.AUCodeSetsGroupCategoryCodeType;
import sif.dd.au30.model.StudentGroupType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.StudentGroup;

@Component
public class StudentGroupConverter extends HitsConverter<StudentGroupType, StudentGroup> {

    public StudentGroupConverter() {
        super(StudentGroupType.class, StudentGroup.class);
    }

    @Override
    public void toSifModel(StudentGroup source, StudentGroupType target) {
        if (source != null && target != null) {
            IObjectFactory objectFactory = getObjectFactory();
            target.setGroupLocalId(source.getGroupLocalId());
            target.setGroupCategory(getEnumValue(source.getGroupCategory(), AUCodeSetsGroupCategoryCodeType.class));
            target.setGroupDescription(
                    objectFactory.createStudentGroupTypeGroupDescription(source.getGroupDescription()));
        }
    }

    @Override
    public void toHitsModel(StudentGroupType source, StudentGroup target) {
        if (source != null && target != null) {
            target.setGroupLocalId(source.getGroupLocalId());
            target.setGroupCategory(getEnumValue(source.getGroupCategory()));
            target.setGroupDescription(getJAXBValue(source.getGroupDescription()));
        }
    }

}
