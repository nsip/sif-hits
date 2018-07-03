package sif3.hits.domain.dao.filter.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.springframework.stereotype.Repository;

import sif.dd.au30.model.StudentContactPersonalType;
import sif3.hits.domain.dao.filter.StudentContactPersonalFilterDAO;
import sif3.hits.domain.model.StudentContactPersonal;
import sif3.hits.domain.model.StudentContactRelationship;
import sif3.hits.domain.model.StudentSchoolEnrollment;

@Repository
public class StudentContactPersonalFilterDAOImpl extends BaseFilterableRepository<StudentContactPersonal, StudentContactPersonalType> implements StudentContactPersonalFilterDAO {
    public StudentContactPersonalFilterDAOImpl() {
        super(StudentContactPersonal.class, StudentContactPersonalType.class);
    }

    @Override
    protected void addServicePathCriteria(Criteria criteria, String key, String value) {
        if ("StudentPersonals".equals(key)) {
            DetachedCriteria studentContactRelationshipQuery = DetachedCriteria.forClass(StudentContactRelationship.class);
            studentContactRelationshipQuery.add(Restrictions.eq("studentPersonalRefId", value));
            studentContactRelationshipQuery.setProjection(Projections.property("studentContactPersonalRefId"));
            criteria.add(Subqueries.propertyIn("refId", studentContactRelationshipQuery));
        } else if ("SchoolInfos".equals(key)) {
            DetachedCriteria enrolmentQuery = DetachedCriteria.forClass(StudentSchoolEnrollment.class);
            enrolmentQuery.add(Restrictions.eq("schoolInfoRefId", value));
            enrolmentQuery.setProjection(Projections.property("studentPersonalRefId"));
            DetachedCriteria studentContactRelationshipQuery = DetachedCriteria.forClass(StudentContactRelationship.class);
            studentContactRelationshipQuery.add(Subqueries.propertyIn("studentPersonalRefId", enrolmentQuery));
            studentContactRelationshipQuery.setProjection(Projections.property("studentContactPersonalRefId"));
            criteria.add(Subqueries.propertyIn("refId", studentContactRelationshipQuery));
        } else {
            super.addServicePathCriteria(criteria, key, value);
        }
    }
}
