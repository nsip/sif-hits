package sif3.hits.domain.converter;

import org.apache.commons.lang3.StringUtils;

import sif.dd.au30.model.AUCodeSetsNameUsageTypeType;
import sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType;
import sif.dd.au30.model.NameType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.FQBaseEntityContactName;

public abstract class FQBaseEntityContactNameConverter<E extends FQBaseEntityContactName> extends HitsConverter<NameType, E> {

    public FQBaseEntityContactNameConverter(Class<E> modelClass) {
        super(NameType.class, modelClass);
    }

    @Override
    public NameType toSifModel(E source) {
        NameType result = null;
        if (source != null && isPopulated(source)) {
            result = super.toSifModel(source);
        }
        return result;
    }

    @Override
    public void toSifModel(E source, NameType target) {
        IObjectFactory objectFactory = getObjectFactory();
        target.setType(getEnumValue(source.getNameType(), AUCodeSetsNameUsageTypeType.class));
        target.setTitle(objectFactory.createBaseNameTypeTitle(source.getTitle()));
        target.setFamilyName(objectFactory.createBaseNameTypeFamilyName(source.getFamilyName()));
        target.setGivenName(objectFactory.createBaseNameTypeGivenName(source.getGivenName()));
        target.setMiddleName(objectFactory.createBaseNameTypeMiddleName(source.getMiddleName()));
        target.setFamilyNameFirst(objectFactory.createBaseNameTypeFamilyNameFirst(getEnumValue(source.getFamilyNameFirst(), AUCodeSetsYesOrNoCategoryType.class)));
        target.setPreferredFamilyName(objectFactory.createBaseNameTypePreferredFamilyName(source.getPreferredFamilyName()));
        target.setPreferredFamilyNameFirst(
                objectFactory.createBaseNameTypePreferredFamilyNameFirst(getEnumValue(source.getPreferredFamilyNameFirst(), AUCodeSetsYesOrNoCategoryType.class)));
        target.setPreferredGivenName(objectFactory.createBaseNameTypePreferredGivenName(source.getPreferredGivenName()));
        target.setSuffix(objectFactory.createBaseNameTypeSuffix(source.getSuffix()));
        target.setFullName(objectFactory.createBaseNameTypeFullName(source.getFullName()));
    }

    @Override
    public void toHitsModel(NameType source, E target) {
        target.setNameType(getEnumValue(source.getType()));
        target.setTitle(getJAXBValue(source.getTitle()));
        target.setFamilyName(getJAXBValue(source.getFamilyName()));
        target.setGivenName(getJAXBValue(source.getGivenName()));
        target.setMiddleName(getJAXBValue(source.getMiddleName()));
        target.setFamilyNameFirst(getJAXBEnumValue(source.getFamilyNameFirst()));
        target.setPreferredFamilyName(getJAXBValue(source.getPreferredFamilyName()));
        target.setPreferredFamilyNameFirst(getJAXBEnumValue(source.getPreferredFamilyNameFirst()));
        target.setPreferredGivenName(getJAXBValue(source.getPreferredGivenName()));
        target.setSuffix(getJAXBValue(source.getSuffix()));
        target.setFullName(getJAXBValue(source.getFullName()));
    }

    public static boolean isPopulated(FQBaseEntityContactName source) {
        return source != null && (StringUtils.isNotBlank(source.getNameType()) || StringUtils.isNotBlank(source.getTitle()) || StringUtils.isNotBlank(source.getFamilyName())
                || StringUtils.isNotBlank(source.getGivenName()) || StringUtils.isNotBlank(source.getMiddleName()) || StringUtils.isNotBlank(source.getFamilyNameFirst())
                || StringUtils.isNotBlank(source.getPreferredFamilyName()) || StringUtils.isNotBlank(source.getPreferredFamilyNameFirst())
                || StringUtils.isNotBlank(source.getPreferredGivenName()) || StringUtils.isNotBlank(source.getSuffix()) || StringUtils.isNotBlank(source.getFullName()));
    }

}
