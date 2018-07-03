package sif3.hits.domain.dao.filter.impl;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.springframework.stereotype.Repository;

import sif.dd.au30.model.DebtorType;
import sif3.hits.domain.dao.filter.DebtorFilterDAO;
import sif3.hits.domain.model.Debtor;
import sif3.hits.domain.model.StaffAssignment;
import sif3.hits.domain.model.StudentContactRelationship;
import sif3.hits.domain.model.StudentSchoolEnrollment;

@Repository
public class DebtorFilterDAOImpl extends BaseFilterableRepository<Debtor, DebtorType> implements DebtorFilterDAO {
    public DebtorFilterDAOImpl() {
        super(Debtor.class, DebtorType.class);
    }

    @Override
    protected void addServicePathCriteria(Criteria criteria, String key, String value) {
        if ("SchoolInfos".equals(key)) {
            DetachedCriteria studentQuery = DetachedCriteria.forClass(StudentSchoolEnrollment.class);
            studentQuery.add(Restrictions.eq("schoolInfoRefId", value));
            studentQuery.setProjection(Projections.property("studentPersonalRefId"));
            LogicalExpression studentExpression = Restrictions.and(Subqueries.propertyIn("billedEntity", studentQuery),
                    Restrictions.eq("billedEntitySIFRefObject", "StudentPersonal"));

            DetachedCriteria staffQuery = DetachedCriteria.forClass(StaffAssignment.class);
            staffQuery.add(Restrictions.eq("schoolInfoRefId", value));
            staffQuery.setProjection(Projections.property("staffPersonalRefId"));
            LogicalExpression staffExpression = Restrictions.and(Subqueries.propertyIn("billedEntity", staffQuery), Restrictions.eq("billedEntitySIFRefObject", "StaffPersonal"));

            DetachedCriteria contactStudentQuery = DetachedCriteria.forClass(StudentSchoolEnrollment.class);
            contactStudentQuery.add(Restrictions.eq("schoolInfoRefId", value));
            contactStudentQuery.setProjection(Projections.property("studentPersonalRefId"));
            DetachedCriteria studentContactRelationshipQuery = DetachedCriteria.forClass(StudentContactRelationship.class);
            studentContactRelationshipQuery.add(Subqueries.propertyIn("studentPersonalRefId", contactStudentQuery));
            studentContactRelationshipQuery.setProjection(Projections.property("studentContactPersonalRefId"));
            LogicalExpression contactExpression = Restrictions.and(Subqueries.propertyIn("billedEntity", studentContactRelationshipQuery),
                    Restrictions.eq("billedEntitySIFRefObject", "StudentContactPersonal"));

            criteria.add(Restrictions.or(studentExpression, staffExpression, contactExpression));
        } else if ("StudentPersonals".equals(key)) {
            criteria.add(Restrictions.eq("billedEntity", value));
            criteria.add(Restrictions.eq("billedEntitySIFRefObject", "StudentPersonal"));
        } else if ("StaffPersonals".equals(key)) {
            criteria.add(Restrictions.eq("billedEntity", value));
            criteria.add(Restrictions.eq("billedEntitySIFRefObject", "StaffPersonal"));
        } else if ("StudentContactPersonals".equals(key)) {
            criteria.add(Restrictions.eq("billedEntity", value));
            criteria.add(Restrictions.eq("billedEntitySIFRefObject", "StudentContactPersonal"));
        } else if ("VendorInfos".equals(key)) {
            criteria.add(Restrictions.eq("billedEntity", value));
            criteria.add(Restrictions.eq("billedEntitySIFRefObject", "VendorInfo"));
        } else {
            super.addServicePathCriteria(criteria, key, value);
        }
    }

    @Override
    protected void addExtraExampleCriteria(Criteria criteria, Debtor example, DebtorType input) {
        if (input.getBilledEntity() != null && StringUtils.isNotBlank(input.getBilledEntity().getSIFRefObject())) {
            criteria.add(Restrictions.eq("billedEntitySIFRefObject", input.getBilledEntity().getSIFRefObject()));
        }
        if (input.getBilledEntity() != null && StringUtils.isNotBlank(input.getBilledEntity().getValue())) {
            criteria.add(Restrictions.eq("billedEntity", input.getBilledEntity().getValue()));
        }
    }
}