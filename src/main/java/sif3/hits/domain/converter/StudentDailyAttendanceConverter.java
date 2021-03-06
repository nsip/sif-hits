package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.AUCodeSetsAttendanceCodeType;
import sif.dd.au30.model.AUCodeSetsAttendanceStatusType;
import sif.dd.au30.model.AUCodeSetsDayValueCodeType;
import sif.dd.au30.model.AttendanceCodeType;
import sif.dd.au30.model.StudentDailyAttendanceType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.StudentDailyAttendance;

@Component
public class StudentDailyAttendanceConverter extends HitsConverter<StudentDailyAttendanceType, StudentDailyAttendance> {

	public StudentDailyAttendanceConverter() {
		super(StudentDailyAttendanceType.class, StudentDailyAttendance.class);
	}

	@Override
	public void toSifModel(StudentDailyAttendance source, StudentDailyAttendanceType target) {
		if (source != null && target != null) {
			IObjectFactory objectFactory = getObjectFactory();

			target.setRefId(source.getRefId());
			target.setStudentPersonalRefId(source.getStudentPersonalRefId());
			target.setSchoolInfoRefId(source.getSchoolInfoRefId());
			target.setDate(getDateValue(source.getCalendarDate()));
			target.setSchoolYear(getYearValue(source.getSchoolYear()));
			target.setDayValue(objectFactory.createStudentDailyAttendanceTypeDayValue(
					getEnumValue(source.getDayValue(), AUCodeSetsDayValueCodeType.class)));

			if (source.getAttendanceCode() != null) {
				AttendanceCodeType attendanceCodeType = objectFactory.createAttendanceCodeType();
				attendanceCodeType
						.setCode(getEnumValue(source.getAttendanceCode(), AUCodeSetsAttendanceCodeType.class));
				target.setAttendanceCode(attendanceCodeType);
			}

			target.setAttendanceStatus(
					getEnumValue(source.getAttendanceStatus(), AUCodeSetsAttendanceStatusType.class));
			target.setTimeIn(objectFactory.createStudentDailyAttendanceTypeTimeIn(getTimeValue(source.getTimeIn())));
			target.setTimeOut(objectFactory.createStudentDailyAttendanceTypeTimeOut(getTimeValue(source.getTimeOut())));
			target.setAbsenceValue(objectFactory
					.createStudentDailyAttendanceTypeAbsenceValue(getBigDecimalValue(source.getAbsenceValue())));
			target.setAttendanceNote(
					objectFactory.createStudentDailyAttendanceTypeAttendanceNote(source.getAttendanceNote()));
		}
	}

	@Override
	public void toHitsModel(StudentDailyAttendanceType source, StudentDailyAttendance target) {
		if (source != null && target != null) {
			target.setRefId(source.getRefId());
			target.setStudentPersonalRefId(source.getStudentPersonalRefId());
			target.setSchoolInfoRefId(source.getSchoolInfoRefId());
			target.setCalendarDate(getDateValue(source.getDate()));
			target.setSchoolYear(getYearValue(source.getSchoolYear()));
			target.setDayValue(getJAXBEnumValue(source.getDayValue()));

			if (source.getAttendanceCode() != null) {
				AttendanceCodeType attendanceCodeType = source.getAttendanceCode();
				target.setAttendanceCode(getEnumValue(attendanceCodeType.getCode()));
			} else {
				target.setAttendanceCode(null);
			}

			target.setAttendanceStatus(getEnumValue(source.getAttendanceStatus()));
			target.setTimeIn(getTimeValue(getJAXBValue(source.getTimeIn())));
			target.setTimeOut(getTimeValue(getJAXBValue(source.getTimeOut())));
			target.setAbsenceValue(getBigDecimalValue(getJAXBValue(source.getAbsenceValue())));
			target.setAttendanceNote(getJAXBValue(source.getAttendanceNote()));
		}
	}
}
