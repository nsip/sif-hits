package sif3.hits.domain.dao.filter.impl;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.springframework.stereotype.Repository;

import sif.dd.au30.model.NAPStudentResponseSetType;
import sif3.hits.domain.dao.filter.NAPStudentResponseSetFilterDAO;
import sif3.hits.domain.model.NAPStudentResponseSet;
import sif3.hits.domain.model.StudentPersonalOtherId;
import sif3.hits.domain.model.StudentSchoolEnrollment;
import sif3.hits.service.PersonalStudentIdService;

@Repository
public class NAPStudentResponseSetFilterDAOImpl extends BaseFilterableRepository<NAPStudentResponseSet, NAPStudentResponseSetType> implements NAPStudentResponseSetFilterDAO {
    public NAPStudentResponseSetFilterDAOImpl() {
        super(NAPStudentResponseSet.class, NAPStudentResponseSetType.class);
    }

    @Override
    protected void addExtraExampleCriteria(Criteria criteria, NAPStudentResponseSet example, NAPStudentResponseSetType input) {
        if (input != null) {
            if (needsFilter(input.getStudentPersonalRefId())) {
                criteria.createAlias("studentPersonal", "student");
                criteria.add(Restrictions.eq("student.refId", input.getStudentPersonalRefId().getValue()));
            }
            if (needsFilter(input.getNAPTestRefId())) {
                criteria.createAlias("napTest", "test");
                criteria.add(Restrictions.eq("test.refId", input.getNAPTestRefId().getValue()));
            }
            if (StringUtils.isNotBlank(input.getPlatformStudentIdentifier())) {
                DetachedCriteria subquery = DetachedCriteria.forClass(StudentPersonalOtherId.class, "spoi");
                subquery.setProjection(Projections.property("studentPersonalOtherIdId.studentPersonal.refId"))
                        .add(Restrictions.eq("studentPersonalOtherIdId.otherId", input.getPlatformStudentIdentifier()))
                        .add(Restrictions.eq("studentPersonalOtehrIdId.otherIdType", PersonalStudentIdService.PERSONAL_STUDENT_IDENTIFIER_TYPE));
                criteria.add(Subqueries.propertyIn("studentPersonal.refId", subquery));
            }
        }
    }

    @Override
    protected void addServicePathCriteria(Criteria criteria, String key, String value) {
        if ("StudentPersonals".equals(key)) {
            criteria.createAlias("studentPersonal", "student");
            criteria.add(Restrictions.eq("student.refId", value));
        } else if ("SchoolInfos".equals(key)) {
            criteria.createAlias("studentPersonal", "studentSchool");
            DetachedCriteria enrolmentQuery = DetachedCriteria.forClass(StudentSchoolEnrollment.class);
            enrolmentQuery.add(Restrictions.eq("schoolInfoRefId", value));
            enrolmentQuery.setProjection(Projections.property("studentPersonalRefId"));
            criteria.add(Subqueries.propertyIn("studentSchool.refId", enrolmentQuery));
        } else {
            super.addServicePathCriteria(criteria, key, value);
        }
    }
}
