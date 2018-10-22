package sif3.hits.rest.consumer;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.AUCodeSetsEmailTypeType;
import sif.dd.au30.model.AUCodeSetsSexCodeType;
import sif.dd.au30.model.AUCodeSetsStaffStatusType;
import sif.dd.au30.model.AUCodeSetsTelephoneNumberTypeType;
import sif.dd.au30.model.DemographicsType;
import sif.dd.au30.model.EmailListType;
import sif.dd.au30.model.EmailType;
import sif.dd.au30.model.NameOfRecordType;
import sif.dd.au30.model.ObjectFactory;
import sif.dd.au30.model.OtherIdListType;
import sif.dd.au30.model.OtherIdType;
import sif.dd.au30.model.PersonInfoType;
import sif.dd.au30.model.PhoneNumberListType;
import sif.dd.au30.model.PhoneNumberType;
import sif.dd.au30.model.StaffPersonalCollectionType;
import sif.dd.au30.model.StaffPersonalType;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.infra.rest.consumer.ConsumerLoader;

public class StaffPersonalConsumerTest extends BaseTest {
    private ConsumerTest<StaffPersonalType, StaffPersonalCollectionType> staffTester = null;

    public static class StaffPersonalRefIds {
        public static String REF_ID_1 = "7d83555d-24e9-4d4f-bb3e-21d7ad86b8d3";
        public static String REF_ID_2 = "40453960-800e-47d1-ae1e-8dee599eaaf8";
        public static String REF_ID_3 = "4414f636-f3ca-4eb6-8898-88810a7e3018";
        public static String REF_ID_4 = "46077b13-71f6-4c10-9ed0-275f16952f05";
        public static String REF_ID_5 = "9e62ae55-aba1-41a1-8f3e-d09635b203f5";

        public static String LOCAL_ID = "ez7b7b7";

        public static NameOfRecordType getNameOfRecord(ObjectFactory objectFactory) {
            NameOfRecordType nameOfRecordType = new NameOfRecordType();
            nameOfRecordType.setType("LGL");
            nameOfRecordType.setFamilyName(objectFactory.createBaseNameTypeFamilyName("Tester"));
            nameOfRecordType.setPreferredFamilyName(objectFactory.createBaseNameTypePreferredFamilyName("PTester"));
            nameOfRecordType.setGivenName(objectFactory.createBaseNameTypeGivenName("Gavin"));
            nameOfRecordType.setPreferredGivenName(objectFactory.createBaseNameTypePreferredGivenName("PGavin"));
            nameOfRecordType.setMiddleName(objectFactory.createBaseNameTypeMiddleName("Middle"));
            nameOfRecordType.setTitle(objectFactory.createBaseNameTypeTitle("Mr"));
            nameOfRecordType.setFullName(objectFactory.createBaseNameTypeFullName("Mr Full Name Gavin Tester"));
            return nameOfRecordType;
        }
    }

    private final String REF_ID_1 = "E9F19488026B11E3A5325DE06940ABA2";
    private final String REF_ID_2 = "E9F19488026B11E3A5325DE06940ABA4";
    private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };

    @Test
    @Category({ IntegrationTest.class, InitialiseData.class })
    public void initialiseData() throws Exception {
        ObjectFactory objectFactory = new ObjectFactory();
        StaffPersonalType staffPersonalType = new StaffPersonalType();
        staffPersonalType.setRefId(StaffPersonalRefIds.REF_ID_1);
        staffPersonalType.setLocalId(StaffPersonalRefIds.LOCAL_ID);

        PersonInfoType personInfo = new PersonInfoType();
        NameOfRecordType nameOfRecordType = StaffPersonalRefIds.getNameOfRecord(objectFactory);
        personInfo.setName(nameOfRecordType);

        DemographicsType demographics = new DemographicsType();
        demographics.setSex(objectFactory.createDemographicsTypeSex(AUCodeSetsSexCodeType.fromValue("1")));
        demographics.setBirthDate(objectFactory.createDemographicsTypeBirthDate(getDate("1984-12-20")));
        personInfo.setDemographics(objectFactory.createPersonInfoTypeDemographics(demographics));

        PhoneNumberListType phoneNumberList = new PhoneNumberListType();
        PhoneNumberType phoneNumber = new PhoneNumberType();
        phoneNumber.setType(AUCodeSetsTelephoneNumberTypeType.fromValue("0096"));
        phoneNumber.setNumber("+61400000000");
        phoneNumberList.getPhoneNumber().add(phoneNumber);
        personInfo.setPhoneNumberList(objectFactory.createPersonInfoTypePhoneNumberList(phoneNumberList));

        EmailListType emailList = new EmailListType();
        EmailType email = new EmailType();
        email.setType(AUCodeSetsEmailTypeType.fromValue("06")); // AUCodeSetsEmailTypeType.WORK
        email.setValue("the.email@not.a.real.domain");
        emailList.getEmail().add(email);
        personInfo.setEmailList(objectFactory.createPersonInfoTypeEmailList(emailList));

        staffPersonalType.setPersonInfo(personInfo);

        staffPersonalType.setEmploymentStatus(objectFactory.createStaffPersonalTypeEmploymentStatus(AUCodeSetsStaffStatusType.A));
        staffPersonalType.setStateProvinceId(objectFactory.createStaffPersonalTypeStateProvinceId("WA"));

        OtherIdListType otherIdList = new OtherIdListType();
        OtherIdType otherId = new OtherIdType();
        otherId.setType("0004");
        otherId.setValue("identifier");
        otherIdList.getOtherId().add(otherId);
        otherId = new OtherIdType();
        otherId.setType("0003");
        otherId.setValue("otherid");
        otherIdList.getOtherId().add(otherId);
        staffPersonalType.setOtherIdList(objectFactory.createStaffPersonalTypeOtherIdList(otherIdList));

        staffTester.doCreateOne(staffPersonalType);
        String xmlExpectedTo = staffTester.getXML(staffPersonalType);

        staffPersonalType.setRefId(StaffPersonalRefIds.REF_ID_2);
        staffTester.doCreateOne(staffPersonalType);
        staffPersonalType.setRefId(StaffPersonalRefIds.REF_ID_3);
        staffTester.doCreateOne(staffPersonalType);
        staffPersonalType.setRefId(StaffPersonalRefIds.REF_ID_4);
        staffTester.doCreateOne(staffPersonalType);
        staffPersonalType.setRefId(StaffPersonalRefIds.REF_ID_5);
        staffPersonalType.setOtherIdList(null);
        staffTester.doCreateOne(staffPersonalType);

        StaffPersonalType getResult = staffTester.doGetOne(StaffPersonalRefIds.REF_ID_1);
        String xmlExpectedFrom = staffTester.getXML(getResult);
        boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
        if (!semiEquals) {
            Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
        }
    }

    @Before
    public void setup() {
        ConsumerLoader.initialise("TestConsumer");
        staffTester = new ConsumerTest<StaffPersonalType, StaffPersonalCollectionType>(StaffPersonalType.class, "StaffPersonal", StaffPersonalCollectionType.class,
                "StaffPersonals");
        staffTester.testDeleteMany(REF_IDS);
    }

    @Test
    @Category(IntegrationTest.class)
    public void testUpdateSingle() throws Exception {
        List<Response> responses = staffTester.testGetSingle(StaffPersonalRefIds.REF_ID_1);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        StaffPersonalType staffPersonal = (StaffPersonalType) response.getDataObject();
        Assert.assertEquals(StaffPersonalRefIds.REF_ID_1, staffPersonal.getRefId());

        String xmlExpectedFrom = staffTester.getXML(staffPersonal);

        List<Response> updateResponses = staffTester.doUpdateOne(staffPersonal, StaffPersonalRefIds.REF_ID_1);
        Assert.assertNotNull(updateResponses);
        Assert.assertEquals(1, updateResponses.size());
        Assert.assertEquals(updateResponses.get(0).getStatus(), HttpStatus.NO_CONTENT.value());

        List<Response> getResponses = staffTester.testGetSingle(StaffPersonalRefIds.REF_ID_1);
        Assert.assertNotNull(getResponses);
        Assert.assertEquals(1, getResponses.size());
        Response getResponse = getResponses.get(0);
        Assert.assertNotNull(getResponse.getDataObject());
        StaffPersonalType comparisonTo = (StaffPersonalType) getResponse.getDataObject();
        Assert.assertEquals(StaffPersonalRefIds.REF_ID_1, comparisonTo.getRefId());
        String xmlExpectedTo = staffTester.getXML(comparisonTo);

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
        List<Response> responses = staffTester.testGetSingle(StaffPersonalRefIds.REF_ID_1);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        StaffPersonalType staffPersonal = (StaffPersonalType) response.getDataObject();
        Assert.assertEquals(StaffPersonalRefIds.REF_ID_1, staffPersonal.getRefId());
    }

    @Test
    @Category(IntegrationTest.class)
    public void testGetMany() {
        List<Response> responses = staffTester.testGetMany(5, 0);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        StaffPersonalCollectionType staffCollection = (StaffPersonalCollectionType) response.getDataObject();
        Assert.assertNotNull(staffCollection.getStaffPersonal());
        Assert.assertEquals(5, staffCollection.getStaffPersonal().size());
    }

    @Test
    @Category(IntegrationTest.class)
    public void testCreateDelete() {
        List<Response> createResponses = staffTester.testCreateOne("staff.xml");
        Assert.assertNotNull(createResponses);
        Assert.assertEquals(1, createResponses.size());
        Response createResponse = createResponses.get(0);
        Assert.assertNotNull(createResponse.getDataObject());
        StaffPersonalType staffPersonal = (StaffPersonalType) createResponse.getDataObject();
        Assert.assertEquals(REF_ID_1, staffPersonal.getRefId());

        List<Response> deleteResponses = staffTester.testDeleteOne(REF_ID_1);
        Assert.assertNotNull(deleteResponses);
        Assert.assertEquals(1, deleteResponses.size());
        Response deleteResponse = deleteResponses.get(0);
        Assert.assertNull(deleteResponse.getDataObject());
        Assert.assertEquals(HttpStatus.NO_CONTENT.value(), deleteResponse.getStatus());
    }
    
    @Test
    @Category(IntegrationTest.class)
    public void testCreate() {
//        String s = new String("ö");
//        byte[] b = s.getBytes(Charset.forName("UTF-8"));
//        for (int i = 0; i < b.length; i++) {
//            System.out.print(b[i]  & 0xFF);
//        }
//        System.out.print("\n");
//        byte[] bb = s.getBytes(Charset.forName("ISO-8859-1"));
//        for (int i = 0; i < bb.length; i++) {
//            System.out.print(bb[i] & 0xFF);
//        }
        staffTester.testUpdateMany("staffs.xml");
    }

    @Test
    @Category(IntegrationTest.class)
    public void testCreateDeleteMany() {
        final List<String> REF_ID_LIST = Arrays.asList(REF_IDS);

        List<BulkOperationResponse<CreateOperationStatus>> createResponses = staffTester.testCreateMany("staffs.xml");
        Assert.assertNotNull(createResponses);
        Assert.assertEquals(1, createResponses.size());
        BulkOperationResponse<CreateOperationStatus> createResponse = createResponses.get(0);
        Assert.assertNotNull(createResponse.getOperationStatuses());
        Assert.assertEquals(2, createResponse.getOperationStatuses().size());
        for (CreateOperationStatus operationStatus : createResponse.getOperationStatuses()) {
            Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getAdvisoryID()));
            Assert.assertEquals(HttpStatus.CREATED.value(), operationStatus.getStatus());
        }

        List<BulkOperationResponse<OperationStatus>> deleteResponses = staffTester.testDeleteMany(REF_IDS);
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
