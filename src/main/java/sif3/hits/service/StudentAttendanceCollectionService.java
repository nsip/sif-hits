package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.StudentAttendanceCollectionCollectionType;
import sif.dd.au30.model.StudentAttendanceCollectionType;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.StudentAttendanceCollectionConverter;
import sif3.hits.domain.dao.StudentAttendanceCollectionDAO;
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.dao.filter.StudentAttendanceCollectionFilterDAO;
import sif3.hits.domain.model.StudentAttendanceCollection;

@Service
public class StudentAttendanceCollectionService extends
		BaseService<StudentAttendanceCollectionType, StudentAttendanceCollectionCollectionType, StudentAttendanceCollection> {

	@Autowired
	private StudentAttendanceCollectionConverter studentAttendanceCollectionConverter;

	@Autowired
	private StudentAttendanceCollectionDAO studentAttendanceCollectionDAO;

	@Autowired
	private StudentAttendanceCollectionFilterDAO studentAttendanceCollectionFilterDAO;

	@Override
	protected StudentAttendanceCollectionCollectionType getCollection(List<StudentAttendanceCollectionType> items) {
		StudentAttendanceCollectionCollectionType result = new StudentAttendanceCollectionCollectionType();
		if (items != null) {
			result.getStudentAttendanceCollection().addAll(items);
		}
		return result;
	}

	@Override
	protected HitsConverter<StudentAttendanceCollectionType, StudentAttendanceCollection> getConverter() {
		return studentAttendanceCollectionConverter;
	}

	@Override
	protected JpaRepository<StudentAttendanceCollection, String> getDAO() {
		return studentAttendanceCollectionDAO;
	}

	@Override
	protected FilterableRepository<StudentAttendanceCollection, StudentAttendanceCollectionType> getFilterableDAO() {
		return studentAttendanceCollectionFilterDAO;
	}
}
