package sif3.hits.domain.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class StudentAttendanceTimeList extends HitsEntity {
  private static final long serialVersionUID = 902174985470454123L;

  private String refId;
  private String schoolInfoRefId;
  private String studentPersonalRefId;
  private String attendanceTimeListDate;
  private String schoolYear;
  private Set<StudentAttendanceTime> attendanceTimes;

  @Id
  public String getRefId() {
    return refId;
  }

  public void setRefId(String refId) {
    this.refId = refId;
  }

  @Column(name = "SchoolInfo_RefId")
  public String getSchoolInfoRefId() {
    return schoolInfoRefId;
  }

  public void setSchoolInfoRefId(String schoolInfoRefId) {
    this.schoolInfoRefId = schoolInfoRefId;
  }

  @Column(name = "StudentPersonal_RefId")
  public String getStudentPersonalRefId() {
    return studentPersonalRefId;
  }

  public void setStudentPersonalRefId(String studentPersonalRefId) {
    this.studentPersonalRefId = studentPersonalRefId;
  }

  public String getAttendanceTimeListDate() {
    return attendanceTimeListDate;
  }

  public void setAttendanceTimeListDate(String attendanceTimeListDate) {
    this.attendanceTimeListDate = attendanceTimeListDate;
  }

  public String getSchoolYear() {
    return schoolYear;
  }

  public void setSchoolYear(String schoolYear) {
    this.schoolYear = schoolYear;
  }

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "studentAttendanceTimeId.studentAttendanceTimeList")
  public Set<StudentAttendanceTime> getAttendanceTimes() {
    return attendanceTimes;
  }

  public void setAttendanceTimes(Set<StudentAttendanceTime> attendanceTimes) {
    this.attendanceTimes = attendanceTimes;
  }
}
