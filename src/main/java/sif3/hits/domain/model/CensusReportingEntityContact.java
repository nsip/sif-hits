package sif3.hits.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "CensusReporting_EntityContact")
public class CensusReportingEntityContact extends BaseEntityContact {
	private static final long serialVersionUID = 1768420621855319251L;

	private CensusReporting censusReporting;
	private List<CensusReportingEntityContactName> censusReportingEntityContactNameList;
	private List<CensusReportingEntityContactAddress> censusReportingEntityContactAddressList;

	@ManyToOne
	@JoinColumn(name = "CensusReporting_Id")
	public CensusReporting getCensusReporting() {
		return censusReporting;
	}

	public void setCensusReporting(CensusReporting censusReporting) {
		this.censusReporting = censusReporting;
	}

	// Actually OneToOne but easier to manager in hibernate this way.
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "entityContact")
	public List<CensusReportingEntityContactName> getCensusReportingEntityContactNameList() {
		return censusReportingEntityContactNameList;
	}

	public void setCensusReportingEntityContactNameList(
			List<CensusReportingEntityContactName> censusReportingEntityContactNameList) {
		this.censusReportingEntityContactNameList = censusReportingEntityContactNameList;
	}

	@Transient
	public CensusReportingEntityContactName getName() {
		CensusReportingEntityContactName result = null;
		if (censusReportingEntityContactNameList != null && !censusReportingEntityContactNameList.isEmpty()) {
			result = censusReportingEntityContactNameList.get(0);
		}
		return result;
	}

	@Transient
	public void setName(CensusReportingEntityContactName name) {
		if (censusReportingEntityContactNameList == null) {
			censusReportingEntityContactNameList = new ArrayList<>();
		}
		censusReportingEntityContactNameList.clear();
		if (name != null) {
			censusReportingEntityContactNameList.add(name);
			name.setEntityContact(this);
		}
	}

	// Actually OneToOne but easier to manager in hibernate this way.
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "entityContact")
	public List<CensusReportingEntityContactAddress> getCensusReportingEntityContactAddressList() {
		return censusReportingEntityContactAddressList;
	}

	public void setCensusReportingEntityContactAddressList(
			List<CensusReportingEntityContactAddress> censusReportingEntityContactAddressList) {
		this.censusReportingEntityContactAddressList = censusReportingEntityContactAddressList;
	}

	@Transient
	public CensusReportingEntityContactAddress getAddress() {
		CensusReportingEntityContactAddress result = null;
		if (censusReportingEntityContactAddressList != null && !censusReportingEntityContactAddressList.isEmpty()) {
			result = censusReportingEntityContactAddressList.get(0);
		}
		return result;
	}

	@Transient
	public void setAddress(CensusReportingEntityContactAddress address) {
		if (censusReportingEntityContactAddressList == null) {
			censusReportingEntityContactAddressList = new ArrayList<>();
		}
		censusReportingEntityContactAddressList.clear();
		if (address != null) {
			censusReportingEntityContactAddressList.add(address);
			address.setEntityContact(this);
		}
	}

}
