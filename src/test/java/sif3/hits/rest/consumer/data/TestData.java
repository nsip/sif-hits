package sif3.hits.rest.consumer.data;

import sif.dd.au30.model.*;
import sif3.common.model.QueryCriteria;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.converter.factory.ObjectFactory;
import sif3.hits.utils.UsesConstants;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public abstract class TestData<T, C> implements UsesConstants {

    public abstract T getTestObject(String refId);

    public T getTestObject(int index) {
        return getTestObject(getRefId(index));
    }

    public abstract C getTestCollection(String... refIds);

    public List<T> getExamplesForQuery() {
        return new ArrayList<>();
    }

    public boolean isExampleObject(T object, int index) {
        return false;
    }

    public List<QueryCriteria> getServicePathQueries() {
        return new ArrayList<>();
    }

    public boolean isServicePathObject(T object, int index) {
        return false;
    }

    public abstract String getSingleObjectXMLFilename();

    public abstract String getMultiObjectXMLFilename();

    public abstract String getRefId(int index);

    public boolean verifyAllInitialObjects() {
        return false;
    }

    public static final String DEFAULT_STATE = "WA";
    public static final String DEFAULT_POSTCODE = "6000";
    public static final String DEFAULT_CITY = "Perth";
    public static final String DEFAULT_LAT = "-31.952693";
    public static final String DEFAULT_LON = "115.871971";

    protected static XMLGregorianCalendar getDate(String date) {
        XMLGregorianCalendar result = null;
        try {
            result = DatatypeFactory.newInstance().newXMLGregorianCalendar(date);
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        return result;
    }

    protected static Calendar getCalendar(String date) {
        XMLGregorianCalendar xmlCal = getDate(date);
        return xmlCal.toGregorianCalendar();
    }

    public static AddressType getAddress(String addressLineOne, String addressLineTwo) {
        AddressType address = new AddressType();
        getAddress(address, addressLineOne, addressLineTwo, false);
        return address;
    }

    public static AddressType getSchoolAddress(String streetNumber, String street) {
        AddressType address = new AddressType();
        getAddress(address, streetNumber, street, true);
        return address;
    }

    private static void getAddress(AddressType address, String inputOne, String inputTwo, boolean schoolAddress) {
        IObjectFactory objectFactory = getObjectFactory();
        address.setCity(DEFAULT_CITY);
        address.setStateProvince(objectFactory.createAddressTypeStateProvince(DEFAULT_STATE));
        address.setType(AUCodeSetsAddressTypeType.fromValue(DEFAULT_ADDRESS_TYPE));
        address.setRole(AUCodeSetsAddressRoleType.fromValue(DEFAULT_ADDRESS_ROLE));
        address.setPostalCode(DEFAULT_POSTCODE);

        AddressStreetType street = objectFactory.createAddressStreetType();
        if (schoolAddress) {
            street.setStreetNumber(objectFactory.createAddressStreetTypeStreetNumber(inputOne));
            street.setStreetName(objectFactory.createAddressStreetTypeStreetName(inputTwo));
        } else {
            street.setLine1(objectFactory.createAddressStreetTypeLine1(inputOne));
            street.setLine2(objectFactory.createAddressStreetTypeLine2(inputTwo));
        }
        address.setStreet(street);

        GridLocationType gridLocation = objectFactory.createGridLocationType();
        gridLocation.setLatitude(new BigDecimal(DEFAULT_LAT));
        gridLocation.setLongitude(new BigDecimal(DEFAULT_LON));
        address.setGridLocation(objectFactory.createAddressTypeGridLocation(gridLocation));
    }

    public static NameType getName(String title, String firstName, String middleName, String lastName) {
        NameType result = new NameType();
        result.setType(DEFAULT_NAME_TYPE_ENUM);
        return getName(result, title, firstName, middleName, lastName, true);
    }

    public static NameOfRecordType getNameOfRecord(String title, String firstName, String middleName, String lastName) {
        return getNameOfRecord(title, firstName, middleName, lastName, true);
    }

    public static NameOfRecordType getNameOfRecord(String title, String firstName, String middleName, String lastName, boolean fullName) {
        NameOfRecordType result = new NameOfRecordType();
        result.setType(DEFAULT_NAME_TYPE);
        return getName(result, title, firstName, middleName, lastName, fullName);
    }


    private static <E extends BaseNameType> E getName(E target, String title, String firstName, String middleName, String lastName, boolean fullName) {
        IObjectFactory objectFactory = getObjectFactory();
        target.setFamilyName(objectFactory.createBaseNameTypeFamilyName(lastName));
        target.setPreferredFamilyName(objectFactory.createBaseNameTypePreferredFamilyName(lastName));
        target.setGivenName(objectFactory.createBaseNameTypeGivenName(firstName));
        target.setPreferredGivenName(objectFactory.createBaseNameTypePreferredGivenName(firstName));
        target.setMiddleName(objectFactory.createBaseNameTypeMiddleName(middleName));
        target.setTitle(objectFactory.createBaseNameTypeTitle(title));
        if (fullName) {
            if (title == null) {
                target.setFullName(objectFactory.createBaseNameTypeFullName(firstName + " " + middleName + " " + lastName));
            } else {
                target.setFullName(objectFactory.createBaseNameTypeFullName(title + " " + firstName + " " + middleName + " " + lastName));
            }
        }
        return target;
    }

    public static PhoneNumberType getPhoneNumber(String number) {
        PhoneNumberType phoneNumber = new PhoneNumberType();
        phoneNumber.setType(AUCodeSetsTelephoneNumberTypeType.fromValue(DEFAULT_PHONE_TYPE));
        phoneNumber.setNumber(number);
        return phoneNumber;
    }

    public static EmailType getEmail(String email) {
        EmailType result = new EmailType();
        result.setType(AUCodeSetsEmailTypeType.fromValue(DEFAULT_EMAIL_TYPE));
        result.setValue(email);
        return result;
    }

    public WellbeingDocumentType getWellbeingDocument(int index) {
        IObjectFactory objectFactory = getObjectFactory();
        WellbeingDocumentType wellbeingDocument = objectFactory.createWellbeingDocumentType();
        wellbeingDocument.setLocation("\\\\secure-share\\plan-documents\\st1234568\\plan-" + index + ".doc");
        wellbeingDocument.setSensitivity(objectFactory.createWellbeingDocumentTypeSensitivity("SENSITIVE"));
        wellbeingDocument.setURL(objectFactory.createWellbeingDocumentTypeURL("http://secure-document-server.edu/plan-documents/st12345678/plan-" + index + ".doc"));
        wellbeingDocument.setDocumentType(objectFactory.createWellbeingDocumentTypeDocumentType("Plan"));
        wellbeingDocument.setDocumentReviewDate(objectFactory.createWellbeingDocumentTypeDocumentReviewDate(getDate("2018-04-03")));
        wellbeingDocument.setDocumentDescription(objectFactory.createWellbeingDocumentTypeDocumentDescription("Plan document " + index + " for student 12345678."));
        return wellbeingDocument;
    }
//
//    public AGRuleType getAGRuleType(int parent, int index) {
//        IObjectFactory objectFactory = getObjectFactory();
//        AGRuleType agRule = objectFactory.createAGRuleType();
//        agRule.setAGRuleStatus(objectFactory.createAGRuleTypeAGRuleStatus("status-" + parent + "-" + index));
//        agRule.setAGRuleResponse(objectFactory.createAGRuleTypeAGRuleResponse("response-" + parent + "-" + index));
//        agRule.setAGRuleComment(objectFactory.createAGRuleTypeAGRuleComment("comment-" + parent + "-" + index));
//        agRule.setAGRuleCode(objectFactory.createAGRuleTypeAGRuleCode("code-" + parent + "-" + index));
//        return agRule;
//    }


    protected static IObjectFactory getObjectFactory() {
        return ObjectFactory.getInstance();
    }

    public <E> E getValue(E[] values, int index) {
        E result = null;
        if (values != null && values.length > 0) {
            result = values[index % values.length];
        }
        return result;
    }
}