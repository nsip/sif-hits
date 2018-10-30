package sif3.hits.rest.consumer;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.AUCodeSetsAddressTypeType;
import sif.dd.au30.model.AUCodeSetsEmailTypeType;
import sif.dd.au30.model.AUCodeSetsNameUsageTypeType;
import sif.dd.au30.model.AUCodeSetsStandardAustralianClassificationOfCountriesSACCType;
import sif.dd.au30.model.AUCodeSetsTelephoneNumberTypeType;
import sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType;
import sif.dd.au30.model.AddressStreetType;
import sif.dd.au30.model.AddressType;
import sif.dd.au30.model.EmailType;
import sif.dd.au30.model.EntityContactInfoType;
import sif.dd.au30.model.FQContextualQuestionListType;
import sif.dd.au30.model.FQContextualQuestionType;
import sif.dd.au30.model.FQItemListType;
import sif.dd.au30.model.FQItemType;
import sif.dd.au30.model.FQReportingCollectionType;
import sif.dd.au30.model.FQReportingType;
import sif.dd.au30.model.FQRuleListType;
import sif.dd.au30.model.FQRuleType;
import sif.dd.au30.model.GridLocationType;
import sif.dd.au30.model.MapReferenceType;
import sif.dd.au30.model.NameType;
import sif.dd.au30.model.ObjectFactory;
import sif.dd.au30.model.PhoneNumberType;
import sif.dd.au30.model.SoftwareVendorInfoContainerType;
import sif.dd.au30.model.StatisticalAreaType;
import sif.dd.au30.model.StatisticalAreasType;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.infra.rest.consumer.ConsumerLoader;

public class FQReportingConsumerTest extends BaseTest {
    private ConsumerTest<FQReportingType, FQReportingCollectionType> fqReportingTester = null;

    public static class FQReportingRefIds {
        public static String REF_ID_1 = "00694d06-6e2e-458f-86a2-e3641dba4f11";
        public static String REF_ID_2 = "fd4b8973-5652-40c7-ab7b-848b7c2e44e9";
        public static String REF_ID_3 = "3c4a155f-43ee-4307-a3ca-afd770fcdd73";
        public static String REF_ID_4 = "276a009c-9153-4a98-8f90-54172c4a99b9";
        public static String REF_ID_5 = "b3485f77-28bb-4651-ba0f-2be5cabd98ab";
    }

    private final String REF_ID_1 = "0d2862c0-9148-4820-b62c-16f6ee8edbb1";
    private final String REF_ID_2 = "57e498e8-7055-4c4a-89fd-f6d9a4905f2e";
    private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };

    private FQRuleType getFQRuleType(ObjectFactory objectFactory, String code, String comment) {
        FQRuleType result = objectFactory.createFQRuleType();
        result.setFQRuleCode(objectFactory.createFQRuleTypeFQRuleCode(code));
        result.setFQRuleComment(objectFactory.createFQRuleTypeFQRuleComment(comment));
        return result;
    }

    private FQItemType getFQItemType(ObjectFactory objectFactory, String code, String comment, String tuitionAmount, String boardingAmount, String systemAmount,
            String dioceseAmount) {
        FQItemType result = objectFactory.createFQItemType();
        result.setFQItemCode(code);
        result.setFQComments(comment);
        result.setTuitionAmount(objectFactory.createFQItemTypeTuitionAmount(new BigDecimal(tuitionAmount)));
        result.setBoardingAmount(objectFactory.createFQItemTypeBoardingAmount(new BigDecimal(boardingAmount)));
        result.setSystemAmount(objectFactory.createFQItemTypeSystemAmount(new BigDecimal(systemAmount)));
        result.setDioceseAmount(objectFactory.createFQItemTypeDioceseAmount(new BigDecimal(dioceseAmount)));
        return result;
    }

    private FQContextualQuestionType getFQContextualQuestionType(ObjectFactory objectFactory, String context, String answer) {
        FQContextualQuestionType result = objectFactory.createFQContextualQuestionType();
        result.setFQContext(context);
        result.setFQAnswer(answer);
        return result;
    }
    

    private EntityContactInfoType getEntityContact(ObjectFactory objectFactory) throws DatatypeConfigurationException {
        EntityContactInfoType entityContact = objectFactory.createEntityContactInfoType();
        entityContact.setName(getName(objectFactory));
        entityContact.setPositionTitle(objectFactory.createEntityContactInfoTypePositionTitle("Auditor"));
        entityContact.setRole(objectFactory.createEntityContactInfoTypeRole("Audits"));
        entityContact.setRegistrationDetails(objectFactory.createEntityContactInfoTypeRegistrationDetails("Registered"));
        entityContact.setQualifications(objectFactory.createEntityContactInfoTypeQualifications("Qualified"));
        entityContact.setAddress(objectFactory.createContactInfoTypeAddress(getAddress(objectFactory)));
        entityContact.setEmail(objectFactory.createEntityContactInfoTypeEmail(getEmail(objectFactory)));
        entityContact.setPhoneNumber(objectFactory.createEntityContactInfoTypePhoneNumber(getPhoneNumber(objectFactory)));
        return entityContact;
    }

    private PhoneNumberType getPhoneNumber(ObjectFactory objectFactory) {
        PhoneNumberType result = objectFactory.createPhoneNumberType();
        result.setType(AUCodeSetsTelephoneNumberTypeType.fromValue("0096"));
        result.setNumber("(03) 1234 5678");
        result.setExtension(objectFactory.createPhoneNumberTypeExtension("1234"));
        result.setListedStatus(objectFactory.createPhoneNumberTypeListedStatus(AUCodeSetsYesOrNoCategoryType.Y));
        result.setPreference(objectFactory.createPhoneNumberTypePreference(1L));
        return result;
    }

    private EmailType getEmail(ObjectFactory objectFactory) {
        EmailType result = objectFactory.createEmailType();
        result.setType(AUCodeSetsEmailTypeType.fromValue("01"));
        result.setValue("my.email@not.a.real.domain");
        return result;
    }

    private AddressType getAddress(ObjectFactory objectFactory) throws DatatypeConfigurationException {
        AddressType addressType = objectFactory.createAddressType();
        addressType.setType(AUCodeSetsAddressTypeType.fromValue("0123"));
        addressType.setEffectiveFromDate(objectFactory.createAddressTypeEffectiveFromDate(getDate("2010-01-23")));
        addressType.setEffectiveToDate(objectFactory.createAddressTypeEffectiveToDate(getDate("2019-01-23")));
        addressType.setStreet(getStreet(objectFactory));
        addressType.setCity("City");
        addressType.setStateProvince(objectFactory.createAddressTypeStateProvince("VIC"));
        addressType.setCountry(objectFactory.createAddressTypeCountry(AUCodeSetsStandardAustralianClassificationOfCountriesSACCType.fromValue("1101")));
        addressType.setPostalCode("3210");
        addressType.setGridLocation(objectFactory.createAddressTypeGridLocation(getGridLocation(objectFactory)));
        addressType.setMapReference(objectFactory.createAddressTypeMapReference(getMapReference(objectFactory)));
        addressType.setRadioContact(objectFactory.createAddressTypeRadioContact("radio-012"));
        addressType.setCommunity(objectFactory.createAddressTypeCommunity("community-0123"));
        addressType.setLocalId(objectFactory.createAddressTypeLocalId("ad01234"));
        addressType.setAddressGlobalUID(objectFactory.createAddressTypeAddressGlobalUID("50dff74e-e3a4-4be1-83a9-4c60a6db4dd3"));
        
        StatisticalAreasType statisticalAreasType = objectFactory.createStatisticalAreasType();
        statisticalAreasType.getStatisticalArea().add(getStatisticalArea(objectFactory,"SLA","Hepburn (S) - West"));
        statisticalAreasType.getStatisticalArea().add(getStatisticalArea(objectFactory,"SSD","2010 East Central Highlands"));
        statisticalAreasType.getStatisticalArea().add(getStatisticalArea(objectFactory,"SD","20 Central Highlands"));
        addressType.setStatisticalAreas(objectFactory.createAddressTypeStatisticalAreas(statisticalAreasType));
        return addressType;
    }

    private StatisticalAreaType getStatisticalArea(ObjectFactory objectFactory, String unitType, String value) {    
        StatisticalAreaType result = objectFactory.createStatisticalAreaType();
        result.setSpatialUnitType(unitType);
        result.setValue(value);
        return result;
    }

    private MapReferenceType getMapReference(ObjectFactory objectFactory) {
        MapReferenceType result = objectFactory.createMapReferenceType();
        result.setType("Geographic DMS");
        result.setXCoordinate("37° 30' 3.186'' S");
        result.setYCoordinate("143° 59' 19.194'' E");
        return result;
    }

    private GridLocationType getGridLocation(ObjectFactory objectFactory) {
        GridLocationType result = objectFactory.createGridLocationType();
        result.setLatitude(new BigDecimal("-37.500885"));
        result.setLongitude(new BigDecimal("143.988665"));
        return result;
    }

    private AddressStreetType getStreet(ObjectFactory objectFactory) {
        AddressStreetType result = objectFactory.createAddressStreetType();
        result.setLine1("Administration Building");
        result.setLine2(objectFactory.createAddressStreetTypeLine2("Senior Campus"));
        result.setLine3(objectFactory.createAddressStreetTypeLine3("123 Some Road"));
        result.setComplex(objectFactory.createAddressStreetTypeComplex("Complex"));
        result.setStreetNumber(objectFactory.createAddressStreetTypeStreetNumber("123"));
        result.setStreetPrefix(objectFactory.createAddressStreetTypeStreetPrefix("Prefix"));
        result.setStreetType(objectFactory.createAddressStreetTypeStreetType("Road"));
        result.setStreetSuffix(objectFactory.createAddressStreetTypeStreetSuffix("East"));
        result.setApartmentType(objectFactory.createAddressStreetTypeApartmentType("Apartments"));
        result.setApartmentNumber(objectFactory.createAddressStreetTypeApartmentNumber("1A"));
        result.setApartmentNumberPrefix(objectFactory.createAddressStreetTypeApartmentNumberPrefix("1"));
        result.setApartmentNumberSuffix(objectFactory.createAddressStreetTypeApartmentNumberSuffix("A"));
        return result;
    }

    private NameType getName(ObjectFactory objectFactory) {
        NameType nameType = objectFactory.createNameType();
        nameType.setType(AUCodeSetsNameUsageTypeType.LGL);
        nameType.setTitle(objectFactory.createBaseNameTypeTitle("Mr"));
        nameType.setFamilyName(objectFactory.createBaseNameTypeFamilyName("Smith"));
        nameType.setGivenName(objectFactory.createBaseNameTypeGivenName("John"));
        nameType.setMiddleName(objectFactory.createBaseNameTypeMiddleName("James"));
        nameType.setFamilyNameFirst(objectFactory.createBaseNameTypeFamilyNameFirst(AUCodeSetsYesOrNoCategoryType.N));
        nameType.setPreferredFamilyName(objectFactory.createBaseNameTypePreferredFamilyName("Jones"));
        nameType.setPreferredFamilyNameFirst(objectFactory.createBaseNameTypePreferredFamilyNameFirst(AUCodeSetsYesOrNoCategoryType.N));
        nameType.setPreferredGivenName(objectFactory.createBaseNameTypePreferredGivenName("James"));
        nameType.setFullName(objectFactory.createBaseNameTypeFullName("Mr John James Smith III"));
        return nameType;
    }

    @Test
    @Category({ IntegrationTest.class, InitialiseData.class })
    public void initialiseData() throws Exception {
        ObjectFactory objectFactory = new ObjectFactory();
        FQReportingType fqReporting = new FQReportingType();
        fqReporting.setRefId(FQReportingRefIds.REF_ID_1);
        fqReporting.setFQYear(getDate("2018"));
        fqReporting.setReportingAuthority(objectFactory.createFQReportingTypeReportingAuthority("Ballarat Diocese"));
        fqReporting.setReportingAuthoritySystem(objectFactory.createFQReportingTypeReportingAuthoritySystem("Vic Catholic"));
        fqReporting.setReportingAuthorityCommonwealthId(objectFactory.createFQReportingTypeReportingAuthorityCommonwealthId("123456"));
        fqReporting.setSystemSubmission(objectFactory.createFQReportingTypeSystemSubmission(AUCodeSetsYesOrNoCategoryType.Y));
        
        SoftwareVendorInfoContainerType softwareVendorInfoContainerType = objectFactory.createSoftwareVendorInfoContainerType();
        softwareVendorInfoContainerType.setSoftwareProduct(objectFactory.createSoftwareVendorInfoContainerTypeSoftwareProduct("MYOB"));
        softwareVendorInfoContainerType.setSoftwareVersion(objectFactory.createSoftwareVendorInfoContainerTypeSoftwareVersion("11.0"));
        fqReporting.setSoftwareVendorInfo(objectFactory.createFQReportingTypeSoftwareVendorInfo(softwareVendorInfoContainerType));
        
        fqReporting.setEntityLevel(objectFactory.createFQReportingTypeEntityLevel("School"));
        fqReporting.setSchoolInfoRefId(objectFactory.createFQReportingTypeSchoolInfoRefId(SchoolInfoConsumerTest.REF_ID));
        fqReporting.setLocalId(objectFactory.createFQReportingTypeLocalId("012384390132190"));
        fqReporting.setStateProvinceId(objectFactory.createFQReportingTypeStateProvinceId("xx-pp-12345"));
        fqReporting.setCommonwealthId(objectFactory.createFQReportingTypeCommonwealthId("39813"));
        fqReporting.setACARAId(objectFactory.createFQReportingTypeACARAId("1234"));
        fqReporting.setEntityName(objectFactory.createFQReportingTypeEntityName("ABC Secondary College"));
        
        fqReporting.setEntityContact(objectFactory.createFQReportingTypeEntityContact(getEntityContact(objectFactory)));
        
        FQContextualQuestionListType fqContextualQuestionListType = objectFactory.createFQContextualQuestionListType();
        fqContextualQuestionListType.getFQContextualQuestion().add(getFQContextualQuestionType(objectFactory, "GI.010", "Cash"));
        fqContextualQuestionListType.getFQContextualQuestion().add(getFQContextualQuestionType(objectFactory, "GI.015", "No"));
        fqContextualQuestionListType.getFQContextualQuestion().add(getFQContextualQuestionType(objectFactory, "GI.020", "In kind"));
        
        FQItemListType fqItemListType = objectFactory.createFQItemListType();
        fqItemListType.getFQItem().add(getFQItemType(objectFactory, "RI.010", "Item 1", "123.00", "456.00", "789.00", "101.00"));
        fqItemListType.getFQItem().add(getFQItemType(objectFactory, "RI.020", "Item 2", "234.00", "567.00", "890.00", "212.00"));
        fqItemListType.getFQItem().add(getFQItemType(objectFactory, "RI.030", "Item 3", "345.00", "678.00", "901.00", "323.00"));
        fqItemListType.getFQItem().add(getFQItemType(objectFactory, "RI.040", "Item 4", "456.00", "789.00", "123.00", "434.00"));
        fqReporting.setFQItemList(objectFactory.createFQReportingTypeFQItemList(fqItemListType));
        
        FQRuleListType fqRuleListType = objectFactory.createFQRuleListType();
        fqRuleListType.getFQRule().add(getFQRuleType(objectFactory, "WR-001", "Rule 1. Don't talk about FQ Reporting"));
        fqRuleListType.getFQRule().add(getFQRuleType(objectFactory, "WR-002", "Rule 2. See rule 1."));
        fqReporting.setFQRuleList(objectFactory.createFQReportingTypeFQRuleList(fqRuleListType));

        fqReportingTester.doCreateOne(fqReporting);
        fqReportingTester.doUpdateOne(fqReporting, fqReporting.getRefId());
        String xmlExpectedTo = fqReportingTester.getXML(fqReporting);

        fqReporting.setRefId(FQReportingRefIds.REF_ID_2);
        fqReportingTester.doCreateOne(fqReporting);
        fqReportingTester.doUpdateOne(fqReporting, fqReporting.getRefId());

        fqReporting.setRefId(FQReportingRefIds.REF_ID_3);
        fqReportingTester.doCreateOne(fqReporting);
        fqReportingTester.doUpdateOne(fqReporting, fqReporting.getRefId());

        fqReporting.setRefId(FQReportingRefIds.REF_ID_4);
        fqReportingTester.doCreateOne(fqReporting);
        fqReportingTester.doUpdateOne(fqReporting, fqReporting.getRefId());

        fqReporting.setRefId(FQReportingRefIds.REF_ID_5);
        fqReportingTester.doCreateOne(fqReporting);
        fqReportingTester.doUpdateOne(fqReporting, fqReporting.getRefId());

        FQReportingType getResult = fqReportingTester.doGetOne(FQReportingRefIds.REF_ID_1);
        String xmlExpectedFrom = fqReportingTester.getXML(getResult);
        Assert.assertNotNull("XML Expected From isNull", xmlExpectedFrom);
        Assert.assertNotNull("XML Expected To isNull", xmlExpectedTo);
        boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
        if (!semiEquals) {
            Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
        }
    }


    @Before
    public void setup() {
        ConsumerLoader.initialise("TestConsumer");
        fqReportingTester = new ConsumerTest<FQReportingType, FQReportingCollectionType>(FQReportingType.class, "FQReporting", FQReportingCollectionType.class, "FQReportings");
        fqReportingTester.testDeleteMany(REF_IDS);
    }

    @Test
    @Category(IntegrationTest.class)
    public void testUpdateSingle() throws Exception {
        List<Response> responses = fqReportingTester.testGetSingle(FQReportingRefIds.REF_ID_1);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        FQReportingType fqReporting = (FQReportingType) response.getDataObject();
        Assert.assertEquals(FQReportingRefIds.REF_ID_1, fqReporting.getRefId());

        String xmlExpectedFrom = fqReportingTester.getXML(fqReporting);

        List<Response> updateResponses = fqReportingTester.doUpdateOne(fqReporting, FQReportingRefIds.REF_ID_1);
        Assert.assertNotNull(updateResponses);
        Assert.assertEquals(1, updateResponses.size());
        Assert.assertEquals(updateResponses.get(0).getStatus(), HttpStatus.NO_CONTENT.value());

        List<Response> getResponses = fqReportingTester.testGetSingle(FQReportingRefIds.REF_ID_1);
        Assert.assertNotNull(getResponses);
        Assert.assertEquals(1, getResponses.size());
        Response getResponse = getResponses.get(0);
        Assert.assertNotNull(getResponse.getDataObject());
        FQReportingType fqReportingTo = (FQReportingType) getResponse.getDataObject();
        Assert.assertEquals(FQReportingRefIds.REF_ID_1, fqReportingTo.getRefId());
        String xmlExpectedTo = fqReportingTester.getXML(fqReportingTo);

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
        List<Response> responses = fqReportingTester.testGetSingle(FQReportingRefIds.REF_ID_1);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        FQReportingType fqReporting = (FQReportingType) response.getDataObject();
        Assert.assertEquals(FQReportingRefIds.REF_ID_1, fqReporting.getRefId());
    }

    @Test
    @Category(IntegrationTest.class)
    public void testQBE() {
        // No QBE's required yet.
    }

    @Test
    @Category(IntegrationTest.class)
    public void testGetMany() {
        List<Response> responses = fqReportingTester.testGetMany(5, 0);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        FQReportingCollectionType studentCollection = (FQReportingCollectionType) response.getDataObject();
        Assert.assertNotNull(studentCollection.getFQReporting());
        Assert.assertEquals(5, studentCollection.getFQReporting().size());
    }

    @Test
    @Category(IntegrationTest.class)
    public void testCreateDelete() {
        List<Response> createResponses = fqReportingTester.testCreateOne("fqreporting.xml");
        Assert.assertNotNull(createResponses);
        Assert.assertEquals(1, createResponses.size());
        Response createResponse = createResponses.get(0);
        Assert.assertNotNull(createResponse.getDataObject());
        FQReportingType fqReporting = (FQReportingType) createResponse.getDataObject();
        Assert.assertEquals(REF_ID_1, fqReporting.getRefId());

        List<Response> deleteResponses = fqReportingTester.testDeleteOne(REF_ID_1);
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

        List<BulkOperationResponse<CreateOperationStatus>> createResponses = fqReportingTester.testCreateMany("fqreportings.xml");
        Assert.assertNotNull(createResponses);
        Assert.assertEquals(1, createResponses.size());
        BulkOperationResponse<CreateOperationStatus> createResponse = createResponses.get(0);
        Assert.assertNotNull(createResponse.getOperationStatuses());
        Assert.assertEquals(2, createResponse.getOperationStatuses().size());
        for (CreateOperationStatus operationStatus : createResponse.getOperationStatuses()) {
            Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getAdvisoryID()));
            Assert.assertEquals(HttpStatus.CREATED.value(), operationStatus.getStatus());
        }

        List<BulkOperationResponse<OperationStatus>> deleteResponses = fqReportingTester.testDeleteMany(REF_IDS);
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
