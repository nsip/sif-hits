package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif3.hits.domain.model.StudentAttendanceCollectionLocalCode;

@Component
public class StudentAttendanceCollectionLocalCodeConverter
		extends BaseLocalCodeConverter<StudentAttendanceCollectionLocalCode> {

	public StudentAttendanceCollectionLocalCodeConverter() {
		super(StudentAttendanceCollectionLocalCode.class);
	}

}
