package sif3.hits.domain.dao.filter.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import sif.dd.au30.model.TermInfoType;
import sif3.hits.domain.dao.filter.TermInfoFilterDAO;
import sif3.hits.domain.model.TermInfo;

@Repository
public class TermInfoFilterDAOImpl extends BaseFilterableRepository<TermInfo, TermInfoType>
		implements TermInfoFilterDAO {
	public TermInfoFilterDAOImpl() {
		super(TermInfo.class, TermInfoType.class);
	}

	@Override
	protected void addServicePathCriteria(Criteria criteria, String key, String value) {
		if ("SchoolInfos".equals(key)) {
			criteria.createAlias("schoolInfo", "school");
			criteria.add(Restrictions.eq("school.refId", value));
		} else {
			super.addServicePathCriteria(criteria, key, value);
		}
	}
}
