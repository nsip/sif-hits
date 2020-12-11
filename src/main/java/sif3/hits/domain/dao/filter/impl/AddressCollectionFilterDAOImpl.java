package sif3.hits.domain.dao.filter.impl;

import org.springframework.stereotype.Repository;

import sif.dd.au30.model.AddressCollectionType;
import sif3.hits.domain.dao.filter.AddressCollectionFilterDAO;
import sif3.hits.domain.model.AddressCollection;

@Repository
public class AddressCollectionFilterDAOImpl extends BaseFilterableRepository<AddressCollection, AddressCollectionType>
		implements AddressCollectionFilterDAO {
	public AddressCollectionFilterDAOImpl() {
		super(AddressCollection.class, AddressCollectionType.class);
	}
}
