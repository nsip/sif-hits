package sif3.hits.domain.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class StaffPersonalOtherIdId implements Serializable {
  private static final long serialVersionUID = 8116304826135644138L;

  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  @JoinColumn(name = "StaffPersonal_RefId", referencedColumnName = "RefId")
  private StaffPersonal staffPersonal;
  private String otherId;
  private String otherIdType;

  public StaffPersonal getStaffPersonal() {
    return staffPersonal;
  }

  public void setStaffPersonal(StaffPersonal staffPersonal) {
    this.staffPersonal = staffPersonal;
  }

  public String getOtherId() {
    return otherId;
  }

  public void setOtherId(String otherId) {
    this.otherId = otherId;
  }

  public String getOtherIdType() {
    return otherIdType;
  }

  public void setOtherIdType(String otherIdType) {
    this.otherIdType = otherIdType;
  }
}
