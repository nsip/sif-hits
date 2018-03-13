package sif3.hits.domain.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "StudentAttendanceTimeList_PeriodAttendance")
public class PeriodAttendanceTime {

    private Long id;
    private StudentAttendanceTimeList studentAttendanceTimeList;
    private String attendanceType;
    private String attendanceCode;
    private String attendanceStatus;
    private String attendanceDate;
    private String sessionInfoRefId;
    private String scheduledActivityRefId;
    private String timetablePeriod;
    private String dayId;
    private String startTime;
    private String endTime;
    private String timeIn;
    private String timeOut;
    private String timeTableCellRefId;
    private String timeTableSubjectRefId;
    private String attendanceNote;

    private List<PeriodAttendanceTeacher> teachers;
    private List<String> roomInfos;
    private List<PeriodAttendanceOtherCode> otherCodes;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "studentAttendanceTimeList_RefId")
    public StudentAttendanceTimeList getStudentAttendanceTimeList() {
        return studentAttendanceTimeList;
    }

    public void setStudentAttendanceTimeList(StudentAttendanceTimeList studentAttendanceTimeList) {
        this.studentAttendanceTimeList = studentAttendanceTimeList;
    }

    public String getAttendanceType() {
        return attendanceType;
    }

    public void setAttendanceType(String attendanceType) {
        this.attendanceType = attendanceType;
    }

    public String getAttendanceCode() {
        return attendanceCode;
    }

    public void setAttendanceCode(String attendanceCode) {
        this.attendanceCode = attendanceCode;
    }

    public String getAttendanceStatus() {
        return attendanceStatus;
    }

    public void setAttendanceStatus(String attendanceStatus) {
        this.attendanceStatus = attendanceStatus;
    }

    public String getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(String attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    @Column(name = "sessionInfo_RefId")
    public String getSessionInfoRefId() {
        return sessionInfoRefId;
    }

    public void setSessionInfoRefId(String sessionInfoRefId) {
        this.sessionInfoRefId = sessionInfoRefId;
    }

    @Column(name = "scheduledActivity_RefId")
    public String getScheduledActivityRefId() {
        return scheduledActivityRefId;
    }

    public void setScheduledActivityRefId(String scheduledActivityRefId) {
        this.scheduledActivityRefId = scheduledActivityRefId;
    }

    public String getTimetablePeriod() {
        return timetablePeriod;
    }

    public void setTimetablePeriod(String timetablePeriod) {
        this.timetablePeriod = timetablePeriod;
    }

    public String getDayId() {
        return dayId;
    }

    public void setDayId(String dayId) {
        this.dayId = dayId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(String timeIn) {
        this.timeIn = timeIn;
    }

    public String getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(String timeOut) {
        this.timeOut = timeOut;
    }

    @Column(name = "TimeTableCell_RefId")
    public String getTimeTableCellRefId() {
        return timeTableCellRefId;
    }

    public void setTimeTableCellRefId(String timeTableCellRefId) {
        this.timeTableCellRefId = timeTableCellRefId;
    }

    @Column(name = "TimeTableSubject_RefId")
    public String getTimeTableSubjectRefId() {
        return timeTableSubjectRefId;
    }

    public void setTimeTableSubjectRefId(String timeTableSubjectRefId) {
        this.timeTableSubjectRefId = timeTableSubjectRefId;
    }

    public String getAttendanceNote() {
        return attendanceNote;
    }

    public void setAttendanceNote(String attendanceNote) {
        this.attendanceNote = attendanceNote;
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "periodAttendanceTime")
    public List<PeriodAttendanceTeacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<PeriodAttendanceTeacher> teachers) {
        this.teachers = teachers;
    }

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "StudentAttendanceTimeList_PeriodAttendance_RoomInfo", joinColumns = @JoinColumn(name = "PeriodAttendance_Id"))
    @Column(name="RoomInfo_RefId")
    public List<String> getRoomInfos() {
        return roomInfos;
    }

    public void setRoomInfos(List<String> roomInfos) {
        this.roomInfos = roomInfos;
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "periodAttendanceTime")
    public List<PeriodAttendanceOtherCode> getOtherCodes() {
        return otherCodes;
    }

    public void setOtherCodes(List<PeriodAttendanceOtherCode> otherCodes) {
        this.otherCodes = otherCodes;
    }
}
