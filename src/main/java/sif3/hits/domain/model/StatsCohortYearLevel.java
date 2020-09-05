package sif3.hits.domain.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "StudentAttendanceCR_StatsCohortYearLevel")
public class StatsCohortYearLevel extends HitsEntity {
	private static final long serialVersionUID = -1284158391852943920L;

	private Long id;
	private StudentAttendanceCollectionReporting studentAttendanceCollectionReporting;
	private String yearLevel;
	private List<StatsCohort> statsCohortList;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "StudentAttendanceCR_Id")
	public StudentAttendanceCollectionReporting getStudentAttendanceCollectionReporting() {
		return studentAttendanceCollectionReporting;
	}

	public void setStudentAttendanceCollectionReporting(
			StudentAttendanceCollectionReporting studentAttendanceCollectionReporting) {
		this.studentAttendanceCollectionReporting = studentAttendanceCollectionReporting;
	}

	public String getYearLevel() {
		return yearLevel;
	}

	public void setYearLevel(String yearLevel) {
		this.yearLevel = yearLevel;
	}

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "statsCohortYearLevel")
	public List<StatsCohort> getStatsCohortList() {
		return statsCohortList;
	}

	public void setStatsCohortList(List<StatsCohort> statsCohortList) {
		this.statsCohortList = statsCohortList;
	}

}
