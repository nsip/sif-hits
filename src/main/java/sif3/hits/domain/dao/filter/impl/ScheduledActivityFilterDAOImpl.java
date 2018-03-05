package sif3.hits.domain.dao.filter.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.hibernate.persister.collection.CollectionPropertyNames;
import org.springframework.stereotype.Repository;

import sif.dd.au30.model.ScheduledActivityType;
import sif3.hits.domain.dao.filter.ScheduledActivityFilterDAO;
import sif3.hits.domain.model.ScheduledActivity;
import sif3.hits.domain.model.ScheduledActivityTeacher;

@Repository
public class ScheduledActivityFilterDAOImpl extends BaseFilterableRepository<ScheduledActivity, ScheduledActivityType> implements ScheduledActivityFilterDAO {
    public ScheduledActivityFilterDAOImpl() {
        super(ScheduledActivity.class, ScheduledActivityType.class);
    }

    @Override
    protected void addServicePathCriteria(Criteria criteria, String key, String value) {
        if ("StudentPersonals".equals(key)) {
            DetachedCriteria scheduledActivityQuery = DetachedCriteria.forClass(ScheduledActivity.class);
            scheduledActivityQuery.createAlias("studentPersonalRefIds", "student");
            scheduledActivityQuery.add(Restrictions.eq("student." + CollectionPropertyNames.COLLECTION_ELEMENTS, value));
            scheduledActivityQuery.setProjection(Projections.property("refId"));
            criteria.add(Subqueries.propertyIn("refId", scheduledActivityQuery));
        } else if ("TeachingGroups".equals(key)) {
            DetachedCriteria scheduledActivityQuery = DetachedCriteria.forClass(ScheduledActivity.class);
            scheduledActivityQuery.createAlias("teachingGroupRefIds", "teacher");
            scheduledActivityQuery.add(Restrictions.eq("teacher." + CollectionPropertyNames.COLLECTION_ELEMENTS, value));
            scheduledActivityQuery.setProjection(Projections.property("refId"));
            criteria.add(Subqueries.propertyIn("refId", scheduledActivityQuery));
        } else if ("StaffPersonals".equals(key)) {
            DetachedCriteria scheduledActivityTeacherQuery = DetachedCriteria.forClass(ScheduledActivityTeacher.class);
            scheduledActivityTeacherQuery.add(Restrictions.eq("scheduledActivityTeacherId.staffPersonalRefId", value));
            scheduledActivityTeacherQuery.setProjection(Projections.property("scheduledActivityTeacherId.scheduledActivity.refId"));
            criteria.add(Subqueries.propertyIn("refId", scheduledActivityTeacherQuery));
        } else {
            super.addServicePathCriteria(criteria, key, value);
        }
    }
}
