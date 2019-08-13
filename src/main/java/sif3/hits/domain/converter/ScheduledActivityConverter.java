package sif3.hits.domain.converter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.AUCodeSetsScheduledActivityTypeType;
import sif.dd.au30.model.AUCodeSetsYearLevelCodeType;
import sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType;
import sif.dd.au30.model.RoomListType;
import sif.dd.au30.model.ScheduledActivityOverrideType;
import sif.dd.au30.model.ScheduledActivityType;
import sif.dd.au30.model.ScheduledTeacherListType;
import sif.dd.au30.model.StudentsType;
import sif.dd.au30.model.TeacherCoverType;
import sif.dd.au30.model.TeachingGroupListType;
import sif.dd.au30.model.YearLevelType;
import sif.dd.au30.model.YearLevelsType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.ScheduledActivity;
import sif3.hits.domain.model.ScheduledActivityTeacher;

@Component
public class ScheduledActivityConverter extends HitsConverter<ScheduledActivityType, ScheduledActivity> {

    @Autowired
    private ScheduledActivityTeacherConverter scheduledActivityTeacherConverter;

    public ScheduledActivityConverter() {
        super(ScheduledActivityType.class, ScheduledActivity.class);
    }

    @Override
    public void toSifModel(ScheduledActivity source, ScheduledActivityType target) {
        if (source != null && target != null) {
            IObjectFactory objectFactory = getObjectFactory();
            target.setRefId(source.getRefId());
            target.setSchoolInfoRefId(source.getSchoolInfoRefId());
            target.setTimeTableCellRefId(objectFactory.createScheduledActivityTypeTimeTableCellRefId(source.getTimeTableCellRefId()));
            target.setTimeTableRefId(objectFactory.createScheduledActivityTypeTimeTableRefId(source.getTimeTableRefId()));
            target.setTimeTableSubjectRefId(objectFactory.createScheduledActivityTypeTimeTableSubjectRefId(source.getTimeTableSubjectRefId()));
            target.setDayId(objectFactory.createScheduledActivityTypeDayId(source.getDayId()));
            target.setPeriodId(objectFactory.createScheduledActivityTypePeriodId(source.getPeriodId()));
            target.setActivityDate(getDateValue(source.getDate()));
            target.setStartTime(getTimeValue(source.getStartTime()));
            target.setFinishTime(getTimeValue(source.getFinishTime()));
            target.setCellType(objectFactory.createScheduledActivityTypeCellType(source.getCellType()));
            target.setLocation(objectFactory.createScheduledActivityTypeLocation(source.getLocation()));
            target.setActivityType(objectFactory.createScheduledActivityTypeActivityType(getEnumValue(source.getType(), AUCodeSetsScheduledActivityTypeType.class)));
            target.setActivityName(objectFactory.createScheduledActivityTypeActivityName(source.getName()));
            target.setActivityComment(objectFactory.createScheduledActivityTypeActivityComment(source.getComment()));

            RoomListType roomList = objectFactory.createRoomListType();
            for (String roomInfoRefId : source.getRoomInfoRefIds()) {
                roomList.getRoomInfoRefId().add(roomInfoRefId);
            }
            target.setRoomList(objectFactory.createScheduledActivityTypeRoomList(roomList));

            StudentsType studentList = objectFactory.createStudentsType();
            for (String studentPersonalRefId : source.getStudentPersonalRefIds()) {
                studentList.getStudentPersonalRefId().add(studentPersonalRefId);
            }
            target.setStudentList(objectFactory.createScheduledActivityTypeStudentList(studentList));

            TeachingGroupListType teachingGroupList = objectFactory.createTeachingGroupListType();
            for (String teachingGroupRefId : source.getTeachingGroupRefIds()) {
                teachingGroupList.getTeachingGroupRefId().add(teachingGroupRefId);
            }
            target.setTeachingGroupList(objectFactory.createScheduledActivityTypeTeachingGroupList(teachingGroupList));

            List<TeacherCoverType> teachers = scheduledActivityTeacherConverter.toSifModelList(source.getTeachers());
            ScheduledTeacherListType teacherList = objectFactory.createScheduledTeacherListType();
            teacherList.getTeacherCover().addAll(teachers);
            target.setTeacherList(objectFactory.createScheduledActivityTypeTeacherList(teacherList));

            YearLevelsType yearLevelsType = new YearLevelsType();
            YearLevelType yearLevelType = new YearLevelType();
            yearLevelType.setCode(getEnumValue(source.getYearLevels(), AUCodeSetsYearLevelCodeType.class));
            yearLevelsType.getYearLevel().add(yearLevelType);
            target.setYearLevels(objectFactory.createScheduledActivityTypeYearLevels(yearLevelsType));

            ScheduledActivityOverrideType override = objectFactory.createScheduledActivityOverrideType();
            override.setValue(getEnumValue(source.getOverride(), AUCodeSetsYesOrNoCategoryType.class));
            override.setDateOfOverride(getDateValue(source.getDateOfOverride()));
            target.setOverride(objectFactory.createScheduledActivityTypeOverride(override));

            if (roomList.getRoomInfoRefId().isEmpty()) {
                target.setRoomList(null);
            }
            if (studentList.getStudentPersonalRefId().isEmpty()) {
                target.setStudentList(null);
            }
            if (teachingGroupList.getTeachingGroupRefId().isEmpty()) {
                target.setTeachingGroupList(null);
            }
            if (teacherList.getTeacherCover().isEmpty()) {
                target.setTeacherList(null);
            }
        }
    }

    @Override
    public void toHitsModel(ScheduledActivityType source, ScheduledActivity target) {
        if (source != null && target != null) {
            target.setRefId(source.getRefId());
            target.setSchoolInfoRefId(source.getSchoolInfoRefId());
            target.setTimeTableCellRefId(getJAXBValue(source.getTimeTableCellRefId()));
            target.setTimeTableRefId(getJAXBValue(source.getTimeTableRefId()));
            target.setTimeTableSubjectRefId(getJAXBValue(source.getTimeTableSubjectRefId()));
            target.setDayId(getJAXBValue(source.getDayId()));
            target.setPeriodId(getJAXBValue(source.getPeriodId()));
            target.setDate(getDateValue(source.getActivityDate()));
            target.setStartTime(getTimeValue(source.getStartTime()));
            target.setFinishTime(getTimeValue(source.getFinishTime()));
            target.setCellType(getJAXBValue(source.getCellType()));
            target.setLocation(getJAXBValue(source.getLocation()));
            target.setType(getJAXBEnumValue(source.getActivityType()));
            target.setName(getJAXBValue(source.getActivityName()));
            target.setComment(getJAXBValue(source.getActivityComment()));

            Set<String> roomInfoRefIds = new HashSet<String>();
            RoomListType roomList = getJAXBValue(source.getRoomList());
            if (roomList != null && roomList.getRoomInfoRefId() != null) {
                roomInfoRefIds.addAll(roomList.getRoomInfoRefId());
            }
            target.setRoomInfoRefIds(roomInfoRefIds);

            Set<String> studentPersonalRefIds = new HashSet<String>();
            StudentsType studentList = getJAXBValue(source.getStudentList());
            if (studentList != null && studentList.getStudentPersonalRefId() != null) {
                studentPersonalRefIds.addAll(studentList.getStudentPersonalRefId());
            }
            target.setStudentPersonalRefIds(studentPersonalRefIds);

            Set<String> teachingGroupRefIds = new HashSet<String>();
            TeachingGroupListType teachingGroupList = getJAXBValue(source.getTeachingGroupList());
            if (teachingGroupList != null && teachingGroupList.getTeachingGroupRefId() != null) {
                teachingGroupRefIds.addAll(teachingGroupList.getTeachingGroupRefId());
            }
            target.setTeachingGroupRefIds(teachingGroupRefIds);

            Set<ScheduledActivityTeacher> teachers = new HashSet<ScheduledActivityTeacher>();
            ScheduledTeacherListType teacherList = getJAXBValue(source.getTeacherList());
            if (teacherList != null && teacherList.getTeacherCover() != null) {
                teachers.addAll(scheduledActivityTeacherConverter.toHitsModelList(teacherList.getTeacherCover()));
                for (ScheduledActivityTeacher teacher : teachers) {
                    teacher.setScheduledActivity(target);
                }
            }
            if (target.getTeachers() == null) {
                target.setTeachers(new HashSet<ScheduledActivityTeacher>());
            } else {
                target.getTeachers().clear();
            }
            target.getTeachers().addAll(teachers);

            YearLevelsType yearLevelsType = getJAXBValue(source.getYearLevels());
            if (yearLevelsType != null) {
                List<YearLevelType> yearLevels = yearLevelsType.getYearLevel();
                if (yearLevels != null && yearLevels.size() > 0 && yearLevels.get(0) != null) {
                    target.setYearLevels(getEnumValue(yearLevels.get(0).getCode()));
                }
            }

            ScheduledActivityOverrideType override = getJAXBValue(source.getOverride());
            if (override != null) {
                target.setOverride(getEnumValue(override.getValue()));
                target.setDateOfOverride(getDateValue(override.getDateOfOverride()));
            }
        }
    }
}
