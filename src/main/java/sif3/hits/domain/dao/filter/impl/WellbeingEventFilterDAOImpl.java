package sif3.hits.domain.dao.filter.impl;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import sif.dd.au30.model.WellbeingEventType;
import sif3.hits.domain.dao.filter.WellbeingEventFilterDAO;
import sif3.hits.domain.model.WellbeingEvent;

@Repository
public class WellbeingEventFilterDAOImpl extends BaseFilterableRepository<WellbeingEvent, WellbeingEventType> implements WellbeingEventFilterDAO {
    public WellbeingEventFilterDAOImpl() {
        super(WellbeingEvent.class, WellbeingEventType.class);
    }

    @Override
    protected void addServicePathCriteria(Criteria criteria, String key, String value) {
    }
}
