package sif3.hits.domain.dao.filter.impl;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import sif.dd.au30.model.PersonalisedPlanType;
import sif3.hits.domain.dao.filter.PersonalisedPlanFilterDAO;
import sif3.hits.domain.model.PersonalisedPlan;

@Repository
public class PersonalisedPlanFilterDAOImpl extends BaseFilterableRepository<PersonalisedPlan, PersonalisedPlanType> implements PersonalisedPlanFilterDAO {
    public PersonalisedPlanFilterDAOImpl() {
        super(PersonalisedPlan.class, PersonalisedPlanType.class);
    }

    @Override
    protected void addServicePathCriteria(Criteria criteria, String key, String value) {
    }
}
