package sif3.hits.rest.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.CensusCollectionCollectionType;
import sif.dd.au30.model.CensusCollectionType;
import sif3.hits.domain.model.CensusCollection;
import sif3.hits.service.CensusCollectionService;

public class CensusCollectionProvider extends
		HitsBaseProvider<CensusCollectionType, CensusCollectionCollectionType, CensusCollection, CensusCollectionService> {

	protected static final Logger L = LoggerFactory.getLogger(CensusCollectionProvider.class);

	/**
	 * @param providerID        The ID of the provider.
	 * @param serviceProperties values of provider property file.
	 */
	public CensusCollectionProvider() {
		super(CensusCollectionType.class, "CensusCollection", CensusCollectionCollectionType.class,
				"CensusCollections", CensusCollectionService.class);
	}
}
