package sif3.hits.domain.dao.filter.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.springframework.stereotype.Repository;

import sif3.hits.domain.dao.filter.StudentContactRelationshipFilterDAO;
import sif3.hits.domain.model.StudentContactRelationship;
import sif3.hits.domain.model.StudentSchoolEnrollment;

@Repository
public class StudentContactRelationshipFilterDAOImpl extends BaseFilterableRepository<StudentContactRelationship>implements StudentContactRelationshipFilterDAO {
  public StudentContactRelationshipFilterDAOImpl() {
    super(StudentContactRelationship.class);
  }
  
  @Override
  protected void addServicePathCriteria(Criteria criteria, String key, String value) {
    if ("SchoolInfos".equals(key)) {
      DetachedCriteria enrolmentQuery = DetachedCriteria.forClass(StudentSchoolEnrollment.class);
      enrolmentQuery.add(Restrictions.eq("schoolInfoRefId", value));
      enrolmentQuery.setProjection(Projections.property("studentPersonalRefId"));      
      criteria.add(Subqueries.propertyIn("studentPersonalRefId", enrolmentQuery));
    } else {
      super.addServicePathCriteria(criteria, key, value);
    }
  }

}
