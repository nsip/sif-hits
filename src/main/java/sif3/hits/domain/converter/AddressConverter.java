package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.AUCodeSetsAddressRoleType;
import sif.dd.au30.model.AUCodeSetsAddressTypeType;
import sif.dd.au30.model.AddressStreetType;
import sif.dd.au30.model.AddressType;
import sif.dd.au30.model.GridLocationType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.Address;

@Component
public class AddressConverter extends HitsConverter<AddressType, Address> {

  public AddressConverter() {
    super(AddressType.class, Address.class);
  }

  @Override
  public void toSifModel(Address source, AddressType target) {
    if (source != null && target != null) {
      IObjectFactory objectFactory = getObjectFactory();

      target.setCity(source.getCity());
      target.setStateProvince(objectFactory.createAddressTypeStateProvince(source.getStateProvince()));
      target.setType(getEnumValue(source.getAddressType(), AUCodeSetsAddressTypeType.class));
      target.setRole(getEnumValue(source.getAddressRole(), AUCodeSetsAddressRoleType.class));
      target.setPostalCode(source.getPostalCode());

      AddressStreetType street = objectFactory.createAddressStreetType();
      street.setLine1(objectFactory.createAddressStreetTypeLine1(source.getLineOne()));
      street.setLine2(objectFactory.createAddressStreetTypeLine2(source.getLineTwo()));
      target.setStreet(street);

      if (source.getLatitude() != null || source.getLongitude() != null) {
        GridLocationType gridLocation = objectFactory.createGridLocationType();
        gridLocation.setLatitude(getBigDecimalValue(source.getLatitude()));
        gridLocation.setLongitude(getBigDecimalValue(source.getLongitude()));
        target.setGridLocation(objectFactory.createAddressTypeGridLocation(gridLocation));
      }
    }
  }

  @Override
  public void toHitsModel(AddressType source, Address target) {
    if (source != null && target != null) {

      target.setCity(source.getCity());
      target.setStateProvince(getJAXBValue(source.getStateProvince()));
      target.setAddressType(getEnumValue(source.getType()));
      target.setAddressRole(getEnumValue(source.getRole()));
      target.setPostalCode(source.getPostalCode());

      AddressStreetType street = source.getStreet();
      if (street != null) {
        target.setLineOne(getJAXBValue(street.getLine1()));
        target.setLineTwo(getJAXBValue(street.getLine2()));
      }

      GridLocationType gridLocation = getJAXBValue(source.getGridLocation());
      if (gridLocation != null) {
        target.setLatitude(getBigDecimalValue(gridLocation.getLatitude()));
        target.setLongitude(getBigDecimalValue(gridLocation.getLongitude()));
      }
    }
  }
}
