package sif3.hits.domain.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class WellbeingCharacteristic extends HitsEntity {
	private static final long serialVersionUID = 5415009818190195157L;

	private String refId;
	private String localId;
	private String studentPersonalRefId;
	private String schoolInfoRefId;
	private String classification;
	private String startDate;
	private String endDate;
	private String reviewDate;
	private String notes;
	private String category;
	private String subcategory;
	private String localCharacteristicCode;
	private String characteristicSeverity;
	private String dailyManagement;
	private String emergencyManagement;
	private String emergencyResponsePlan;
	private String trigger;
	private String confidentialFlag;
	private String alert;

	private List<String> symptoms;
	private List<WellbeingCharacteristicDocument> documents;
	private List<WellbeingCharacteristicMedication> medication;

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

	@Column(name = "WellbeingCharacteristicClassification")
	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	@Column(name = "WellbeingCharacteristicStartDate")
	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	@Column(name = "WellbeingCharacteristicEndDate")
	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@Column(name = "WellbeingCharacteristicReviewDate")
	public String getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}

	@Column(name = "WellbeingCharacteristicNotes")
	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Column(name = "WellbeingCharacteristicCategory")
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Column(name = "WellbeingCharacteristicSubcategory")
	public String getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}

	@Column(name = "WellbeingCharacteristicLocalCharacteristicCode")
	public String getLocalCharacteristicCode() {
		return localCharacteristicCode;
	}

	public void setLocalCharacteristicCode(String localCharacteristicCode) {
		this.localCharacteristicCode = localCharacteristicCode;
	}

	@Column(name = "WellbeingCharacteristicCharacteristicSeverity")
	public String getCharacteristicSeverity() {
		return characteristicSeverity;
	}

	public void setCharacteristicSeverity(String characteristicSeverity) {
		this.characteristicSeverity = characteristicSeverity;
	}

	@Column(name = "WellbeingCharacteristicDailyManagement")
	public String getDailyManagement() {
		return dailyManagement;
	}

	public void setDailyManagement(String dailyManagement) {
		this.dailyManagement = dailyManagement;
	}

	@Column(name = "WellbeingCharacteristicEmergencyManagement")
	public String getEmergencyManagement() {
		return emergencyManagement;
	}

	public void setEmergencyManagement(String emergencyManagement) {
		this.emergencyManagement = emergencyManagement;
	}

	@Column(name = "WellbeingCharacteristicEmergencyResponsePlan")
	public String getEmergencyResponsePlan() {
		return emergencyResponsePlan;
	}

	public void setEmergencyResponsePlan(String emergencyResponsePlan) {
		this.emergencyResponsePlan = emergencyResponsePlan;
	}

	@Column(name = "WellbeingCharacteristicTrigger")
	public String getTrigger() {
		return trigger;
	}

	public void setTrigger(String trigger) {
		this.trigger = trigger;
	}

	@Column(name = "WellbeingCharacteristicConfidentialFlag")
	public String getConfidentialFlag() {
		return confidentialFlag;
	}

	public void setConfidentialFlag(String confidentialFlag) {
		this.confidentialFlag = confidentialFlag;
	}

	@Column(name = "WellbeingCharacteristicAlert")
	public String getAlert() {
		return alert;
	}

	public void setAlert(String alert) {
		this.alert = alert;
	}

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "wellbeingCharacteristic")
	public List<WellbeingCharacteristicDocument> getDocuments() {
		return documents;
	}

	public void setDocuments(List<WellbeingCharacteristicDocument> documents) {
		this.documents = documents;
	}

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "wellbeingCharacteristic")
	public List<WellbeingCharacteristicMedication> getMedication() {
		return medication;
	}

	public void setMedication(List<WellbeingCharacteristicMedication> medication) {
		this.medication = medication;
	}

	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "WellbeingCharacteristic_Symptom", joinColumns = @JoinColumn(name = "WellbeingCharacteristic_RefId"))
	@Column(name = "Symptom")
	public List<String> getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(List<String> symptoms) {
		this.symptoms = symptoms;
	}
}
