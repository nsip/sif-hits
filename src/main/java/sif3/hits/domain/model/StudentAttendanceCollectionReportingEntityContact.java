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
@Table(name = "StudentAttendanceCR_EntityContact" )
public class StudentAttendanceCollectionReportingEntityContact extends BaseEntityContact {
	private static final long serialVersionUID = 569893542121731132L;

	private StudentAttendanceCollectionReporting studentAttendanceCollectionReporting;
	private List<StudentAttendanceCollectionReportingEntityContactName> names;
	private List<StudentAttendanceCollectionReportingEntityContactAddress> addresses;

	@ManyToOne
	@JoinColumn(name = "StudentAttendanceCollectionReporting_Id")
	public StudentAttendanceCollectionReporting getStudentAttendanceCollectionReporting() {
		return studentAttendanceCollectionReporting;
	}

	public void setStudentAttendanceCollectionReporting(StudentAttendanceCollectionReporting studentAttendanceCollectionReporting) {
		this.studentAttendanceCollectionReporting = studentAttendanceCollectionReporting;
	}

	// Actually One to One but easier to manage with hibernate this way
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "entityContact")
	public List<StudentAttendanceCollectionReportingEntityContactName> getNames() {
		return names;
	}

	public void setNames(List<StudentAttendanceCollectionReportingEntityContactName> names) {
		this.names = names;
	}

	@Transient
	public StudentAttendanceCollectionReportingEntityContactName getName() {
		StudentAttendanceCollectionReportingEntityContactName result = null;
		if (names != null && !names.isEmpty()) {
			result = names.get(0);
		}
		return result;
	}

	@Transient
	public void setName(StudentAttendanceCollectionReportingEntityContactName name) {
		if (names == null) {
			names = new ArrayList<StudentAttendanceCollectionReportingEntityContactName>();
		}
		names.clear();
		if (name != null) {
			names.add(name);
			name.setEntityContact(this);
		}
	}

	// Actually One to One but easier to manage with hibernate this way
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "entityContact")
	public List<StudentAttendanceCollectionReportingEntityContactAddress> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<StudentAttendanceCollectionReportingEntityContactAddress> addresses) {
		this.addresses = addresses;
	}

	@Transient
	public StudentAttendanceCollectionReportingEntityContactAddress getAddress() {
		StudentAttendanceCollectionReportingEntityContactAddress result = null;
		if (addresses != null && !addresses.isEmpty()) {
			result = addresses.get(0);
		}
		return result;
	}

	@Transient
	public void setAddress(StudentAttendanceCollectionReportingEntityContactAddress address) {
		if (addresses == null) {
			addresses = new ArrayList<StudentAttendanceCollectionReportingEntityContactAddress>();
		}
		addresses.clear();
		if (address != null) {
			addresses.add(address);
			address.setEntityContact(this);
		}
	}
}