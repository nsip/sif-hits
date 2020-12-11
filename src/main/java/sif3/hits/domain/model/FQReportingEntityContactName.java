package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FQReporting_EntityContact_Name")
public class FQReportingEntityContactName extends BaseNameType {
	private static final long serialVersionUID = 954576208095522486L;

	private FQReportingEntityContact entityContact;

	@ManyToOne(optional = false)
	@JoinColumn(name = "FQReporting_EntityContact_Id", referencedColumnName = "Id")
	public FQReportingEntityContact getEntityContact() {
		return entityContact;
	}

	public void setEntityContact(FQReportingEntityContact entityContact) {
		this.entityContact = entityContact;
	}

}
