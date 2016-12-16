package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.AttendanceCodeType;
import sif.dd.au30.model.AuditInfoType;
import sif.dd.au30.model.CreationUserType;
import sif.dd.au30.model.StudentPeriodAttendanceType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.StudentPeriodAttendance;

@Component
public class StudentPeriodAttendanceConverter extends HitsConverter<StudentPeriodAttendanceType, StudentPeriodAttendance> {

  public StudentPeriodAttendanceConverter() {
    super(StudentPeriodAttendanceType.class, StudentPeriodAttendance.class);
  }

  @Override
  public void toSifModel(StudentPeriodAttendance source, StudentPeriodAttendanceType target) {
    if (source != null && target != null) {
      IObjectFactory objectFactory = getObjectFactory();
      target.setRefId(source.getRefId());
      target.setStudentPersonalRefId(source.getStudentPersonalRefId());
      target.setSchoolInfoRefId(source.getSchoolInfoRefId());
      target.setDate(getDateValue(source.getCalendarDate()));
      target.setSessionInfoRefId(objectFactory.createStudentPeriodAttendanceTypeSessionInfoRefId(source.getSessionInfoRefId()));
      target.setTimetablePeriod(objectFactory.createStudentPeriodAttendanceTypeTimetablePeriod(source.getTimetablePeriod()));
      target.setTimeIn(objectFactory.createStudentPeriodAttendanceTypeTimeIn(getTimeValue(source.getTimeIn())));
      target.setTimeOut(objectFactory.createStudentPeriodAttendanceTypeTimeOut(getTimeValue(source.getTimeOut())));

      if (source.getAttendanceCode() != null) {
        AttendanceCodeType attendanceCode = objectFactory.createAttendanceCodeType();
        attendanceCode.setCode(source.getAttendanceCode());
        target.setAttendanceCode(attendanceCode);
      }

      target.setAttendanceStatus(source.getAttendanceStatus());
      target.setSchoolYear(objectFactory.createStudentPeriodAttendanceTypeSchoolYear(getYearValue(source.getSchoolYear())));

      if (source.getCreationUserType() != null || source.getAuditInfoCreationDateTime() != null || source.getAuditInfoCreationUserUserId() != null) {
        AuditInfoType auditInfo = objectFactory.createAuditInfoType();
        auditInfo.setCreationDateTime(getCalendarValue(source.getAuditInfoCreationDateTime()));

        CreationUserType creationUser = objectFactory.createCreationUserType();
        creationUser.setType(source.getCreationUserType());
        creationUser.setUserId(source.getAuditInfoCreationUserUserId());
        if (source.getCreationUserType() != null || source.getAuditInfoCreationUserUserId() != null) {
          auditInfo.setCreationUser(creationUser);
        }
        target.setAuditInfo(objectFactory.createStudentPeriodAttendanceTypeAuditInfo(auditInfo));
      }
      target.setAttendanceComment(objectFactory.createStudentPeriodAttendanceTypeAttendanceComment(source.getAttendanceComment()));
    }
  }

  @Override
  public void toHitsModel(StudentPeriodAttendanceType source, StudentPeriodAttendance target) {
    if (source != null && target != null) {
      target.setRefId(source.getRefId());
      target.setStudentPersonalRefId(source.getStudentPersonalRefId());
      target.setSchoolInfoRefId(source.getSchoolInfoRefId());
      target.setCalendarDate(getDateValue(source.getDate()));
      target.setSessionInfoRefId(getJAXBValue(source.getSessionInfoRefId()));
      target.setTimetablePeriod(getJAXBValue(source.getTimetablePeriod()));
      target.setTimeIn(getTimeValue(getJAXBValue(source.getTimeIn())));
      target.setTimeOut(getTimeValue(getJAXBValue(source.getTimeOut())));

      if (source.getAttendanceCode() != null) {
        target.setAttendanceCode(source.getAttendanceCode().getCode());
      }
      target.setAttendanceStatus(source.getAttendanceStatus());
      target.setSchoolYear(getYearValue(getJAXBValue(source.getSchoolYear())));

      AuditInfoType auditInfo = getJAXBValue(source.getAuditInfo());
      if (auditInfo != null) {
        target.setAuditInfoCreationDateTime(getCalendarValue(auditInfo.getCreationDateTime()));

        CreationUserType creationUser = auditInfo.getCreationUser();
        if (creationUser != null) {
          target.setCreationUserType(creationUser.getType());
          target.setAuditInfoCreationUserUserId(creationUser.getUserId());
        }
      }
      target.setAttendanceComment(getJAXBValue(source.getAttendanceComment()));
    }
  }

}