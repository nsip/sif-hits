package sif3.hits.domain.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "StudentAttendanceTimeList_AttendanceTime")
public class StudentAttendanceTime {

    private Long id;
    private StudentAttendanceTimeList studentAttendanceTimeList;
    private String startTime;

    private String attendanceType;
    private String attendanceStatus;
    private String endTime;
    private String durationValue;
    private String attendanceNote;
    private String timeTableSubjectRefId;

    private Set<StudentAttendanceTimeOtherCode> otherCodes;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "StudentAttendanceTimeList_RefId", referencedColumnName = "RefId")
    public StudentAttendanceTimeList getStudentAttendanceTimeList() {
        return studentAttendanceTimeList;
    }

    public void setStudentAttendanceTimeList(StudentAttendanceTimeList studentAttendanceTimeList) {
        this.studentAttendanceTimeList = studentAttendanceTimeList;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getAttendanceStatus() {
        return attendanceStatus;
    }

    public void setAttendanceStatus(String attendanceStatus) {
        this.attendanceStatus = attendanceStatus;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getAttendanceNote() {
        return attendanceNote;
    }

    public void setAttendanceNote(String attendanceNote) {
        this.attendanceNote = attendanceNote;
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "studentAttendanceTime")
    public Set<StudentAttendanceTimeOtherCode> getOtherCodes() {
        return otherCodes;
    }

    public void setOtherCodes(Set<StudentAttendanceTimeOtherCode> otherCodes) {
        this.otherCodes = otherCodes;
    }

    public String getAttendanceType() {
        return attendanceType;
    }

    public void setAttendanceType(String attendanceType) {
        this.attendanceType = attendanceType;
    }

    public String getDurationValue() {
        return durationValue;
    }

    public void setDurationValue(String durationValue) {
        this.durationValue = durationValue;
    }

    @Column(name = "TimeTableSubject_RefId")
    public String getTimeTableSubjectRefId() {
        return timeTableSubjectRefId;
    }

    public void setTimeTableSubjectRefId(String timeTableSubjectRefId) {
        this.timeTableSubjectRefId = timeTableSubjectRefId;
    }

}
