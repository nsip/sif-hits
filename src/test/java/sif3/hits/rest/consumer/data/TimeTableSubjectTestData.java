package sif3.hits.rest.consumer.data;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import sif.dd.au30.model.AUCodeSetsYearLevelCodeType;
import sif.dd.au30.model.OtherCodeListType;
import sif.dd.au30.model.TimeTableSubjectCollectionType;
import sif.dd.au30.model.TimeTableSubjectType;
import sif.dd.au30.model.YearLevelType;
import sif.dd.au30.model.YearRangeType;
import sif3.common.model.QueryCriteria;
import sif3.common.model.QueryOperator;
import sif3.common.model.QueryPredicate;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.utils.RefIdGenerator;

public class TimeTableSubjectTestData extends TestData<TimeTableSubjectType, TimeTableSubjectCollectionType> {

    public static final String REF_ID_1 = "d7e56fa7-e708-4563-9490-9d15677c6a27";
    public static final String REF_ID_2 = "6cdc4fa7-0b42-4251-93f2-a6ef7081336c";
    public static final String REF_ID_3 = "154f75f6-d23d-4478-8056-a53b676ca994";
    public static final String REF_ID_4 = "09267be7-9088-48cf-a2fe-1ea0b63ac85b";
    public static final String REF_ID_5 = "a4f9e811-c6f9-4124-ac27-aa9d4a2a4667";

    public static final String[] REF_ID_RA = {REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5};
    public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);

    public static final String XML_REF_ID_1 = "b8ab7a14-e32a-4184-8320-856110bd2fd3";
    public static final String XML_REF_ID_2 = "ded69aab-2bac-4102-81f0-32663c72c633";

    public static final String[] XML_REF_ID_RA = {XML_REF_ID_1, XML_REF_ID_2};
    public static final List<String> XML_REF_ID_LIST = Arrays.asList(XML_REF_ID_RA);

    public static final String LOCAL_ID = "local-id-tts";

    public TimeTableSubjectType getTestObject(String refId) {
        IObjectFactory objectFactory = getObjectFactory();
        TimeTableSubjectType timeTableSubject = new TimeTableSubjectType();
        timeTableSubject.setRefId(refId);
        timeTableSubject.setSchoolInfoRefId(objectFactory.createTimeTableSubjectTypeSchoolInfoRefId(SchoolInfoTestData.REF_ID_1));
        timeTableSubject.setSchoolLocalId(objectFactory.createTimeTableSubjectTypeSchoolLocalId(SchoolInfoTestData.LOCAL_ID));
        timeTableSubject.setSubjectLocalId(LOCAL_ID);
        YearLevelType yearLevel = new YearLevelType();
        yearLevel.setCode(AUCodeSetsYearLevelCodeType.fromValue("4"));
        timeTableSubject.setAcademicYear(objectFactory.createTimeTableSubjectTypeAcademicYear(yearLevel));
        timeTableSubject.setFaculty(objectFactory.createTimeTableSubjectTypeFaculty("Science"));
        timeTableSubject.setSubjectShortName(objectFactory.createTimeTableSubjectTypeSubjectShortName("Computing"));
        timeTableSubject.setSubjectLongName("Introduction to Computing");
        timeTableSubject.setSubjectType(objectFactory.createTimeTableSubjectTypeSubjectType("Elective"));
        timeTableSubject.setProposedMinClassSize(objectFactory.createTimeTableSubjectTypeProposedMinClassSize(new BigDecimal("12")));
        timeTableSubject.setProposedMaxClassSize(objectFactory.createTimeTableSubjectTypeProposedMaxClassSize(new BigDecimal("25")));
        timeTableSubject.setSemester(objectFactory.createTimeTableSubjectTypeSemester(2L));
        timeTableSubject.setSchoolYear(objectFactory.createTimeTableSubjectTypeSchoolYear(getDate("2014")));

        OtherCodeListType otherCodeList = new OtherCodeListType();
        OtherCodeListType.OtherCode otherCode = new OtherCodeListType.OtherCode();
        otherCode.setCodeset("Local");
        otherCode.setValue("ITC");
        otherCodeList.getOtherCode().add(otherCode);
        otherCode = new OtherCodeListType.OtherCode();
        otherCode.setCodeset("Local");
        otherCode.setValue("Computing");
        otherCodeList.getOtherCode().add(otherCode);
        timeTableSubject.setOtherCodeList(objectFactory.createTimeTableSubjectTypeOtherCodeList(otherCodeList));

        if (REF_ID_5.equals(refId)) {
            timeTableSubject.setAcademicYear(null);
            YearRangeType yearRange = new YearRangeType();
            YearLevelType startYear = new YearLevelType();
            startYear.setCode(AUCodeSetsYearLevelCodeType.fromValue("K4"));
            YearLevelType endYear = new YearLevelType();
            endYear.setCode(AUCodeSetsYearLevelCodeType.fromValue("6"));
            yearRange.setStart(startYear);
            yearRange.setEnd(endYear);
            timeTableSubject.setAcademicYearRange(objectFactory.createTimeTableSubjectTypeAcademicYearRange(yearRange));
        }
        return timeTableSubject;
    }

    @Override
    public List<QueryCriteria> getServicePathQueries() {
        QueryCriteria queryCriteria = new QueryCriteria();
        queryCriteria.addPredicate(new QueryPredicate("SchoolInfos", QueryOperator.EQUAL, SchoolInfoTestData.REF_ID_1));
        return Arrays.asList(queryCriteria);
    }

    @Override
    public boolean isServicePathObject(TimeTableSubjectType object, int index) {
        return object != null && object.getSchoolInfoRefId() != null && SchoolInfoTestData.REF_ID_1.equals(object.getSchoolInfoRefId().getValue());
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

    public TimeTableSubjectCollectionType getTestCollection(String... refIds) {
        TimeTableSubjectCollectionType result = new TimeTableSubjectCollectionType();
        for (int i = 0; refIds != null && i < refIds.length; i++) {
            result.getTimeTableSubject().add(getTestObject(refIds[i]));
        }
        return result;
    }

    public String getSingleObjectXMLFilename() {
        return "TimeTableSubject.xml";
    }

    public String getMultiObjectXMLFilename() {
        return "TimeTableSubjects.xml";
    }

}

