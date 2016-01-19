package sif3.hits.domain.dao.filter.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.springframework.stereotype.Repository;

import sif3.hits.domain.dao.filter.StudentPersonalFilterDAO;
import sif3.hits.domain.model.StudentPersonal;
import sif3.hits.domain.model.TeachingGroup;

@Repository
public class StudentPersonalFilterDAOImpl extends BaseFilterableRepository<StudentPersonal>implements StudentPersonalFilterDAO {
  public StudentPersonalFilterDAOImpl() {
    super(StudentPersonal.class);
  }
  
  protected void addServicePathCriteria(Criteria criteria, String key, String value) {
    if ("TeachingGroups".equals(key)) {
      DetachedCriteria teachingGroupQuery = DetachedCriteria.forClass(TeachingGroup.class);
      teachingGroupQuery.createAlias("studentPersonals", "s");
      teachingGroupQuery.add(Restrictions.eq("refId", value));
      teachingGroupQuery.setProjection(Projections.property("s.refId"));
      criteria.add(Subqueries.propertyIn("refId", teachingGroupQuery));
    } else {
      super.addServicePathCriteria(criteria, key, value);
    }
  }
}
