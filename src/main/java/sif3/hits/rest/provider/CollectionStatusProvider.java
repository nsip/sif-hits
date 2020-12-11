package sif3.hits.rest.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.CollectionStatusCollectionType;
import sif.dd.au30.model.CollectionStatusType;
import sif3.hits.domain.model.CollectionStatus;
import sif3.hits.service.CollectionStatusService;

public class CollectionStatusProvider extends
		HitsBaseProvider<CollectionStatusType, CollectionStatusCollectionType, CollectionStatus, CollectionStatusService> {

	protected static final Logger L = LoggerFactory.getLogger(CollectionStatusProvider.class);

	/**
	 * @param providerID        The ID of the provider.
	 * @param serviceProperties values of provider property file.
	 */
	public CollectionStatusProvider() {
		super(CollectionStatusType.class, "CollectionStatus", CollectionStatusCollectionType.class,
				"CollectionStatuss", CollectionStatusService.class);
	}
}
