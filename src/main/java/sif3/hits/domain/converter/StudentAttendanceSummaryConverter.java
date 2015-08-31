package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.StudentAttendanceSummaryType;
import sif3.hits.domain.converter.factory.ObjectFactory;
import sif3.hits.domain.model.StudentAttendanceSummary;

@Component
public class StudentAttendanceSummaryConverter extends
    HitsConverter<StudentAttendanceSummaryType, StudentAttendanceSummary> {

  public StudentAttendanceSummaryConverter() {
    super(StudentAttendanceSummaryType.class, StudentAttendanceSummary.class);
  }

  @Override
  public void toSifModel(StudentAttendanceSummary source, StudentAttendanceSummaryType target) {
    if (source != null && target != null) {
      ObjectFactory objectFactory = getObjectFactory();

      target.setStudentAttendanceSummaryRefId(objectFactory
          .createStudentAttendanceSummaryTypeStudentAttendanceSummaryRefId(source.getRefId()));
      target.setStudentPersonalRefId(source.getStudentPersonalRefId());
      target.setSchoolInfoRefId(source.getSchoolInfoRefId());
      target.setSchoolYear(getYearValue(source.getSchoolYear()));
      target.setStartDate(getDateValue(source.getStartDate()));
      target.setEndDate(getDateValue(source.getEndDate()));

      target.setStartDay(objectFactory.createStudentAttendanceSummaryTypeStartDay(getLongValue(source.getStartDay())));
      target.setEndDay(objectFactory.createStudentAttendanceSummaryTypeEndDay(getLongValue(source.getEndDay())));
      target.setFTE(objectFactory.createStudentAttendanceSummaryTypeFTE(getBigDecimalValue(source.getFte())));
      target.setDaysAttended(getBigDecimalValue(source.getDaysAttended()));
      target.setExcusedAbsences(getBigDecimalValue(source.getExcusedAbsences()));
      target.setUnexcusedAbsences(getBigDecimalValue(source.getUnexcusedAbsences()));
      target.setDaysTardy(objectFactory.createStudentAttendanceSummaryTypeDaysTardy(getBigDecimalValue(source
          .getDaysTardy())));
      target.setDaysInMembership(getBigDecimalValue(source.getDaysInMembership()));
    }
  }

  @Override
  public void toHitsModel(StudentAttendanceSummaryType source, StudentAttendanceSummary target) {
    if (source != null && target != null) {
      target.setRefId(getJAXBValue(source.getStudentAttendanceSummaryRefId()));
      target.setStudentPersonalRefId(source.getStudentPersonalRefId());
      target.setSchoolInfoRefId(source.getSchoolInfoRefId());
      target.setSchoolYear(getYearValue(source.getSchoolYear()));
      target.setStartDate(getDateValue(source.getStartDate()));
      target.setEndDate(getDateValue(source.getEndDate()));

      target.setStartDay(getLongValue(getJAXBValue(source.getStartDay())));
      target.setEndDay(getLongValue(getJAXBValue(source.getEndDay())));
      target.setFte(getBigDecimalValue(getJAXBValue(source.getFTE())));
      target.setDaysAttended(getBigDecimalValue(source.getDaysAttended()));
      target.setExcusedAbsences(getBigDecimalValue(source.getExcusedAbsences()));
      target.setUnexcusedAbsences(getBigDecimalValue(source.getUnexcusedAbsences()));
      target.setDaysTardy(getBigDecimalValue(getJAXBValue(source.getDaysTardy())));
      target.setDaysInMembership(getBigDecimalValue(source.getDaysInMembership()));
    }
  }
}
