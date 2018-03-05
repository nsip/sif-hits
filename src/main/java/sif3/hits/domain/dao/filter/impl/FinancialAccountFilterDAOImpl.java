package sif3.hits.domain.dao.filter.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.springframework.stereotype.Repository;

import sif.dd.au30.model.FinancialAccountType;
import sif3.hits.domain.dao.filter.FinancialAccountFilterDAO;
import sif3.hits.domain.model.FinancialAccount;
import sif3.hits.domain.model.LocationInfo;

@Repository
public class FinancialAccountFilterDAOImpl extends BaseFilterableRepository<FinancialAccount, FinancialAccountType> implements FinancialAccountFilterDAO {
    public FinancialAccountFilterDAOImpl() {
        super(FinancialAccount.class, FinancialAccountType.class);
    }

    @Override
    protected void addServicePathCriteria(Criteria criteria, String key, String value) {
        if ("ChargedLocationInfos".equals(key)) {
            criteria.add(Restrictions.eq("locationInfoRefId", value));
        } else if ("SchoolInfos".equals(key)) {
            DetachedCriteria locationQuery = DetachedCriteria.forClass(LocationInfo.class);
            locationQuery.add(Restrictions.eq("schoolInfoRefId", value));
            locationQuery.setProjection(Projections.property("refId"));
            criteria.add(Subqueries.propertyIn("locationInfoRefId", locationQuery));
        } else {
            super.addServicePathCriteria(criteria, key, value);
        }
    }
}
