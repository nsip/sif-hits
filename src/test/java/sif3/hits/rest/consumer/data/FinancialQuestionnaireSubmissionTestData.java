//package sif3.hits.rest.consumer.data;
//
//import java.math.BigDecimal;
//import java.util.Arrays;
//import java.util.List;
//
//import sif.dd.au30.model.AGRuleListType;
//import sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType;
//import sif.dd.au30.model.EntityContactInfoType;
//import sif.dd.au30.model.FQContextualQuestionListType;
//import sif.dd.au30.model.FQContextualQuestionType;
//import sif.dd.au30.model.FQItemListType;
//import sif.dd.au30.model.FQItemType;
//import sif.dd.au30.model.FQReportingListType;
//import sif.dd.au30.model.FQReportingType;
//import sif.dd.au30.model.FinancialQuestionnaireSubmissionCollectionType;
//import sif.dd.au30.model.FinancialQuestionnaireSubmissionType;
//import sif.dd.au30.model.SoftwareVendorInfoContainerType;
//import sif3.hits.domain.converter.factory.IObjectFactory;
//import sif3.hits.utils.RefIdGenerator;
//
//public class FinancialQuestionnaireSubmissionTestData extends TestData<FinancialQuestionnaireSubmissionType, FinancialQuestionnaireSubmissionCollectionType> {
//
//    public static final String REF_ID_1 = "44a373db-6054-41fc-8588-3ff7c7936ce9";
//    public static final String REF_ID_2 = "6c239099-e95c-4119-bfbb-b2be4b4550d9";
//    public static final String REF_ID_3 = "2d0ef3f3-dcbf-4b24-a7e6-2cf1f7f127d6";
//    public static final String REF_ID_4 = "e739dc5e-58d6-4d20-b967-fdd08a5c7293";
//    public static final String REF_ID_5 = "d64f7442-8d35-4a52-b87e-1e62bdfc6b94";
//
//    public static final String[] REF_ID_RA = {REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5};
//    public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);
//
//    public static final String XML_REF_ID_1 = "fa55d29e-b547-4c28-8c5b-91e84d1f6480";
//    public static final String XML_REF_ID_2 = "f2c594be-ba02-4d4f-8447-7383b3f18a1b";
//
//    public static final String[] XML_REF_ID_RA = {XML_REF_ID_1, XML_REF_ID_2};
//    public static final List<String> XML_REF_ID_LIST = Arrays.asList(XML_REF_ID_RA);
//
//    public static final String FQ_REF_ID = "e2c655e4-12ee-4e95-ab27-4ce6b2f59d9";
//
//    public FinancialQuestionnaireSubmissionType getTestObject(String refId) {
//        IObjectFactory objectFactory = getObjectFactory();
//        FinancialQuestionnaireSubmissionType financialQuestionnaireSubmission = objectFactory.createFinancialQuestionnaireSubmissionType();
//        financialQuestionnaireSubmission.setRefId(refId);
//
//        financialQuestionnaireSubmission.setFQYear(getDate("2019"));
//        financialQuestionnaireSubmission.setReportingAuthority(objectFactory.createFinancialQuestionnaireSubmissionTypeReportingAuthority("reporting-authority"));
//        financialQuestionnaireSubmission.setReportingAuthoritySystem(objectFactory.createFinancialQuestionnaireSubmissionTypeReportingAuthoritySystem("authority system"));
//        financialQuestionnaireSubmission.setReportingAuthorityCommonwealthId("cid-1");
//        financialQuestionnaireSubmission.setSystemSubmission(objectFactory.createFinancialQuestionnaireSubmissionTypeSystemSubmission(AUCodeSetsYesOrNoCategoryType.fromValue("Y")));
//        financialQuestionnaireSubmission.setFQReportComments(objectFactory.createFinancialQuestionnaireSubmissionTypeFQReportComments("report comments would be here"));
//
//        SoftwareVendorInfoContainerType softwareVendorInfoContainerType = objectFactory.createSoftwareVendorInfoContainerType();
//        softwareVendorInfoContainerType.setSoftwareProduct("HUB Integration Testing Service");
//        softwareVendorInfoContainerType.setSoftwareVersion("v2.8.0");
//        financialQuestionnaireSubmission.setSoftwareVendorInfo(softwareVendorInfoContainerType);
//
//        financialQuestionnaireSubmission.setSubmissionContact(getEntityContact("Mr", "Submission", "Test", "Contact"));
//        FQReportingListType fqReportingListType = objectFactory.createFQReportingListType();
//        fqReportingListType.getFQReporting().add(getFQReporting(1));
//        fqReportingListType.getFQReporting().add(getFQReporting(2));
//        financialQuestionnaireSubmission.setFQReportingList(objectFactory.createFinancialQuestionnaireSubmissionTypeFQReportingList(fqReportingListType));
//        return financialQuestionnaireSubmission;
//    }
//
//    public FQReportingType getFQReporting(int index) {
//        IObjectFactory objectFactory = getObjectFactory();
//        FQReportingType target = objectFactory.createFQReportingType();
//        target.setFQRefId(objectFactory.createFQReportingTypeFQRefId(FQ_REF_ID + index));
//        target.setEntityLevel("" + index);
//        target.setSchoolInfoRefId(objectFactory.createFQReportingTypeSchoolInfoRefId(SchoolInfoTestData.REF_ID_1));
//        target.setLocalId(objectFactory.createFQReportingTypeLocalId("local-id-" + index));
//        target.setStateProvinceId(objectFactory.createFQReportingTypeStateProvinceId("sp-id-" + index));
//        target.setCommonwealthId("cw-id-" + index);
//        target.setACARAId(objectFactory.createFQReportingTypeACARAId("1234" + index));
//        target.setEntityName(objectFactory.createFQReportingTypeEntityName("entity name - " + index));
//        target.setEntityContact(getEntityContact("Ms", "Entity", "Test " + index, "Contact"));
//
//        FQContextualQuestionListType fqContextualQuestionListType = objectFactory.createFQContextualQuestionListType();
//        fqContextualQuestionListType.getFQContextualQuestion().add(getContextualQuestion(index, 1));
//        fqContextualQuestionListType.getFQContextualQuestion().add(getContextualQuestion(index, 2));
//        target.setFQContextualQuestionList(objectFactory.createFQReportingTypeFQContextualQuestionList(fqContextualQuestionListType));
//
//        FQItemListType fqItemListType = objectFactory.createFQItemListType();
//        fqItemListType.getFQItem().add(getFQItem(index, 1));
//        fqItemListType.getFQItem().add(getFQItem(index, 2));
//        target.setFQItemList(fqItemListType);
//
//        AGRuleListType agRuleListType = objectFactory.createAGRuleListType();
//        agRuleListType.getAGRule().add(getAGRuleType(index, 1));
//        agRuleListType.getAGRule().add(getAGRuleType(index, 2));
//        target.setAGRuleList(objectFactory.createFQReportingTypeAGRuleList(agRuleListType));
//        return target;
//    }
//
//    private static FQItemType getFQItem(int parentIndex, int index) {
//        IObjectFactory objectFactory = getObjectFactory();
//        FQItemType target = new FQItemType();
//        target.setFQItemCode("item-code-" + parentIndex + "-" + index);
//        target.setTuitionAmount(objectFactory.createFQItemTypeTuitionAmount(new BigDecimal("1" + parentIndex + index + ".00")));
//        target.setBoardingAmount(objectFactory.createFQItemTypeBoardingAmount(new BigDecimal("2" + parentIndex + index + ".00")));
//        target.setSystemAmount(objectFactory.createFQItemTypeSystemAmount(new BigDecimal("3" + parentIndex + index + ".00")));
//        target.setDioceseAmount(objectFactory.createFQItemTypeDioceseAmount(new BigDecimal("4" + parentIndex + index + ".00")));
//        target.setFQComments(objectFactory.createFQItemTypeFQComments("FQ Item Comments " + parentIndex + ":" + index));
//        return target;
//    }
//
//    private static FQContextualQuestionType getContextualQuestion(int parentIndex, int index) {
//        FQContextualQuestionType target = new FQContextualQuestionType();
//        target.setFQContext("context " + parentIndex + ":" + index);
//        target.setFQAnswer("answer " + parentIndex + ":" + index);
//        return target;
//    }
//
//    public static EntityContactInfoType getEntityContact(String title, String firstName, String middleNames, String lastName) {
//        IObjectFactory objectFactory = getObjectFactory();
//        EntityContactInfoType target = objectFactory.createEntityContactInfoType();
//        target.setName(getName(title, firstName, middleNames, lastName));
//        target.setQualifications(objectFactory.createEntityContactInfoTypeQualifications("Qualifications"));
//        target.setRole(objectFactory.createEntityContactInfoTypeRole("Role"));
//        target.setPositionTitle(objectFactory.createEntityContactInfoTypePositionTitle("Position"));
//        target.setRegistrationDetails(objectFactory.createEntityContactInfoTypeRegistrationDetails("Registration Details"));
//        target.setAddress(objectFactory.createEntityContactInfoTypeAddress(getAddress("c/- " + firstName + " " + lastName, "43 My Street")));
//        target.setEmail(getEmail(firstName + "." + lastName + "@not.a.real.domain"));
//        target.setPhoneNumber(getPhoneNumber("98740123"));
//        return target;
//    }
//
//    public String getRefId(int index) {
//        String result = null;
//        if (index >= 0 && index < REF_ID_RA.length) {
//            result = REF_ID_RA[index];
//        } else {
//            result = RefIdGenerator.getRefId();
//        }
//        return result;
//    }
//
//    public FinancialQuestionnaireSubmissionCollectionType getTestCollection(String... refIds) {
//        FinancialQuestionnaireSubmissionCollectionType result = new FinancialQuestionnaireSubmissionCollectionType();
//        for (int i = 0; refIds != null && i < refIds.length; i++) {
//            result.getFinancialQuestionnaireSubmission().add(getTestObject(refIds[i]));
//        }
//        return result;
//    }
//
//    public String getSingleObjectXMLFilename() {
//        return "FinancialQuestionnaireSubmission.xml";
//    }
//
//    public String getMultiObjectXMLFilename() {
//        return "FinancialQuestionnaireSubmissions.xml";
//    }
//
//}
//
