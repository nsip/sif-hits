package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "StudentAttendanceCR_EntityContact_Address_StatisticalArea")
public class StudentAttendanceCollectionReportingEntityContactAddressStatisticalArea
		extends BaseAddressStatisticalArea {
	private static final long serialVersionUID = 5495475119299160335L;

	private StudentAttendanceCollectionReportingEntityContactAddress address;

	@ManyToOne(optional = false)
	@JoinColumn(name = "StudentAttendanceCR_EntityContact_Address_Id", referencedColumnName = "Id")
	public StudentAttendanceCollectionReportingEntityContactAddress getAddress() {
		return address;
	}

	public void setAddress(StudentAttendanceCollectionReportingEntityContactAddress address) {
		this.address = address;
	}

}
