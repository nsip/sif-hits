package sif3.hits.domain.dao.filter.impl;

import org.springframework.stereotype.Repository;

import sif.dd.au30.model.CollectionRoundType;
import sif3.hits.domain.dao.filter.CollectionRoundFilterDAO;
import sif3.hits.domain.model.CollectionRound;

@Repository
public class CollectionRoundFilterDAOImpl extends BaseFilterableRepository<CollectionRound, CollectionRoundType>
		implements CollectionRoundFilterDAO {
	public CollectionRoundFilterDAOImpl() {
		super(CollectionRound.class, CollectionRoundType.class);
	}
}
