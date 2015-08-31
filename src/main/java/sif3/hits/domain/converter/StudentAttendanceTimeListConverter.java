package sif3.hits.domain.converter;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.AttendanceCodeType;
import sif.dd.au30.model.OtherCodeListType;
import sif.dd.au30.model.OtherCodeListType.OtherCode;
import sif.dd.au30.model.StudentAttendanceTimeListType;
import sif.dd.au30.model.StudentAttendanceTimeListType.AttendanceTimes;
import sif.dd.au30.model.StudentAttendanceTimeListType.AttendanceTimes.AttendanceTime;
import sif3.hits.domain.converter.factory.ObjectFactory;
import sif3.hits.domain.model.StudentAttendanceTime;
import sif3.hits.domain.model.StudentAttendanceTimeList;
import sif3.hits.domain.model.StudentAttendanceTimeOtherCode;

@Component
public class StudentAttendanceTimeListConverter extends
    HitsConverter<StudentAttendanceTimeListType, StudentAttendanceTimeList> {

  public StudentAttendanceTimeListConverter() {
    super(StudentAttendanceTimeListType.class, StudentAttendanceTimeList.class);
  }

  @Override
  public void toSifModel(StudentAttendanceTimeList source, StudentAttendanceTimeListType target) {
    if (source != null && target != null) {
      ObjectFactory objectFactory = getObjectFactory();
      target.setRefId(source.getRefId());
      target.setDate(getDateValue(source.getAttendanceTimeListDate()));
      target.setSchoolInfoRefId(source.getSchoolInfoRefId());
      target.setSchoolYear(getYearValue(source.getSchoolYear()));
      target.setStudentPersonalRefId(source.getStudentPersonalRefId());

      if (source.getAttendanceTimes() != null && !source.getAttendanceTimes().isEmpty()) {
        AttendanceTimes attendanceTimes = objectFactory.createStudentAttendanceTimeListTypeAttendanceTimes();
        for (StudentAttendanceTime studentAttendanceTime : source.getAttendanceTimes()) {
          AttendanceTime attendanceTime = objectFactory
              .createStudentAttendanceTimeListTypeAttendanceTimesAttendanceTime();
          attendanceTime
              .setDurationValue(objectFactory
                  .createStudentAttendanceTimeListTypeAttendanceTimesAttendanceTimeDurationValue(getBigDecimalValue(studentAttendanceTime
                      .getAbsenceValue())));
          attendanceTime.setAttendanceNote(objectFactory
              .createStudentAttendanceTimeListTypeAttendanceTimesAttendanceTimeAttendanceNote(studentAttendanceTime
                  .getAttendanceNote()));
          attendanceTime.setAttendanceStatus(studentAttendanceTime.getAttendanceStatus());
          attendanceTime.setEndTime(getTimeValue(studentAttendanceTime.getEndTime()));
          attendanceTime.setStartTime(getTimeValue(studentAttendanceTime.getStartTime()));

          AttendanceCodeType attendanceCodeType = new AttendanceCodeType();
          attendanceCodeType.setCode(studentAttendanceTime.getCode());

          if (studentAttendanceTime.getOtherCodes() != null && !studentAttendanceTime.getOtherCodes().isEmpty()) {
            OtherCodeListType otherCodeList = new OtherCodeListType();
            for (StudentAttendanceTimeOtherCode studentOtherCode : studentAttendanceTime.getOtherCodes()) {
              OtherCode otherCode = new OtherCode();
              otherCode.setValue(studentOtherCode.getOtherCode());
              otherCode.setCodeset(studentOtherCode.getCodeSet());
              otherCodeList.getOtherCode().add(otherCode);
            }
            attendanceCodeType.setOtherCodeList(objectFactory.createAttendanceCodeTypeOtherCodeList(otherCodeList));
          }
          attendanceTime.setAttendanceCode(attendanceCodeType);

          attendanceTimes.getAttendanceTime().add(attendanceTime);
        }
        target.setAttendanceTimes(attendanceTimes);
      }
    }
  }

  @Override
  public void toHitsModel(StudentAttendanceTimeListType source, StudentAttendanceTimeList target) {
    if (source != null && target != null) {
      target.setRefId(source.getRefId());
      target.setAttendanceTimeListDate(getDateValue(source.getDate()));
      target.setSchoolInfoRefId(source.getSchoolInfoRefId());
      target.setSchoolYear(getYearValue(source.getSchoolYear()));
      target.setStudentPersonalRefId(source.getStudentPersonalRefId());

      Set<StudentAttendanceTime> attendanceTimes = new HashSet<StudentAttendanceTime>();
      target.setAttendanceTimes(attendanceTimes);

      if (source.getAttendanceTimes() != null) {
        for (AttendanceTime attendanceTime : source.getAttendanceTimes().getAttendanceTime()) {
          StudentAttendanceTime studentAttendanceTime = new StudentAttendanceTime();
          studentAttendanceTime.setStudentAttendanceTimeList(target);
          studentAttendanceTime.setAbsenceValue(getBigDecimalValue(getJAXBValue(attendanceTime.getDurationValue())));
          studentAttendanceTime.setAttendanceNote(getJAXBValue(attendanceTime.getAttendanceNote()));
          studentAttendanceTime.setAttendanceStatus(attendanceTime.getAttendanceStatus());
          studentAttendanceTime.setStartTime(getTimeValue(attendanceTime.getStartTime()));
          studentAttendanceTime.setEndTime(getTimeValue(attendanceTime.getEndTime()));
          if (attendanceTime.getAttendanceCode() != null) {
            AttendanceCodeType attendanceCode = attendanceTime.getAttendanceCode();
            
            studentAttendanceTime.setCode(attendanceCode.getCode());
            
            Set<StudentAttendanceTimeOtherCode> otherCodes = new HashSet<StudentAttendanceTimeOtherCode>();
            studentAttendanceTime.setOtherCodes(otherCodes);
            
            if (attendanceCode.getOtherCodeList() != null) {
              OtherCodeListType otherCodeList = getJAXBValue(attendanceCode.getOtherCodeList());
              if (otherCodeList != null) {
                for (OtherCode otherCode : otherCodeList.getOtherCode()) {
                  StudentAttendanceTimeOtherCode studentOtherCode = new StudentAttendanceTimeOtherCode();
                  studentOtherCode.setStudentAttendanceTime(studentAttendanceTime);
                  studentOtherCode.setOtherCode(otherCode.getValue());
                  studentOtherCode.setCodeSet(otherCode.getCodeset());
                  otherCodes.add(studentOtherCode);
                }
              }
            }
          }
          attendanceTimes.add(studentAttendanceTime);
        }
      }
    }
  }
}
