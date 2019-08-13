package sif3.hits.rest.consumer.data;

import sif.dd.au30.model.*;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.utils.RefIdGenerator;

import java.util.Arrays;
import java.util.List;

public class CalendarSummaryTestData extends TestData<CalendarSummaryType, CalendarSummaryCollectionType> {

    public static final String REF_ID_1 = "4b169183-bbd7-4814-8f5c-0f5ff91deb78";
    public static final String REF_ID_2 = "9f42897d-2606-498a-a48a-ad089a21962d";
    public static final String REF_ID_3 = "21bc8d93-91c6-41a3-b3c0-8d1590835060";
    public static final String REF_ID_4 = "095386a4-172c-4c04-b696-3ba5d033ce70";
    public static final String REF_ID_5 = "cd09d100-1b94-480c-905d-1d2ec95b5e87";

    public static final String[] REF_ID_RA = {REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5};
    public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);

    public static final String XML_REF_ID_1 = "3d5e62b2-f01b-4897-bc6f-fdd147cb2fe2";
    public static final String XML_REF_ID_2 = "2e3341df-3e3b-41fd-b4cf-bdad124fbd21";

    public static final String[] XML_REF_ID_RA = {XML_REF_ID_1, XML_REF_ID_2};
    public static final List<String> XML_REF_ID_LIST = Arrays.asList(XML_REF_ID_RA);

    public static final String SCHOOL_YEAR = "2014";
    public static final String LOCAL_ID = "local-id";
    public static final Long DAYS_IN_SESSION = 75L;
    public static final String START_DATE = "2014-07-02";
    public static final String END_DATE = "2014-11-02";
    public static final Long INSTRUCTION_MINUTES = 999L;
    public static final Long MINUTES_PER_DAY = 450L;
    public static final String[] YEAR_LEVELS = {"4", "5", "6"};

    public CalendarSummaryType getTestObject(String refId) {
        IObjectFactory objectFactory = getObjectFactory();

        CalendarSummaryType calendarSummary = new CalendarSummaryType();
        calendarSummary.setRefId(refId);
        calendarSummary.setSchoolInfoRefId(SchoolInfoTestData.REF_ID_1);
        calendarSummary.setSchoolYear(getDate(SCHOOL_YEAR));
        calendarSummary.setLocalId(LOCAL_ID);
        calendarSummary.setDaysInSession(DAYS_IN_SESSION);
        calendarSummary.setStartDate(objectFactory.createCalendarSummaryTypeStartDate(getDate(START_DATE)));
        calendarSummary.setEndDate(objectFactory.createCalendarSummaryTypeEndDate(getDate(END_DATE)));
        calendarSummary.setFirstInstructionDate(objectFactory.createCalendarSummaryTypeFirstInstructionDate(getDate(START_DATE)));
        calendarSummary.setLastInstructionDate(objectFactory.createCalendarSummaryTypeLastInstructionDate(getDate(END_DATE)));
        calendarSummary.setInstructionalMinutes(objectFactory.createCalendarSummaryTypeInstructionalMinutes(INSTRUCTION_MINUTES));
        calendarSummary.setMinutesPerDay(objectFactory.createCalendarSummaryTypeMinutesPerDay(MINUTES_PER_DAY));

        YearLevelsType yearLevels = new YearLevelsType();
        for (String code : YEAR_LEVELS) {
            YearLevelType yearLevel = new YearLevelType();
            yearLevel.setCode(AUCodeSetsYearLevelCodeType.fromValue(code));
            yearLevels.getYearLevel().add(yearLevel);
        }
        calendarSummary.setYearLevels(objectFactory.createCalendarSummaryTypeYearLevels(yearLevels));
        return calendarSummary;
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

    public CalendarSummaryCollectionType getTestCollection(String... refIds) {
        CalendarSummaryCollectionType result = new CalendarSummaryCollectionType();
        for (int i = 0; refIds != null && i < refIds.length; i++) {
            result.getCalendarSummary().add(getTestObject(refIds[i]));
        }
        return result;
    }

    @Override
    public List<CalendarSummaryType> getExamplesForQuery() {
        CalendarSummaryType result = new CalendarSummaryType();
        result.setSchoolInfoRefId(SchoolInfoTestData.REF_ID_1);
        result.setDaysInSession(DAYS_IN_SESSION);
        return Arrays.asList(result);
    }

    @Override
    public boolean isExampleObject(CalendarSummaryType object, int index) {
        return object != null && object.getSchoolInfoRefId().equals(SchoolInfoTestData.REF_ID_1) && object.getDaysInSession() == DAYS_IN_SESSION;
    }

    public String getSingleObjectXMLFilename() {
        return "CalendarSummary.xml";
    }

    public String getMultiObjectXMLFilename() {
        return "CalendarSummarys.xml";
    }

}

