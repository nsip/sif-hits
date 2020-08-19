package sif3.hits.domain.dao.filter.impl;

import org.springframework.stereotype.Repository;

import sif.dd.au30.model.CensusCollectionType;
import sif3.hits.domain.dao.filter.CensusCollectionFilterDAO;
import sif3.hits.domain.model.CensusCollection;

@Repository
public class CensusCollectionFilterDAOImpl extends BaseFilterableRepository<CensusCollection, CensusCollectionType>
		implements CensusCollectionFilterDAO {
	public CensusCollectionFilterDAOImpl() {
		super(CensusCollection.class, CensusCollectionType.class);
	}
}
