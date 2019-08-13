package sif3.hits.rest.consumer.data;

import org.apache.commons.lang3.StringUtils;
import sif.dd.au30.model.*;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.utils.RefIdGenerator;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class StudentAttendanceTimeListTestData extends TestData<StudentAttendanceTimeListType, StudentAttendanceTimeListCollectionType> {

    public static final String REF_ID_1 = "8dceaf54-d24b-4764-81dc-f7161d6bf4bb";
    public static final String REF_ID_2 = "dd34d067-cb6a-43db-aa67-30be119259b4";
    public static final String REF_ID_3 = "382eaa57-b6c0-4e90-b428-da7fc1adf322";
    public static final String REF_ID_4 = "71db9fd1-fd98-4244-a054-6f590bcc64e9";
    public static final String REF_ID_5 = "03c0b30a-06a3-49ec-acf9-2575516451a9";

    public static final String[] REF_ID_RA = {REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5};
    public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);

    public static final String XML_REF_ID_1 = "6aa01c63-acfc-4795-b113-a9cd4258672f";
    public static final String XML_REF_ID_2 = "f5d3a245-c747-4cf8-9704-edba719dcb56";

    public static final String[] XML_REF_ID_RA = {XML_REF_ID_1, XML_REF_ID_2};
    public static final List<String> XML_REF_ID_LIST = Arrays.asList(XML_REF_ID_RA);

    public StudentAttendanceTimeListType getTestObject(String refId) {
        StudentAttendanceTimeListType studentAttendanceTimeList = new StudentAttendanceTimeListType();
        studentAttendanceTimeList.setRefId(refId);
        studentAttendanceTimeList.setStudentPersonalRefId(StudentPersonalTestData.REF_ID_1);
        studentAttendanceTimeList.setSchoolInfoRefId(SchoolInfoTestData.REF_ID_1);
        studentAttendanceTimeList.setDate(getDate("2014-11-11"));
        studentAttendanceTimeList.setSchoolYear(getDate("2014"));

        AttendanceTimesType attendanceTimes = new AttendanceTimesType();
        studentAttendanceTimeList.setAttendanceTimes(attendanceTimes);
        attendanceTimes.getAttendanceTime().add(getAttendanceTime("09:00:00", "11:00:00", "01", null, null, "100"));
        attendanceTimes.getAttendanceTime().add(getAttendanceTime("11:00:00", "13:00:00", "01", "0.2", "Orthodontist Appt, returned to school.", "200", "S", "Local", "C", "Text"));
        attendanceTimes.getAttendanceTime().add(getAttendanceTime("13:00:00", "15:30:00", "01", null, null, "100", "C", "Text"));
        return studentAttendanceTimeList;
    }

    private AttendanceTimeType getAttendanceTime(String startTime, String endTime, String status, String absence, String note, String code, String... otherCodes) {
        IObjectFactory objectFactory = getObjectFactory();
        AttendanceTimeType attendanceTime = new AttendanceTimeType();
        if (StringUtils.isNotBlank(absence)) {
            attendanceTime.setDurationValue(objectFactory.createAttendanceTimeTypeDurationValue(new BigDecimal(absence)));
        }
        if (StringUtils.isNotBlank(note)) {
            attendanceTime.setAttendanceNote(objectFactory.createAttendanceTimeTypeAttendanceNote(note));
        }
        attendanceTime.setAttendanceStatus(AUCodeSetsAttendanceStatusType.fromValue(status));
        attendanceTime.setStartTime(getDate(startTime));
        attendanceTime.setEndTime(getDate(endTime));

        AttendanceCodeType attendanceCodeType = new AttendanceCodeType();
        attendanceTime.setAttendanceCode(attendanceCodeType);
        attendanceCodeType.setCode(AUCodeSetsAttendanceCodeType.fromValue(code));
        if (otherCodes != null && otherCodes.length > 1) {
            OtherCodeListType otherCodeListType = new OtherCodeListType();
            for (int i = 0; i < otherCodes.length; i += 2) {
                OtherCodeListType.OtherCode otherCode = new OtherCodeListType.OtherCode();
                otherCode.setValue(otherCodes[i]);
                otherCode.setCodeset(otherCodes[i + 1]);
                otherCodeListType.getOtherCode().add(otherCode);
            }
            attendanceCodeType.setOtherCodeList(objectFactory.createAttendanceCodeTypeOtherCodeList(otherCodeListType));
        }
        return attendanceTime;
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

    public StudentAttendanceTimeListCollectionType getTestCollection(String... refIds) {
        StudentAttendanceTimeListCollectionType result = new StudentAttendanceTimeListCollectionType();
        for (int i = 0; refIds != null && i < refIds.length; i++) {
            result.getStudentAttendanceTimeList().add(getTestObject(refIds[i]));
        }
        return result;
    }

    public String getSingleObjectXMLFilename() {
        return "StudentAttendanceTimeList.xml";
    }

    public String getMultiObjectXMLFilename() {
        return "StudentAttendanceTimeLists.xml";
    }

}

