package sif3.hits.rest.consumer.data;

import sif.dd.au30.model.*;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.utils.RefIdGenerator;

import java.math.BigDecimal;
import java.util.*;

public class StudentSchoolEnrollmentTestData extends TestData<StudentSchoolEnrollmentType, StudentSchoolEnrollmentCollectionType> {

    public static final String REF_ID_1 = "48ef20db-d30b-4de5-ab1c-ee3d6e4f01dc";
    public static final String REF_ID_2 = "d0ab5940-3e38-4d48-81ff-3efb52c50b00";
    public static final String REF_ID_3 = "f0c42c50-f258-4c18-9bd8-ae99a656a0ff";
    public static final String REF_ID_4 = "30bd8bd3-9f68-48e2-bf34-d791c40bb28f";
    public static final String REF_ID_5 = "6354ea05-7e7a-46ac-ae4a-fcac06c2bf32";

    public static final String[] REF_ID_RA = {REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5};
    public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);

    public static final String XML_REF_ID_1 = "e35d4c5a-750e-43b5-a104-0a5f9c5fe5b4";
    public static final String XML_REF_ID_2 = "49c9c9bf-57db-4ff8-b13c-a93f40b9fa11";

    public static final String[] XML_REF_ID_RA = {XML_REF_ID_1, XML_REF_ID_2};
    public static final List<String> XML_REF_ID_LIST = Arrays.asList(XML_REF_ID_RA);

    public static final String SCHOOL_YEAR = "2018";
    public static final String YEAR_LEVEL = "8";
    public static final Map<String, String> STUDENT_MAP = new HashMap<>();

    static {
        STUDENT_MAP.put(REF_ID_1, StudentPersonalTestData.REF_ID_1);
        STUDENT_MAP.put(REF_ID_2, StudentPersonalTestData.REF_ID_2);
        STUDENT_MAP.put(REF_ID_3, StudentPersonalTestData.REF_ID_3);
        STUDENT_MAP.put(REF_ID_4, StudentPersonalTestData.REF_ID_4);
        STUDENT_MAP.put(REF_ID_5, StudentPersonalTestData.REF_ID_5);
        STUDENT_MAP.put(XML_REF_ID_1, StudentPersonalTestData.REF_ID_1);
        STUDENT_MAP.put(XML_REF_ID_2, StudentPersonalTestData.REF_ID_2);
    }

    public StudentSchoolEnrollmentType getTestObject(String refId) {
        IObjectFactory objectFactory = getObjectFactory();

        StudentSchoolEnrollmentType enrollment = new StudentSchoolEnrollmentType();
        enrollment.setRefId(refId);
        enrollment.setStudentPersonalRefId(STUDENT_MAP.getOrDefault(refId, StudentPersonalTestData.REF_ID_5));
        enrollment.setMembershipType(AUCodeSetsSchoolEnrollmentTypeType.fromValue("01"));
        enrollment.setLocalId(objectFactory.createStudentSchoolEnrollmentTypeLocalId("a-new-local-data"));
        enrollment.setTimeFrame(AUCodeSetsEnrollmentTimeFrameType.fromValue("H"));
        enrollment.setSchoolYear(getDate(SCHOOL_YEAR));
        enrollment.setEntryDate(getDate("2018-01-01"));
        enrollment.setHomegroup(objectFactory.createStudentSchoolEnrollmentTypeHomegroup("home-group"));
        enrollment.setACARASchoolId(objectFactory.createStudentSchoolEnrollmentTypeACARASchoolId(SchoolInfoTestData.ACARA_ID));
        enrollment.setSchoolInfoRefId(SchoolInfoTestData.REF_ID_1);
        enrollment.setClassCode(objectFactory.createStudentSchoolEnrollmentTypeClassCode("class-code"));
        enrollment.setReportingSchool(objectFactory.createStudentSchoolEnrollmentTypeReportingSchool(AUCodeSetsYesOrNoCategoryType.fromValue("Y")));
        enrollment.setHouse(objectFactory.createStudentSchoolEnrollmentTypeHouse("the-house"));
        enrollment.setIndividualLearningPlan(objectFactory.createStudentSchoolEnrollmentTypeIndividualLearningPlan(AUCodeSetsYesOrNoCategoryType.fromValue("N")));
        enrollment.setExitDate(objectFactory.createStudentSchoolEnrollmentTypeExitDate(getDate("2018-12-31")));
        enrollment.setFTE(objectFactory.createStudentSchoolEnrollmentTypeFTE(new BigDecimal("1.0")));
        enrollment.setFTPTStatus(objectFactory.createStudentSchoolEnrollmentTypeFTPTStatus(AUCodeSetsFTPTStatusCodeType.fromValue("01")));
        enrollment.setFFPOS(objectFactory.createStudentSchoolEnrollmentTypeFFPOS(AUCodeSetsFFPOSStatusCodeType.fromValue("2")));
        enrollment.setRecordClosureReason(objectFactory.createStudentSchoolEnrollmentTypeRecordClosureReason("end-of-year"));
        enrollment.setPreviousSchool(objectFactory.createStudentSchoolEnrollmentTypePreviousSchool("77b444bb-fe0a-48bb-971b-f510a4e76e48"));
        enrollment.setPreviousSchoolName(objectFactory.createStudentSchoolEnrollmentTypePreviousSchoolName("Previous Primary School"));
        enrollment.setDestinationSchool(objectFactory.createStudentSchoolEnrollmentTypeDestinationSchool("570eeaef-41a7-4686-bec4-0a87b080e2c4"));
        enrollment.setDestinationSchoolName(objectFactory.createStudentSchoolEnrollmentTypeDestinationSchoolName("Destination High School"));
        enrollment.setStartedAtSchoolDate(objectFactory.createStudentSchoolEnrollmentTypeStartedAtSchoolDate(getDate("2014-02-15")));
        enrollment.setInternationalStudent(objectFactory.createStudentSchoolEnrollmentTypeInternationalStudent(AUCodeSetsYesOrNoCategoryType.N));
        
        enrollment.setDisabilityLevelOfAdjustment(objectFactory.createStudentSchoolEnrollmentTypeDisabilityLevelOfAdjustment("QDTP"));
        enrollment.setDisabilityCategory(objectFactory.createStudentSchoolEnrollmentTypeDisabilityCategory("Physical"));
        enrollment.setCensusAge(objectFactory.createStudentSchoolEnrollmentTypeCensusAge(new BigDecimal("12")));
        enrollment.setDistanceEducationStudent(objectFactory.createStudentSchoolEnrollmentTypeDistanceEducationStudent(AUCodeSetsYesOrNoCategoryType.fromValue("Y")));
        enrollment.setBoardingStatus(objectFactory.createStudentSchoolEnrollmentTypeBoardingStatus(AUCodeSetsBoardingType.fromValue("D")));
        
        StudentEntryContainerType entryTypeContainer = objectFactory.createStudentEntryContainerType();
        entryTypeContainer.setCode(AUCodeSetsEntryTypeType.fromValue("1821"));
        enrollment.setEntryType(objectFactory.createStudentSchoolEnrollmentTypeEntryType(entryTypeContainer));

        YearLevelType yearLevelType = objectFactory.createYearLevelType();
        yearLevelType.setCode(AUCodeSetsYearLevelCodeType.fromValue(YEAR_LEVEL));
        enrollment.setYearLevel(objectFactory.createStudentSchoolEnrollmentTypeYearLevel(yearLevelType));

        StudentSchoolEnrollmentType.Homeroom homeroom = objectFactory.createStudentSchoolEnrollmentTypeHomeroom();
        homeroom.setSIFRefObject("RoomInfo");
        homeroom.setValue(RoomInfoTestData.REF_ID_1);
        enrollment.setHomeroom(objectFactory.createStudentSchoolEnrollmentTypeHomeroom(homeroom));

        StudentSchoolEnrollmentType.Advisor advisor = objectFactory.createStudentSchoolEnrollmentTypeAdvisor();
        advisor.setSIFRefObject("StaffPersonal");
        advisor.setValue(StaffPersonalTestData.REF_ID_1);
        enrollment.setAdvisor(objectFactory.createStudentSchoolEnrollmentTypeAdvisor(advisor));

        StudentSchoolEnrollmentType.Counselor counselor = objectFactory.createStudentSchoolEnrollmentTypeCounselor();
        counselor.setSIFRefObject("StaffPersonal");
        counselor.setValue(StaffPersonalTestData.REF_ID_4);
        enrollment.setCounselor(objectFactory.createStudentSchoolEnrollmentTypeCounselor(counselor));

        YearLevelType testLevelType = objectFactory.createYearLevelType();
        testLevelType.setCode(AUCodeSetsYearLevelCodeType.fromValue(YEAR_LEVEL));
        enrollment.setTestLevel(objectFactory.createStudentSchoolEnrollmentTypeTestLevel(testLevelType));

        StudentSchoolEnrollmentType.Calendar calendar = objectFactory.createStudentSchoolEnrollmentTypeCalendar();
        calendar.setSIFRefObject("CalendarSummary");
        calendar.setValue(CalendarSummaryTestData.REF_ID_1);
        enrollment.setCalendar(objectFactory.createStudentSchoolEnrollmentTypeCalendar(calendar));

        StudentExitStatusContainerType exitStatusContainer = objectFactory.createStudentExitStatusContainerType();
        exitStatusContainer.setCode(AUCodeSetsExitWithdrawalStatusType.fromValue("1905"));
        enrollment.setExitStatus(objectFactory.createStudentSchoolEnrollmentTypeExitStatus(exitStatusContainer));


        StudentExitContainerType exitTypeContainer = objectFactory.createStudentExitContainerType();
        exitTypeContainer.setCode(AUCodeSetsExitWithdrawalTypeType.fromValue("1907"));
        enrollment.setExitType(objectFactory.createStudentSchoolEnrollmentTypeExitType(exitTypeContainer));

        CatchmentStatusContainerType catchmentStatusContainer = objectFactory.createCatchmentStatusContainerType();
        catchmentStatusContainer.setCode(AUCodeSetsPublicSchoolCatchmentStatusType.fromValue("1652"));
        enrollment.setCatchmentStatus(objectFactory.createStudentSchoolEnrollmentTypeCatchmentStatus(catchmentStatusContainer));

        PromotionInfoType promotionInfo = objectFactory.createPromotionInfoType();
        promotionInfo.setPromotionStatus(objectFactory.createPromotionInfoTypePromotionStatus("promotion-status"));
        enrollment.setPromotionInfo(objectFactory.createStudentSchoolEnrollmentTypePromotionInfo(promotionInfo));

        StudentSubjectChoiceListType studentSubjectChoiceListType = objectFactory.createStudentSubjectChoiceListType();
        for (int i = 0; i < 5; i++) {
            StudentSubjectChoiceType studentSubjectChoiceType = objectFactory.createStudentSubjectChoiceType();
            studentSubjectChoiceType.setSubjectLocalId("subject-local-data-" + i);
            studentSubjectChoiceType.setOtherSchoolLocalId(objectFactory.createStudentSubjectChoiceTypeOtherSchoolLocalId("other-school-data-" + i));
            studentSubjectChoiceType.setPreferenceNumber(objectFactory.createStudentSubjectChoiceTypePreferenceNumber(Long.parseLong("" + (i + 1), 10)));
            SubjectAreaType subjectAreaType = objectFactory.createSubjectAreaType();
            subjectAreaType.setCode("study-description-" + i);
            studentSubjectChoiceType.setStudyDescription(objectFactory.createStudentSubjectChoiceTypeStudyDescription(subjectAreaType));
            studentSubjectChoiceListType.getStudentSubjectChoice().add(studentSubjectChoiceType);
        }
        enrollment.setStudentSubjectChoiceList(objectFactory.createStudentSchoolEnrollmentTypeStudentSubjectChoiceList(studentSubjectChoiceListType));

        StudentGroupListType studentGroupListType = objectFactory.createStudentGroupListType();
        for (int i = 0; i < 5; i++) {
            StudentGroupType studentGroup = objectFactory.createStudentGroupType();
            studentGroup.setGroupLocalId("group-local-data-" + i);
            studentGroup.setGroupCategory(AUCodeSetsGroupCategoryCodeType.fromValue("OtherGroup"));
            studentGroup.setGroupDescription(objectFactory.createStudentGroupTypeGroupDescription("group-description-" + i));
            studentGroupListType.getStudentGroup().add(studentGroup);
        }
        enrollment.setStudentGroupList(objectFactory.createStudentSchoolEnrollmentTypeStudentGroupList(studentGroupListType));

        PublishingPermissionListType publishingPermissionListType = objectFactory.createPublishingPermissionListType();
        for (int i = 0; i < AUCodeSetsPermissionCategoryCodeType.values().length; i++) {
            PublishingPermissionType publishingPermission = objectFactory.createPublishingPermissionType();
            publishingPermission.setPermissionValue(AUCodeSetsYesOrNoCategoryType.fromValue("Y"));
            publishingPermission.setPermissionCategory(AUCodeSetsPermissionCategoryCodeType.values()[i]);
            publishingPermissionListType.getPublishingPermission().add(publishingPermission);
        }
        enrollment.setPublishingPermissionList(objectFactory.createStudentSchoolEnrollmentTypePublishingPermissionList(publishingPermissionListType));

        return enrollment;
    }

    @Override
    public List<StudentSchoolEnrollmentType> getExamplesForQuery() {
        List<StudentSchoolEnrollmentType> examples = new ArrayList<>();
        IObjectFactory objectFactory = getObjectFactory();
        StudentSchoolEnrollmentType exampleOne = new StudentSchoolEnrollmentType();
        exampleOne.setStudentPersonalRefId(StudentPersonalTestData.REF_ID_2);
        examples.add(exampleOne);

        StudentSchoolEnrollmentType exampleTwo = new StudentSchoolEnrollmentType();
        exampleTwo.setSchoolYear(getDate(SCHOOL_YEAR));
        YearLevelType yly = new YearLevelType();
        yly.setCode(AUCodeSetsYearLevelCodeType.fromValue(YEAR_LEVEL));
        exampleTwo.setYearLevel(objectFactory.createStudentSchoolEnrollmentTypeYearLevel(yly));
        examples.add(exampleTwo);
        return examples;
    }

    @Override
    public boolean isExampleObject(StudentSchoolEnrollmentType object, int index) {
        if (index == 0) {
            return object != null && StudentPersonalTestData.REF_ID_2.equals(object.getStudentPersonalRefId());
        } else if (index == 1) {
            return object != null && getDate(SCHOOL_YEAR).equals(object.getSchoolYear()) && YEAR_LEVEL.equals(object.getYearLevel().getValue().getCode().value());
        }
        return super.isExampleObject(object, index);
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

    public StudentSchoolEnrollmentCollectionType getTestCollection(String... refIds) {
        StudentSchoolEnrollmentCollectionType result = new StudentSchoolEnrollmentCollectionType();
        for (int i = 0; refIds != null && i < refIds.length; i++) {
            result.getStudentSchoolEnrollment().add(getTestObject(refIds[i]));
        }
        return result;
    }

    public String getSingleObjectXMLFilename() {
        return "StudentSchoolEnrollment.xml";
    }

    public String getMultiObjectXMLFilename() {
        return "StudentSchoolEnrollments.xml";
    }

}

