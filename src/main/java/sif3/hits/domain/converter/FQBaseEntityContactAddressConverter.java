package sif3.hits.domain.converter;

import org.apache.commons.lang3.StringUtils;

import sif.dd.au30.model.AUCodeSetsAddressRoleType;
import sif.dd.au30.model.AUCodeSetsAddressTypeType;
import sif.dd.au30.model.AUCodeSetsStandardAustralianClassificationOfCountriesSACCType;
import sif.dd.au30.model.AddressStreetType;
import sif.dd.au30.model.AddressType;
import sif.dd.au30.model.GridLocationType;
import sif.dd.au30.model.MapReferenceType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.FQBaseEntityContactAddress;

public abstract class FQBaseEntityContactAddressConverter<E extends FQBaseEntityContactAddress>
		extends HitsConverter<AddressType, E> {

	public FQBaseEntityContactAddressConverter(Class<E> modelClass) {
		super(AddressType.class, modelClass);
	}

	@Override
	public AddressType toSifModel(E source) {
		AddressType result = null;
		if (isPopulated(source)) {
			result = super.toSifModel(source);
		}
		return result;
	}

	@Override
	public void toSifModel(E source, AddressType target) {
		IObjectFactory objectFactory = getObjectFactory();

		target.setType(getEnumValue(source.getAddressType(), AUCodeSetsAddressTypeType.class));
		target.setRole(getEnumValue(source.getAddressRole(), AUCodeSetsAddressRoleType.class));
		target.setEffectiveFromDate(
				objectFactory.createAddressTypeEffectiveFromDate(getDateValue(source.getEffectiveFromDate())));
		target.setEffectiveToDate(
				objectFactory.createAddressTypeEffectiveToDate(getDateValue(source.getEffectiveToDate())));
		if (isStreetPopulated(source)) {
			AddressStreetType street = objectFactory.createAddressStreetType();
			street.setLine1(objectFactory.createAddressStreetTypeLine1(source.getStreetLine1()));
			street.setLine2(objectFactory.createAddressStreetTypeLine2(source.getStreetLine2()));
			street.setLine3(objectFactory.createAddressStreetTypeLine3(source.getStreetLine3()));
			street.setComplex(objectFactory.createAddressStreetTypeComplex(source.getStreetComplex()));
			street.setStreetNumber(objectFactory.createAddressStreetTypeStreetNumber(source.getStreetStreetNumber()));
			street.setStreetPrefix(objectFactory.createAddressStreetTypeStreetPrefix(source.getStreetStreetPrefix()));
			street.setStreetName(objectFactory.createAddressStreetTypeStreetName(source.getStreetStreetName()));
			street.setStreetType(objectFactory.createAddressStreetTypeStreetType(source.getStreetStreetType()));
			street.setStreetSuffix(objectFactory.createAddressStreetTypeStreetSuffix(source.getStreetStreetSuffix()));
			street.setApartmentType(
					objectFactory.createAddressStreetTypeApartmentType(source.getStreetApartmentType()));
			street.setApartmentNumberPrefix(objectFactory
					.createAddressStreetTypeApartmentNumberPrefix(source.getStreetApartmentNumberPrefix()));
			street.setApartmentNumber(
					objectFactory.createAddressStreetTypeApartmentNumber(source.getStreetApartmentNumber()));
			street.setApartmentNumberSuffix(objectFactory
					.createAddressStreetTypeApartmentNumberSuffix(source.getStreetApartmentNumberSuffix()));
			target.setStreet(street);
		}

		target.setCity(source.getCity());
		target.setStateProvince(objectFactory.createAddressTypeStateProvince(source.getStateProvince()));
		target.setCountry(objectFactory.createAddressTypeCountry(getEnumValue(source.getCountry(),
				AUCodeSetsStandardAustralianClassificationOfCountriesSACCType.class)));
		target.setPostalCode(source.getPostalCode());
		if (StringUtils.isNotBlank(source.getGridLocationLatitude())
				|| StringUtils.isNotBlank(source.getGridLocationLongitude())) {
			GridLocationType gridLocation = objectFactory.createGridLocationType();
			gridLocation.setLatitude(getBigDecimalValue(source.getGridLocationLatitude()));
			gridLocation.setLongitude(getBigDecimalValue(source.getGridLocationLongitude()));
			target.setGridLocation(objectFactory.createAddressTypeGridLocation(gridLocation));
		}
		if (StringUtils.isNotBlank(source.getMapReferenceXCoordinate())
				|| StringUtils.isNotBlank(source.getMapReferenceYCoordinate())) {
			MapReferenceType mapReferenceType = objectFactory.createMapReferenceType();
			mapReferenceType.setType(source.getMapReferenceType());
			mapReferenceType.setXCoordinate(source.getMapReferenceXCoordinate());
			mapReferenceType.setYCoordinate(source.getMapReferenceYCoordinate());
			mapReferenceType
					.setMapNumber(objectFactory.createMapReferenceTypeMapNumber(source.getMapReferenceMapNumber()));
			target.setMapReference(objectFactory.createAddressTypeMapReference(mapReferenceType));
		}
		target.setRadioContact(objectFactory.createAddressTypeRadioContact(source.getRadioContact()));
		target.setCommunity(objectFactory.createAddressTypeCommunity(source.getCommunity()));
		target.setLocalId(objectFactory.createAddressTypeLocalId(source.getLocalId()));
		target.setAddressGlobalUID(objectFactory.createAddressTypeAddressGlobalUID(source.getAddressGlobalUID()));
	}

	@Override
	public void toHitsModel(AddressType source, E target) {
		target.setAddressType(getEnumValue(source.getType()));
		target.setAddressRole(getEnumValue(source.getRole()));
		target.setEffectiveFromDate(getDateValue(getJAXBValue(source.getEffectiveFromDate())));
		target.setEffectiveToDate(getDateValue(getJAXBValue(source.getEffectiveToDate())));

		AddressStreetType street = source.getStreet();
		if (street != null) {
			target.setStreetLine1(getJAXBValue(street.getLine1()));
			target.setStreetLine2(getJAXBValue(street.getLine2()));
			target.setStreetLine3(getJAXBValue(street.getLine3()));
			target.setStreetComplex(getJAXBValue(street.getComplex()));
			target.setStreetStreetNumber(getJAXBValue(street.getStreetNumber()));
			target.setStreetStreetPrefix(getJAXBValue(street.getStreetPrefix()));
			target.setStreetStreetName(getJAXBValue(street.getStreetName()));
			target.setStreetStreetType(getJAXBValue(street.getStreetType()));
			target.setStreetStreetSuffix(getJAXBValue(street.getStreetSuffix()));
			target.setStreetApartmentType(getJAXBValue(street.getApartmentType()));
			target.setStreetApartmentNumberPrefix(getJAXBValue(street.getApartmentNumberPrefix()));
			target.setStreetApartmentNumber(getJAXBValue(street.getApartmentNumber()));
			target.setStreetApartmentNumberSuffix(getJAXBValue(street.getApartmentNumberSuffix()));
		}
		target.setCity(source.getCity());
		target.setStateProvince(getJAXBValue(source.getStateProvince()));
		target.setCountry(getJAXBEnumValue(source.getCountry()));
		target.setPostalCode(source.getPostalCode());

		GridLocationType gridLocation = getJAXBValue(source.getGridLocation());
		if (gridLocation != null) {
			target.setGridLocationLatitude(getBigDecimalValue(gridLocation.getLatitude()));
			target.setGridLocationLongitude(getBigDecimalValue(gridLocation.getLongitude()));
		}

		MapReferenceType mapReference = getJAXBValue(source.getMapReference());
		if (mapReference != null) {
			target.setMapReferenceType(mapReference.getType());
			target.setMapReferenceXCoordinate(mapReference.getXCoordinate());
			target.setMapReferenceYCoordinate(mapReference.getYCoordinate());
			target.setMapReferenceMapNumber(getJAXBValue(mapReference.getMapNumber()));
		}
		target.setRadioContact(getJAXBValue(source.getRadioContact()));
		target.setCommunity(getJAXBValue(source.getCommunity()));
		target.setLocalId(getJAXBValue(source.getLocalId()));
		target.setAddressGlobalUID(getJAXBValue(source.getAddressGlobalUID()));
	}

	public static boolean isPopulated(FQBaseEntityContactAddress source) {
		return source != null && (StringUtils.isNotBlank(source.getEffectiveFromDate())
				|| StringUtils.isNotBlank(source.getEffectiveToDate()) || isStreetPopulated(source)
				|| StringUtils.isNotBlank(source.getCity()) || StringUtils.isNotBlank(source.getStateProvince())
				|| StringUtils.isNotBlank(source.getCountry())
				|| StringUtils.isNotBlank(source.getGridLocationLatitude())
				|| StringUtils.isNotBlank(source.getGridLocationLongitude())
				|| StringUtils.isNotBlank(source.getMapReferenceXCoordinate())
				|| StringUtils.isNotBlank(source.getMapReferenceYCoordinate())
				|| StringUtils.isNotBlank(source.getMapReferenceMapNumber())
				|| StringUtils.isNotBlank(source.getRadioContact()) || StringUtils.isNotBlank(source.getCommunity())
				|| StringUtils.isNotBlank(source.getLocalId()) || StringUtils.isNotBlank(source.getAddressGlobalUID())
				|| (source.getStatisticalAreas() != null && !source.getStatisticalAreas().isEmpty()));
	}

	private static boolean isStreetPopulated(FQBaseEntityContactAddress source) {
		return StringUtils.isNotBlank(source.getStreetLine1()) || StringUtils.isNotBlank(source.getStreetLine2())
				|| StringUtils.isNotBlank(source.getStreetLine3()) || StringUtils.isNotBlank(source.getStreetComplex())
				|| StringUtils.isNotBlank(source.getStreetStreetNumber())
				|| StringUtils.isNotBlank(source.getStreetStreetPrefix())
				|| StringUtils.isNotBlank(source.getStreetStreetName())
				|| StringUtils.isNotBlank(source.getStreetStreetType())
				|| StringUtils.isNotBlank(source.getStreetStreetSuffix())
				|| StringUtils.isNotBlank(source.getStreetApartmentType())
				|| StringUtils.isNotBlank(source.getStreetApartmentNumberPrefix())
				|| StringUtils.isNotBlank(source.getStreetApartmentNumber())
				|| StringUtils.isNotBlank(source.getStreetApartmentNumberSuffix());
	}

}
