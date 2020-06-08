package sif3.hits.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TermInfo extends HitsEntity {
	private static final long serialVersionUID = -428078099998185241L;

	private String refId;
	private String schoolInfoRefId;
	private String schoolYear;
	private String startDate;
	private String endDate;
	private String description;
	private String relativeDuration;
	private String termCode;
	private String track;
	private String termSpan;
	private String markingTerm;
	private String schedulingTerm;
	private String attendanceTerm;

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

	public String getSchoolYear() {
		return schoolYear;
	}

	public void setSchoolYear(String schoolYear) {
		this.schoolYear = schoolYear;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRelativeDuration() {
		return relativeDuration;
	}

	public void setRelativeDuration(String relativeDuration) {
		this.relativeDuration = relativeDuration;
	}

	public String getTermCode() {
		return termCode;
	}

	public void setTermCode(String termCode) {
		this.termCode = termCode;
	}

	public String getTrack() {
		return track;
	}

	public void setTrack(String track) {
		this.track = track;
	}

	public String getTermSpan() {
		return termSpan;
	}

	public void setTermSpan(String termSpan) {
		this.termSpan = termSpan;
	}

	public String getMarkingTerm() {
		return markingTerm;
	}

	public void setMarkingTerm(String markingTerm) {
		this.markingTerm = markingTerm;
	}

	public String getSchedulingTerm() {
		return schedulingTerm;
	}

	public void setSchedulingTerm(String schedulingTerm) {
		this.schedulingTerm = schedulingTerm;
	}

	public String getAttendanceTerm() {
		return attendanceTerm;
	}

	public void setAttendanceTerm(String attendanceTerm) {
		this.attendanceTerm = attendanceTerm;
	}

}
