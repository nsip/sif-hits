package sif3.hits.domain.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "TeachingGroup_Teacher")
public class TeachingGroupTeacher {

	private TeachingGroupTeacherId teachingGroupTeacherId;
	private String teacherAssociation;

	@EmbeddedId
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
	public String getStaffPersonalRefId() {
		String result = null;
		if (teachingGroupTeacherId != null) {
			result = teachingGroupTeacherId.getStaffPersonalRefId();
		}
		return result;
	}

	@Transient
	public void setStaffPersonalRefId(String staffPersonalRefId) {
		if (teachingGroupTeacherId == null) {
			teachingGroupTeacherId = new TeachingGroupTeacherId();
		}
		teachingGroupTeacherId.setStaffPersonalRefId(staffPersonalRefId);
	}

}
