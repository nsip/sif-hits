package sif3.hits.rest.consumer.data;

import sif.dd.au30.model.*;
import sif3.common.model.QueryCriteria;
import sif3.common.model.QueryOperator;
import sif3.common.model.QueryPredicate;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.utils.RefIdGenerator;

import java.util.Arrays;
import java.util.List;

public class VendorInfoTestData extends TestData<VendorInfoType, VendorInfoCollectionType> {

    public static final String REF_ID_1 = "140b8bc9-9137-4c65-b1c0-fda79796e2d9";
    public static final String REF_ID_2 = "23ba78ea-3644-4537-ad5a-8891dca8f301";
    public static final String REF_ID_3 = "ddeb1d71-71d0-4411-8e3e-c7c1c69c8621";
    public static final String REF_ID_4 = "0d0a36ef-401e-44f8-ae6e-8f197bb38341";
    public static final String REF_ID_5 = "9ff4bf32-1a61-4f6a-90e3-042584931a9d";

    public static final String[] REF_ID_RA = {REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5};
    public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);

    public static final String XML_REF_ID_1 = "33e3843b-7693-47ac-92c3-574b62a9245b";
    public static final String XML_REF_ID_2 = "6fc24394-c842-4bba-9e79-107d391999d3";

    public static final String[] XML_REF_ID_RA = {XML_REF_ID_1, XML_REF_ID_2};
    public static final List<String> XML_REF_ID_LIST = Arrays.asList(XML_REF_ID_RA);

    public VendorInfoType getTestObject(String refId) {
        IObjectFactory objectFactory = getObjectFactory();

        VendorInfoType vendorInfoType = new VendorInfoType();
        vendorInfoType.setRefId(refId);
        vendorInfoType.setABN(objectFactory.createVendorInfoTypeABN("25 348404 20404"));
        vendorInfoType.setAccountName(objectFactory.createVendorInfoTypeAccountName("John Smith"));
        vendorInfoType.setAccountNumber(objectFactory.createVendorInfoTypeAccountNumber("4394958"));
        vendorInfoType.setBPay(objectFactory.createVendorInfoTypeBPay("34205890508302390409"));
        vendorInfoType.setBSB(objectFactory.createVendorInfoTypeBSB("444-333"));

        ContactInfoType contactInfoType = new ContactInfoType();
        contactInfoType.setAddress(objectFactory.createContactInfoTypeAddress(getAddress("43 Some Street", null)));
        EmailListType emailListType = new EmailListType();
        emailListType.getEmail().add(getEmail("vendor.email@not.a.real.domain"));
        contactInfoType.setEmailList(objectFactory.createContactInfoTypeEmailList(emailListType));

        NameType name = new NameType();
        name.setType(DEFAULT_NAME_TYPE_ENUM);
        name.setFamilyName(objectFactory.createBaseNameTypeFamilyName("Jones"));
        name.setGivenName(objectFactory.createBaseNameTypeGivenName("Jack"));
        name.setMiddleName(objectFactory.createBaseNameTypeMiddleName("Jim"));
        contactInfoType.setName(name);

        PhoneNumberListType phoneNumberList = new PhoneNumberListType();
        phoneNumberList.getPhoneNumber().add(getPhoneNumber("+61843032011"));
        contactInfoType.setPhoneNumberList(objectFactory.createContactInfoTypePhoneNumberList(phoneNumberList));

        contactInfoType.setPositionTitle(objectFactory.createContactInfoTypePositionTitle("Position Title"));
        contactInfoType.setRole(objectFactory.createContactInfoTypeRole("Role"));
        vendorInfoType.setContactInfo(objectFactory.createVendorInfoTypeContactInfo(contactInfoType));

        vendorInfoType.setCustomerId(objectFactory.createVendorInfoTypeCustomerId("434443L"));
        vendorInfoType.setName("Vendor Inc Pty Ltd");
        vendorInfoType.setPaymentTerms(objectFactory.createVendorInfoTypePaymentTerms("30"));
        vendorInfoType.setRegisteredForGST(objectFactory.createVendorInfoTypeRegisteredForGST(AUCodeSetsYesOrNoCategoryType.Y));
        return vendorInfoType;
    }

    @Override
    public List<QueryCriteria> getServicePathQueries() {
        QueryCriteria queryCriteria = new QueryCriteria();
        queryCriteria.addPredicate(new QueryPredicate("SchoolInfos", QueryOperator.EQUAL, SchoolInfoTestData.REF_ID_1));
        return Arrays.asList(queryCriteria);
    }

    @Override
    public boolean isServicePathObject(VendorInfoType object, int index) {
        // linked back via other objects no way to check here.
        return object != null;
    }

    public String getRefId(int index) {
        String result = null;
        if (index >= 0 && index < REF_ID_RA.length) {
            result = REF_ID_RA[index];
        } else {
            result = RefIdGenerator.getRefId();
        }
        return result;
    }

    public VendorInfoCollectionType getTestCollection(String... refIds) {
        VendorInfoCollectionType result = new VendorInfoCollectionType();
        for (int i = 0; refIds != null && i < refIds.length; i++) {
            result.getVendorInfo().add(getTestObject(refIds[i]));
        }
        return result;
    }

    public String getSingleObjectXMLFilename() {
        return "VendorInfo.xml";
    }

    public String getMultiObjectXMLFilename() {
        return "VendorInfos.xml";
    }

}

