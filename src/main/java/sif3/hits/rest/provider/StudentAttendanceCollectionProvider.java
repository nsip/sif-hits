package sif3.hits.rest.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.StudentAttendanceCollectionCollectionType;
import sif.dd.au30.model.StudentAttendanceCollectionType;
import sif3.hits.domain.model.StudentAttendanceCollection;
import sif3.hits.service.StudentAttendanceCollectionService;

public class StudentAttendanceCollectionProvider extends
		HitsBaseProvider<StudentAttendanceCollectionType, StudentAttendanceCollectionCollectionType, StudentAttendanceCollection, StudentAttendanceCollectionService> {

	protected static final Logger L = LoggerFactory.getLogger(StudentAttendanceCollectionProvider.class);

	/**
	 * @param providerID        The ID of the provider.
	 * @param serviceProperties values of provider property file.
	 */
	public StudentAttendanceCollectionProvider() {
		super(StudentAttendanceCollectionType.class, "StudentAttendanceCollection",
				StudentAttendanceCollectionCollectionType.class, "StudentAttendanceCollections",
				StudentAttendanceCollectionService.class);
	}
}
