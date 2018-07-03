package sif3.hits.domain.dao.filter.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.springframework.stereotype.Repository;

import sif.dd.au30.model.GradingAssignmentType;
import sif3.hits.domain.dao.filter.GradingAssignmentFilterDAO;
import sif3.hits.domain.model.GradingAssignment;
import sif3.hits.domain.model.TeachingGroup;

@Repository
public class GradingAssignmentFilterDAOImpl extends BaseFilterableRepository<GradingAssignment, GradingAssignmentType> implements GradingAssignmentFilterDAO {
    public GradingAssignmentFilterDAOImpl() {
        super(GradingAssignment.class, GradingAssignmentType.class);
    }

    @Override
    protected void addExtraExampleCriteria(Criteria criteria, GradingAssignment example, GradingAssignmentType input) {
        if (input != null) {
            if (needsFilter(input.getTeachingGroupRefId())) {
                criteria.createAlias("teachingGroup", "tg");
                criteria.add(Restrictions.eq("tg.refId", input.getTeachingGroupRefId().getValue()));
            }
        }
    }
    
    @Override
    protected void addServicePathCriteria(Criteria criteria, String key, String value) {
        if ("TeachingGroups".equals(key)) {
            criteria.createAlias("teachingGroup", "tg");
            criteria.add(Restrictions.eq("tg.refId", value));
        } else if ("SchoolInfos".equals(key)) {
            criteria.createAlias("teachingGroup", "tgs");
            DetachedCriteria teachingGroupQuery = DetachedCriteria.forClass(TeachingGroup.class);
            teachingGroupQuery.createAlias("schoolInfo", "school");
            teachingGroupQuery.add(Restrictions.eq("school.refId", value));
            teachingGroupQuery.setProjection(Projections.property("refId"));
            criteria.add(Subqueries.propertyIn("tgs.refId", teachingGroupQuery));
        } else {
            super.addServicePathCriteria(criteria, key, value);
        }
    }
}
