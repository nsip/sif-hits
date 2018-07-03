package sif3.hits.domain.converter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.AUCodeSetsAttendanceCodeType;
import sif.dd.au30.model.AUCodeSetsAttendanceStatusType;
import sif.dd.au30.model.AttendanceCodeType;
import sif.dd.au30.model.AttendanceTimeType;
import sif.dd.au30.model.AttendanceTimesType;
import sif.dd.au30.model.OtherCodeListType;
import sif.dd.au30.model.OtherCodeListType.OtherCode;
import sif.dd.au30.model.PeriodAttendanceType;
import sif.dd.au30.model.PeriodAttendancesType;
import sif.dd.au30.model.StudentAttendanceTimeListType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.PeriodAttendanceTime;
import sif3.hits.domain.model.StudentAttendanceTime;
import sif3.hits.domain.model.StudentAttendanceTimeList;
import sif3.hits.domain.model.StudentAttendanceTimeOtherCode;

@Component
public class StudentAttendanceTimeListConverter extends HitsConverter<StudentAttendanceTimeListType, StudentAttendanceTimeList> {

    @Autowired
    StudentAttendanceTimeListPeriodAttendanceConverter periodAttendanceConverter;

    public StudentAttendanceTimeListConverter() {
        super(StudentAttendanceTimeListType.class, StudentAttendanceTimeList.class);
    }

    @Override
    public void toSifModel(StudentAttendanceTimeList source, StudentAttendanceTimeListType target) {
        if (source != null && target != null) {
            IObjectFactory objectFactory = getObjectFactory();
            target.setRefId(source.getRefId());
            target.setDate(getDateValue(source.getAttendanceTimeListDate()));
            target.setSchoolInfoRefId(source.getSchoolInfoRefId());
            target.setSchoolYear(getYearValue(source.getSchoolYear()));
            target.setStudentPersonalRefId(source.getStudentPersonalRefId());

            if (source.getAttendanceTimes() != null && !source.getAttendanceTimes().isEmpty()) {
                AttendanceTimesType attendanceTimes = objectFactory.createAttendanceTimesType();
                for (StudentAttendanceTime studentAttendanceTime : source.getAttendanceTimes()) {
                    AttendanceTimeType attendanceTime = objectFactory.createAttendanceTimeType();
                    attendanceTime.setDurationValue(objectFactory.createAttendanceTimeTypeDurationValue(getBigDecimalValue(studentAttendanceTime.getDurationValue())));
                    attendanceTime.setAttendanceNote(objectFactory.createAttendanceTimeTypeAttendanceNote(studentAttendanceTime.getAttendanceNote()));
                    attendanceTime.setAttendanceStatus(getEnumValue(studentAttendanceTime.getAttendanceStatus(), AUCodeSetsAttendanceStatusType.class));
                    attendanceTime.setEndTime(getTimeValue(studentAttendanceTime.getEndTime()));
                    attendanceTime.setStartTime(getTimeValue(studentAttendanceTime.getStartTime()));
                    attendanceTime.setTimeTableSubjectRefId(objectFactory.createAttendanceTimeTypeTimeTableSubjectRefId(studentAttendanceTime.getTimeTableSubjectRefId()));

                    AttendanceCodeType attendanceCodeType = new AttendanceCodeType();
                    attendanceCodeType.setCode(getEnumValue(studentAttendanceTime.getAttendanceType(), AUCodeSetsAttendanceCodeType.class));

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

            if (source.getPeriodAttendanceTimes() != null && !source.getPeriodAttendanceTimes().isEmpty()) {
                List<PeriodAttendanceType> periodAttendances = periodAttendanceConverter.toSifModelList(source.getPeriodAttendanceTimes());
                if (periodAttendances != null && !periodAttendances.isEmpty()) {
                    PeriodAttendancesType periodAttendancesType = objectFactory.createPeriodAttendancesType();
                    periodAttendancesType.getPeriodAttendance().addAll(periodAttendances);
                    target.setPeriodAttendances(objectFactory.createStudentAttendanceTimeListTypePeriodAttendances(periodAttendancesType));
                }
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

            if (target.getAttendanceTimes() == null) {
                target.setAttendanceTimes(new HashSet<StudentAttendanceTime>());
            }
            target.getAttendanceTimes().clear();

            if (target.getPeriodAttendanceTimes() == null) {
                target.setPeriodAttendanceTimes(new HashSet<PeriodAttendanceTime>());
            }
            target.getPeriodAttendanceTimes().clear();

            if (source.getAttendanceTimes() != null) {
                for (AttendanceTimeType attendanceTime : source.getAttendanceTimes().getAttendanceTime()) {
                    StudentAttendanceTime studentAttendanceTime = new StudentAttendanceTime();
                    studentAttendanceTime.setStudentAttendanceTimeList(target);
                    studentAttendanceTime.setDurationValue(getBigDecimalValue(getJAXBValue(attendanceTime.getDurationValue())));
                    studentAttendanceTime.setAttendanceNote(getJAXBValue(attendanceTime.getAttendanceNote()));
                    studentAttendanceTime.setAttendanceStatus(getEnumValue(attendanceTime.getAttendanceStatus()));
                    studentAttendanceTime.setStartTime(getTimeValue(attendanceTime.getStartTime()));
                    studentAttendanceTime.setEndTime(getTimeValue(attendanceTime.getEndTime()));
                    studentAttendanceTime.setTimeTableSubjectRefId(getJAXBValue(attendanceTime.getTimeTableSubjectRefId()));
                    if (attendanceTime.getAttendanceCode() != null) {
                        AttendanceCodeType attendanceCode = attendanceTime.getAttendanceCode();

                        studentAttendanceTime.setAttendanceType(getEnumValue(attendanceCode.getCode()));

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
                    target.getAttendanceTimes().add(studentAttendanceTime);
                }
            }
            PeriodAttendancesType periodAttendances = getJAXBValue(source.getPeriodAttendances());
            if (periodAttendances != null && !periodAttendances.getPeriodAttendance().isEmpty()) {
                List<PeriodAttendanceTime> periodAttendanceTimes = periodAttendanceConverter.toHitsModelList(periodAttendances.getPeriodAttendance());
                if (periodAttendanceTimes != null && !periodAttendanceTimes.isEmpty()) {
                    for (PeriodAttendanceTime periodAttendanceTime : periodAttendanceTimes) {
                        periodAttendanceTime.setStudentAttendanceTimeList(target);
                    }
                    target.getPeriodAttendanceTimes().addAll(periodAttendanceTimes);
                }
            }
        }
    }
}
