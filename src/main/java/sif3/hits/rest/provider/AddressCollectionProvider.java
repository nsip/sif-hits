package sif3.hits.rest.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.AddressCollectionCollectionType;
import sif.dd.au30.model.AddressCollectionType;
import sif3.hits.domain.model.AddressCollection;
import sif3.hits.service.AddressCollectionService;

public class AddressCollectionProvider extends
		HitsBaseProvider<AddressCollectionType, AddressCollectionCollectionType, AddressCollection, AddressCollectionService> {

	protected static final Logger L = LoggerFactory.getLogger(AddressCollectionProvider.class);

	/**
	 * @param providerID        The ID of the provider.
	 * @param serviceProperties values of provider property file.
	 */
	public AddressCollectionProvider() {
		super(AddressCollectionType.class, "AddressCollection", AddressCollectionCollectionType.class,
				"AddressCollections", AddressCollectionService.class);
	}
}
