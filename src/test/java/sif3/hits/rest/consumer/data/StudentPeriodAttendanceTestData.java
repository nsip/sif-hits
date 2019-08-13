package sif3.hits.rest.consumer.data;

import sif.dd.au30.model.*;

import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.rest.consumer.SchoolInfoConsumerTest;
import sif3.hits.rest.consumer.SessionInfoConsumerTest;
import sif3.hits.rest.consumer.StudentPersonalConsumerTest;
import sif3.hits.utils.RefIdGenerator;

import java.util.*;

public class StudentPeriodAttendanceTestData extends TestData<StudentPeriodAttendanceType,StudentPeriodAttendanceCollectionType> {

    public static final String REF_ID_1 = "3ccb8f4d-3fee-4ffd-a4dc-4c70e89e08c0";
    public static final String REF_ID_2 = "80bb69a4-e7d6-4d12-bd58-88e9ed837688";
    public static final String REF_ID_3 = "ca050687-8ca2-432c-a5d2-d928ee645eb2";
    public static final String REF_ID_4 = "59ab68ea-a00a-4e2f-90ab-055fc18889f6";
    public static final String REF_ID_5 = "6bb56868-707c-4afa-9492-d2325a11c250";

    public static final String[] REF_ID_RA = { REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5 };
    public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);

    public static final String XML_REF_ID_1 = "076446a2-f19b-4e08-bd37-e7dec7c8e50c";
    public static final String XML_REF_ID_2 = "4fa5cd96-9f54-4534-8e64-24b5ad3b2e4e";

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

    public StudentPeriodAttendanceType getTestObject(String refId) {
        IObjectFactory objectFactory = getObjectFactory();
        StudentPeriodAttendanceType studentPeriodAttendance = new StudentPeriodAttendanceType();
        studentPeriodAttendance.setRefId(refId);
        studentPeriodAttendance.setStudentPersonalRefId(STUDENT_MAP.getOrDefault(refId,StudentPersonalTestData.REF_ID_5));
        studentPeriodAttendance.setSchoolInfoRefId(SchoolInfoTestData.REF_ID_1);
        studentPeriodAttendance.setDate(getDate("2014-11-11"));
        studentPeriodAttendance.setSessionInfoRefId(objectFactory.createStudentPeriodAttendanceTypeSessionInfoRefId(SessionInfoTestData.REF_ID_1));
        studentPeriodAttendance.setTimetablePeriod(objectFactory.createStudentPeriodAttendanceTypeTimetablePeriod("P6"));
        studentPeriodAttendance.setTimeIn(objectFactory.createStudentPeriodAttendanceTypeTimeIn(getDate("09:00:00")));
        studentPeriodAttendance.setTimeOut(objectFactory.createStudentPeriodAttendanceTypeTimeOut(getDate("15:30:00")));
        AttendanceCodeType attendanceCode = new AttendanceCodeType();
        attendanceCode.setCode(AUCodeSetsAttendanceCodeType.fromValue("802"));
        studentPeriodAttendance.setAttendanceCode(attendanceCode);
        studentPeriodAttendance.setAttendanceStatus(AUCodeSetsAttendanceStatusType.fromValue("01"));
        studentPeriodAttendance.setSchoolYear(objectFactory.createStudentPeriodAttendanceTypeSchoolYear(getDate("2014")));
        studentPeriodAttendance.setAttendanceComment(objectFactory.createStudentPeriodAttendanceTypeAttendanceComment("The Comments"));
        AuditInfoType auditInfo = new AuditInfoType();
        Calendar calendar = Calendar.getInstance();
        calendar.set(2014, 12, 20, 15, 17, 54);
        calendar.set(Calendar.MILLISECOND, 444);
        auditInfo.setCreationDateTime(calendar);
        CreationUserType creationUser = new CreationUserType();
        creationUser.setType("Teacher");
        creationUser.setUserId("ez204ff0");
        auditInfo.setCreationUser(creationUser);
        studentPeriodAttendance.setAuditInfo(objectFactory.createStudentPeriodAttendanceTypeAuditInfo(auditInfo));
        return studentPeriodAttendance;
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

    public StudentPeriodAttendanceCollectionType getTestCollection(String... refIds) {
        StudentPeriodAttendanceCollectionType result = new StudentPeriodAttendanceCollectionType();
        for (int i = 0; refIds != null && i < refIds.length; i++) {
            result.getStudentPeriodAttendance().add(getTestObject(refIds[i]));
        }
        return result;
    }

    public String getSingleObjectXMLFilename() {
        return "StudentPeriodAttendance.xml";
    }

    public String getMultiObjectXMLFilename() {
        return "StudentPeriodAttendances.xml";
    }

}

