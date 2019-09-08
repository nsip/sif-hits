package sif3.hits.rest.consumer.data;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import sif.dd.au30.model.AUCodeSetsCalendarEventType;
import sif.dd.au30.model.AttendanceInfoType;
import sif.dd.au30.model.CalendarDateCollectionType;
import sif.dd.au30.model.CalendarDateInfoType;
import sif.dd.au30.model.CalendarDateType;
import sif.dd.au30.model.OtherCodeListType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.utils.RefIdGenerator;

public class CalendarDateTestData extends TestData<CalendarDateType,CalendarDateCollectionType> {

    public static final String REF_ID_1 = "be72fe47-bb29-4b7d-9475-de121191060d";
    public static final String REF_ID_2 = "311337fa-aa77-4091-bf4e-e6a3f7bdf947";
    public static final String REF_ID_3 = "9db4cebf-a603-494e-afb9-7253c50792bd";
    public static final String REF_ID_4 = "e6426a98-84fc-47a7-98bc-e12f1e3b5f60";
    public static final String REF_ID_5 = "4970b5ce-4d9e-45d2-add6-5d08b42825db";

    public static final String[] REF_ID_RA = { REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5 };
    public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);

    public static final String XML_REF_ID_1 = "a68205fd-3d83-4f53-8456-efc04829aadc";
    public static final String XML_REF_ID_2 = "8580f554-ec2d-4355-84fe-dffdf187438f";

    public static final String[] XML_REF_ID_RA = { XML_REF_ID_1, XML_REF_ID_2 };
    public static final List<String> XML_REF_ID_LIST = Arrays.asList(XML_REF_ID_RA);

    public static final String CALENDAR_DATE = "2014-10-11";
    public static final String CALENDAR_YEAR = "2014";
    public static final String CALENDAR_TYPE = "INST";
    public static final String OTHER_CODE_TYPE = "Local";
    public static final String[] OTHER_CODES = {"Normal", "Students"};
    public static final Long CALENDAR_DATE_NUMBER = 44L;
    public static final String ATTENDANCE_VALUE = "1.0";
    public static final String ATTENDANCE_COUNTS = "Yes";

    public CalendarDateType getTestObject(String refId) {
        IObjectFactory objectFactory = getObjectFactory();

        CalendarDateType calendarDate = new CalendarDateType();
        calendarDate.setDate(getDate(CALENDAR_DATE));
        calendarDate.setCalendarDateRefId(refId);
        calendarDate.setCalendarSummaryRefId(objectFactory.createCalendarDateTypeCalendarSummaryRefId(CalendarSummaryTestData.REF_ID_1));
        calendarDate.setSchoolInfoRefId(SchoolInfoTestData.REF_ID_1);
        calendarDate.setSchoolYear(getDate(CALENDAR_YEAR));

        CalendarDateInfoType calendarDateType = new CalendarDateInfoType();
        calendarDateType.setCode(AUCodeSetsCalendarEventType.fromValue(CALENDAR_TYPE));

        OtherCodeListType otherCodeList = new OtherCodeListType();
        OtherCodeListType.OtherCode otherCode = new OtherCodeListType.OtherCode();
        otherCode.setCodeset(OTHER_CODE_TYPE);
        otherCode.setValue(OTHER_CODES[0]);
        otherCodeList.getOtherCode().add(otherCode);
        otherCode = new OtherCodeListType.OtherCode();
        otherCode.setCodeset(OTHER_CODE_TYPE);
        otherCode.setValue(OTHER_CODES[1]);
        otherCodeList.getOtherCode().add(otherCode);
        calendarDateType.setOtherCodeList(objectFactory.createCalendarDateInfoTypeOtherCodeList(otherCodeList));
        calendarDate.setCalendarDateType(calendarDateType);

        calendarDate.setCalendarDateNumber(objectFactory.createCalendarDateTypeCalendarDateNumber(CALENDAR_DATE_NUMBER));
        AttendanceInfoType studentAttendance = new AttendanceInfoType();
        studentAttendance.setAttendanceValue(new BigDecimal(ATTENDANCE_VALUE));
        studentAttendance.setCountsTowardAttendance(ATTENDANCE_COUNTS);
        calendarDate.setStudentAttendance(objectFactory.createCalendarDateTypeStudentAttendance(studentAttendance));
        return calendarDate;
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

    public CalendarDateCollectionType getTestCollection(String... refIds) {
        CalendarDateCollectionType result = new CalendarDateCollectionType();
        for (int i = 0; refIds != null && i < refIds.length; i++) {
            result.getCalendarDate().add(getTestObject(refIds[i]));
        }
        return result;
    }

    public String getSingleObjectXMLFilename() {
        return "CalendarDate.xml";
    }

    public String getMultiObjectXMLFilename() {
        return "CalendarDates.xml";
    }

}

