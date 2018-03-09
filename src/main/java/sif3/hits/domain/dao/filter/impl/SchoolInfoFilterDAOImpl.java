package sif3.hits.domain.dao.filter.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.springframework.stereotype.Repository;

import sif.dd.au30.model.SchoolInfoType;
import sif3.hits.domain.dao.filter.SchoolInfoFilterDAO;
import sif3.hits.domain.model.SchoolInfo;
import sif3.hits.domain.model.StaffAssignment;

@Repository
public class SchoolInfoFilterDAOImpl extends BaseFilterableRepository<SchoolInfo, SchoolInfoType> implements SchoolInfoFilterDAO {
    public SchoolInfoFilterDAOImpl() {
        super(SchoolInfo.class, SchoolInfoType.class);
    }

    @Override
    protected void addServicePathCriteria(Criteria criteria, String key, String value) {
        if ("StaffPersonals".equals(key)) {
            DetachedCriteria assignmentQuery = DetachedCriteria.forClass(StaffAssignment.class);
            assignmentQuery.add(Restrictions.eq("staffPersonalRefId", value));
            assignmentQuery.setProjection(Projections.property("schoolInfoRefId"));
            criteria.add(Subqueries.propertyIn("refId", assignmentQuery));
        } else {
            super.addServicePathCriteria(criteria, key, value);
        }
    }
}
