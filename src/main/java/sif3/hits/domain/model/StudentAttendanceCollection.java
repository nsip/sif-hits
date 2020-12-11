package sif3.hits.domain.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class StudentAttendanceCollection extends HitsEntity {
	private static final long serialVersionUID = -4234234991938219L;

	private String refId;
	private String studentAttendanceCollectionYear;
	private String roundCode;
	private String reportingAuthorityCommonwealthId;
	private String softwareProduct;
	private String softwareVersion;

	private List<StudentAttendanceCollectionLocalCode> localCodeList;
	private List<StudentAttendanceCollectionReporting> studentAttendanceCollectionReportingList;

	@Id
	public String getRefId() {
		return refId;
	}

	public void setRefId(String refId) {
		this.refId = refId;
	}

	public String getStudentAttendanceCollectionYear() {
		return studentAttendanceCollectionYear;
	}

	public void setStudentAttendanceCollectionYear(String studentAttendanceCollectionYear) {
		this.studentAttendanceCollectionYear = studentAttendanceCollectionYear;
	}

	public String getRoundCode() {
		return roundCode;
	}

	public void setRoundCode(String roundCode) {
		this.roundCode = roundCode;
	}

	public String getReportingAuthorityCommonwealthId() {
		return reportingAuthorityCommonwealthId;
	}

	public void setReportingAuthorityCommonwealthId(String reportingAuthorityCommonwealthId) {
		this.reportingAuthorityCommonwealthId = reportingAuthorityCommonwealthId;
	}

	@Column(name = "SoftwareVendorInfo_SoftwareProduct")
	public String getSoftwareProduct() {
		return softwareProduct;
	}

	public void setSoftwareProduct(String softwareProduct) {
		this.softwareProduct = softwareProduct;
	}

	@Column(name = "SoftwareVendorInfo_SoftwareVersion")
	public String getSoftwareVersion() {
		return softwareVersion;
	}

	public void setSoftwareVersion(String softwareVersion) {
		this.softwareVersion = softwareVersion;
	}

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "studentAttendanceCollection")
	public List<StudentAttendanceCollectionLocalCode> getLocalCodeList() {
		return localCodeList;
	}

	public void setLocalCodeList(List<StudentAttendanceCollectionLocalCode> localCodeList) {
		this.localCodeList = localCodeList;
	}

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "studentAttendanceCollection")
	public List<StudentAttendanceCollectionReporting> getStudentAttendanceCollectionReportingList() {
		return studentAttendanceCollectionReportingList;
	}

	public void setStudentAttendanceCollectionReportingList(
			List<StudentAttendanceCollectionReporting> studentAttendanceCollectionReportingList) {
		this.studentAttendanceCollectionReportingList = studentAttendanceCollectionReportingList;
	}
}
