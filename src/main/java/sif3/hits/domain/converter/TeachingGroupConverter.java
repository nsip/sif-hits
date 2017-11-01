package sif3.hits.domain.converter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.StudentListType;
import sif.dd.au30.model.TeacherListType;
import sif.dd.au30.model.TeachingGroupPeriodListType;
import sif.dd.au30.model.TeachingGroupPeriodType;
import sif.dd.au30.model.TeachingGroupStudentType;
import sif.dd.au30.model.TeachingGroupTeacherType;
import sif.dd.au30.model.TeachingGroupType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.StaffPersonal;
import sif3.hits.domain.model.StudentPersonal;
import sif3.hits.domain.model.TeachingGroup;
import sif3.hits.domain.model.TeachingGroupTeacher;
import sif3.hits.domain.model.TimeTableCell;

@Component
public class TeachingGroupConverter extends HitsConverter<TeachingGroupType, TeachingGroup> {

  public TeachingGroupConverter() {
    super(TeachingGroupType.class, TeachingGroup.class);
  }

  @Autowired
  private TeachingGroupStudentConverter teachingGroupStudentConverter;

  @Autowired
  private TeachingGroupTeacherConverter teachingGroupTeacherConverter;

  @Autowired
  private TeachingGroupSchoolInfoConverter teachingGroupSchoolInfoConverter;

  @Autowired
  private TeachingGroupTimeTableSubjectConveter teachingGroupTimeTableSubjectConveter;

  @Autowired
  private TeachingGroupPeriodTimeTableCellConverter teachingGroupPeriodTimeTableCellConverter;

  @Override
  public void toSifModel(TeachingGroup source, TeachingGroupType target) {
    if (source != null && target != null) {
      IObjectFactory objectFactory = getObjectFactory();
      target.setRefId(source.getRefId());
      target.setLocalId(source.getLocalId());
      target.setShortName(source.getShortName());
      target.setLongName(objectFactory.createTeachingGroupTypeLongName(source.getLongName()));

      teachingGroupTimeTableSubjectConveter.toSifModel(source.getTimeTableSubject(), target);

      List<TeachingGroupStudentType> students = teachingGroupStudentConverter.toSifModelList(source.getStudentPersonals());
      StudentListType studentList = objectFactory.createStudentListType();
      studentList.getTeachingGroupStudent().addAll(students);
      if (students != null && !students.isEmpty()) {
        target.setStudentList(objectFactory.createTeachingGroupTypeStudentList(studentList));
      }

      List<TeachingGroupTeacherType> teachers = teachingGroupTeacherConverter.toSifModelList(source.getTeachingGroupTeachers());
      if (teachers != null && !teachers.isEmpty()) {
        TeacherListType teacherList = objectFactory.createTeacherListType();

        teacherList.getTeachingGroupTeacher().addAll(teachers);
        target.setTeacherList(objectFactory.createTeachingGroupTypeTeacherList(teacherList));
      }

      List<TeachingGroupPeriodType> teachingGroupPeriods = teachingGroupPeriodTimeTableCellConverter.toSifModelList(source.getTimeTablePeriods());
      if (teachingGroupPeriods != null && !teachingGroupPeriods.isEmpty()) {
        TeachingGroupPeriodListType teachingGroupPeriodList = objectFactory.createTeachingGroupPeriodListType();
        teachingGroupPeriodList.getTeachingGroupPeriod().addAll(teachingGroupPeriods);
        target.setTeachingGroupPeriodList(objectFactory.createTeachingGroupTypeTeachingGroupPeriodList(teachingGroupPeriodList));
      }

      teachingGroupSchoolInfoConverter.toSifModel(source.getSchoolInfo(), target);

      target.setSchoolYear(getYearValue(source.getSchoolYear()));
    }
  }

  @Override
  public void toHitsModel(TeachingGroupType source, TeachingGroup target) {
    if (source != null && target != null) {
      target.setRefId(source.getRefId());
      target.setLocalId(source.getLocalId());
      target.setShortName(source.getShortName());
      target.setLongName(getJAXBValue(source.getLongName()));
      target.setSchoolYear(getYearValue(source.getSchoolYear()));
      target.setSchoolInfo(teachingGroupSchoolInfoConverter.toHitsModel(source));
      target.setTimeTableSubject(teachingGroupTimeTableSubjectConveter.toHitsModel(source));

      handleTeachers(target, source);
      handleStudents(target, source);
      handlePeriods(target, source);
    }
  }

  private void handleTeachers(TeachingGroup target, TeachingGroupType source) {
    Map<String, String> newStaffPersonals = new HashMap<>();
    Map<String, TeachingGroupTeacher> existingStaffPersonals = new HashMap<>();

    TeacherListType teacherListType = getJAXBValue(source.getTeacherList());
    if (teacherListType != null && !teacherListType.getTeachingGroupTeacher().isEmpty()) {
      for (TeachingGroupTeacherType teachingGroupTeacherType : teacherListType.getTeachingGroupTeacher()) {
        String refId = getJAXBValue(teachingGroupTeacherType.getStaffPersonalRefId());
        if (refId != null) {
          newStaffPersonals.put(refId, teachingGroupTeacherType.getAssociation());
        }
      }
    }

    if (target.getTeachingGroupTeachers() == null) {
      target.setTeachingGroupTeachers(new HashSet<TeachingGroupTeacher>());
    }
    for (TeachingGroupTeacher teachingGroupTeacher : target.getTeachingGroupTeachers()) {
      existingStaffPersonals.put(teachingGroupTeacher.getStaffPersonal().getRefId(), teachingGroupTeacher);
    }
    target.getTeachingGroupTeachers().clear();
    for (Entry<String, TeachingGroupTeacher> entry : existingStaffPersonals.entrySet()) {
      if (newStaffPersonals.containsKey(entry.getKey())) {
        String association = newStaffPersonals.get(entry.getKey());
        entry.getValue().setTeacherAssociation(association);
        target.getTeachingGroupTeachers().add(entry.getValue());
      } else {
//        entry.getValue().setTeachingGroup(null);
      }
    }
    for (Entry<String, String> entry : newStaffPersonals.entrySet()) {
      if (!existingStaffPersonals.containsKey(entry.getKey())) {
        TeachingGroupTeacher teacher = new TeachingGroupTeacher();
        teacher.setTeacherAssociation(entry.getValue());
        StaffPersonal staffPersonal = new StaffPersonal();
        staffPersonal.setRefId(entry.getKey());
        teacher.setStaffPersonal(staffPersonal);
        // Do Not Set Teaching Group Yet!
        target.getTeachingGroupTeachers().add(teacher);
      }
    }
  }

  private void handleStudents(TeachingGroup target, TeachingGroupType source) {
    Set<String> newStudentPersonals = new HashSet<>();
    Map<String, StudentPersonal> existingStudentPersonals = new HashMap<>();

    StudentListType studentListType = getJAXBValue(source.getStudentList());
    if (studentListType != null && !studentListType.getTeachingGroupStudent().isEmpty()) {
      for (TeachingGroupStudentType teachingGroupStudentType : studentListType.getTeachingGroupStudent()) {
        String refId = getJAXBValue(teachingGroupStudentType.getStudentPersonalRefId());
        if (refId != null) {
          newStudentPersonals.add(refId);
        }
      }
    }
    if (target.getStudentPersonals() == null) {
      target.setStudentPersonals(new HashSet<StudentPersonal>());
    }
    for (StudentPersonal studentPersonal : target.getStudentPersonals()) {
      existingStudentPersonals.put(studentPersonal.getRefId(), studentPersonal);
    }
    target.getStudentPersonals().clear();
    for (Entry<String, StudentPersonal> entry : existingStudentPersonals.entrySet()) {
      if (newStudentPersonals.contains(entry.getKey())) {
        target.getStudentPersonals().add(entry.getValue());
      }
    }
    for (String refId : newStudentPersonals) {
      if (!existingStudentPersonals.containsKey(refId)) {
        StudentPersonal studentPersonal = new StudentPersonal();
        studentPersonal.setTemporary(true);
        studentPersonal.setRefId(refId);
        target.getStudentPersonals().add(studentPersonal);
      }
    }
  }

  private void handlePeriods(TeachingGroup target, TeachingGroupType source) {
    Set<String> newPeriods = new HashSet<>();
    Map<String, TimeTableCell> existingPeriods = new HashMap<>();

    TeachingGroupPeriodListType teachingGroupPeriodListType = getJAXBValue(source.getTeachingGroupPeriodList());
    if (teachingGroupPeriodListType != null && !teachingGroupPeriodListType.getTeachingGroupPeriod().isEmpty()) {
      for (TeachingGroupPeriodType teachingGroupPeriodType : teachingGroupPeriodListType.getTeachingGroupPeriod()) {
        String refId = getJAXBValue(teachingGroupPeriodType.getTimeTableCellRefId());
        if (refId != null) {
          newPeriods.add(refId);
        }
      }
    }
    if (target.getTimeTablePeriods() == null) {
      target.setTimeTablePeriods(new HashSet<TimeTableCell>());
    }
    for (TimeTableCell timeTablePeriod : target.getTimeTablePeriods()) {
      existingPeriods.put(timeTablePeriod.getRefId(), timeTablePeriod);
    }
    target.getTimeTablePeriods().clear();
    for (Entry<String, TimeTableCell> entry : existingPeriods.entrySet()) {
      if (newPeriods.contains(entry.getKey())) {
        target.getTimeTablePeriods().add(entry.getValue());
      } else {
        entry.getValue().setTeachingGroup(null);
      }
    }
    for (String refId : newPeriods) {
      if (!existingPeriods.containsKey(refId)) {
        TimeTableCell period = new TimeTableCell();
        period.setTemporary(true);
        period.setRefId(refId);
        target.getTimeTablePeriods().add(period);
      }
    }
  }
}
