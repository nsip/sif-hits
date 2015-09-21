package sif3.hits.domain.converter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType;
import sif.dd.au30.model.ContactInfoType;
import sif.dd.au30.model.EmailListType;
import sif.dd.au30.model.EmailListType.Email;
import sif.dd.au30.model.NameType;
import sif.dd.au30.model.PhoneNumberListType;
import sif.dd.au30.model.PhoneNumberListType.PhoneNumber;
import sif.dd.au30.model.VendorInfoType;
import sif3.hits.domain.converter.factory.ObjectFactory;
import sif3.hits.domain.model.VendorInfo;
import sif3.hits.utils.UsesConstants;

@Component
public class VendorInfoConverter extends HitsConverter<VendorInfoType, VendorInfo> implements UsesConstants {

  @Autowired
  private AddressConverter addressConverter;

  public VendorInfoConverter() {
    super(VendorInfoType.class, VendorInfo.class);
  }

  @Override
  public void toSifModel(VendorInfo source, VendorInfoType target) {
    if (source != null && target != null) {
      ObjectFactory objectFactory = getObjectFactory();

      target.setRefId(source.getRefId());
      target.setABN(objectFactory.createVendorInfoTypeABN(source.getABN()));
      target.setAccountName(objectFactory.createVendorInfoTypeAccountName(source.getAccountName()));
      target.setAccountNumber(objectFactory.createVendorInfoTypeAccountNumber(source.getAccountNumber()));
      target.setBPay(objectFactory.createVendorInfoTypeBPay(source.getBPay()));
      target.setBSB(objectFactory.createVendorInfoTypeBSB(source.getBSB()));

      if (source.hasContactInfo()) {
        ContactInfoType contactInfoType = new ContactInfoType();
        contactInfoType
            .setAddress(objectFactory.createContactInfoTypeAddress(addressConverter.toSifModel(source.getAddress())));
        if (StringUtils.isNotBlank(source.getContactInfoEmail())) {
          EmailListType emailListType = new EmailListType();
          Email email = new Email();
          email.setValue(source.getContactInfoEmail());
          email.setType(DEFAULT_EMAIL_TYPE);
          emailListType.getEmail().add(email);
          contactInfoType.setEmailList(objectFactory.createContactInfoTypeEmailList(emailListType));
        }
        if (source.hasNameInfo()) {
          NameType name = new NameType();
          name.setType(DEFAULT_NAME_TYPE_ENUM);
          name.setFamilyName(objectFactory.createBaseNameTypeFamilyName(source.getContactInfoFamilyName()));
          name.setGivenName(objectFactory.createBaseNameTypeGivenName(source.getContactInfoGivenName()));
          name.setMiddleName(objectFactory.createBaseNameTypeMiddleName(source.getContactInfoMiddleName()));
          contactInfoType.setName(name);
        }
        if (StringUtils.isNotBlank(source.getContactInfoPhoneNumber())) {
          PhoneNumberListType phoneNumberList = new PhoneNumberListType();
          PhoneNumber phoneNumber = new PhoneNumber();
          phoneNumber.setType(DEFAULT_PHONE_TYPE);
          phoneNumber.setNumber(source.getContactInfoPhoneNumber());
          phoneNumberList.getPhoneNumber().add(phoneNumber);
          contactInfoType.setPhoneNumberList(objectFactory.createContactInfoTypePhoneNumberList(phoneNumberList));
        }
        contactInfoType
            .setPositionTitle(objectFactory.createContactInfoTypePositionTitle(source.getContactInfoPositionTitle()));
        contactInfoType.setRole(objectFactory.createContactInfoTypeRole(source.getContactInfoRole()));
        target.setContactInfo(objectFactory.createVendorInfoTypeContactInfo(contactInfoType));
      }
      target.setCustomerId(objectFactory.createVendorInfoTypeCustomerId(source.getCustomerId()));
      target.setName(source.getName());
      target.setPaymentTerms(objectFactory.createVendorInfoTypePaymentTerms(source.getPaymentTerms()));
      target.setRegisteredForGST(objectFactory.createVendorInfoTypeRegisteredForGST(
          getEnumValue(source.getRegisteredForGST(), AUCodeSetsYesOrNoCategoryType.class)));
    }
  }

  @Override
  public void toHitsModel(VendorInfoType source, VendorInfo target) {
    if (source != null && target != null) {
      target.setRefId(source.getRefId());
      target.setABN(getJAXBValue(source.getABN()));
      target.setAccountName(getJAXBValue(source.getAccountName()));
      target.setAccountNumber(getJAXBValue(source.getAccountNumber()));
      target.setBPay(getJAXBValue(source.getBPay()));
      target.setBSB(getJAXBValue(source.getBSB()));

      ContactInfoType contactInfo = getJAXBValue(source.getContactInfo());
      if (contactInfo != null) {
        target.setAddress(addressConverter.toHitsModel(getJAXBValue(contactInfo.getAddress())));
        target.getAddress().setPersonRefId(source.getRefId());

        EmailListType emailList = getJAXBValue(contactInfo.getEmailList());
        if (emailList != null && emailList.getEmail() != null && !emailList.getEmail().isEmpty()) {
          target.setContactInfoEmail(emailList.getEmail().get(0).getValue());
        }

        NameType name = contactInfo.getName();
        if (name != null) {
          target.setContactInfoGivenName(getJAXBValue(name.getGivenName()));
          target.setContactInfoFamilyName(getJAXBValue(name.getFamilyName()));
          target.setContactInfoMiddleName(getJAXBValue(name.getMiddleName()));
        }

        PhoneNumberListType phoneNumberList = getJAXBValue(contactInfo.getPhoneNumberList());
        if (phoneNumberList != null && phoneNumberList.getPhoneNumber() != null
            && !phoneNumberList.getPhoneNumber().isEmpty()) {
          target.setContactInfoPhoneNumber(phoneNumberList.getPhoneNumber().get(0).getNumber());
        }
        target.setContactInfoPositionTitle(getJAXBValue(contactInfo.getPositionTitle()));
        target.setContactInfoRole(getJAXBValue(contactInfo.getRole()));
      }
      target.setCustomerId(getJAXBValue(source.getCustomerId()));
      target.setName(source.getName());
      target.setPaymentTerms(getJAXBValue(source.getPaymentTerms()));
      target.setRegisteredForGST(getJAXBEnumValue(source.getRegisteredForGST()));
    }
  }
}