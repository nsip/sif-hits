package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "StudentAttendanceCR_EntityContact_Name")
public class StudentAttendanceCollectionReportingEntityContactName extends BaseNameType {
	private static final long serialVersionUID = 954576208095522486L;

	private StudentAttendanceCollectionReportingEntityContact entityContact;

	@ManyToOne(optional = false)
	@JoinColumn(name = "StudentAttendanceCR_EntityContact_Id", referencedColumnName = "Id")
	public StudentAttendanceCollectionReportingEntityContact getEntityContact() {
		return entityContact;
	}

	public void setEntityContact(StudentAttendanceCollectionReportingEntityContact entityContact) {
		this.entityContact = entityContact;
	}

}
