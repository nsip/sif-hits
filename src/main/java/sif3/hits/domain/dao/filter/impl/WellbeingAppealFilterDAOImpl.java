package sif3.hits.domain.dao.filter.impl;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import sif.dd.au30.model.WellbeingAppealType;
import sif3.hits.domain.dao.filter.WellbeingAppealFilterDAO;
import sif3.hits.domain.model.WellbeingAppeal;

@Repository
public class WellbeingAppealFilterDAOImpl extends BaseFilterableRepository<WellbeingAppeal, WellbeingAppealType> implements WellbeingAppealFilterDAO {
    public WellbeingAppealFilterDAOImpl() {
        super(WellbeingAppeal.class, WellbeingAppealType.class);
    }

    @Override
    protected void addServicePathCriteria(Criteria criteria, String key, String value) {
    }
}
