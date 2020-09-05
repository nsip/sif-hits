package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif3.hits.domain.model.StudentAttendanceCollectionReportingEntityContactAddressStatisticalArea;

@Component
public class StudentAttendanceCollectionReportingEntityContactAddressStatisticalAreaConverter extends
		BaseAddressStatisticalAreaConverter<StudentAttendanceCollectionReportingEntityContactAddressStatisticalArea> {

	public StudentAttendanceCollectionReportingEntityContactAddressStatisticalAreaConverter() {
		super(StudentAttendanceCollectionReportingEntityContactAddressStatisticalArea.class);
	}

}
