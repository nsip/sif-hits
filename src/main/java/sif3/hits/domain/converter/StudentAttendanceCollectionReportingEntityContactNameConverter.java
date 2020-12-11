package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif3.hits.domain.model.StudentAttendanceCollectionReportingEntityContactName;

@Component
public class StudentAttendanceCollectionReportingEntityContactNameConverter
		extends BaseNameTypeConverter<StudentAttendanceCollectionReportingEntityContactName> {

	public StudentAttendanceCollectionReportingEntityContactNameConverter() {
		super(StudentAttendanceCollectionReportingEntityContactName.class);
	}

}
