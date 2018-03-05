package sif3.hits.domain.dao.filter.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import sif.dd.au30.model.StudentSchoolEnrollmentType;
import sif3.hits.domain.dao.filter.StudentSchoolEnrollmentFilterDAO;
import sif3.hits.domain.model.StudentSchoolEnrollment;

@Repository
public class StudentSchoolEnrollmentFilterDAOImpl extends BaseFilterableRepository<StudentSchoolEnrollment, StudentSchoolEnrollmentType> implements StudentSchoolEnrollmentFilterDAO {
    public StudentSchoolEnrollmentFilterDAOImpl() {
        super(StudentSchoolEnrollment.class, StudentSchoolEnrollmentType.class);
    }

    @Override
    protected void addServicePathCriteria(Criteria criteria, String key, String value) {
        if ("SchoolInfos".equals(key)) {
            criteria.add(Restrictions.eq("schoolInfoRefId", value));
        } else {
            super.addServicePathCriteria(criteria, key, value);
        }
    }
}
