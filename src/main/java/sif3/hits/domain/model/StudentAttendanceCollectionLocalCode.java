package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "StudentAttendanceCollection_LocalCode")
public class StudentAttendanceCollectionLocalCode extends BaseLocalCode {
	private static final long serialVersionUID = -5179655028790957468L;

	private StudentAttendanceCollection studentAttendanceCollection;

	@ManyToOne
	@JoinColumn(name = "StudentAttendanceCollection_RefId")
	public StudentAttendanceCollection getStudentAttendanceCollection() {
		return studentAttendanceCollection;
	}

	public void setStudentAttendanceCollection(StudentAttendanceCollection studentAttendanceCollection) {
		this.studentAttendanceCollection = studentAttendanceCollection;
	}

}
