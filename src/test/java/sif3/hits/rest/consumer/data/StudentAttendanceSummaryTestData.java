package sif3.hits.rest.consumer.data;

import sif.dd.au30.model.StudentAttendanceSummaryCollectionType;
import sif.dd.au30.model.StudentAttendanceSummaryType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.utils.RefIdGenerator;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class StudentAttendanceSummaryTestData extends TestData<StudentAttendanceSummaryType, StudentAttendanceSummaryCollectionType> {

    public static final String REF_ID_1 = "e07c4fd9-1f64-4451-845f-2d00a1fd93e1";
    public static final String REF_ID_2 = "86497f2a-a465-4993-a7a0-5e89e65c1bbf";
    public static final String REF_ID_3 = "78a8cc94-1617-4e42-aca3-6b0045449fb6";
    public static final String REF_ID_4 = "a99b9db3-c42b-4080-8f01-5576b0b6a2f9";
    public static final String REF_ID_5 = "de00ba01-0f37-43a7-a47c-e350a4c390ef";

    public static final String[] REF_ID_RA = {REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5};
    public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);

    public static final String XML_REF_ID_1 = "bd35fc2c-cee4-4568-bff7-cec73c083f21";
    public static final String XML_REF_ID_2 = "99f71d10-a1e9-491f-9a18-8614a358361a";

    public static final String[] XML_REF_ID_RA = {XML_REF_ID_1, XML_REF_ID_2};
    public static final List<String> XML_REF_ID_LIST = Arrays.asList(XML_REF_ID_RA);

    public StudentAttendanceSummaryType getTestObject(String refId) {
        IObjectFactory objectFactory = getObjectFactory();
        StudentAttendanceSummaryType studentAttendanceSummary = new StudentAttendanceSummaryType();
        studentAttendanceSummary.setStudentAttendanceSummaryRefId(refId);
        studentAttendanceSummary.setSchoolInfoRefId(SchoolInfoTestData.REF_ID_1);
        studentAttendanceSummary.setStudentPersonalRefId(StudentPersonalTestData.REF_ID_1);
        studentAttendanceSummary.setSchoolYear(getDate("2014"));
        studentAttendanceSummary.setStartDate(getDate("2014-09-01"));
        studentAttendanceSummary.setEndDate(getDate("2014-09-05"));
        studentAttendanceSummary.setStartDay(objectFactory.createStudentAttendanceSummaryTypeStartDay(1L));
        studentAttendanceSummary.setEndDay(objectFactory.createStudentAttendanceSummaryTypeEndDay(5L));
        studentAttendanceSummary.setFTE(objectFactory.createStudentAttendanceSummaryTypeFTE(new BigDecimal("1.0")));
        studentAttendanceSummary.setDaysAttended(new BigDecimal("4.5"));
        studentAttendanceSummary.setExcusedAbsences(BigDecimal.ZERO);
        studentAttendanceSummary.setUnexcusedAbsences(new BigDecimal("0.5"));
        studentAttendanceSummary.setDaysTardy(objectFactory.createStudentAttendanceSummaryTypeDaysTardy(new BigDecimal("2")));
        studentAttendanceSummary.setDaysInMembership(new BigDecimal("5"));
        return studentAttendanceSummary;
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

    public StudentAttendanceSummaryCollectionType getTestCollection(String... refIds) {
        StudentAttendanceSummaryCollectionType result = new StudentAttendanceSummaryCollectionType();
        for (int i = 0; refIds != null && i < refIds.length; i++) {
            result.getStudentAttendanceSummary().add(getTestObject(refIds[i]));
        }
        return result;
    }

    public String getSingleObjectXMLFilename() {
        return "StudentAttendanceSummary.xml";
    }

    public String getMultiObjectXMLFilename() {
        return "StudentAttendanceSummarys.xml";
    }

}

