package sif3.hits.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class TeachingGroupTeacherId implements Serializable {
	private static final long serialVersionUID = -1744780977301679895L;

	private TeachingGroup teachingGroup;
	private String staffPersonalRefId;

	@ManyToOne(optional = false)
	@JoinColumn(name = "TeachingGroup_RefId", referencedColumnName = "RefId")
	public TeachingGroup getTeachingGroup() {
		return teachingGroup;
	}

	public void setTeachingGroup(TeachingGroup teachingGroup) {
		this.teachingGroup = teachingGroup;
	}

	@Column(name = "StaffPersonal_RefId")
	public String getStaffPersonalRefId() {
		return staffPersonalRefId;
	}

	public void setStaffPersonalRefId(String staffPersonalRefId) {
		this.staffPersonalRefId = staffPersonalRefId;
	}
}
