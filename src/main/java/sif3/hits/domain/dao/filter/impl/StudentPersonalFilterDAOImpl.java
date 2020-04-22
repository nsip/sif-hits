package sif3.hits.domain.dao.filter.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.hibernate.persister.collection.CollectionPropertyNames;
import org.springframework.stereotype.Repository;

import sif.dd.au30.model.StudentPersonalType;
import sif3.hits.domain.dao.filter.StudentPersonalFilterDAO;
import sif3.hits.domain.model.StudentPersonal;
import sif3.hits.domain.model.StudentSchoolEnrollment;
import sif3.hits.domain.model.TeachingGroup;

@Repository
public class StudentPersonalFilterDAOImpl extends BaseFilterableRepository<StudentPersonal, StudentPersonalType> implements StudentPersonalFilterDAO {
    public StudentPersonalFilterDAOImpl() {
        super(StudentPersonal.class, StudentPersonalType.class);
    }

    protected void addServicePathCriteria(Criteria criteria, String key, String value) {
        if ("TeachingGroups".equals(key)) {
            DetachedCriteria teachingGroupQuery = DetachedCriteria.forClass(TeachingGroup.class);
            teachingGroupQuery.createAlias("studentPersonalRefIds", "student");
            teachingGroupQuery.add(Restrictions.eq("refId", value));
            teachingGroupQuery.setProjection(Projections.property("student." + CollectionPropertyNames.COLLECTION_ELEMENTS));
            criteria.add(Subqueries.propertyIn("refId", teachingGroupQuery));
        } else if ("SchoolInfos".equals(key)) {
            DetachedCriteria enrolmentQuery = DetachedCriteria.forClass(StudentSchoolEnrollment.class);
            enrolmentQuery.add(Restrictions.eq("schoolInfoRefId", value));
            enrolmentQuery.setProjection(Projections.property("studentPersonalRefId"));
            criteria.add(Subqueries.propertyIn("refId", enrolmentQuery));
        } else {
            super.addServicePathCriteria(criteria, key, value);
        }
    }
}
