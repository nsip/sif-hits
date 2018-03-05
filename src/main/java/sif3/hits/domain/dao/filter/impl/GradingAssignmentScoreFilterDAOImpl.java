package sif3.hits.domain.dao.filter.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import sif.dd.au30.model.GradingAssignmentScoreType;
import sif3.hits.domain.dao.filter.GradingAssignmentScoreFilterDAO;
import sif3.hits.domain.model.GradingAssignmentScore;

@Repository
public class GradingAssignmentScoreFilterDAOImpl extends BaseFilterableRepository<GradingAssignmentScore, GradingAssignmentScoreType> implements GradingAssignmentScoreFilterDAO {
    public GradingAssignmentScoreFilterDAOImpl() {
        super(GradingAssignmentScore.class, GradingAssignmentScoreType.class);
    }

    @Override
    protected void addExtraExampleCriteria(Criteria criteria, GradingAssignmentScore example, GradingAssignmentScoreType input) {
        if (input != null) {
            if (needsFilter(input.getTeachingGroupRefId())) {
                criteria.createAlias("teachingGroup", "tg");
                criteria.add(Restrictions.eq("tg.refId", input.getTeachingGroupRefId().getValue()));
            }
            if (needsFilter(input.getStudentPersonalRefId())) {
                criteria.createAlias("studentPersonal", "student");
                criteria.add(Restrictions.eq("student.refId", input.getStudentPersonalRefId().getValue()));
            }
        }
    }
    
    @Override
    protected void addServicePathCriteria(Criteria criteria, String key, String value) {
        if ("GradingAssignments".equals(key)) {
            criteria.add(Restrictions.eq("gradingAssignmentRefId", value));
        } else if ("StudentPersonals".equals(key)) {
            criteria.createAlias("studentPersonal", "student");
            criteria.add(Restrictions.eq("student.refId", value));
        } else {
            super.addServicePathCriteria(criteria, key, value);
        }
    }
}
