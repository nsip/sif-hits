package sif3.hits.domain.dao.filter.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.springframework.stereotype.Repository;

import sif.dd.au30.model.NAPTestItemType;
import sif3.hits.domain.dao.filter.NAPTestItemFilterDAO;
import sif3.hits.domain.model.NAPTestItem;
import sif3.hits.domain.model.NAPTestletTestItem;

@Repository
public class NAPTestItemFilterDAOImpl extends BaseFilterableRepository<NAPTestItem, NAPTestItemType> implements NAPTestItemFilterDAO {
    public NAPTestItemFilterDAOImpl() {
        super(NAPTestItem.class, NAPTestItemType.class);
    }

    @Override
    protected void addServicePathCriteria(Criteria criteria, String key, String value) {
        if ("NAPTests".equals(key)) {
            DetachedCriteria testQuery = DetachedCriteria.forClass(NAPTestletTestItem.class);
            testQuery.createAlias("napTestItem", "testItem");
            testQuery.createAlias("napTestlet", "testlet");
            testQuery.createAlias("testlet.napTest", "test");
            testQuery.add(Restrictions.eq("test.refId", value));
            testQuery.setProjection(Projections.property("testItem.refId"));
            criteria.add(Subqueries.propertyIn("refId", testQuery));
        } else {
            super.addServicePathCriteria(criteria, key, value);
        }
    }
}
