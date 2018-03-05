package sif3.hits.domain.dao.filter.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import sif.dd.au30.model.NAPTestletType;
import sif3.hits.domain.dao.filter.NAPTestletFilterDAO;
import sif3.hits.domain.model.NAPTestlet;

@Repository
public class NAPTestletFilterDAOImpl extends BaseFilterableRepository<NAPTestlet, NAPTestletType> implements NAPTestletFilterDAO {
    public NAPTestletFilterDAOImpl() {
        super(NAPTestlet.class, NAPTestletType.class);
    }
    
    @Override
    protected void addServicePathCriteria(Criteria criteria, String key, String value) {
        if ("NAPTests".equals(key)) {
            criteria.createAlias("napTest", "test");
            criteria.add(Restrictions.eq("test.refId", value));
        } else {
            super.addServicePathCriteria(criteria, key, value);
        }
    }
}
