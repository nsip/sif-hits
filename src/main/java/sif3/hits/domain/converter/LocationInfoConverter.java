package sif3.hits.domain.converter;

import java.util.HashSet;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.AddressListType;
import sif.dd.au30.model.ChargedLocationInfoType;
import sif.dd.au30.model.PhoneNumberListType;
import sif.dd.au30.model.PhoneNumberListType.PhoneNumber;
import sif3.hits.domain.converter.factory.ObjectFactory;
import sif3.hits.domain.model.Address;
import sif3.hits.domain.model.LocationInfo;
import sif3.hits.utils.UsesConstants;

@Component
public class LocationInfoConverter extends HitsConverter<ChargedLocationInfoType, LocationInfo> implements UsesConstants {

  @Autowired
  private AddressConverter addressConverter;

  public LocationInfoConverter() {
    super(ChargedLocationInfoType.class, LocationInfo.class);
  }

  @Override
  public void toSifModel(LocationInfo source, ChargedLocationInfoType target) {
    if (source != null && target != null) {
      ObjectFactory objectFactory = getObjectFactory();

      target.setRefId(source.getRefId());
      target.setDescription(objectFactory.createChargedLocationInfoTypeDescription(source.getDescription()));
      target.setLocalId(objectFactory.createChargedLocationInfoTypeLocalId(source.getLocalId()));
      target.setLocationType(source.getLocationType());
      target.setName(source.getName());
      target.setParentChargedLocationInfoRefId(objectFactory.createChargedLocationInfoTypeParentChargedLocationInfoRefId(source.getParentLocationInfoRefId()));
      
      if (StringUtils.isNotBlank(source.getPhoneNumber())) {
        PhoneNumberListType phoneNumberList = objectFactory.createPhoneNumberListType();
        PhoneNumber phoneNumber = objectFactory.createPhoneNumberListTypePhoneNumber();
        phoneNumber.setNumber(source.getPhoneNumber());
        phoneNumber.setType(DEFAULT_PHONE_TYPE);
        phoneNumberList.getPhoneNumber().add(phoneNumber);
        target.setPhoneNumberList(objectFactory.createChargedLocationInfoTypePhoneNumberList(phoneNumberList));
      }
      
      target.setSchoolInfoRefId(objectFactory.createChargedLocationInfoTypeSchoolInfoRefId(source.getSchoolInfoRefId()));
      target.setSiteCategory(source.getSiteCategory());
      target.setStateProvinceId(objectFactory.createChargedLocationInfoTypeStateProvinceId(source.getStateProvinceId()));

      if (source.getAddresses() != null && !source.getAddresses().isEmpty()) {
        AddressListType addressList = objectFactory.createAddressListType();
        addressList.getAddress().addAll(addressConverter.toSifModelList(source.getAddresses(), AddressListType.Address.class));
        target.setAddressList(objectFactory.createDebtorTypeAddressList(addressList));
      }
    }
  }

  @Override
  public void toHitsModel(ChargedLocationInfoType source, LocationInfo target) {
    if (source != null && target != null) {
      target.setRefId(source.getRefId());

      target.setDescription(getJAXBValue(source.getDescription()));
      target.setLocalId(getJAXBValue(source.getLocalId()));
      target.setLocationType(source.getLocationType());
      target.setName(source.getName());
      target.setParentLocationInfoRefId(getJAXBValue(source.getParentChargedLocationInfoRefId()));

      PhoneNumberListType phoneNumberList = getJAXBValue(source.getPhoneNumberList());
      if (phoneNumberList != null && phoneNumberList.getPhoneNumber() != null && !phoneNumberList.getPhoneNumber().isEmpty()) {
        target.setPhoneNumber(phoneNumberList.getPhoneNumber().get(0).getNumber());
      }
      
      target.setSchoolInfoRefId(getJAXBValue(source.getSchoolInfoRefId()));
      target.setSiteCategory(source.getSiteCategory());
      target.setStateProvinceId(getJAXBValue(source.getStateProvinceId()));
      
      AddressListType addressList = getJAXBValue(source.getAddressList());
      if (target.getAddresses() == null) {
        target.setAddresses(new HashSet<Address>());
      } else {
        target.getAddresses().clear();
      }
      if (addressList != null && addressList.getAddress() != null && !addressList.getAddress().isEmpty()) {
        target.getAddresses().addAll(addressConverter.toHitsModelList(addressList.getAddress()));
        for (Address address : target.getAddresses()) {
          address.setPersonRefId(target.getRefId());
        }
      }
    }
  }

}
