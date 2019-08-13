package sif3.hits.domain.converter;

import org.apache.commons.lang3.StringUtils;
import sif.dd.au30.model.*;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.FQBaseEntityContact;

public abstract class FQBaseEntityContactConverter<E extends FQBaseEntityContact> extends HitsConverter<EntityContactInfoType, E> {

    public FQBaseEntityContactConverter(Class<E> modelClass) {
        super(EntityContactInfoType.class, modelClass);
    }

    @Override
    public EntityContactInfoType toSifModel(E source) {
        EntityContactInfoType result = null;
        if (isPopulated(source)) {
            result = super.toSifModel(source);
        }
        return result;
    }

    @Override
    public void toSifModel(E source, EntityContactInfoType target) {
        if (source != null && target != null) {
            IObjectFactory objectFactory = getObjectFactory();

            target.setName(null);
            target.setQualifications(objectFactory.createEntityContactInfoTypeQualifications(source.getQualifications()));
            target.setRole(objectFactory.createEntityContactInfoTypeRole(source.getRole()));
            target.setPositionTitle(objectFactory.createEntityContactInfoTypePositionTitle(source.getPositionTitle()));
            target.setRegistrationDetails(objectFactory.createEntityContactInfoTypeRegistrationDetails(source.getRegistrationDetails()));
            target.setQualifications(objectFactory.createEntityContactInfoTypeQualifications(source.getQualifications()));
            target.setAddress(null);
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
    }

    @Override
    public void toHitsModel(EntityContactInfoType source, E target) {
        target.setQualifications(getJAXBValue(source.getQualifications()));
        target.setRole(getJAXBValue(source.getRole()));
        target.setRegistrationDetails(getJAXBValue(source.getRegistrationDetails()));
        target.setQualifications(getJAXBValue(source.getQualifications()));
        target.setPositionTitle(getJAXBValue(source.getPositionTitle()));

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

    public static boolean isPopulated(FQBaseEntityContact source) {
        return source != null && (StringUtils.isNotBlank(source.getPositionTitle()) || StringUtils.isNotBlank(source.getRole())
                || StringUtils.isNotBlank(source.getRegistrationDetails()) || StringUtils.isNotBlank(source.getQualifications()) || StringUtils.isNotBlank(source.getEmailType())
                || StringUtils.isNotBlank(source.getEmail()) || StringUtils.isNotBlank(source.getPhoneNumber()) || StringUtils.isNotBlank(source.getPhoneNumberType())
                || StringUtils.isNotBlank(source.getPhoneNumberExtension()) || StringUtils.isNotBlank(source.getPhoneNumberListedStatus())
                || StringUtils.isNotBlank(source.getPhoneNumberPreference()) || FQBaseEntityContactNameConverter.isPopulated(source.getName()) || FQBaseEntityContactAddressConverter.isPopulated(source.getAddress()));
    }

}
