package sif3.hits.domain.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class ScheduledActivity extends HitsEntity implements ZoneFilterable {
  private static final long serialVersionUID = -1681160900137304643L;

  private String refId;
  private String schoolInfoRefId;
  private String timeTableRefId;
  private String timeTableCellRefId;
  private String timeTableSubjectRefId;
  private String dayId;
  private String periodId;
  private String date;
  private String startTime;
  private String finishTime;
  private String cellType;
  private String location;
  private String type;
  private String name;
  private String comment;
  private String yearLevels;
  private String override;
  private String dateOfOverride;
  private Set<String> roomInfoRefIds;
  private Set<String> studentPersonalRefIds;
  private Set<String> teachingGroupRefIds;
  private Set<ScheduledActivityTeacher> teachers;

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

  @Column(name = "TimeTable_RefId")
  public String getTimeTableRefId() {
    return timeTableRefId;
  }

  public void setTimeTableRefId(String timeTableRefId) {
    this.timeTableRefId = timeTableRefId;
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

  public String getDayId() {
    return dayId;
  }

  public void setDayId(String dayId) {
    this.dayId = dayId;
  }

  public String getPeriodId() {
    return periodId;
  }

  public void setPeriodId(String periodId) {
    this.periodId = periodId;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getStartTime() {
    return startTime;
  }

  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  public String getFinishTime() {
    return finishTime;
  }

  public void setFinishTime(String finishTime) {
    this.finishTime = finishTime;
  }

  public String getCellType() {
    return cellType;
  }

  public void setCellType(String cellType) {
    this.cellType = cellType;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public String getYearLevels() {
    return yearLevels;
  }

  public void setYearLevels(String yearLevels) {
    this.yearLevels = yearLevels;
  }

  public String getOverride() {
    return override;
  }

  public void setOverride(String override) {
    this.override = override;
  }

  public String getDateOfOverride() {
    return dateOfOverride;
  }

  public void setDateOfOverride(String dateOfOverride) {
    this.dateOfOverride = dateOfOverride;
  }

  @ElementCollection
  @CollectionTable(name = "ScheduledActivity_Room", joinColumns = { @JoinColumn(name="ScheduledActivity_RefId") } )
  @Column(name = "RoomInfo_RefId")
  public Set<String> getRoomInfoRefIds() {
    return roomInfoRefIds;
  }

  public void setRoomInfoRefIds(Set<String> roomInfoRefIds) {
    this.roomInfoRefIds = roomInfoRefIds;
  }

  @ElementCollection
  @CollectionTable(name = "ScheduledActivity_Student", joinColumns = { @JoinColumn(name="ScheduledActivity_RefId") } )
  @Column(name = "StudentPersonal_RefId")
  public Set<String> getStudentPersonalRefIds() {
    return studentPersonalRefIds;
  }

  public void setStudentPersonalRefIds(Set<String> studentPersonalRefIds) {
    this.studentPersonalRefIds = studentPersonalRefIds;
  }

  @ElementCollection
  @CollectionTable(name = "ScheduledActivity_TeachingGroup", joinColumns = { @JoinColumn(name="ScheduledActivity_RefId") } )
  @Column(name = "TeachingGroup_RefId")
  public Set<String> getTeachingGroupRefIds() {
    return teachingGroupRefIds;
  }

  public void setTeachingGroupRefIds(Set<String> teachingGroupRefIds) {
    this.teachingGroupRefIds = teachingGroupRefIds;
  }

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "scheduledActivityTeacherId.scheduledActivity",  cascade = CascadeType.ALL)
  public Set<ScheduledActivityTeacher> getTeachers() {
    return teachers;
  }

  public void setTeachers(Set<ScheduledActivityTeacher> teachers) {
    this.teachers = teachers;
  }
}
