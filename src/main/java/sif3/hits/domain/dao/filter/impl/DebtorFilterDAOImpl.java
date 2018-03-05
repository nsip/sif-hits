package sif3.hits.domain.dao.filter.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import sif.dd.au30.model.DebtorType;
import sif3.hits.domain.dao.filter.DebtorFilterDAO;
import sif3.hits.domain.model.Debtor;

@Repository
public class DebtorFilterDAOImpl extends BaseFilterableRepository<Debtor, DebtorType> implements DebtorFilterDAO {
    public DebtorFilterDAOImpl() {
        super(Debtor.class, DebtorType.class);
    }

    @Override
    protected void addServicePathCriteria(Criteria criteria, String key, String value) {
        if ("StudentPersonals".equals(key)) {
            criteria.add(Restrictions.eq("billedEntity", value));
            criteria.add(Restrictions.eq("billedEntitySIFRefObject", "StudentPersonal"));
        } else if ("StaffPersonals".equals(key)) {
            criteria.add(Restrictions.eq("billedEntity", value));
            criteria.add(Restrictions.eq("billedEntitySIFRefObject", "StaffPersonal"));
        } else if ("StudentContactPersonals".equals(key)) {
            criteria.add(Restrictions.eq("billedEntity", value));
            criteria.add(Restrictions.eq("billedEntitySIFRefObject", "StudentContactPersonal"));
        } else if ("VendorInfos".equals(key)) {
            criteria.add(Restrictions.eq("billedEntity", value));
            criteria.add(Restrictions.eq("billedEntitySIFRefObject", "VendorInfo"));
        } else {
            super.addServicePathCriteria(criteria, key, value);
        }
    }
}
