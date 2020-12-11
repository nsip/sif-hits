package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CensusReporting_EntityContact_Name")
public class CensusReportingEntityContactName extends BaseNameType {
	private static final long serialVersionUID = 7023996178780330742L;

	private CensusReportingEntityContact entityContact;

	@ManyToOne(optional = false)
	@JoinColumn(name = "CensusReporting_EntityContact_Id", referencedColumnName = "Id")
	public CensusReportingEntityContact getEntityContact() {
		return entityContact;
	}

	public void setEntityContact(CensusReportingEntityContact entityContact) {
		this.entityContact = entityContact;
	}

}
