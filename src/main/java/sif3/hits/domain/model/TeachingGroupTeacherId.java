package sif3.hits.domain.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class TeachingGroupTeacherId implements Serializable {
  private static final long serialVersionUID = -1744780977301679895L;

  @ManyToOne(optional = false)
  @JoinColumn(name = "TeachingGroup_RefId", referencedColumnName = "RefId")
  private TeachingGroup teachingGroup;

  @ManyToOne(optional = false)
  @JoinColumn(name = "StaffPersonal_RefId", referencedColumnName = "RefId")
  private StaffPersonal staffPersonal;

  public TeachingGroup getTeachingGroup() {
    return teachingGroup;
  }

  public void setTeachingGroup(TeachingGroup teachingGroup) {
    this.teachingGroup = teachingGroup;
  }

  public StaffPersonal getStaffPersonal() {
    return staffPersonal;
  }

  public void setStaffPersonal(StaffPersonal staffPersonal) {
    this.staffPersonal = staffPersonal;
  }
}
