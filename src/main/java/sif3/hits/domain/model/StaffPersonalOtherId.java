package sif3.hits.domain.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "StaffPersonal_OtherId")
public class StaffPersonalOtherId implements Serializable {
  private static final long serialVersionUID = 603884775630519212L;

  @EmbeddedId
  private StaffPersonalOtherIdId staffPersonalOtherIdId;

  public StaffPersonalOtherIdId getStaffPersonalOtherIdId() {
    return staffPersonalOtherIdId;
  }

  public void setStaffPersonalOtherIdId(StaffPersonalOtherIdId staffPersonalOtherIdId) {
    this.staffPersonalOtherIdId = staffPersonalOtherIdId;
  }

  @Transient
  public StaffPersonal getStaffPersonal() {
    StaffPersonal result = null;
    if (staffPersonalOtherIdId != null) {
      result = staffPersonalOtherIdId.getStaffPersonal();
    }
    return result;
  }

  @Transient
  public void setStaffPersonal(StaffPersonal staffPersonal) {
    if (staffPersonalOtherIdId == null) {
      staffPersonalOtherIdId = new StaffPersonalOtherIdId();
    }
    this.staffPersonalOtherIdId.setStaffPersonal(staffPersonal);
  }

  @Transient
  public String getOtherId() {
    String result = null;
    if (staffPersonalOtherIdId != null) {
      result = staffPersonalOtherIdId.getOtherId();
    }
    return result;
  }

  @Transient
  public void setOtherId(String otherId) {
    if (staffPersonalOtherIdId == null) {
      staffPersonalOtherIdId = new StaffPersonalOtherIdId();
    }
    this.staffPersonalOtherIdId.setOtherId(otherId);
  }

  @Transient
  public String getOtherIdType() {
    String result = null;
    if (staffPersonalOtherIdId != null) {
      result = staffPersonalOtherIdId.getOtherIdType();
    }
    return result;
  }

  @Transient
  public void setOtherIdType(String otherIdType) {
    if (staffPersonalOtherIdId == null) {
      staffPersonalOtherIdId = new StaffPersonalOtherIdId();
    }
    this.staffPersonalOtherIdId.setOtherIdType(otherIdType);
  }

}
