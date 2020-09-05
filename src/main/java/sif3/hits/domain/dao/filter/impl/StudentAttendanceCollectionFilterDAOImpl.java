package sif3.hits.domain.dao.filter.impl;

import org.springframework.stereotype.Repository;

import sif.dd.au30.model.StudentAttendanceCollectionType;
import sif3.hits.domain.dao.filter.StudentAttendanceCollectionFilterDAO;
import sif3.hits.domain.model.StudentAttendanceCollection;

@Repository
public class StudentAttendanceCollectionFilterDAOImpl
		extends BaseFilterableRepository<StudentAttendanceCollection, StudentAttendanceCollectionType>
		implements StudentAttendanceCollectionFilterDAO {

	public StudentAttendanceCollectionFilterDAOImpl() {
		super(StudentAttendanceCollection.class, StudentAttendanceCollectionType.class);
	}

}
