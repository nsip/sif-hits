package sif3.hits.rest.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.CollectionRoundCollectionType;
import sif.dd.au30.model.CollectionRoundType;
import sif3.hits.domain.model.CollectionRound;
import sif3.hits.service.CollectionRoundService;

public class CollectionRoundProvider extends
		HitsBaseProvider<CollectionRoundType, CollectionRoundCollectionType, CollectionRound, CollectionRoundService> {

	protected static final Logger L = LoggerFactory.getLogger(CollectionRoundProvider.class);

	/**
	 * @param providerID        The ID of the provider.
	 * @param serviceProperties values of provider property file.
	 */
	public CollectionRoundProvider() {
		super(CollectionRoundType.class, "CollectionRound", CollectionRoundCollectionType.class,
				"CollectionRounds", CollectionRoundService.class);
	}
}
