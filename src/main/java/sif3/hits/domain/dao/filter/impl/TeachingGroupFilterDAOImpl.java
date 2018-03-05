package sif3.hits.domain.dao.filter.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.springframework.stereotype.Repository;

import sif.dd.au30.model.TeachingGroupType;
import sif3.hits.domain.dao.filter.TeachingGroupFilterDAO;
import sif3.hits.domain.model.TeachingGroup;
import sif3.hits.domain.model.TeachingGroupTeacher;

@Repository
public class TeachingGroupFilterDAOImpl extends BaseFilterableRepository<TeachingGroup, TeachingGroupType> implements TeachingGroupFilterDAO {
    public TeachingGroupFilterDAOImpl() {
        super(TeachingGroup.class, TeachingGroupType.class);
    }

    @Override
    protected void addExtraExampleCriteria(Criteria criteria, TeachingGroup example, TeachingGroupType input) {
        if (input != null) {
            if (needsFilter(input.getSchoolLocalId(), input.getSchoolInfoRefId())) {
                criteria.createAlias("schoolInfo", "school");
                if (needsFilter(input.getSchoolInfoRefId())) {
                    criteria.add(Restrictions.eq("school.refId", input.getSchoolInfoRefId().getValue()));
                }
                if (needsFilter(input.getSchoolLocalId())) {
                    criteria.add(Restrictions.eq("school.localId", input.getSchoolLocalId().getValue()));
                }
            }
            if (needsFilter(input.getTimeTableSubjectLocalId(), input.getTimeTableSubjectRefId())) {
                criteria.createAlias("timeTableSubject", "subject");
                if (needsFilter(input.getTimeTableSubjectRefId())) {
                    criteria.add(Restrictions.eq("subject.refId", input.getTimeTableSubjectRefId().getValue()));
                }
                if (needsFilter(input.getTimeTableSubjectLocalId())) {
                    criteria.add(Restrictions.eq("subject.localId", input.getTimeTableSubjectLocalId().getValue()));
                }
            }
        }
    }

    @Override
    protected void addServicePathCriteria(Criteria criteria, String key, String value) {
        if ("StudentPersonals".equals(key)) {
            DetachedCriteria teachingGroupQuery = DetachedCriteria.forClass(TeachingGroup.class);
            teachingGroupQuery.createAlias("studentPersonals", "s");
            teachingGroupQuery.add(Restrictions.eq("s.refId", value));
            teachingGroupQuery.setProjection(Projections.property("refId"));
            criteria.add(Subqueries.propertyIn("refId", teachingGroupQuery));
        } else if ("TimeTableSubjects".equals(key)) {
            criteria.createAlias("timeTableSubject", "subject");
            criteria.add(Restrictions.eq("subject.refId", value));
        } else if ("StaffPersonals".equals(key)) {
            DetachedCriteria teachingGroupTeacherQuery = DetachedCriteria.forClass(TeachingGroupTeacher.class);
            teachingGroupTeacherQuery.add(Restrictions.eq("teachingGroupTeacherId.staffPersonal.refId", value));
            teachingGroupTeacherQuery.setProjection(Projections.property("teachingGroupTeacherId.teachingGroup.refId"));
            criteria.add(Subqueries.propertyIn("refId", teachingGroupTeacherQuery));
        } else if ("SchoolInfos".equals(key)) {
            DetachedCriteria teachingGroupQuery = DetachedCriteria.forClass(TeachingGroup.class);
            teachingGroupQuery.createAlias("schoolInfo", "s");
            teachingGroupQuery.add(Restrictions.eq("s.refId", value));
            teachingGroupQuery.setProjection(Projections.property("refId"));
            criteria.add(Subqueries.propertyIn("refId", teachingGroupQuery));
        } else {
            super.addServicePathCriteria(criteria, key, value);
        }
    }
}
