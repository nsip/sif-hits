package sif3.hits.domain.converter;

import java.util.HashSet;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.AddressListType;
import sif.dd.au30.model.DemographicsType;
import sif.dd.au30.model.DemographicsType.Religion;
import sif.dd.au30.model.EmailListType;
import sif.dd.au30.model.EmailListType.Email;
import sif.dd.au30.model.NameOfRecordType;
import sif.dd.au30.model.PersonInfoType;
import sif.dd.au30.model.PhoneNumberListType;
import sif.dd.au30.model.PhoneNumberListType.PhoneNumber;
import sif3.hits.domain.converter.factory.ObjectFactory;
import sif3.hits.domain.model.Address;
import sif3.hits.domain.model.AddressPerson;
import sif3.hits.domain.model.Person;
import sif3.hits.domain.model.StudentPerson;

@Component
public class PersonInfoConverter extends HitsConverter<PersonInfoType, Person> {

  public PersonInfoConverter() {
    super(PersonInfoType.class, null);
  }

  @Autowired
  private NameOfRecordConverter nameOfRecordConverter;
  
  @Autowired
  private AddressConverter addressConverter;

  @Override
  public void toSifModel(Person source, PersonInfoType target) {
    if (source != null & target != null) {
      ObjectFactory objectFactory = getObjectFactory();
      NameOfRecordType name = target.getName();
      if (name == null) {
        name = new NameOfRecordType();
      }
      nameOfRecordConverter.toSifModel(source, name);
      target.setName(name);

      EmailListType emailList = new EmailListType();
      Email email = new Email();
      email.setType("06"); // AUCodeSetsEmailTypeType.WORK
      email.setValue(source.getEmail());
      emailList.getEmail().add(email);
      target.setEmailList(objectFactory.createEmailList(emailList));

      PhoneNumberListType phoneNumberList = new PhoneNumberListType();
      PhoneNumber phoneNumber = new PhoneNumber();
      phoneNumber.setNumber(source.getPhoneNumber());
      phoneNumberList.getPhoneNumber().add(phoneNumber);
      target.setPhoneNumberList(objectFactory.createPhoneNumberList(phoneNumberList));

      DemographicsType demographics = new DemographicsType();
      demographics.setSex(objectFactory.createDemographicsTypeSex(source.getSex()));
      demographics.setBirthDate(objectFactory.createDemographicsTypeBirthDate(getDateValue(source.getBirthDate())));

      if (source instanceof StudentPerson) {
        StudentPerson studentSource = (StudentPerson) source;
        demographics.setIndigenousStatus(objectFactory.createDemographicsTypeIndigenousStatus(studentSource
            .getIndigenousStatus()));
        demographics.setCountryOfBirth(objectFactory.createDemographicsTypeCountryOfBirth(studentSource
            .getCountryOfBirth()));
        if (StringUtils.isNotBlank(studentSource.getReligion())) {
          Religion religion = objectFactory.createDemographicsTypeReligion();
          religion.setCode(studentSource.getReligion());
          demographics.setReligion(objectFactory.createDemographicsTypeReligion(religion));
        }
      }
      if (source instanceof AddressPerson) {
        AddressPerson addressSource = (AddressPerson) source;
        AddressListType addressList = objectFactory.createAddressListType();
        addressList.getAddress().addAll(addressConverter.toSifModelList(addressSource.getAddresses()));
        target.setAddressList(objectFactory.createPersonInfoTypeAddressList(addressList));
      }
      
      target.setDemographics(objectFactory.createDemographics(demographics));
    }
  }

  @Override
  public void toHitsModel(PersonInfoType source, Person target) {
    if (source != null && target != null) {
      NameOfRecordType name = source.getName();
      nameOfRecordConverter.toHitsModel(name, target);

      EmailListType emailList = getJAXBValue(source.getEmailList());
      if (emailList != null && emailList.getEmail().size() > 0) {
        Email email = emailList.getEmail().get(0);
        target.setEmail(email.getValue());
      }

      PhoneNumberListType phoneNumberList = getJAXBValue(source.getPhoneNumberList());
      if (phoneNumberList != null && phoneNumberList.getPhoneNumber().size() > 0) {
        PhoneNumber phoneNumber = phoneNumberList.getPhoneNumber().get(0);
        target.setPhoneNumber(phoneNumber.getNumber());
      }
      
      if (target instanceof AddressPerson) {
        AddressListType addressList = getJAXBValue(source.getAddressList());
        if (addressList != null && addressList.getAddress() != null && !addressList.getAddress().isEmpty()) {
          AddressPerson addressTarget = (AddressPerson) target;
          addressTarget.setAddresses(new HashSet<Address>(addressConverter.toHitsModelList(addressList.getAddress())));
        }
      }

      DemographicsType demographics = getJAXBValue(source.getDemographics());
      if (demographics != null) {
        target.setSex(getJAXBValue(demographics.getSex()));
        target.setBirthDate(getDateValue(getJAXBValue(demographics.getBirthDate())));
        if (target instanceof StudentPerson) {
          StudentPerson studentTarget = (StudentPerson) target;
          studentTarget.setIndigenousStatus(getJAXBValue(demographics.getIndigenousStatus()));
          studentTarget.setCountryOfBirth(getJAXBValue(demographics.getCountryOfBirth()));

          Religion religion = getJAXBValue(demographics.getReligion());
          if (religion != null && StringUtils.isNotBlank(religion.getCode())) {
            studentTarget.setReligion(religion.getCode());
          }
        }
      }
    }
  }
}
