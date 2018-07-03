package sif3.hits.domain.dao.filter.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.springframework.stereotype.Repository;

import sif.dd.au30.model.JournalType;
import sif3.hits.domain.dao.filter.JournalFilterDAO;
import sif3.hits.domain.model.FinancialAccount;
import sif3.hits.domain.model.Journal;
import sif3.hits.domain.model.LocationInfo;

@Repository
public class JournalFilterDAOImpl extends BaseFilterableRepository<Journal, JournalType> implements JournalFilterDAO {
    public JournalFilterDAOImpl() {
        super(Journal.class, JournalType.class);
    }

    @Override
    protected void addServicePathCriteria(Criteria criteria, String key, String value) {
        if ("SchoolInfos".equals(key)) {
            DetachedCriteria locationQuery = DetachedCriteria.forClass(LocationInfo.class);
            locationQuery.add(Restrictions.eq("schoolInfoRefId", value));
            locationQuery.setProjection(Projections.property("refId"));
            
            DetachedCriteria financialAccountQuery = DetachedCriteria.forClass(FinancialAccount.class);
            financialAccountQuery.add(Subqueries.propertyIn("locationInfoRefId", locationQuery));
            financialAccountQuery.setProjection(Projections.property("refId"));
            
            criteria.add(Restrictions.or(Subqueries.propertyIn("debitFinancialAccountRefId", financialAccountQuery), Subqueries.propertyIn("creditFinancialAccountRefId", financialAccountQuery)));
        } else {
            super.addServicePathCriteria(criteria, key, value);
        }
    }
}
