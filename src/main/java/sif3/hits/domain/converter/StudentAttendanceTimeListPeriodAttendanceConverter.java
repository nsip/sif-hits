package sif3.hits.domain.converter;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.AUCodeSetsAttendanceCodeType;
import sif.dd.au30.model.AUCodeSetsAttendanceStatusType;
import sif.dd.au30.model.AttendanceCodeType;
import sif.dd.au30.model.OtherCodeListType;
import sif.dd.au30.model.OtherCodeListType.OtherCode;
import sif.dd.au30.model.PeriodAttendanceType;
import sif.dd.au30.model.RoomListType;
import sif.dd.au30.model.ScheduledTeacherListType;
import sif.dd.au30.model.TeacherCoverType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.PeriodAttendanceOtherCode;
import sif3.hits.domain.model.PeriodAttendanceTeacher;
import sif3.hits.domain.model.PeriodAttendanceTime;

@Component
public class StudentAttendanceTimeListPeriodAttendanceConverter extends HitsConverter<PeriodAttendanceType, PeriodAttendanceTime> {

    @Autowired
    private StudentPeriodAttendanceOtherCodeConverter otherCodeConverter;

    @Autowired
    private StudentPeriodAttendanceTeacherCoverConverter teacherCoverConverter;

    public StudentAttendanceTimeListPeriodAttendanceConverter() {
        super(PeriodAttendanceType.class, PeriodAttendanceTime.class);
    }

    @Override
    public void toSifModel(PeriodAttendanceTime source, PeriodAttendanceType target) {
        if (source != null && target != null) {
            IObjectFactory objectFactory = getObjectFactory();
            target.setAttendanceType(objectFactory.createPeriodAttendanceTypeAttendanceType(source.getAttendanceType()));
            target.setAttendanceStatus(getEnumValue(source.getAttendanceStatus(), AUCodeSetsAttendanceStatusType.class));
            target.setDate(getDateValue(source.getAttendanceDate()));
            target.setSessionInfoRefId(objectFactory.createPeriodAttendanceTypeSessionInfoRefId(source.getSessionInfoRefId()));
            target.setScheduledActivityRefId(objectFactory.createPeriodAttendanceTypeScheduledActivityRefId(source.getScheduledActivityRefId()));
            target.setTimetablePeriod(objectFactory.createPeriodAttendanceTypeTimetablePeriod(source.getTimetablePeriod()));
            target.setDayId(objectFactory.createPeriodAttendanceTypeDayId(source.getDayId()));
            target.setStartTime(objectFactory.createPeriodAttendanceTypeStartTime(getTimeValue(source.getStartTime())));
            target.setEndTime(objectFactory.createPeriodAttendanceTypeEndTime(getTimeValue(source.getEndTime())));
            target.setTimeIn(objectFactory.createPeriodAttendanceTypeTimeIn(getTimeValue(source.getTimeIn())));
            target.setTimeOut(objectFactory.createPeriodAttendanceTypeTimeOut(getTimeValue(source.getTimeOut())));
            target.setTimeTableCellRefId(objectFactory.createPeriodAttendanceTypeTimeTableCellRefId(source.getTimeTableCellRefId()));
            target.setTimeTableSubjectRefId(objectFactory.createPeriodAttendanceTypeTimeTableSubjectRefId(source.getTimeTableSubjectRefId()));
            target.setAttendanceNote(objectFactory.createPeriodAttendanceTypeAttendanceNote(source.getAttendanceNote()));

            List<TeacherCoverType> teacherCovers = teacherCoverConverter.toSifModelList(source.getTeachers());
            if (teacherCovers != null && !teacherCovers.isEmpty()) {
                ScheduledTeacherListType scheduledTeacherList = objectFactory.createScheduledTeacherListType();
                scheduledTeacherList.getTeacherCover().addAll(teacherCovers);
                target.setTeacherList(objectFactory.createPeriodAttendanceTypeTeacherList(scheduledTeacherList));
            }

            if (source.getRoomInfos() != null && !source.getRoomInfos().isEmpty()) {
                RoomListType roomList = objectFactory.createRoomListType();
                roomList.getRoomInfoRefId().addAll(source.getRoomInfos());
                target.setRoomList(objectFactory.createPeriodAttendanceTypeRoomList(roomList));
            }

            List<OtherCode> otherCodes = otherCodeConverter.toSifModelList(source.getOtherCodes());
            if (StringUtils.isNotBlank(source.getAttendanceCode()) || (otherCodes != null && !otherCodes.isEmpty())) {
                AttendanceCodeType attendanceCodeType = objectFactory.createAttendanceCodeType();
                attendanceCodeType.setCode(getEnumValue(source.getAttendanceCode(), AUCodeSetsAttendanceCodeType.class));
                if (otherCodes != null && !otherCodes.isEmpty()) {
                    OtherCodeListType otherCodeListType = objectFactory.createOtherCodeListType();
                    otherCodeListType.getOtherCode().addAll(otherCodes);
                    attendanceCodeType.setOtherCodeList(objectFactory.createAttendanceCodeTypeOtherCodeList(otherCodeListType));
                }
                target.setAttendanceCode(attendanceCodeType);
            }
        }
    }

    @Override
    public void toHitsModel(PeriodAttendanceType source, PeriodAttendanceTime target) {
        if (source != null && target != null) {
            resetModel(target);
            target.setAttendanceType(getJAXBValue(source.getAttendanceType()));
            target.setAttendanceStatus(getEnumValue(source.getAttendanceStatus()));
            target.setAttendanceDate(getDateValue(source.getDate()));
            target.setSessionInfoRefId(getJAXBValue(source.getSessionInfoRefId()));
            target.setScheduledActivityRefId(getJAXBValue(source.getScheduledActivityRefId()));
            target.setTimetablePeriod(getJAXBValue(source.getTimetablePeriod()));
            target.setDayId(getJAXBValue(source.getDayId()));
            target.setStartTime(getTimeValue(getJAXBValue(source.getStartTime())));
            target.setEndTime(getTimeValue(getJAXBValue(source.getEndTime())));
            target.setTimeIn(getTimeValue(getJAXBValue(source.getTimeIn())));
            target.setTimeOut(getTimeValue(getJAXBValue(source.getTimeOut())));
            target.setTimeTableCellRefId(getJAXBValue(source.getTimeTableCellRefId()));
            target.setTimeTableSubjectRefId(getJAXBValue(source.getTimeTableSubjectRefId()));
            target.setAttendanceNote(getJAXBValue(source.getAttendanceNote()));
            ScheduledTeacherListType scheduledTeacherList = getJAXBValue(source.getTeacherList());
            if (scheduledTeacherList != null && !scheduledTeacherList.getTeacherCover().isEmpty()) {
                List<PeriodAttendanceTeacher> teacherCovers = teacherCoverConverter.toHitsModelList(scheduledTeacherList.getTeacherCover());
                if (teacherCovers != null && !teacherCovers.isEmpty()) {
                    for (PeriodAttendanceTeacher teacherCover : teacherCovers) {
                        teacherCover.setPeriodAttendanceTime(target);
                    }
                    target.getTeachers().addAll(teacherCovers);
                }
            }
            RoomListType roomList = getJAXBValue(source.getRoomList());
            if (roomList != null && !roomList.getRoomInfoRefId().isEmpty()) {
                target.getRoomInfos().addAll(roomList.getRoomInfoRefId());
            }

            AttendanceCodeType attendanceCodeType = source.getAttendanceCode();
            if (attendanceCodeType != null) {
                target.setAttendanceCode(getEnumValue(attendanceCodeType.getCode()));
                OtherCodeListType otherCodeList = getJAXBValue(attendanceCodeType.getOtherCodeList());
                if (otherCodeList != null && !otherCodeList.getOtherCode().isEmpty()) {
                    List<PeriodAttendanceOtherCode> otherCodes = otherCodeConverter.toHitsModelList(otherCodeList.getOtherCode());
                    if (otherCodes != null && !otherCodes.isEmpty()) {
                        for (PeriodAttendanceOtherCode otherCode : otherCodes) {
                            otherCode.setPeriodAttendanceTime(target);
                        }
                        target.getOtherCodes().addAll(otherCodes);
                    }
                }
            }
        }
    }

    private void resetModel(PeriodAttendanceTime target) {
        target.setAttendanceCode(null);
        if (target.getOtherCodes() == null) {
            target.setOtherCodes(new ArrayList<PeriodAttendanceOtherCode>());
        }
        target.getOtherCodes().clear();

        if (target.getTeachers() == null) {
            target.setTeachers(new ArrayList<PeriodAttendanceTeacher>());
        }
        target.getTeachers().clear();

        if (target.getRoomInfos() == null) {
            target.setRoomInfos(new ArrayList<String>());
        }
        target.getRoomInfos().clear();
    }
}
