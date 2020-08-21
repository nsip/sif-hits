package sif3.hits.domain.dao.filter.impl;

import org.springframework.stereotype.Repository;

import sif.dd.au30.model.CollectionStatusType;
import sif3.hits.domain.dao.filter.CollectionStatusFilterDAO;
import sif3.hits.domain.model.CollectionStatus;

@Repository
public class CollectionStatusFilterDAOImpl extends BaseFilterableRepository<CollectionStatus, CollectionStatusType>
		implements CollectionStatusFilterDAO {
	public CollectionStatusFilterDAOImpl() {
		super(CollectionStatus.class, CollectionStatusType.class);
	}
}
