package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class TimeTableCell extends HitsEntity {
  private static final long serialVersionUID = -454486003499588488L;

  private String refId;
  private TimeTable timeTable;
  private TimeTableSubject timeTableSubject;
  private TeachingGroup teachingGroup;
  private RoomInfo roomInfo;
  private String cellType;
  private String periodId;
  private String dayId;
  private StaffPersonal staffPersonal;
  
  private boolean temporary = false;

  @Id
  public String getRefId() {
    return refId;
  }

  public void setRefId(String refId) {
    this.refId = refId;
  }

  @ManyToOne
  @JoinColumn(name = "TimeTable_RefId", referencedColumnName = "RefId", nullable = false)
  public TimeTable getTimeTable() {
    return timeTable;
  }

  public void setTimeTable(TimeTable timeTable) {
    this.timeTable = timeTable;
  }

  @ManyToOne
  @JoinColumn(name = "TimeTableSubject_RefId", referencedColumnName = "RefId")
  public TimeTableSubject getTimeTableSubject() {
    return timeTableSubject;
  }

  public void setTimeTableSubject(TimeTableSubject timeTableSubject) {
    this.timeTableSubject = timeTableSubject;
  }

  @ManyToOne
  @JoinColumn(name = "TeachingGroup_RefId", referencedColumnName = "RefId")
  public TeachingGroup getTeachingGroup() {
    return teachingGroup;
  }

  public void setTeachingGroup(TeachingGroup teachingGroup) {
    this.teachingGroup = teachingGroup;
  }

  @ManyToOne
  @JoinColumn(name = "RoomInfo_RefId", referencedColumnName = "RefId")
  public RoomInfo getRoomInfo() {
    return roomInfo;
  }

  public void setRoomInfo(RoomInfo roomInfo) {
    this.roomInfo = roomInfo;
  }

  public String getCellType() {
    return cellType;
  }

  public void setCellType(String cellType) {
    this.cellType = cellType;
  }

  public String getPeriodId() {
    return periodId;
  }

  public void setPeriodId(String periodId) {
    this.periodId = periodId;
  }

  public String getDayId() {
    return dayId;
  }

  public void setDayId(String dayId) {
    this.dayId = dayId;
  }

  @ManyToOne
  @JoinColumn(name = "StaffPersonal_RefId", referencedColumnName = "RefId")
  public StaffPersonal getStaffPersonal() {
    return staffPersonal;
  }

  public void setStaffPersonal(StaffPersonal staffPersonal) {
    this.staffPersonal = staffPersonal;
  }
  
  @Transient
  public boolean isTemporary() {
    return temporary;
  }
  
  @Transient
  public void setTemporary(boolean temporary) {
    this.temporary = temporary;
  }
}
