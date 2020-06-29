package sif3.hits.domain.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class SchoolCourseInfo extends HitsEntity {
	private static final long serialVersionUID = 7547665692985438945L;

	private String refId;
	private String schoolInfoRefId;
	private String schoolLocalId;
	private String schoolYear;
	private String termInfoRefId;
	private String courseCode;
	private String stateCourseCode;
	private String districtCourseCode;
	private String courseTitle;
	private String description;
	private String instructionalLevel;
	private String courseCredits;
	private String coreAcademicCourse;
	private String graduationRequirement;
	private String department;
	private String courseContent;
	private List<SubjectArea> subjectAreas;

	@Id
	public String getRefId() {
		return refId;
	}

	public void setRefId(String refId) {
		this.refId = refId;
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

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getStateCourseCode() {
		return stateCourseCode;
	}

	public void setStateCourseCode(String stateCourseCode) {
		this.stateCourseCode = stateCourseCode;
	}

	public String getDistrictCourseCode() {
		return districtCourseCode;
	}

	public void setDistrictCourseCode(String districtCourseCode) {
		this.districtCourseCode = districtCourseCode;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInstructionalLevel() {
		return instructionalLevel;
	}

	public void setInstructionalLevel(String instructionalLevel) {
		this.instructionalLevel = instructionalLevel;
	}

	public String getCourseCredits() {
		return courseCredits;
	}

	public void setCourseCredits(String courseCredits) {
		this.courseCredits = courseCredits;
	}

	public String getCoreAcademicCourse() {
		return coreAcademicCourse;
	}

	public void setCoreAcademicCourse(String coreAcademicCourse) {
		this.coreAcademicCourse = coreAcademicCourse;
	}

	public String getGraduationRequirement() {
		return graduationRequirement;
	}

	public void setGraduationRequirement(String graduationRequirement) {
		this.graduationRequirement = graduationRequirement;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getCourseContent() {
		return courseContent;
	}

	public void setCourseContent(String courseContent) {
		this.courseContent = courseContent;
	}

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "schoolCourseInfo")
	public List<SubjectArea> getSubjectAreas() {
		return subjectAreas;
	}

	public void setSubjectAreas(List<SubjectArea> subjectAreas) {
		this.subjectAreas = subjectAreas;
	}

}
