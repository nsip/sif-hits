package sif3.hits.domain.converter;

import java.util.HashSet;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.AUCodeSetsAustralianStandardClassificationOfLanguagesASCLType;
import sif.dd.au30.model.AUCodeSetsAustralianStandardClassificationOfReligiousGroupsASCRGType;
import sif.dd.au30.model.AUCodeSetsEmailTypeType;
import sif.dd.au30.model.AUCodeSetsIndigenousStatusType;
import sif.dd.au30.model.AUCodeSetsLanguageTypeType;
import sif.dd.au30.model.AUCodeSetsSexCodeType;
import sif.dd.au30.model.AUCodeSetsStandardAustralianClassificationOfCountriesSACCType;
import sif.dd.au30.model.AUCodeSetsTelephoneNumberTypeType;
import sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType;
import sif.dd.au30.model.AddressListType;
import sif.dd.au30.model.AddressType;
import sif.dd.au30.model.DemographicsType;
import sif.dd.au30.model.EmailListType;
import sif.dd.au30.model.EmailType;
import sif.dd.au30.model.LanguageBaseType;
import sif.dd.au30.model.LanguageListType;
import sif.dd.au30.model.NameOfRecordType;
import sif.dd.au30.model.PersonInfoType;
import sif.dd.au30.model.PhoneNumberListType;
import sif.dd.au30.model.PhoneNumberType;
import sif.dd.au30.model.ReligionType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.Address;
import sif3.hits.domain.model.AddressPerson;
import sif3.hits.domain.model.Language;
import sif3.hits.domain.model.Person;
import sif3.hits.domain.model.StudentPerson;
import sif3.hits.utils.UsesConstants;

@Component
public class PersonInfoConverter extends HitsConverter<PersonInfoType, Person> implements UsesConstants {

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
      IObjectFactory objectFactory = getObjectFactory();
      NameOfRecordType name = target.getName();
      if (name == null) {
        name = objectFactory.createNameOfRecordType();
      }
      nameOfRecordConverter.toSifModel(source, name);
      target.setName(name);

      EmailListType emailList = objectFactory.createEmailListType();
      EmailType email = objectFactory.createEmailType();
      email.setType(getEnumValue(DEFAULT_EMAIL_TYPE, AUCodeSetsEmailTypeType.class));
      email.setValue(source.getEmail());
      emailList.getEmail().add(email);
      target.setEmailList(objectFactory.createPersonInfoTypeEmailList(emailList));

      if (StringUtils.isNotBlank(source.getPhoneNumber())) {
        PhoneNumberListType phoneNumberList = objectFactory.createPhoneNumberListType();
        PhoneNumberType phoneNumber = objectFactory.createPhoneNumberType();
        phoneNumber.setNumber(source.getPhoneNumber());
        phoneNumber.setType(getEnumValue(DEFAULT_PHONE_TYPE, AUCodeSetsTelephoneNumberTypeType.class));
        phoneNumberList.getPhoneNumber().add(phoneNumber);
        target.setPhoneNumberList(objectFactory.createPersonInfoTypePhoneNumberList(phoneNumberList));
      }

      DemographicsType demographics = objectFactory.createDemographicsType();
      demographics.setSex(objectFactory.createDemographicsTypeSex(getEnumValue(source.getSex(), AUCodeSetsSexCodeType.class)));
      demographics.setBirthDate(objectFactory.createDemographicsTypeBirthDate(getDateValue(source.getBirthDate())));
      demographics.setInterpreterRequired(objectFactory.createDemographicsTypeInterpreterRequired(getEnumValue(source.getInterpreterRequired(), AUCodeSetsYesOrNoCategoryType.class)));

      if (source instanceof StudentPerson) {
        StudentPerson studentSource = (StudentPerson) source;
        if (StringUtils.isNotBlank(studentSource.getIndigenousStatus()) || StringUtils.isNotBlank(studentSource.getLbote()) || StringUtils.isNotBlank(studentSource.getCountryOfBirth())
            || StringUtils.isNotBlank(studentSource.getReligion())) {
          demographics.setLBOTE(objectFactory.createDemographicsTypeLBOTE(getEnumValue(studentSource.getLbote(), AUCodeSetsYesOrNoCategoryType.class)));
          demographics.setIndigenousStatus(objectFactory.createDemographicsTypeIndigenousStatus(getEnumValue(studentSource.getIndigenousStatus(), AUCodeSetsIndigenousStatusType.class)));
          demographics.setCountryOfBirth(
              objectFactory.createDemographicsTypeCountryOfBirth(getEnumValue(studentSource.getCountryOfBirth(), AUCodeSetsStandardAustralianClassificationOfCountriesSACCType.class)));
          if (StringUtils.isNotBlank(studentSource.getReligion())) {
            ReligionType religion = objectFactory.createReligionType();
            religion.setCode(getEnumValue(studentSource.getReligion(), AUCodeSetsAustralianStandardClassificationOfReligiousGroupsASCRGType.class));
            demographics.setReligion(objectFactory.createDemographicsTypeReligion(religion));
          }
        }
      }
      if (source instanceof AddressPerson) {
        AddressPerson addressSource = (AddressPerson) source;
        if (addressSource.getAddresses() != null && !addressSource.getAddresses().isEmpty()) {
          AddressListType addressList = objectFactory.createAddressListType();
          addressList.getAddress().addAll(addressConverter.toSifModelList(addressSource.getAddresses(), AddressType.class));
          target.setAddressList(objectFactory.createPersonInfoTypeAddressList(addressList));
        }
      }
      if (source.getLanguages() != null && !source.getLanguages().isEmpty()) {
        LanguageListType languageListType = objectFactory.createLanguageListType();
        for (Language language : source.getLanguages()) {
          LanguageBaseType languageBaseType = objectFactory.createLanguageBaseType();
          languageBaseType.setCode(getEnumValue(language.getLanguageCode(), AUCodeSetsAustralianStandardClassificationOfLanguagesASCLType.class));
          languageBaseType.setDialect(objectFactory.createLanguageBaseTypeDialect(language.getLanguageDialect()));
          languageBaseType.setLanguageType(objectFactory.createLanguageBaseTypeLanguageType(getEnumValue(language.getLanguageType(), AUCodeSetsLanguageTypeType.class)));
          languageListType.getLanguage().add(languageBaseType);
        }
        demographics.setLanguageList(objectFactory.createDemographicsTypeLanguageList(languageListType));
      }
      target.setDemographics(objectFactory.createPersonInfoTypeDemographics(demographics));
    }
  }

  @Override
  public void toHitsModel(PersonInfoType source, Person target) {
    if (source != null && target != null) {
      NameOfRecordType name = source.getName();
      nameOfRecordConverter.toHitsModel(name, target);

      EmailListType emailList = getJAXBValue(source.getEmailList());
      if (emailList != null && emailList.getEmail().size() > 0) {
        EmailType email = emailList.getEmail().get(0);
        target.setEmail(email.getValue());
      }

      PhoneNumberListType phoneNumberList = getJAXBValue(source.getPhoneNumberList());
      if (phoneNumberList != null && phoneNumberList.getPhoneNumber().size() > 0) {
        PhoneNumberType phoneNumber = phoneNumberList.getPhoneNumber().get(0);
        target.setPhoneNumber(phoneNumber.getNumber());
      }

      if (target instanceof AddressPerson) {
        AddressListType addressList = getJAXBValue(source.getAddressList());
        if (addressList != null && addressList.getAddress() != null && !addressList.getAddress().isEmpty()) {
          AddressPerson addressTarget = (AddressPerson) target;
          if (addressTarget.getAddresses() != null) {
            addressTarget.getAddresses().clear();
          } else {
            addressTarget.setAddresses(new HashSet<Address>());
          }
          addressTarget.getAddresses().addAll(addressConverter.toHitsModelList(addressList.getAddress()));
          for (Address address : addressTarget.getAddresses()) {
            address.setPersonRefId(target.getRefId());
          }
        }
      }

      DemographicsType demographics = getJAXBValue(source.getDemographics());
      if (demographics != null) {
        target.setSex(getJAXBEnumValue(demographics.getSex()));
        target.setBirthDate(getDateValue(getJAXBValue(demographics.getBirthDate())));
        target.setInterpreterRequired(getJAXBEnumValue(demographics.getInterpreterRequired()));
        if (target.getLanguages() == null) {
          target.setLanguages(new HashSet<Language>());
        } else {
          target.getLanguages().clear();
        }
        if (getJAXBValue(demographics.getLanguageList()) != null) {
          for (LanguageBaseType languageBaseType : getJAXBValue(demographics.getLanguageList()).getLanguage()) {
            Language language = new Language();
            language.setPersonRefId(target.getRefId());
            language.setLanguageCode(getEnumValue(languageBaseType.getCode()));
            language.setLanguageDialect(getJAXBValue(languageBaseType.getDialect()));
            language.setLanguageType(getJAXBEnumValue(languageBaseType.getLanguageType()));
            target.getLanguages().add(language);
          }
        }

        if (target instanceof StudentPerson) {
          StudentPerson studentTarget = (StudentPerson) target;
          studentTarget.setIndigenousStatus(getJAXBEnumValue(demographics.getIndigenousStatus()));
          studentTarget.setCountryOfBirth(getJAXBEnumValue(demographics.getCountryOfBirth()));
          studentTarget.setLbote(getJAXBEnumValue(demographics.getLBOTE()));

          ReligionType religion = getJAXBValue(demographics.getReligion());
          if (religion != null) studentTarget.setReligion(getEnumValue(religion.getCode()));
        }
      }
    }
  }
}
