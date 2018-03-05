package sif3.hits.domain.dao.filter.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import sif.dd.au30.model.StudentAttendanceSummaryType;
import sif3.hits.domain.dao.filter.StudentAttendanceSummaryFilterDAO;
import sif3.hits.domain.model.StudentAttendanceSummary;

@Repository
public class StudentAttendanceSummaryFilterDAOImpl extends BaseFilterableRepository<StudentAttendanceSummary, StudentAttendanceSummaryType>
        implements StudentAttendanceSummaryFilterDAO {
    public StudentAttendanceSummaryFilterDAOImpl() {
        super(StudentAttendanceSummary.class, StudentAttendanceSummaryType.class);
    }

    @Override
    protected void addServicePathCriteria(Criteria criteria, String key, String value) {
        if ("SchoolInfos".equals(key)) {
            criteria.add(Restrictions.eq("schoolInfoRefId", value));
        } else if ("StudentPersonals".equals(key)) {
            criteria.add(Restrictions.eq("studentPersonalRefId", value));
        } else {
            super.addServicePathCriteria(criteria, key, value);
        }
    }
}
