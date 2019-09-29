package sif3.hits.rest.consumer.data;

import sif.dd.au30.model.*;
import sif3.common.model.QueryCriteria;
import sif3.common.model.QueryOperator;
import sif3.common.model.QueryPredicate;
import sif3.hits.utils.RefIdGenerator;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class StaffAssignmentTestData extends TestData<StaffAssignmentType, StaffAssignmentCollectionType> {

    public static final String REF_ID_1 = "6a05bce1-ec88-40f7-a747-3de0a1f5c99f";
    public static final String REF_ID_2 = "abb2634a-6e24-4e47-8930-40cdcfee5ed6";
    public static final String REF_ID_3 = "f17a9866-fe18-4a0a-8b8f-c708aa4242dd";
    public static final String REF_ID_4 = "292bd6ba-33fa-4626-a260-67ac279fbb43";
    public static final String REF_ID_5 = "b0f02e3e-50b7-4904-b32e-0adb0d7386c0";

    public static final String[] REF_ID_RA = {REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5};
    public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);

    public static final String XML_REF_ID_1 = "10413493-8f28-4dec-ab20-45a84236d108";
    public static final String XML_REF_ID_2 = "cfb04779-4af4-4faf-be16-0cc26d3b24e3";

    public static final String[] XML_REF_ID_RA = {XML_REF_ID_1, XML_REF_ID_2};
    public static final List<String> XML_REF_ID_LIST = Arrays.asList(XML_REF_ID_RA);

    public StaffAssignmentType getTestObject(String refId) {
        ObjectFactory objectFactory = new ObjectFactory();

        StaffAssignmentType staffAssignment = new StaffAssignmentType();
        staffAssignment.setRefId(refId);
        staffAssignment.setStaffPersonalRefId(StaffPersonalTestData.REF_ID_1);
        staffAssignment.setSchoolInfoRefId(SchoolInfoTestData.REF_ID_1);
        staffAssignment.setSchoolYear(objectFactory.createStaffAssignmentTypeSchoolYear(getDate("2014")));
        staffAssignment.setDescription(objectFactory.createStaffAssignmentTypeDescription("Description"));
        staffAssignment.setPrimaryAssignment(AUCodeSetsYesOrNoCategoryType.Y);
        staffAssignment.setJobStartDate(objectFactory.createStaffAssignmentTypeJobStartDate(getDate("2012-01-20")));
        staffAssignment.setJobEndDate(objectFactory.createStaffAssignmentTypeJobEndDate(getDate("2014-12-20")));
        staffAssignment.setJobFunction(objectFactory.createStaffAssignmentTypeJobFunction("Teacher"));
        staffAssignment.setJobFTE(objectFactory.createStaffAssignmentTypeJobFTE(new BigDecimal("1")));
        staffAssignment.setEmploymentStatus(objectFactory.createStaffAssignmentTypeEmploymentStatus(AUCodeSetsStaffStatusType.fromValue("A")));
        staffAssignment.setCasualReliefTeacher(objectFactory.createStaffAssignmentTypeCasualReliefTeacher(AUCodeSetsYesOrNoCategoryType.fromValue("Y")));
        staffAssignment.setHomegroup(objectFactory.createStaffAssignmentTypeHomegroup("Home Group"));
        staffAssignment.setHouse(objectFactory.createStaffAssignmentTypeHouse("House"));
        staffAssignment.setPreviousSchoolName(objectFactory.createStaffAssignmentTypePreviousSchoolName("Previous High School"));
        staffAssignment.setAvailableForTimetable(objectFactory.createStaffAssignmentTypeAvailableForTimetable(AUCodeSetsYesOrNoCategoryType.Y));
        
        if (REF_ID_5.equals(refId)) {
            staffAssignment.setStaffPersonalRefId(StaffPersonalTestData.REF_ID_5);
        }

        StaffActivityExtensionType staffActivity = new StaffActivityExtensionType();
        staffActivity.setCode(AUCodeSetsStaffActivityType.fromValue("1102"));
        staffAssignment.setStaffActivity(objectFactory.createStaffAssignmentTypeStaffActivity(staffActivity));

        YearLevelsType yearLevels = objectFactory.createYearLevelsType();
        for (int i = 8; i < 13; i++) {
            YearLevelType yearLevel = objectFactory.createYearLevelType();
            yearLevel.setCode(AUCodeSetsYearLevelCodeType.fromValue("" + i));
            yearLevels.getYearLevel().add(yearLevel);
        }
        staffAssignment.setYearLevels(objectFactory.createStaffAssignmentTypeYearLevels(yearLevels));

        CalendarSummaryListType calendarSummaries = objectFactory.createCalendarSummaryListType();
        calendarSummaries.getCalendarSummaryRefId().addAll(CalendarSummaryTestData.REF_ID_LIST);
        staffAssignment.setCalendarSummaryList(objectFactory.createStaffAssignmentTypeCalendarSummaryList(calendarSummaries));

        StaffSubjectListType staffSubjectList = objectFactory.createStaffSubjectListType();
        StaffSubjectType staffSubject = objectFactory.createStaffSubjectType();
        staffSubject.setTimeTableSubjectRefId(objectFactory.createStaffSubjectTypeTimeTableSubjectRefId(TimeTableSubjectTestData.REF_ID_1));
        staffSubjectList.getStaffSubject().add(staffSubject);
        staffAssignment.setStaffSubjectList(objectFactory.createStaffAssignmentTypeStaffSubjectList(staffSubjectList));
        return staffAssignment;
    }

    @Override
    public List<StaffAssignmentType> getExamplesForQuery() {
        StaffAssignmentType staffAssignment = new StaffAssignmentType();
        staffAssignment.setStaffPersonalRefId(StaffPersonalTestData.REF_ID_1);
        return Arrays.asList(staffAssignment);
    }

    @Override
    public boolean isExampleObject(StaffAssignmentType object, int index) {
        return object != null && StaffPersonalTestData.REF_ID_1.equals(object.getStaffPersonalRefId());
    }

    @Override
    public List<QueryCriteria> getServicePathQueries() {
        QueryCriteria queryCriteria = new QueryCriteria();
        queryCriteria.addPredicate(new QueryPredicate("StaffPersonals", QueryOperator.EQUAL, StaffPersonalTestData.REF_ID_1));
        return Arrays.asList(queryCriteria);
    }

    @Override
    public boolean isServicePathObject(StaffAssignmentType object, int index) {
        return object != null && StaffPersonalTestData.REF_ID_1.equals(object.getStaffPersonalRefId());
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

    public StaffAssignmentCollectionType getTestCollection(String... refIds) {
        StaffAssignmentCollectionType result = new StaffAssignmentCollectionType();
        for (int i = 0; refIds != null && i < refIds.length; i++) {
            result.getStaffAssignment().add(getTestObject(refIds[i]));
        }
        return result;
    }

    public String getSingleObjectXMLFilename() {
        return "StaffAssignment.xml";
    }

    public String getMultiObjectXMLFilename() {
        return "StaffAssignments.xml";
    }

}

