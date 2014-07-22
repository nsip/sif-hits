package sif3.hits.domain.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "ScheduledActivity_Teacher")
public class ScheduledActivityTeacher {
  @EmbeddedId
  private ScheduledActivityTeacherId scheduledActivityTeacherId;

  private String teacherLocalId;
  private String startTime;
  private String finishTime;
  private String credit;
  private String supervision;
  private String weighting;

  public ScheduledActivityTeacherId getScheduledActivityTeacherId() {
    return scheduledActivityTeacherId;
  }

  public void setScheduledActivityTeacherId(ScheduledActivityTeacherId scheduledActivityTeacherId) {
    this.scheduledActivityTeacherId = scheduledActivityTeacherId;
  }

  @Transient
  public ScheduledActivity getScheduledActivity() {
    ScheduledActivity result = null;
    if (scheduledActivityTeacherId != null) {
      result = scheduledActivityTeacherId.getScheduledActivity();
    }
    return result;
  }

  @Transient
  public void setScheduledActivity(ScheduledActivity scheduledActivity) {
    if (scheduledActivityTeacherId == null) {
      scheduledActivityTeacherId = new ScheduledActivityTeacherId();
    }
    this.scheduledActivityTeacherId.setScheduledActivity(scheduledActivity);
  }

  @Transient
  public String getStaffPersonalRefId() {
    String result = null;
    if (scheduledActivityTeacherId != null) {
      result = scheduledActivityTeacherId.getStaffPersonalRefId();
    }
    return result;
  }

  @Transient
  public void setStaffPersonalRefId(String staffPersonalRefId) {
    if (scheduledActivityTeacherId == null) {
      scheduledActivityTeacherId = new ScheduledActivityTeacherId();
    }
    this.scheduledActivityTeacherId.setStaffPersonalRefId(staffPersonalRefId);
  }

  public String getTeacherLocalId() {
    return teacherLocalId;
  }

  public void setTeacherLocalId(String teacherLocalId) {
    this.teacherLocalId = teacherLocalId;
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

  public String getCredit() {
    return credit;
  }

  public void setCredit(String credit) {
    this.credit = credit;
  }

  public String getSupervision() {
    return supervision;
  }

  public void setSupervision(String supervision) {
    this.supervision = supervision;
  }

  public String getWeighting() {
    return weighting;
  }

  public void setWeighting(String weighting) {
    this.weighting = weighting;
  }
}
