package sif3.hits.domain.converter;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

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
import sif3.hits.domain.model.StudentPersonal;
import sif3.hits.domain.model.TeachingGroup;
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
  private TeachingGroupPeriodTimeTableCellConverter teachingGroupPeriodTimeTableCellConverter;

  @Override
  public void toSifModel(TeachingGroup source, TeachingGroupType target) {
    if (source != null && target != null) {
      IObjectFactory objectFactory = getObjectFactory();
      target.setRefId(source.getRefId());
      target.setLocalId(source.getLocalId());
      target.setShortName(source.getShortName());
      target.setLongName(objectFactory.createTeachingGroupTypeLongName(source.getLongName()));

      List<TeachingGroupStudentType> students = teachingGroupStudentConverter.toSifModelList(source.getStudentPersonals());
      StudentListType studentList = objectFactory.createStudentListType();
      studentList.getTeachingGroupStudent().addAll(students);
      target.setStudentList(objectFactory.createTeachingGroupTypeStudentList(studentList));

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

      target.setTeachingGroupTeachers(new HashSet<sif3.hits.domain.model.TeachingGroupTeacher>());
      if (source.getTeacherList() != null && source.getTeacherList().getValue() != null) {
        Collection<sif3.hits.domain.model.TeachingGroupTeacher> teachers = teachingGroupTeacherConverter.toHitsModelList(source.getTeacherList().getValue().getTeachingGroupTeacher());
        if (teachers != null) {
          target.setTeachingGroupTeachers(new HashSet<sif3.hits.domain.model.TeachingGroupTeacher>(teachers));
        }
      }

      target.setStudentPersonals(new HashSet<StudentPersonal>());
      if (source.getStudentList() != null && source.getStudentList().getValue() != null) {
        Collection<StudentPersonal> studentPersonals = teachingGroupStudentConverter.toHitsModelList(source.getStudentList().getValue().getTeachingGroupStudent());
        if (studentPersonals != null) {
          target.setStudentPersonals(new HashSet<StudentPersonal>(studentPersonals));
        }
      }

      target.setTimeTablePeriods(new HashSet<TimeTableCell>());
      if (source.getTeachingGroupPeriodList() != null && source.getTeachingGroupPeriodList().getValue() != null) {
        Collection<TimeTableCell> timeTablePeriods = teachingGroupPeriodTimeTableCellConverter.toHitsModelList(source.getTeachingGroupPeriodList().getValue().getTeachingGroupPeriod());
        if (timeTablePeriods != null) {
          target.setTimeTablePeriods(new HashSet<TimeTableCell>(timeTablePeriods));
        }
      }
    }
  }
}
