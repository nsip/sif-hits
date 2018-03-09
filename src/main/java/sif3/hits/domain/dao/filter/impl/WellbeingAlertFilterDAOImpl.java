package sif3.hits.domain.dao.filter.impl;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import sif.dd.au30.model.WellbeingAlertType;
import sif3.hits.domain.dao.filter.WellbeingAlertFilterDAO;
import sif3.hits.domain.model.WellbeingAlert;

@Repository
public class WellbeingAlertFilterDAOImpl extends BaseFilterableRepository<WellbeingAlert, WellbeingAlertType> implements WellbeingAlertFilterDAO {
    public WellbeingAlertFilterDAOImpl() {
        super(WellbeingAlert.class, WellbeingAlertType.class);
    }

    @Override
    protected void addServicePathCriteria(Criteria criteria, String key, String value) {
    }
}
