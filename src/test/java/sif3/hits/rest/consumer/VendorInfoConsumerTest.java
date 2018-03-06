package sif3.hits.rest.consumer;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.AUCodeSetsEmailTypeType;
import sif.dd.au30.model.AUCodeSetsTelephoneNumberTypeType;
import sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType;
import sif.dd.au30.model.ContactInfoType;
import sif.dd.au30.model.EmailListType;
import sif.dd.au30.model.EmailType;
import sif.dd.au30.model.NameType;
import sif.dd.au30.model.ObjectFactory;
import sif.dd.au30.model.PhoneNumberListType;
import sif.dd.au30.model.PhoneNumberType;
import sif.dd.au30.model.VendorInfoCollectionType;
import sif.dd.au30.model.VendorInfoType;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.hits.rest.consumer.StudentPersonalConsumerTest.StudentPersonalRefIds;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.utils.UsesConstants;
import sif3.infra.rest.consumer.ConsumerLoader;

public class VendorInfoConsumerTest extends BaseTest implements UsesConstants {
    private ConsumerTest<VendorInfoType, VendorInfoCollectionType> vendorInfoTester = null;

    public static class VendorInfoRefIds {
        public static String REF_ID_1 = "df9543ee-a145-4e19-b87b-816852aa24bf";
        public static String REF_ID_2 = "16f9023e-73d2-4f56-bcab-78ed80f62192";
        public static String REF_ID_3 = "c1c5dca3-0e2f-415e-98f7-be6b2407f48e";
        public static String REF_ID_4 = "c31a3e10-7fa2-43f9-8e5a-b63b60c40781";
        public static String REF_ID_5 = "d87ee459-4f19-4ba5-877e-fd0a77b66910";
    }

    private final String REF_ID_1 = "02339d2b-54e9-4ea1-bcd4-493e2b952c4e";
    private final String REF_ID_2 = "6ebef915-9ace-4972-9cf7-a750da2ae299";
    private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };

    @Test
    @Category({ IntegrationTest.class, InitialiseData.class })
    public void initialiseData() throws Exception {
        ObjectFactory objectFactory = new ObjectFactory();
        VendorInfoType vendorInfoType = new VendorInfoType();
        vendorInfoType.setRefId(VendorInfoRefIds.REF_ID_1);
        vendorInfoType.setABN(objectFactory.createVendorInfoTypeABN("25 348404 20404"));
        vendorInfoType.setAccountName(objectFactory.createVendorInfoTypeAccountName("John Smith"));
        vendorInfoType.setAccountNumber(objectFactory.createVendorInfoTypeAccountNumber("4394958"));
        vendorInfoType.setBPay(objectFactory.createVendorInfoTypeBPay("34205890508302390409"));
        vendorInfoType.setBSB(objectFactory.createVendorInfoTypeBSB("444-333"));

        ContactInfoType contactInfoType = new ContactInfoType();
        contactInfoType.setAddress(objectFactory.createContactInfoTypeAddress(StudentPersonalRefIds.getAddressType(objectFactory, "43 Some Street", null)));
        EmailListType emailListType = new EmailListType();
        EmailType email = new EmailType();
        email.setValue("email@not.a.real.domain");
        email.setType(AUCodeSetsEmailTypeType.fromValue(DEFAULT_EMAIL_TYPE));
        emailListType.getEmail().add(email);
        contactInfoType.setEmailList(objectFactory.createContactInfoTypeEmailList(emailListType));

        NameType name = new NameType();
        name.setType(DEFAULT_NAME_TYPE_ENUM);
        name.setFamilyName(objectFactory.createBaseNameTypeFamilyName("Jones"));
        name.setGivenName(objectFactory.createBaseNameTypeGivenName("Jack"));
        name.setMiddleName(objectFactory.createBaseNameTypeMiddleName("Jim"));
        contactInfoType.setName(name);

        PhoneNumberListType phoneNumberList = new PhoneNumberListType();
        PhoneNumberType phoneNumber = new PhoneNumberType();
        phoneNumber.setType(AUCodeSetsTelephoneNumberTypeType.fromValue(DEFAULT_PHONE_TYPE));
        phoneNumber.setNumber("08 9455 3382");
        phoneNumberList.getPhoneNumber().add(phoneNumber);
        contactInfoType.setPhoneNumberList(objectFactory.createContactInfoTypePhoneNumberList(phoneNumberList));

        contactInfoType.setPositionTitle(objectFactory.createContactInfoTypePositionTitle("Position Title"));
        contactInfoType.setRole(objectFactory.createContactInfoTypeRole("Role"));
        vendorInfoType.setContactInfo(objectFactory.createVendorInfoTypeContactInfo(contactInfoType));

        vendorInfoType.setCustomerId(objectFactory.createVendorInfoTypeCustomerId("434443L"));
        vendorInfoType.setName("Vendor Inc Pty Ltd");
        vendorInfoType.setPaymentTerms(objectFactory.createVendorInfoTypePaymentTerms("30"));
        vendorInfoType.setRegisteredForGST(objectFactory.createVendorInfoTypeRegisteredForGST(AUCodeSetsYesOrNoCategoryType.Y));

        vendorInfoTester.doCreateOne(vendorInfoType);
        String xmlExpectedTo = vendorInfoTester.getXML(vendorInfoType);

        vendorInfoType.setRefId(VendorInfoRefIds.REF_ID_2);
        vendorInfoTester.doCreateOne(vendorInfoType);
        vendorInfoType.setRefId(VendorInfoRefIds.REF_ID_3);
        vendorInfoTester.doCreateOne(vendorInfoType);
        vendorInfoType.setRefId(VendorInfoRefIds.REF_ID_4);
        vendorInfoTester.doCreateOne(vendorInfoType);
        vendorInfoType.setRefId(VendorInfoRefIds.REF_ID_5);
        vendorInfoTester.doCreateOne(vendorInfoType);

        VendorInfoType getResult = vendorInfoTester.doGetOne(VendorInfoRefIds.REF_ID_1);
        String xmlExpectedFrom = vendorInfoTester.getXML(getResult);
        boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
        if (!semiEquals) {
            Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
        }
    }

    @Before
    public void setup() {
        ConsumerLoader.initialise("TestConsumer");
        vendorInfoTester = new ConsumerTest<VendorInfoType, VendorInfoCollectionType>(VendorInfoType.class, "VendorInfo", VendorInfoCollectionType.class, "VendorInfos");
        vendorInfoTester.testDeleteMany(REF_IDS);
    }

    @Test
    @Category(IntegrationTest.class)
    public void testUpdateSingle() throws Exception {
        List<Response> responses = vendorInfoTester.testGetSingle(VendorInfoRefIds.REF_ID_1);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        VendorInfoType vendorInfo = (VendorInfoType) response.getDataObject();
        Assert.assertEquals(VendorInfoRefIds.REF_ID_1, vendorInfo.getRefId());

        String xmlExpectedFrom = vendorInfoTester.getXML(vendorInfo);

        List<Response> updateResponses = vendorInfoTester.doUpdateOne(vendorInfo, VendorInfoRefIds.REF_ID_1);
        Assert.assertNotNull(updateResponses);
        Assert.assertEquals(1, updateResponses.size());
        Assert.assertEquals(updateResponses.get(0).getStatus(), HttpStatus.NO_CONTENT.value());

        List<Response> getResponses = vendorInfoTester.testGetSingle(VendorInfoRefIds.REF_ID_1);
        Assert.assertNotNull(getResponses);
        Assert.assertEquals(1, getResponses.size());
        Response getResponse = getResponses.get(0);
        Assert.assertNotNull(getResponse.getDataObject());
        VendorInfoType comparisonTo = (VendorInfoType) getResponse.getDataObject();
        Assert.assertEquals(VendorInfoRefIds.REF_ID_1, comparisonTo.getRefId());
        String xmlExpectedTo = vendorInfoTester.getXML(comparisonTo);

        boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
        if (!semiEquals) {
            System.out.println("From:\n" + xmlExpectedFrom);
            System.out.println("\nTo:\n" + xmlExpectedTo);
            Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
        }
    }

    @Test
    @Category(IntegrationTest.class)
    public void testGetSingle() {
        List<Response> responses = vendorInfoTester.testGetSingle(VendorInfoRefIds.REF_ID_1);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        VendorInfoType vendorInfo = (VendorInfoType) response.getDataObject();
        Assert.assertEquals(VendorInfoRefIds.REF_ID_1, vendorInfo.getRefId());
    }

    @Test
    @Category(IntegrationTest.class)
    public void testGetMany() {
        List<Response> responses = vendorInfoTester.testGetMany(5, 0);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        VendorInfoCollectionType vendorInfoCollection = (VendorInfoCollectionType) response.getDataObject();
        Assert.assertNotNull(vendorInfoCollection.getVendorInfo());
        Assert.assertEquals(5, vendorInfoCollection.getVendorInfo().size());
    }

    @Test
    @Category(IntegrationTest.class)
    public void testCreateDelete() {
        List<Response> createResponses = vendorInfoTester.testCreateOne("vendorinfo.xml");
        Assert.assertNotNull(createResponses);
        Assert.assertEquals(1, createResponses.size());
        Response createResponse = createResponses.get(0);
        Assert.assertNotNull(createResponse.getDataObject());
        VendorInfoType vendorInfo = (VendorInfoType) createResponse.getDataObject();
        Assert.assertEquals(REF_ID_1, vendorInfo.getRefId());

        List<Response> deleteResponses = vendorInfoTester.testDeleteOne(REF_ID_1);
        Assert.assertNotNull(deleteResponses);
        Assert.assertEquals(1, deleteResponses.size());
        Response deleteResponse = deleteResponses.get(0);
        Assert.assertNull(deleteResponse.getDataObject());
        Assert.assertEquals(HttpStatus.NO_CONTENT.value(), deleteResponse.getStatus());
    }

    @Test
    @Category(IntegrationTest.class)
    public void testCreateDeleteMany() {
        final List<String> REF_ID_LIST = Arrays.asList(REF_IDS);

        List<BulkOperationResponse<CreateOperationStatus>> createResponses = vendorInfoTester.testCreateMany("vendorinfos.xml");
        Assert.assertNotNull(createResponses);
        Assert.assertEquals(1, createResponses.size());
        BulkOperationResponse<CreateOperationStatus> createResponse = createResponses.get(0);
        Assert.assertNotNull(createResponse.getOperationStatuses());
        Assert.assertEquals(2, createResponse.getOperationStatuses().size());
        for (CreateOperationStatus operationStatus : createResponse.getOperationStatuses()) {
            Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getAdvisoryID()));
            Assert.assertEquals(HttpStatus.CREATED.value(), operationStatus.getStatus());
        }

        List<BulkOperationResponse<OperationStatus>> deleteResponses = vendorInfoTester.testDeleteMany(REF_IDS);
        Assert.assertNotNull(deleteResponses);
        Assert.assertEquals(1, deleteResponses.size());
        BulkOperationResponse<OperationStatus> deleteResponse = deleteResponses.get(0);
        Assert.assertNotNull(deleteResponse.getOperationStatuses());
        Assert.assertEquals(2, deleteResponse.getOperationStatuses().size());
        for (OperationStatus operationStatus : deleteResponse.getOperationStatuses()) {
            Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getResourceID()));
            Assert.assertEquals(HttpStatus.OK.value(), operationStatus.getStatus());
        }
    }
}
