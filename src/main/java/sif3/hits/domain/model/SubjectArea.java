package sif3.hits.domain.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class SubjectArea {
	private Long id;
	private SchoolCourseInfo schoolCourseInfo;
	private String code;
	private List<SubjectAreaOtherCode> otherCodes;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "SchoolCourseInfo_RefId")
	public SchoolCourseInfo getSchoolCourseInfo() {
		return schoolCourseInfo;
	}

	public void setSchoolCourseInfo(SchoolCourseInfo schoolCourseInfo) {
		this.schoolCourseInfo = schoolCourseInfo;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "subjectArea")
	public List<SubjectAreaOtherCode> getOtherCodes() {
		return otherCodes;
	}

	public void setOtherCodes(List<SubjectAreaOtherCode> otherCodes) {
		this.otherCodes = otherCodes;
	}

}
