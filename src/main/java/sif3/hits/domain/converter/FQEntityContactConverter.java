package sif3.hits.domain.converter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.AUCodeSetsEmailTypeType;
import sif.dd.au30.model.AUCodeSetsTelephoneNumberTypeType;
import sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType;
import sif.dd.au30.model.EmailType;
import sif.dd.au30.model.EntityContactInfoType;
import sif.dd.au30.model.PhoneNumberType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.FQEntityContact;

@Component
public class FQEntityContactConverter extends HitsConverter<EntityContactInfoType, FQEntityContact> {

    @Autowired
    FQEntityContactNameConverter nameConverter;

    @Autowired
    FQEntityContactAddressConverter addressConverter;

    public FQEntityContactConverter() {
        super(EntityContactInfoType.class, FQEntityContact.class);
    }

    @Override
    public EntityContactInfoType toSifModel(FQEntityContact source) {
        EntityContactInfoType result = null;
        if (isPopulated(source)) {
            result = super.toSifModel(source);
        }
        return result;
    }

    @Override
    public void toSifModel(FQEntityContact source, EntityContactInfoType target) {
        IObjectFactory objectFactory = getObjectFactory();

        target.setName(nameConverter.toSifModel(source.getName()));
        target.setQualifications(objectFactory.createEntityContactInfoTypeQualifications(source.getQualifications()));
        target.setRole(objectFactory.createEntityContactInfoTypeRole(source.getRole()));
        target.setPositionTitle(objectFactory.createEntityContactInfoTypePositionTitle(source.getPositionTitle()));
        target.setRegistrationDetails(objectFactory.createEntityContactInfoTypeRegistrationDetails(source.getRegistrationDetails()));
        target.setQualifications(objectFactory.createEntityContactInfoTypeQualifications(source.getQualifications()));
        target.setAddress(objectFactory.createContactInfoTypeAddress(addressConverter.toSifModel(source.getAddress())));
        if (StringUtils.isNotBlank(source.getEmailType()) || StringUtils.isNotBlank(source.getEmail())) {
            EmailType emailType = objectFactory.createEmailType();
            emailType.setType(getEnumValue(source.getEmailType(), AUCodeSetsEmailTypeType.class));
            emailType.setValue(source.getEmail());
            target.setEmail(objectFactory.createEntityContactInfoTypeEmail(emailType));
        }
        if (StringUtils.isNotBlank(source.getPhoneNumber()) || StringUtils.isNotBlank(source.getPhoneNumberType()) || StringUtils.isNotBlank(source.getPhoneNumberExtension())
                || StringUtils.isNotBlank(source.getPhoneNumberListedStatus()) || StringUtils.isNotBlank(source.getPhoneNumberPreference())) {
            PhoneNumberType phoneNumberType = objectFactory.createPhoneNumberType();
            phoneNumberType.setNumber(source.getPhoneNumber());
            phoneNumberType.setType(getEnumValue(source.getPhoneNumberType(), AUCodeSetsTelephoneNumberTypeType.class));
            phoneNumberType.setExtension(objectFactory.createPhoneNumberTypeExtension(source.getPhoneNumberExtension()));
            phoneNumberType
                    .setListedStatus(objectFactory.createPhoneNumberTypeListedStatus(getEnumValue(source.getPhoneNumberListedStatus(), AUCodeSetsYesOrNoCategoryType.class)));
            phoneNumberType.setPreference(objectFactory.createPhoneNumberTypePreference(getLongValue(source.getPhoneNumberPreference())));
            target.setPhoneNumber(objectFactory.createContactTypePhoneNumber(phoneNumberType));
        }
    }

    @Override
    public void toHitsModel(EntityContactInfoType source, FQEntityContact target) {
        target.setName(nameConverter.toHitsModel(source.getName()));
        if (!nameConverter.isPopulated(target.getName())) {
            target.setName(null);
        } else {
            target.getName().setEntityContact(target);
        }

        target.setQualifications(getJAXBValue(source.getQualifications()));
        target.setRole(getJAXBValue(source.getRole()));
        target.setRegistrationDetails(getJAXBValue(source.getRegistrationDetails()));
        target.setQualifications(getJAXBValue(source.getQualifications()));
        target.setPositionTitle(getJAXBValue(source.getPositionTitle()));
        target.setAddress(addressConverter.toHitsModel(getJAXBValue(source.getAddress())));
        if (!addressConverter.isPopulated(target.getAddress())) {
            target.setAddress(null);
        } else {
            target.getAddress().setEntityContact(target);
        }

        EmailType emailType = getJAXBValue(source.getEmail());
        if (emailType != null) {
            target.setEmail(emailType.getValue());
            target.setEmailType(getEnumValue(emailType.getType()));
        }

        PhoneNumberType phoneNumberType = getJAXBValue(source.getPhoneNumber());
        if (phoneNumberType != null) {
            target.setPhoneNumber(phoneNumberType.getNumber());
            target.setPhoneNumberExtension(getJAXBValue(phoneNumberType.getExtension()));
            target.setPhoneNumberListedStatus(getJAXBEnumValue(phoneNumberType.getListedStatus()));
            target.setPhoneNumberPreference(getLongValue(getJAXBValue(phoneNumberType.getPreference())));
            target.setPhoneNumberType(getEnumValue(phoneNumberType.getType()));
        }
    }

    public boolean isPopulated(FQEntityContact source) {
        return source != null && (StringUtils.isNotBlank(source.getPositionTitle()) || StringUtils.isNotBlank(source.getRole())
                || StringUtils.isNotBlank(source.getRegistrationDetails()) || StringUtils.isNotBlank(source.getQualifications()) || StringUtils.isNotBlank(source.getEmailType())
                || StringUtils.isNotBlank(source.getEmail()) || StringUtils.isNotBlank(source.getPhoneNumber()) || StringUtils.isNotBlank(source.getPhoneNumberType())
                || StringUtils.isNotBlank(source.getPhoneNumberExtension()) || StringUtils.isNotBlank(source.getPhoneNumberListedStatus())
                || StringUtils.isNotBlank(source.getPhoneNumberPreference()) || nameConverter.isPopulated(source.getName()) || addressConverter.isPopulated(source.getAddress()));
    }

}
