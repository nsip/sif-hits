package sif3.hits.domain.dao.filter.impl;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.springframework.stereotype.Repository;

import sif3.hits.domain.dao.filter.TeachingGroupFilterDAO;
import sif3.hits.domain.model.TeachingGroup;
import sif3.hits.domain.model.TeachingGroupTeacher;

@Repository
public class TeachingGroupFilterDAOImpl extends BaseFilterableRepository<TeachingGroup>implements TeachingGroupFilterDAO {
  public TeachingGroupFilterDAOImpl() {
    super(TeachingGroup.class);
  }

  @Override
  protected void addExampleCriteria(Criteria criteria, TeachingGroup example) {
    if (example != null) {
      if (StringUtils.isNotBlank(example.getLocalId())) {
        criteria.add(Restrictions.eq("localId", example.getLocalId()));
      }
      if (StringUtils.isNotBlank(example.getShortName())) {
        criteria.add(Restrictions.eq("shortName", example.getShortName()));
      }
      if (StringUtils.isNotBlank(example.getLongName())) {
        criteria.add(Restrictions.eq("longName", example.getLongName()));
      }
      if (StringUtils.isNotBlank(example.getSchoolYear())) {
        criteria.add(Restrictions.eq("schoolYear", example.getSchoolYear()));
      }
      if (example.getSchoolInfo() != null && (StringUtils.isNotBlank(example.getSchoolInfo().getRefId()) || StringUtils.isNotBlank(example.getSchoolInfo().getLocalId()))) {
        criteria.createAlias("schoolInfo", "school");
        if (StringUtils.isNotBlank(example.getSchoolInfo().getRefId())) {
          criteria.add(Restrictions.eq("school.refId", example.getSchoolInfo().getRefId()));
        }
        if (StringUtils.isNotBlank(example.getSchoolInfo().getLocalId())) {
          criteria.add(Restrictions.eq("school.localId", example.getSchoolInfo().getLocalId()));
        }
      }
    } else {
      super.addExampleCriteria(criteria, example);
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
    } else if ("StaffPersonals".equals(key)) {
      DetachedCriteria teachingGroupTeacherQuery = DetachedCriteria.forClass(TeachingGroupTeacher.class);
      teachingGroupTeacherQuery.add(Restrictions.eq("teachingGroupTeacherId.staffPersonal.refId", value));
      teachingGroupTeacherQuery.setProjection(Projections.property("teachingGroupTeacherId.teachingGroup.refId"));
      criteria.add(Subqueries.propertyIn("refId", teachingGroupTeacherQuery));
    } else {
      super.addServicePathCriteria(criteria, key, value);
    }
  }

//  @Override
//  public Page<TeachingGroup> findAllWithStudentOrStaffAndFilter(String studentPersonalRefId, String staffPersonalRefId, List<String> schoolRefIds, Pageable pageable) {
//    Session session = (Session) entityManager.getDelegate();
//    Criteria criteria = session.createCriteria(exampleClass);
//    
//    if (studentPersonalRefId != null) {
//      DetachedCriteria studentQuery = DetachedCriteria.forClass(TeachingGroup.class);
//      studentQuery.setProjection(Projections.property("refId"));
//      
//      criteria.add( Subqueries.propertyIn("refId", studentQuery));
//    }
//    if (staffPersonalRefId != null) {
//      DetachedCriteria staffQuery = DetachedCriteria.forClass(TeachingGroupTeacher.class);
//      staffQuery.createAlias("teachingGroupTeacherId.teachingGroup", "teachingGroup");
//      staffQuery.setProjection(Projections.property("teachingGroup.refId"));
//      
//      criteria.add( Subqueries.propertyIn("refId", staffQuery));
//    }
//    return applyPage(criteria.list(), pageable);
//  }
}
