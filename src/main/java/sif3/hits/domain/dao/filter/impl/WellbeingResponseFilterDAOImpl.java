package sif3.hits.domain.dao.filter.impl;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import sif.dd.au30.model.WellbeingResponseType;
import sif3.hits.domain.dao.filter.WellbeingResponseFilterDAO;
import sif3.hits.domain.model.WellbeingResponse;

@Repository
public class WellbeingResponseFilterDAOImpl extends BaseFilterableRepository<WellbeingResponse, WellbeingResponseType> implements WellbeingResponseFilterDAO {
    public WellbeingResponseFilterDAOImpl() {
        super(WellbeingResponse.class, WellbeingResponseType.class);
    }

    @Override
    protected void addServicePathCriteria(Criteria criteria, String key, String value) {
    }
}
