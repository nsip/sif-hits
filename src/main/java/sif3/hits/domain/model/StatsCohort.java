package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "StudentAttendanceCR_YearLevel_StatsCohort")
public class StatsCohort extends HitsEntity {
	private static final long serialVersionUID = -2007492881442632322L;

	private Long id;
	private StatsCohortYearLevel statsCohortYearLevel;
	private String statsCohortId;
	private String statsIndigenousStudentType;
	private String cohortGender;
	private String daysInReferencePeriod;
	private String possibleSchoolDays;
	private String attendanceDays;
	private String attendanceLess90Percent;
	private String attendanceGTE90Percent;
	private String possibleSchoolDaysGT90PercentAttendance;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "StatsCohortYearLevel_Id")
	public StatsCohortYearLevel getStatsCohortYearLevel() {
		return statsCohortYearLevel;
	}

	public void setStatsCohortYearLevel(StatsCohortYearLevel statsCohortYearLevel) {
		this.statsCohortYearLevel = statsCohortYearLevel;
	}

	public String getStatsCohortId() {
		return statsCohortId;
	}

	public void setStatsCohortId(String statsCohortId) {
		this.statsCohortId = statsCohortId;
	}

	public String getStatsIndigenousStudentType() {
		return statsIndigenousStudentType;
	}

	public void setStatsIndigenousStudentType(String statsIndigenousStudentType) {
		this.statsIndigenousStudentType = statsIndigenousStudentType;
	}

	public String getCohortGender() {
		return cohortGender;
	}

	public void setCohortGender(String cohortGender) {
		this.cohortGender = cohortGender;
	}

	public String getDaysInReferencePeriod() {
		return daysInReferencePeriod;
	}

	public void setDaysInReferencePeriod(String daysInReferencePeriod) {
		this.daysInReferencePeriod = daysInReferencePeriod;
	}

	public String getPossibleSchoolDays() {
		return possibleSchoolDays;
	}

	public void setPossibleSchoolDays(String possibleSchoolDays) {
		this.possibleSchoolDays = possibleSchoolDays;
	}

	public String getAttendanceDays() {
		return attendanceDays;
	}

	public void setAttendanceDays(String attendanceDays) {
		this.attendanceDays = attendanceDays;
	}

	public String getAttendanceLess90Percent() {
		return attendanceLess90Percent;
	}

	public void setAttendanceLess90Percent(String attendanceLess90Percent) {
		this.attendanceLess90Percent = attendanceLess90Percent;
	}

	public String getAttendanceGTE90Percent() {
		return attendanceGTE90Percent;
	}

	public void setAttendanceGTE90Percent(String attendanceGTE90Percent) {
		this.attendanceGTE90Percent = attendanceGTE90Percent;
	}

	public String getPossibleSchoolDaysGT90PercentAttendance() {
		return possibleSchoolDaysGT90PercentAttendance;
	}

	public void setPossibleSchoolDaysGT90PercentAttendance(String possibleSchoolDaysGT90PercentAttendance) {
		this.possibleSchoolDaysGT90PercentAttendance = possibleSchoolDaysGT90PercentAttendance;
	}

}
