package sif3.hits.rest.consumer.data;

import sif.dd.au30.model.*;
import sif3.common.model.QueryCriteria;
import sif3.common.model.QueryOperator;
import sif3.common.model.QueryPredicate;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.utils.RefIdGenerator;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeTableCellTestData extends TestData<TimeTableCellType, TimeTableCellCollectionType> {

    public static final String REF_ID_1 = "e491c1f9-cd43-46bc-9ac8-09760f8cbf18";
    public static final String REF_ID_2 = "ff9fb452-9f73-4864-832b-aaa8200efc55";
    public static final String REF_ID_3 = "a176daad-d68c-4db8-b012-cf0dee6aebbd";
    public static final String REF_ID_4 = "f64ab173-7ada-4cdb-b333-c825e7de0d72";
    public static final String REF_ID_5 = "d5c49549-af8d-4db9-9119-bff69da4a7f9";

    public static final String[] REF_ID_RA = {REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5};
    public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);

    public static final String XML_REF_ID_1 = "f79621dd-76fa-4ff5-b2ca-fcaf8a360625";
    public static final String XML_REF_ID_2 = "a8506b5c-4622-4ef6-8c9f-2ba271d6b404";

    public static final String[] XML_REF_ID_RA = {XML_REF_ID_1, XML_REF_ID_2};
    public static final List<String> XML_REF_ID_LIST = Arrays.asList(XML_REF_ID_RA);

    public static final String CELL_TYPE = "Teaching";
    public static final String DAY_ID = "1";
    public static final String PERIOD_ID = "2";

    public static final Map<String, String> DAY_ID_MAP = new HashMap<>();

    static {
        DAY_ID_MAP.put(REF_ID_1, "1");
        DAY_ID_MAP.put(REF_ID_2, "2");
        DAY_ID_MAP.put(REF_ID_3, "3");
        DAY_ID_MAP.put(REF_ID_4, "4");
        DAY_ID_MAP.put(REF_ID_5, "5");
        DAY_ID_MAP.put(XML_REF_ID_1, "4");
        DAY_ID_MAP.put(XML_REF_ID_2, "5");
    }

    public TimeTableCellType getTestObject(String refId) {
        IObjectFactory objectFactory = getObjectFactory();

        TimeTableCellType timeTableCell = new TimeTableCellType();
        timeTableCell.setRefId(refId);
        timeTableCell.setSchoolInfoRefId(objectFactory.createTimeTableCellTypeSchoolInfoRefId(SchoolInfoTestData.REF_ID_1));
        timeTableCell.setSchoolLocalId(objectFactory.createTimeTableCellTypeSchoolLocalId(SchoolInfoTestData.LOCAL_ID));
        timeTableCell.setTimeTableRefId(TimeTableTestData.REF_ID_1);
        timeTableCell.setTimeTableLocalId(objectFactory.createTimeTableCellTypeTimeTableLocalId(TimeTableTestData.LOCAL_ID));
        timeTableCell.setTimeTableSubjectRefId(objectFactory.createTimeTableCellTypeTimeTableSubjectRefId(TimeTableSubjectTestData.REF_ID_1));
        timeTableCell.setSubjectLocalId(objectFactory.createTimeTableCellTypeSubjectLocalId(TimeTableSubjectTestData.LOCAL_ID));
        timeTableCell.setTeachingGroupRefId(TeachingGroupTestData.REF_ID_1);
        timeTableCell.setTeachingGroupLocalId(objectFactory.createTimeTableCellTypeTeachingGroupLocalId(TeachingGroupTestData.LOCAL_ID));
        timeTableCell.setRoomInfoRefId(objectFactory.createTimeTableCellTypeRoomInfoRefId(RoomInfoTestData.REF_ID_1));
        timeTableCell.setRoomNumber(objectFactory.createTimeTableCellTypeRoomNumber(RoomInfoTestData.ROOM_NUMBER));
        timeTableCell.setStaffPersonalRefId(objectFactory.createTimeTableCellTypeStaffPersonalRefId(StaffPersonalTestData.REF_ID_1));
        timeTableCell.setStaffLocalId(objectFactory.createTimeTableCellTypeStaffLocalId(StaffPersonalTestData.LOCAL_ID));
        timeTableCell.setDayId(DAY_ID_MAP.getOrDefault(refId, DAY_ID));
        timeTableCell.setPeriodId(PERIOD_ID);
        timeTableCell.setCellType(CELL_TYPE);

        timeTableCell.setTeacherList(objectFactory.createTimeTableCellTypeTeacherList(getTeacherCover()));

        if (REF_ID_2.equals(refId)) {
            timeTableCell.setTeachingGroupRefId(TeachingGroupTestData.REF_ID_2);
        }
        return timeTableCell;
    }

    public ScheduledTeacherListType getTeacherCover() {
        IObjectFactory objectFactory = getObjectFactory();
        ScheduledTeacherListType result = new ScheduledTeacherListType();
        for (String refId : new String[]{StaffPersonalTestData.REF_ID_1, StaffPersonalTestData.REF_ID_2}) {
            TeacherCoverType teacherCover = new TeacherCoverType();
            teacherCover.setStaffPersonalRefId(refId);
            teacherCover.setStaffLocalId(objectFactory.createTeacherCoverTypeStaffLocalId(StaffPersonalTestData.LOCAL_ID));
            teacherCover.setStartTime(objectFactory.createTeacherCoverTypeStartTime(getDate("09:00:00")));
            teacherCover.setFinishTime(objectFactory.createTeacherCoverTypeFinishTime(getDate("10:00:00")));
            teacherCover.setCredit(objectFactory.createTeacherCoverTypeCredit(AUCodeSetsTeacherCoverCreditType.CASUAL));
            teacherCover.setSupervision(objectFactory.createTeacherCoverTypeSupervision(AUCodeSetsTeacherCoverSupervisionType.NORMAL));
            teacherCover.setWeighting(objectFactory.createTeacherCoverTypeWeighting(new BigDecimal("0.5")));
            result.getTeacherCover().add(teacherCover);
        }
        return result;
    }


    @Override
    public List<TimeTableCellType> getExamplesForQuery() {
        TimeTableCellType timeTableCell = new TimeTableCellType();
        timeTableCell.setTimeTableRefId(TimeTableTestData.REF_ID_1);
        return Arrays.asList(timeTableCell);
    }

    @Override
    public boolean isExampleObject(TimeTableCellType object, int index) {
        return object != null && TimeTableTestData.REF_ID_1.equals(object.getTimeTableRefId());
    }

    @Override
    public List<QueryCriteria> getServicePathQueries() {
        QueryCriteria queryCriteria = new QueryCriteria();
        queryCriteria.addPredicate(new QueryPredicate("SchoolInfos", QueryOperator.EQUAL, SchoolInfoTestData.REF_ID_1));
        return Arrays.asList(queryCriteria);
    }

    @Override
    public boolean isServicePathObject(TimeTableCellType object, int index) {
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

    public TimeTableCellCollectionType getTestCollection(String... refIds) {
        TimeTableCellCollectionType result = new TimeTableCellCollectionType();
        for (int i = 0; refIds != null && i < refIds.length; i++) {
            result.getTimeTableCell().add(getTestObject(refIds[i]));
        }
        return result;
    }

    public String getSingleObjectXMLFilename() {
        return "TimeTableCell.xml";
    }

    public String getMultiObjectXMLFilename() {
        return "TimeTableCells.xml";
    }

}

