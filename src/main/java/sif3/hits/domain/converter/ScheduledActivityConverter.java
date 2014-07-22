package sif3.hits.domain.converter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType;
import sif.dd.au30.model.ObjectFactory;
import sif.dd.au30.model.ScheduledActivityType;
import sif.dd.au30.model.ScheduledActivityType.RoomList;
import sif.dd.au30.model.ScheduledActivityType.StudentList;
import sif.dd.au30.model.ScheduledActivityType.TeacherList;
import sif.dd.au30.model.ScheduledActivityType.TeacherList.TeacherCover;
import sif.dd.au30.model.ScheduledActivityType.TeachingGroupList;
import sif.dd.au30.model.YearLevelType;
import sif.dd.au30.model.YearLevelsType;
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
      ObjectFactory objectFactory = getObjectFactory();
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
      target.setActivityType(objectFactory.createScheduledActivityTypeActivityType(source.getType()));
      target.setActivityName(objectFactory.createScheduledActivityTypeActivityName(source.getName()));
      target.setActivityComment(objectFactory.createScheduledActivityTypeActivityComment(source.getComment()));

      RoomList roomList = new RoomList();
      for (String roomInfoRefId : source.getRoomInfoRefIds()) {
        roomList.getRoomInfoRefId().add(roomInfoRefId);
      }
      target.setRoomList(objectFactory.createScheduledActivityTypeRoomList(roomList));
      
      StudentList studentList = new StudentList();
      for (String studentPersonalRefId : source.getStudentPersonalRefIds()) {
        studentList.getStudentPersonalRefId().add(studentPersonalRefId);
      }
      target.setStudentList(objectFactory.createScheduledActivityTypeStudentList(studentList));
      
      TeachingGroupList teachingGroupList = new TeachingGroupList();
      for (String teachingGroupRefId : source.getTeachingGroupRefIds()) {
        teachingGroupList.getTeachingGroupRefId().add(teachingGroupRefId);
      }
      target.setTeachingGroupList(objectFactory.createScheduledActivityTypeTeachingGroupList(teachingGroupList));
      
      List<TeacherCover> teachers = scheduledActivityTeacherConverter.toSifModelList(source.getTeachers());
      TeacherList teacherList = new TeacherList();
      teacherList.getTeacherCover().addAll(teachers);
      target.setTeacherList(objectFactory.createScheduledActivityTypeTeacherList(teacherList));
      
      
      YearLevelsType yearLevelsType = new YearLevelsType();
      YearLevelType yearLevelType = new YearLevelType();
      yearLevelType.setCode(source.getYearLevels());
      yearLevelsType.getYearLevel().add(yearLevelType);
      target.setYearLevels(objectFactory.createScheduledActivityTypeYearLevels(yearLevelsType));

      sif.dd.au30.model.ScheduledActivityType.Override override = objectFactory.createScheduledActivityTypeOverride();
      override.setValue(getEnumValue(source.getOverride(), AUCodeSetsYesOrNoCategoryType.class));
      override.setDateOfOverride(getDateValue(source.getDateOfOverride()));
      target.setOverride(objectFactory.createScheduledActivityTypeOverride(override));
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
      target.setType(getJAXBValue(source.getActivityType()));
      target.setName(getJAXBValue(source.getActivityName()));
      target.setComment(getJAXBValue(source.getActivityComment()));
      
      Set<String> roomInfoRefIds = new HashSet<String>();
      RoomList roomList = getJAXBValue(source.getRoomList());
      roomInfoRefIds.addAll(roomList.getRoomInfoRefId());
      target.setRoomInfoRefIds(roomInfoRefIds);
      
      Set<String> studentPersonalRefIds = new HashSet<String>();
      StudentList studentList = getJAXBValue(source.getStudentList());
      studentPersonalRefIds.addAll(studentList.getStudentPersonalRefId());
      target.setStudentPersonalRefIds(studentPersonalRefIds);
      
      Set<String> teachingGroupRefIds = new HashSet<String>();
      TeachingGroupList teachingGroupList = getJAXBValue(source.getTeachingGroupList());
      teachingGroupRefIds.addAll(teachingGroupList.getTeachingGroupRefId());
      target.setTeachingGroupRefIds(teachingGroupRefIds);
      
      Set<ScheduledActivityTeacher> teachers = new HashSet<ScheduledActivityTeacher>();
      TeacherList teacherList = getJAXBValue(source.getTeacherList());
      teachers.addAll(scheduledActivityTeacherConverter.toHitsModelList(teacherList.getTeacherCover()));
      target.setTeachers(teachers);
      
      YearLevelsType yearLevelsType = getJAXBValue(source.getYearLevels());
      List<YearLevelType> yearLevels = yearLevelsType.getYearLevel();
      if (yearLevels != null && yearLevels.size() > 0 && yearLevels.get(0) != null) {
        target.setYearLevels(yearLevels.get(0).getCode());
      }

      sif.dd.au30.model.ScheduledActivityType.Override override = getJAXBValue(source.getOverride());
      if (override != null) {
        target.setOverride(getEnumValue(override.getValue()));
        target.setDateOfOverride(getDateValue(override.getDateOfOverride()));
      }
    }
  }
}
