package sif3.hits.domain.converter;

import java.math.BigDecimal;

import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.AUCodeSetsOperationalStatusType;
import sif.dd.au30.model.AUCodeSetsSchoolLevelType;
import sif.dd.au30.model.AUCodeSetsSchoolSectorCodeType;
import sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType;
import sif.dd.au30.model.AddressListType;
import sif.dd.au30.model.AddressListType.Address;
import sif.dd.au30.model.AddressType.Street;
import sif.dd.au30.model.GridLocationType;
import sif.dd.au30.model.ObjectFactory;
import sif.dd.au30.model.SchoolInfoType;
import sif.dd.au30.model.SchoolInfoType.Campus;
import sif3.hits.domain.model.SchoolInfo;

@Component
public class SchoolInfoConverter extends HitsConverter<SchoolInfoType, SchoolInfo> {

  public SchoolInfoConverter() {
    super(SchoolInfoType.class, SchoolInfo.class);
  }

  @Override
  public void toSifModel(SchoolInfo source, SchoolInfoType target) {
    if (source != null && target != null) {
      ObjectFactory objFactory = getObjectFactory();
      target.setRefId(source.getRefId());
      target.setLocalId(objFactory.createSchoolInfoTypeLocalId(source.getLocalId()));
      target.setSchoolName(source.getSchoolName());
      target.setStateProvinceId(objFactory.createSchoolInfoTypeStateProvinceId(source.getStateProvinceId()));
      target.setCommonwealthId(objFactory.createSchoolInfoTypeCommonwealthId(source.getCommonwealthId()));
      AUCodeSetsSchoolSectorCodeType schoolSector = getEnumValue(source.getSchoolSector(), AUCodeSetsSchoolSectorCodeType.class);
      target.setSchoolSector(schoolSector);
      AUCodeSetsOperationalStatusType operationalStatus = getEnumValue(source.getOperationalStatus(), AUCodeSetsOperationalStatusType.class);
      target.setOperationalStatus(objFactory.createSchoolInfoTypeOperationalStatus(operationalStatus));
      AUCodeSetsYesOrNoCategoryType independentSchool = getEnumValue(source.getIndependentSchool(), AUCodeSetsYesOrNoCategoryType.class);
      target.setIndependentSchool(objFactory.createSchoolInfoTypeIndependentSchool(independentSchool));
      AUCodeSetsSchoolLevelType schoolType = getEnumValue(source.getSchoolType(), AUCodeSetsSchoolLevelType.class);
      target.setSchoolType(objFactory.createSchoolInfoTypeSchoolType(schoolType));
      
      // Address - may subtype this if needed elsewhere
      AddressListType addressList = new AddressListType();
      Address address = new Address();
      address.setStateProvince(objFactory.createAddressTypeStateProvince(source.getAddressStateProvince()));
      address.setCity(source.getAddressCity());
      address.setPostalCode(source.getAddressPostalCode());
      
      Street street = new Street();
      street.setStreetNumber(objFactory.createAddressTypeStreetStreetNumber(source.getAddressStreetNumber()));
      street.setStreetName(objFactory.createAddressTypeStreetStreetName(source.getAddressStreetName()));
      address.setStreet(street);
      
      GridLocationType gridLocation = new GridLocationType();
      gridLocation.setLatitude(getBigDecimalValue(source.getAddressLatitude()));
      gridLocation.setLongitude(getBigDecimalValue(source.getAddressLongitude()));
      address.setGridLocation(objFactory.createAddressTypeGridLocation(gridLocation));
      
      addressList.getAddress().add(address);
      target.setAddressList(objFactory.createSchoolInfoTypeAddressList(addressList));
      
      target.setSchoolGeographicLocation(objFactory.createSchoolInfoTypeSchoolGeographicLocation(source.getAddressGeographicLocation()));
      
      BigDecimal aria = getBigDecimalValue(source.getAddressARIA());
      target.setARIA(objFactory.createSchoolInfoTypeARIA(aria));
      XMLGregorianCalendar entityOpen = getDateValue(source.getEntityOpen());
      target.setEntityOpen(objFactory.createSchoolInfoTypeEntityOpen(entityOpen));
      XMLGregorianCalendar entityClose = getDateValue(source.getEntityClose());
      target.setEntityClose(objFactory.createSchoolInfoTypeEntityOpen(entityClose));
      
      Campus campus = new Campus();
      campus.setSchoolCampusId(source.getCampusId());
      AUCodeSetsYesOrNoCategoryType adminStatus = getEnumValue(source.getCampusAdminStatus(), AUCodeSetsYesOrNoCategoryType.class);
      campus.setAdminStatus(adminStatus);
      AUCodeSetsSchoolLevelType campusType = getEnumValue(source.getCampusType(), AUCodeSetsSchoolLevelType.class);
      campus.setCampusType(objFactory.createSchoolInfoTypeCampusCampusType(campusType));
      target.setCampus(objFactory.createSchoolInfoTypeCampus(campus));
    }
  }

  @Override
  public void toHitsModel(SchoolInfoType source, SchoolInfo target) {
    if (source != null && target != null) {
      target.setRefId(source.getRefId());
      target.setLocalId(getJAXBValue(source.getLocalId()));
      target.setSchoolName(source.getSchoolName());
      target.setStateProvinceId(getJAXBValue(source.getStateProvinceId()));
      target.setCommonwealthId(getJAXBValue(source.getCommonwealthId()));
      target.setSchoolSector(getEnumValue(source.getSchoolSector()));
      target.setOperationalStatus(getJAXBEnumValue(source.getOperationalStatus()));
      target.setIndependentSchool(getJAXBEnumValue(source.getIndependentSchool()));
      target.setSchoolType(getJAXBEnumValue(source.getSchoolType()));
      
      // Address - may subtype this if needed elsewhere
      AddressListType addressList = getJAXBValue(source.getAddressList());
      if (addressList != null && addressList.getAddress() != null && addressList.getAddress().size() > 0) {
        Address address = addressList.getAddress().get(0);
        target.setAddressStateProvince(getJAXBValue(address.getStateProvince()));
        target.setAddressCity(address.getCity());
        target.setAddressPostalCode(address.getPostalCode());
        
        Street street = address.getStreet();
        if (street != null) {
          target.setAddressStreetNumber(getJAXBValue(street.getStreetNumber()));
          target.setAddressStreetName(getJAXBValue(street.getStreetName()));
        }
        
        
        GridLocationType gridLocation = getJAXBValue(address.getGridLocation());
        if (gridLocation != null) {
          target.setAddressLatitude(getBigDecimalValue(gridLocation.getLatitude()));
          target.setAddressLongitude(getBigDecimalValue(gridLocation.getLongitude()));
        }
      }
      
      target.setAddressGeographicLocation(getJAXBValue(source.getSchoolGeographicLocation()));
      
      target.setAddressARIA(getBigDecimalValue(getJAXBValue(source.getARIA())));
      target.setEntityOpen(getDateValue(getJAXBValue(source.getEntityOpen())));
      target.setEntityClose(getDateValue(getJAXBValue(source.getEntityClose())));
      
      Campus campus = getJAXBValue(source.getCampus());
      if (campus != null) {
        target.setCampusId(campus.getSchoolCampusId());
        target.setCampusAdminStatus(getEnumValue(campus.getAdminStatus()));
        target.setCampusType(getJAXBEnumValue(campus.getCampusType()));
      }
    }
  }

}