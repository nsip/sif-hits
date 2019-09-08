package sif3.hits.rest.consumer.data;

import java.util.Arrays;
import java.util.List;

import sif.dd.au30.model.TimeTableCollectionType;
import sif.dd.au30.model.TimeTableDayListType;
import sif.dd.au30.model.TimeTableDayType;
import sif.dd.au30.model.TimeTablePeriodListType;
import sif.dd.au30.model.TimeTablePeriodType;
import sif.dd.au30.model.TimeTableType;
import sif3.common.model.QueryCriteria;
import sif3.common.model.QueryOperator;
import sif3.common.model.QueryPredicate;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.utils.RefIdGenerator;

public class TimeTableTestData extends TestData<TimeTableType,TimeTableCollectionType> {

    public static final String REF_ID_1 = "41b18ab6-dd6e-436f-8f84-4e5bcd663031";
    public static final String REF_ID_2 = "86727b86-08bc-4543-87db-061a79f49f97";
    public static final String REF_ID_3 = "5f9fa308-139d-489e-aa6e-14423b1c71bc";
    public static final String REF_ID_4 = "08f4289e-b5dd-41f8-b016-a942407f2e26";
    public static final String REF_ID_5 = "e180dc9f-b81f-43c7-9403-3cd034bd1490";

    public static final String[] REF_ID_RA = { REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5 };
    public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);

    public static final String XML_REF_ID_1 = "6b6e2e71-b5c8-4877-9578-5ed1eb3bbf21";
    public static final String XML_REF_ID_2 = "2a989fde-2932-4cbc-a054-bda947300b94";

    public static final String[] XML_REF_ID_RA = { XML_REF_ID_1, XML_REF_ID_2 };
    public static final List<String> XML_REF_ID_LIST = Arrays.asList(XML_REF_ID_RA);
    public static final String LOCAL_ID = "local-id-tt";

    public TimeTableType getTestObject(String refId) {
        IObjectFactory objectFactory = getObjectFactory();
        TimeTableType timeTable = new TimeTableType();
        timeTable.setRefId(refId);
        timeTable.setSchoolInfoRefId(objectFactory.createTimeTableTypeSchoolInfoRefId(SchoolInfoTestData.REF_ID_1));
        timeTable.setSchoolLocalId(objectFactory.createTimeTableTypeSchoolLocalId(SchoolInfoTestData.LOCAL_ID));
        timeTable.setSchoolName(objectFactory.createTimeTableTypeSchoolName(SchoolInfoTestData.SCHOOL_NAME));
        timeTable.setSchoolYear(getDate("2014"));
        timeTable.setLocalId(objectFactory.createTimeTableTypeLocalId(LOCAL_ID));
        timeTable.setTitle("TERM 4 2014");
        timeTable.setDaysPerCycle(5L);
        timeTable.setPeriodsPerDay(6L);
        timeTable.setTimeTableCreationDate(objectFactory.createTimeTableTypeTimeTableCreationDate(getDate("2014-06-01")));
        timeTable.setStartDate(objectFactory.createTimeTableTypeStartDate(getDate("2014-09-01")));
        timeTable.setEndDate(objectFactory.createTimeTableTypeEndDate(getDate("2014-12-21")));

        TimeTableDayListType timeTableDayList = new TimeTableDayListType();
        TimeTableDayType timeTableDay = new TimeTableDayType();
        timeTableDay.setDayId("1");
        timeTableDay.setDayTitle("Monday");
        timeTableDayList.getTimeTableDay().add(timeTableDay);
        timeTableDay = new TimeTableDayType();
        timeTableDay.setDayId("2");
        timeTableDay.setDayTitle("Tuesday");
        timeTableDayList.getTimeTableDay().add(timeTableDay);
        timeTableDay = new TimeTableDayType();
        timeTableDay.setDayId("3");
        timeTableDay.setDayTitle("Wednesday");
        timeTableDayList.getTimeTableDay().add(timeTableDay);
        timeTableDay = new TimeTableDayType();
        timeTableDay.setDayId("4");
        timeTableDay.setDayTitle("Thursday");
        timeTableDayList.getTimeTableDay().add(timeTableDay);
        timeTableDay = new TimeTableDayType();
        timeTableDay.setDayId("5");
        timeTableDay.setDayTitle("Friday");

        TimeTablePeriodListType timeTablePeriodList = new TimeTablePeriodListType();
        TimeTablePeriodType timeTablePeriod = new TimeTablePeriodType();
        timeTablePeriod.setPeriodId("1");
        timeTablePeriod.setPeriodTitle("Form");
        timeTablePeriod.setBellPeriod(objectFactory.createTimeTablePeriodTypeBellPeriod("1"));
        timeTablePeriod.setStartTime(objectFactory.createTimeTablePeriodTypeStartTime(getDate("08:45:00")));
        timeTablePeriod.setEndTime(objectFactory.createTimeTablePeriodTypeEndTime(getDate("09:00:00")));
        timeTablePeriodList.getTimeTablePeriod().add(timeTablePeriod);
        timeTableDay.setTimeTablePeriodList(timeTablePeriodList);
        timeTableDayList.getTimeTableDay().add(timeTableDay);
        timeTable.setTimeTableDayList(timeTableDayList);

        return timeTable;
    }

    @Override
    public List<QueryCriteria> getServicePathQueries() {
        QueryCriteria queryCriteria = new QueryCriteria();
        queryCriteria.addPredicate(new QueryPredicate("SchoolInfos", QueryOperator.EQUAL, SchoolInfoTestData.REF_ID_1));
        return Arrays.asList(queryCriteria);
    }

    @Override
    public boolean isServicePathObject(TimeTableType object, int index) {
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

    public TimeTableCollectionType getTestCollection(String... refIds) {
        TimeTableCollectionType result = new TimeTableCollectionType();
        for (int i = 0; refIds != null && i < refIds.length; i++) {
            result.getTimeTable().add(getTestObject(refIds[i]));
        }
        return result;
    }

    public String getSingleObjectXMLFilename() {
        return "TimeTable.xml";
    }

    public String getMultiObjectXMLFilename() {
        return "TimeTables.xml";
    }

}

