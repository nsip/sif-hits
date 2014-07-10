package sif3.hits.domain.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.DemographicsType;
import sif.dd.au30.model.EmailListType;
import sif.dd.au30.model.EmailListType.Email;
import sif.dd.au30.model.NameOfRecordType;
import sif.dd.au30.model.ObjectFactory;
import sif.dd.au30.model.PersonInfoType;
import sif.dd.au30.model.PhoneNumberListType;
import sif.dd.au30.model.PhoneNumberListType.PhoneNumber;
import sif3.hits.domain.model.Person;
import sif3.hits.domain.model.StudentPerson;

@Component
public class PersonInfoConverter extends HitsConverter<PersonInfoType, Person> {

  public PersonInfoConverter() {
    super(PersonInfoType.class, null);
  }
  
  @Autowired
  private NameOfRecordConverter nameOfRecordConverter;

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
      if (source instanceof StudentPerson) {
        StudentPerson studentSource = (StudentPerson) source;
        demographics.setBirthDate(objectFactory.createDemographicsTypeBirthDate(getDateValue(studentSource
            .getBirthDate())));
        demographics.setIndigenousStatus(objectFactory.createDemographicsTypeIndigenousStatus(studentSource
            .getIndigenousStatus()));
        demographics.setCountryOfBirth(objectFactory.createDemographicsTypeCountryOfBirth(studentSource
            .getCountryOfBirth()));
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

      DemographicsType demographics = getJAXBValue(source.getDemographics());
      if (demographics != null) {
        target.setSex(getJAXBValue(demographics.getSex()));
        if (target instanceof StudentPerson) {
          StudentPerson studentTarget = (StudentPerson) target;
          studentTarget.setBirthDate(getDateValue(getJAXBValue(demographics.getBirthDate())));
          studentTarget.setIndigenousStatus(getJAXBValue(demographics.getIndigenousStatus()));
          studentTarget.setCountryOfBirth(getJAXBValue(demographics.getCountryOfBirth()));
        }
      }
    }
  }

}
