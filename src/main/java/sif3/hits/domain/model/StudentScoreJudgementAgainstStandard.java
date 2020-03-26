package sif3.hits.domain.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class StudentScoreJudgementAgainstStandard extends HitsEntity {
	private static final long serialVersionUID = 1454357376520259549L;

	private String refId;
	private String schoolYear;
	private String termInfoRefId;
	private String localTermCode;
	private String studentPersonalRefId;
	private String studentStateProvinceId;
	private String studentLocalId;
	private String yearLevel;
	private String teachingGroupRefId;
	private String classLocalId;
	private String staffPersonalRefId;
	private String staffLocalId;
	private List<LearningStandard> learningStandardList;
	private String curriculumCode;
	private String curriculumNodeCode;
	private String score;
	private String specialCircumstanceLocalCode;
	private String managedPathwayLocalCode;
	private String schoolInfoRefId;
	private String schoolLocalId;
	private String schoolCommonwealthId;

	@Id
	public String getRefId() {
		return refId;
	}

	public void setRefId(String refId) {
		this.refId = refId;
	}

	public String getSchoolYear() {
		return schoolYear;
	}

	public void setSchoolYear(String schoolYear) {
		this.schoolYear = schoolYear;
	}

	@Column(name = "TermInfo_RefId")
	public String getTermInfoRefId() {
		return termInfoRefId;
	}

	public void setTermInfoRefId(String termInfoRefId) {
		this.termInfoRefId = termInfoRefId;
	}

	public String getLocalTermCode() {
		return localTermCode;
	}

	public void setLocalTermCode(String localTermCode) {
		this.localTermCode = localTermCode;
	}

	@Column(name = "StudentPersonal_RefId")
	public String getStudentPersonalRefId() {
		return studentPersonalRefId;
	}

	public void setStudentPersonalRefId(String studentPersonalRefId) {
		this.studentPersonalRefId = studentPersonalRefId;
	}

	public String getStudentStateProvinceId() {
		return studentStateProvinceId;
	}

	public void setStudentStateProvinceId(String studentStateProvinceId) {
		this.studentStateProvinceId = studentStateProvinceId;
	}

	public String getStudentLocalId() {
		return studentLocalId;
	}

	public void setStudentLocalId(String studentLocalId) {
		this.studentLocalId = studentLocalId;
	}

	public String getYearLevel() {
		return yearLevel;
	}

	public void setYearLevel(String yearLevel) {
		this.yearLevel = yearLevel;
	}

	@Column(name = "TeachingGroup_RefId")
	public String getTeachingGroupRefId() {
		return teachingGroupRefId;
	}

	public void setTeachingGroupRefId(String teachingGroupRefId) {
		this.teachingGroupRefId = teachingGroupRefId;
	}

	public String getClassLocalId() {
		return classLocalId;
	}

	public void setClassLocalId(String classLocalId) {
		this.classLocalId = classLocalId;
	}

	@Column(name = "StaffPersonal_RefId")
	public String getStaffPersonalRefId() {
		return staffPersonalRefId;
	}

	public void setStaffPersonalRefId(String staffPersonalRefId) {
		this.staffPersonalRefId = staffPersonalRefId;
	}

	public String getStaffLocalId() {
		return staffLocalId;
	}

	public void setStaffLocalId(String staffLocalId) {
		this.staffLocalId = staffLocalId;
	}

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "studentScoreJudgmentAgainstStandard")
	public List<LearningStandard> getLearningStandardList() {
		return learningStandardList;
	}

	public void setLearningStandardList(List<LearningStandard> learningStandardList) {
		this.learningStandardList = learningStandardList;
	}

	public String getCurriculumCode() {
		return curriculumCode;
	}

	public void setCurriculumCode(String curriculumCode) {
		this.curriculumCode = curriculumCode;
	}

	public String getCurriculumNodeCode() {
		return curriculumNodeCode;
	}

	public void setCurriculumNodeCode(String curriculumNodeCode) {
		this.curriculumNodeCode = curriculumNodeCode;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getSpecialCircumstanceLocalCode() {
		return specialCircumstanceLocalCode;
	}

	public void setSpecialCircumstanceLocalCode(String specialCircumstanceLocalCode) {
		this.specialCircumstanceLocalCode = specialCircumstanceLocalCode;
	}

	public String getManagedPathwayLocalCode() {
		return managedPathwayLocalCode;
	}

	public void setManagedPathwayLocalCode(String managedPathwayLocalCode) {
		this.managedPathwayLocalCode = managedPathwayLocalCode;
	}

	@Column(name = "SchoolInfo_RefId")
	public String getSchoolInfoRefId() {
		return schoolInfoRefId;
	}

	public void setSchoolInfoRefId(String schoolInfoRefId) {
		this.schoolInfoRefId = schoolInfoRefId;
	}

	public String getSchoolLocalId() {
		return schoolLocalId;
	}

	public void setSchoolLocalId(String schoolLocalId) {
		this.schoolLocalId = schoolLocalId;
	}

	public String getSchoolCommonwealthId() {
		return schoolCommonwealthId;
	}

	public void setSchoolCommonwealthId(String schoolCommonwealthId) {
		this.schoolCommonwealthId = schoolCommonwealthId;
	}

}
