package sif3.hits.rest.consumer.data;

import sif.dd.au30.model.*;

import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.utils.RefIdGenerator;

import java.math.BigDecimal;
import java.util.*;

public class StudentDailyAttendanceTestData extends TestData<StudentDailyAttendanceType,StudentDailyAttendanceCollectionType> {

    public static final String REF_ID_1 = "453ab5cb-203a-48fc-a326-1b42179cee4f";
    public static final String REF_ID_2 = "9fb7cd1a-bf40-499b-99fa-29f32fa36e3d";
    public static final String REF_ID_3 = "f02cd308-2ac4-47f6-a4fe-3ece8f60dd34";
    public static final String REF_ID_4 = "0a0bbab9-9db7-452a-a23b-d8b649e0d732";
    public static final String REF_ID_5 = "e98223ba-61d0-4b4f-a0e5-7f9841c8d18d";

    public static final String[] REF_ID_RA = { REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5 };
    public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);

    public static final String XML_REF_ID_1 = "d9cb006d-b219-484e-b811-754151a28f56";
    public static final String XML_REF_ID_2 = "8a6f52a4-24e8-49e4-8263-ddb26079e57a";

    public static final String[] XML_REF_ID_RA = { XML_REF_ID_1, XML_REF_ID_2 };
    public static final List<String> XML_REF_ID_LIST = Arrays.asList(XML_REF_ID_RA);

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

    public StudentDailyAttendanceType getTestObject(String refId) {
        IObjectFactory objectFactory = getObjectFactory();

        StudentDailyAttendanceType studentDailyAttendance = new StudentDailyAttendanceType();
        studentDailyAttendance.setRefId(refId);
        studentDailyAttendance.setStudentPersonalRefId(STUDENT_MAP.getOrDefault(refId,StudentPersonalTestData.REF_ID_5));
        studentDailyAttendance.setSchoolInfoRefId(SchoolInfoTestData.REF_ID_1);
        studentDailyAttendance.setDate(getDate("2014-09-04"));
        studentDailyAttendance.setSchoolYear(getDate("2014"));
        studentDailyAttendance.setDayValue(objectFactory.createStudentDailyAttendanceTypeDayValue(AUCodeSetsDayValueCodeType.FULL));
        AttendanceCodeType attendanceCodeType = new AttendanceCodeType();
        attendanceCodeType.setCode(AUCodeSetsAttendanceCodeType.fromValue("100"));
        studentDailyAttendance.setAttendanceCode(attendanceCodeType);
        studentDailyAttendance.setAttendanceStatus(AUCodeSetsAttendanceStatusType.fromValue("NA"));
        studentDailyAttendance.setTimeIn(objectFactory.createStudentDailyAttendanceTypeTimeIn(getDate("08:30:00")));
        studentDailyAttendance.setTimeOut(objectFactory.createStudentDailyAttendanceTypeTimeOut(getDate("15:30:00")));
        studentDailyAttendance.setAbsenceValue(objectFactory.createStudentDailyAttendanceTypeAbsenceValue(BigDecimal.ZERO));
        studentDailyAttendance.setAttendanceNote(objectFactory.createStudentDailyAttendanceTypeAttendanceNote("Attendance Note"));
        return studentDailyAttendance;
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

    public StudentDailyAttendanceCollectionType getTestCollection(String... refIds) {
        StudentDailyAttendanceCollectionType result = new StudentDailyAttendanceCollectionType();
        for (int i = 0; refIds != null && i < refIds.length; i++) {
            result.getStudentDailyAttendance().add(getTestObject(refIds[i]));
        }
        return result;
    }

    public String getSingleObjectXMLFilename() {
        return "StudentDailyAttendance.xml";
    }

    public String getMultiObjectXMLFilename() {
        return "StudentDailyAttendances.xml";
    }

}

