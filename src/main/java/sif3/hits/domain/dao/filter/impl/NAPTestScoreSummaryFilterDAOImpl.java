package sif3.hits.domain.dao.filter.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import sif.dd.au30.model.NAPTestScoreSummaryType;
import sif3.hits.domain.dao.filter.NAPTestScoreSummaryFilterDAO;
import sif3.hits.domain.model.NAPTestScoreSummary;

@Repository
public class NAPTestScoreSummaryFilterDAOImpl extends BaseFilterableRepository<NAPTestScoreSummary, NAPTestScoreSummaryType> implements NAPTestScoreSummaryFilterDAO {
    public NAPTestScoreSummaryFilterDAOImpl() {
        super(NAPTestScoreSummary.class, NAPTestScoreSummaryType.class);
    }
    
    @Override
    protected void addServicePathCriteria(Criteria criteria, String key, String value) {
        if ("SchoolInfos".equals(key)) {
            criteria.createAlias("schoolInfo", "school");
            criteria.add(Restrictions.eq("school.refId", value));
        } else {
            super.addServicePathCriteria(criteria, key, value);
        }
    }
}
