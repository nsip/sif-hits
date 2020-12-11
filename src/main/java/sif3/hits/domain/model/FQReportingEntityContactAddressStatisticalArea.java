package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FQReporting_EntityContact_Address_StatisticalArea")
public class FQReportingEntityContactAddressStatisticalArea extends BaseAddressStatisticalArea {
	private static final long serialVersionUID = 5495475119299160335L;

	private FQReportingEntityContactAddress address;

	@ManyToOne(optional = false)
	@JoinColumn(name = "FQReporting_EntityContact_Address_Id", referencedColumnName = "Id")
	public FQReportingEntityContactAddress getAddress() {
		return address;
	}

	public void setAddress(FQReportingEntityContactAddress address) {
		this.address = address;
	}

}
