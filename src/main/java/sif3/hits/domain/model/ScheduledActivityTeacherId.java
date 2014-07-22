package sif3.hits.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ScheduledActivityTeacherId implements Serializable {
  private static final long serialVersionUID = 6444522498630308820L;

  @ManyToOne(optional = false)
  @JoinColumn(name = "ScheduledActivity_RefId", referencedColumnName = "RefId")
  private ScheduledActivity scheduledActivity;
  
  @Column(name = "StaffPersonal_RefId")
  private String staffPersonalRefId;

  public ScheduledActivity getScheduledActivity() {
    return scheduledActivity;
  }

  public void setScheduledActivity(ScheduledActivity scheduledActivity) {
    this.scheduledActivity = scheduledActivity;
  }

  public String getStaffPersonalRefId() {
    return staffPersonalRefId;
  }

  public void setStaffPersonalRefId(String staffPersonalRefId) {
    this.staffPersonalRefId = staffPersonalRefId;
  }
}