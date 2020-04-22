package sif3.hits.domain.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class TeachingGroup extends HitsEntity {
	private static final long serialVersionUID = -9118445084485647016L;

	private String refId;
	private String shortName;
	private String longName;
	private String localId;
	private String schoolYear;
	private SchoolInfo schoolInfo;
	private List<String> studentPersonalRefIds;
	private List<TeachingGroupTeacher> teachingGroupTeachers;
	private Set<TimeTableCell> timeTablePeriods;
	private TimeTableSubject timeTableSubject;
	private String keyLearningArea;

	@Id
	public String getRefId() {
		return refId;
	}

	public void setRefId(String refId) {
		this.refId = refId;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getLongName() {
		return longName;
	}

	public void setLongName(String longName) {
		this.longName = longName;
	}

	public String getLocalId() {
		return localId;
	}

	public void setLocalId(String localId) {
		this.localId = localId;
	}

	public String getSchoolYear() {
		return schoolYear;
	}

	public void setSchoolYear(String schoolYear) {
		this.schoolYear = schoolYear;
	}

	@ManyToOne
	@JoinColumn(name = "SchoolInfo_RefId")
	public SchoolInfo getSchoolInfo() {
		return schoolInfo;
	}

	public void setSchoolInfo(SchoolInfo schoolInfo) {
		this.schoolInfo = schoolInfo;
	}

	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "TeachingGroup_Student", joinColumns = @JoinColumn(name = "TeachingGroup_RefId"))
	@Column(name = "StudentPersonal_RefId")
	public List<String> getStudentPersonalRefIds() {
		return studentPersonalRefIds;
	}

	public void setStudentPersonalRefIds(List<String> studentPersonalRefIds) {
		this.studentPersonalRefIds = studentPersonalRefIds;
	}

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "teachingGroupTeacherId.teachingGroup")
	public List<TeachingGroupTeacher> getTeachingGroupTeachers() {
		return teachingGroupTeachers;
	}

	public void setTeachingGroupTeachers(List<TeachingGroupTeacher> teachingGroupTeachers) {
		this.teachingGroupTeachers = teachingGroupTeachers;
	}

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH }, mappedBy = "teachingGroup")
	public Set<TimeTableCell> getTimeTablePeriods() {
		return timeTablePeriods;
	}

	public void setTimeTablePeriods(Set<TimeTableCell> timeTablePeriods) {
		this.timeTablePeriods = timeTablePeriods;
	}

	@ManyToOne
	@JoinColumn(name = "TimeTableSubject_RefId", referencedColumnName = "RefId")
	public TimeTableSubject getTimeTableSubject() {
		return timeTableSubject;
	}

	public void setTimeTableSubject(TimeTableSubject timeTableSubject) {
		this.timeTableSubject = timeTableSubject;
	}

	@Column(name = "KLA")
	public String getKeyLearningArea() {
		return keyLearningArea;
	}

	public void setKeyLearningArea(String keyLearningArea) {
		this.keyLearningArea = keyLearningArea;
	}
}
