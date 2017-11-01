package sif3.hits.domain.dao.filter.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.springframework.stereotype.Repository;

import sif3.hits.domain.dao.filter.StaffPersonalFilterDAO;
import sif3.hits.domain.model.StaffAssignment;
import sif3.hits.domain.model.StaffPersonal;
import sif3.hits.domain.model.TeachingGroupTeacher;

@Repository
public class StaffPersonalFilterDAOImpl extends BaseFilterableRepository<StaffPersonal>implements StaffPersonalFilterDAO {
  public StaffPersonalFilterDAOImpl() {
    super(StaffPersonal.class);
  }
  
  @Override
  protected void addServicePathCriteria(Criteria criteria, String key, String value) {
    if ("TeachingGroups".equals(key)) {
      DetachedCriteria teachingGroupTeacherQuery = DetachedCriteria.forClass(TeachingGroupTeacher.class);
      teachingGroupTeacherQuery.add(Restrictions.eq("teachingGroupTeacherId.teachingGroup.refId", value));
      teachingGroupTeacherQuery.setProjection(Projections.property("teachingGroupTeacherId.staffPersonal.refId"));
      criteria.add(Subqueries.propertyIn("refId", teachingGroupTeacherQuery));
    } else if ("SchoolInfos".equals(key)) {
      DetachedCriteria assignmentQuery = DetachedCriteria.forClass(StaffAssignment.class);
      assignmentQuery.add(Restrictions.eq("schoolInfoRefId", value));
      assignmentQuery.setProjection(Projections.property("staffPersonalRefId"));
      criteria.add(Subqueries.propertyIn("refId", assignmentQuery));      
    } else {
      super.addServicePathCriteria(criteria, key, value);
    }
  }
}
