package sif3.hits.domain.dao.filter.impl;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import sif.dd.au30.model.WellbeingPersonLinkType;
import sif3.hits.domain.dao.filter.WellbeingPersonLinkFilterDAO;
import sif3.hits.domain.model.WellbeingPersonLink;

@Repository
public class WellbeingPersonLinkFilterDAOImpl extends
		BaseFilterableRepository<WellbeingPersonLink, WellbeingPersonLinkType> implements WellbeingPersonLinkFilterDAO {
	public WellbeingPersonLinkFilterDAOImpl() {
		super(WellbeingPersonLink.class, WellbeingPersonLinkType.class);
	}

	@Override
	protected void addServicePathCriteria(Criteria criteria, String key, String value) {
	}
}
