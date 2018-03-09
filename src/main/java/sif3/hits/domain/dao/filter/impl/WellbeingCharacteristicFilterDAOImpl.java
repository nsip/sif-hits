package sif3.hits.domain.dao.filter.impl;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import sif.dd.au30.model.WellbeingCharacteristicType;
import sif3.hits.domain.dao.filter.WellbeingCharacteristicFilterDAO;
import sif3.hits.domain.model.WellbeingCharacteristic;

@Repository
public class WellbeingCharacteristicFilterDAOImpl extends BaseFilterableRepository<WellbeingCharacteristic, WellbeingCharacteristicType> implements WellbeingCharacteristicFilterDAO {
    public WellbeingCharacteristicFilterDAOImpl() {
        super(WellbeingCharacteristic.class, WellbeingCharacteristicType.class);
    }

    @Override
    protected void addServicePathCriteria(Criteria criteria, String key, String value) {
    }
}
