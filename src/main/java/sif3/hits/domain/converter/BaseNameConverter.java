package sif3.hits.domain.converter;

import org.apache.commons.lang3.StringUtils;

import sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType;
import sif.dd.au30.model.BaseNameType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.BaseNameOfRecord;

public abstract class BaseNameConverter<S extends BaseNameType, H extends BaseNameOfRecord>
		extends HitsConverter<S, H> {

	protected BaseNameConverter(Class<S> sifClass, Class<H> hitsClass) {
		super(sifClass, hitsClass);
	}

	@Override
	public void toSifModel(H source, S target) {
		IObjectFactory objectFactory = getObjectFactory();
		target.setTitle(objectFactory.createBaseNameTypeTitle(source.getTitle()));
		target.setFamilyName(objectFactory.createBaseNameTypeFamilyName(source.getFamilyName()));
		target.setGivenName(objectFactory.createBaseNameTypeGivenName(source.getGivenName()));
		target.setMiddleName(objectFactory.createBaseNameTypeMiddleName(source.getMiddleName()));
		target.setFamilyNameFirst(objectFactory.createBaseNameTypeFamilyNameFirst(
				getEnumValue(source.getFamilyNameFirst(), AUCodeSetsYesOrNoCategoryType.class)));
		target.setPreferredFamilyName(
				objectFactory.createBaseNameTypePreferredFamilyName(source.getPreferredFamilyName()));
		target.setPreferredFamilyNameFirst(objectFactory.createBaseNameTypePreferredFamilyNameFirst(
				getEnumValue(source.getPreferredFamilyNameFirst(), AUCodeSetsYesOrNoCategoryType.class)));
		target.setPreferredGivenName(
				objectFactory.createBaseNameTypePreferredGivenName(source.getPreferredGivenName()));
		target.setSuffix(objectFactory.createBaseNameTypeSuffix(source.getSuffix()));
		target.setFullName(objectFactory.createBaseNameTypeFullName(source.getFullName()));
	}

	@Override
	public void toHitsModel(S source, H target) {
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

	public static boolean isPopulated(BaseNameOfRecord source) {
		return source != null && (StringUtils.isNotBlank(source.getTitle())
				|| StringUtils.isNotBlank(source.getFamilyName()) || StringUtils.isNotBlank(source.getGivenName())
				|| StringUtils.isNotBlank(source.getMiddleName()) || StringUtils.isNotBlank(source.getFamilyNameFirst())
				|| StringUtils.isNotBlank(source.getPreferredFamilyName())
				|| StringUtils.isNotBlank(source.getPreferredFamilyNameFirst())
				|| StringUtils.isNotBlank(source.getPreferredGivenName()) || StringUtils.isNotBlank(source.getSuffix())
				|| StringUtils.isNotBlank(source.getFullName()));
	}

}
