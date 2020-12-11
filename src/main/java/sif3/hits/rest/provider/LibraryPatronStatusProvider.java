package sif3.hits.rest.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.LibraryPatronStatusCollectionType;
import sif.dd.au30.model.LibraryPatronStatusType;
import sif3.hits.domain.model.LibraryPatronStatus;
import sif3.hits.service.LibraryPatronStatusService;

public class LibraryPatronStatusProvider extends
		HitsBaseProvider<LibraryPatronStatusType, LibraryPatronStatusCollectionType, LibraryPatronStatus, LibraryPatronStatusService> {

	protected static final Logger L = LoggerFactory.getLogger(LibraryPatronStatusProvider.class);

	/**
	 * @param providerID        The ID of the provider.
	 * @param serviceProperties values of provider property file.
	 */
	public LibraryPatronStatusProvider() {
		super(LibraryPatronStatusType.class, "LibraryPatronStatus", LibraryPatronStatusCollectionType.class,
				"LibraryPatronStatuss", LibraryPatronStatusService.class);
	}

}
