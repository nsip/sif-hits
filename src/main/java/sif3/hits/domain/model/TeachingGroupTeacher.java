package sif3.hits.domain.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "TeachingGroup_Teacher")
public class TeachingGroupTeacher {
  @EmbeddedId
  private TeachingGroupTeacherId teachingGroupTeacherId;
  private String teacherAssociation;

  public TeachingGroupTeacherId getTeachingGroupTeacherId() {
    return teachingGroupTeacherId;
  }

  public void setTeachingGroupTeacherId(TeachingGroupTeacherId teachingGroupTeacherId) {
    this.teachingGroupTeacherId = teachingGroupTeacherId;
  }

  public String getTeacherAssociation() {
    return teacherAssociation;
  }

  public void setTeacherAssociation(String teacherAssociation) {
    this.teacherAssociation = teacherAssociation;
  }

  @Transient
  public TeachingGroup getTeachingGroup() {
    TeachingGroup result = null;
    if (teachingGroupTeacherId != null) {
      result = teachingGroupTeacherId.getTeachingGroup();
    }
    return result;
  }

  @Transient
  public void setTeachingGroup(TeachingGroup teachingGroup) {
    if (teachingGroupTeacherId == null) {
      teachingGroupTeacherId = new TeachingGroupTeacherId();
    }
    teachingGroupTeacherId.setTeachingGroup(teachingGroup);
  }

  @Transient
  public StaffPersonal getStaffPersonal() {
    StaffPersonal result = null;
    if (teachingGroupTeacherId != null) {
      result = teachingGroupTeacherId.getStaffPersonal();
    }
    return result;
  }

  @Transient
  public void setStaffPersonal(StaffPersonal staffPersonal) {
    if (teachingGroupTeacherId == null) {
      teachingGroupTeacherId = new TeachingGroupTeacherId();
    }
    teachingGroupTeacherId.setStaffPersonal(staffPersonal);
  }

}