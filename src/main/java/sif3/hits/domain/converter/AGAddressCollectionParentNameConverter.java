package sif3.hits.domain.converter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType;
import sif.dd.au30.model.NameOfRecordType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.AGAddressCollectionReportingParentName;
import sif3.hits.domain.model.FQBaseEntityContactName;

@Component
public class AGAddressCollectionParentNameConverter
		extends HitsConverter<NameOfRecordType, AGAddressCollectionReportingParentName> {

	public AGAddressCollectionParentNameConverter() {
		super(NameOfRecordType.class, AGAddressCollectionReportingParentName.class);
	}

	@Override
	public NameOfRecordType toSifModel(AGAddressCollectionReportingParentName source) {
		NameOfRecordType result = null;
		if (source != null && isPopulated(source)) {
			result = super.toSifModel(source);
		}
		return result;
	}

	@Override
	public void toSifModel(AGAddressCollectionReportingParentName source, NameOfRecordType target) {
		IObjectFactory objectFactory = getObjectFactory();
		target.setType(source.getNameType());
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
	public void toHitsModel(NameOfRecordType source, AGAddressCollectionReportingParentName target) {
		target.setNameType(source.getType());
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
		return source != null && (StringUtils.isNotBlank(source.getNameType())
				|| StringUtils.isNotBlank(source.getTitle()) || StringUtils.isNotBlank(source.getFamilyName())
				|| StringUtils.isNotBlank(source.getGivenName()) || StringUtils.isNotBlank(source.getMiddleName())
				|| StringUtils.isNotBlank(source.getFamilyNameFirst())
				|| StringUtils.isNotBlank(source.getPreferredFamilyName())
				|| StringUtils.isNotBlank(source.getPreferredFamilyNameFirst())
				|| StringUtils.isNotBlank(source.getPreferredGivenName()) || StringUtils.isNotBlank(source.getSuffix())
				|| StringUtils.isNotBlank(source.getFullName()));
	}

}
