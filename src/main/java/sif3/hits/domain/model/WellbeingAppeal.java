package sif3.hits.domain.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class WellbeingAppeal extends HitsEntity {
	private static final long serialVersionUID = -2218730268570380002L;

	private String refId;
	private String localId;
	private String studentPersonalRefId;
	private String schoolInfoRefId;
	private String wellbeingResponseRefId;
	private String localAppealId;
	private String appealStatusCode;
	private String appealDate;
	private String appealNotes;
	private String appealOutcome;

	private List<WellbeingAppealDocument> documents;

	@Id
	public String getRefId() {
		return refId;
	}

	public void setRefId(String refId) {
		this.refId = refId;
	}

	public String getLocalId() {
		return localId;
	}

	public void setLocalId(String localId) {
		this.localId = localId;
	}

	@Column(name = "StudentPersonal_RefId")
	public String getStudentPersonalRefId() {
		return studentPersonalRefId;
	}

	public void setStudentPersonalRefId(String studentPersonalRefId) {
		this.studentPersonalRefId = studentPersonalRefId;
	}

	@Column(name = "SchoolInfo_RefId")
	public String getSchoolInfoRefId() {
		return schoolInfoRefId;
	}

	public void setSchoolInfoRefId(String schoolInfoRefId) {
		this.schoolInfoRefId = schoolInfoRefId;
	}

	@Column(name = "WellbeingResponse_RefId")
	public String getWellbeingResponseRefId() {
		return wellbeingResponseRefId;
	}

	public void setWellbeingResponseRefId(String wellbeingResponseRefId) {
		this.wellbeingResponseRefId = wellbeingResponseRefId;
	}

	public String getLocalAppealId() {
		return localAppealId;
	}

	public void setLocalAppealId(String localAppealId) {
		this.localAppealId = localAppealId;
	}

	public String getAppealStatusCode() {
		return appealStatusCode;
	}

	public void setAppealStatusCode(String appealStatusCode) {
		this.appealStatusCode = appealStatusCode;
	}

	@Column(name = "date")
	public String getAppealDate() {
		return appealDate;
	}

	public void setAppealDate(String appealDate) {
		this.appealDate = appealDate;
	}

	public String getAppealNotes() {
		return appealNotes;
	}

	public void setAppealNotes(String appealNotes) {
		this.appealNotes = appealNotes;
	}

	public String getAppealOutcome() {
		return appealOutcome;
	}

	public void setAppealOutcome(String appealOutcome) {
		this.appealOutcome = appealOutcome;
	}

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "wellbeingAppeal")
	public List<WellbeingAppealDocument> getDocuments() {
		return documents;
	}

	public void setDocuments(List<WellbeingAppealDocument> documents) {
		this.documents = documents;
	}

}
