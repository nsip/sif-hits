package sif3.hits.domain.dao.filter.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import sif.dd.au30.model.StudentAttendanceTimeListType;
import sif3.hits.domain.dao.filter.StudentAttendanceTimeListFilterDAO;
import sif3.hits.domain.model.StudentAttendanceTimeList;

@Repository
public class StudentAttendanceTimeListFilterDAOImpl extends BaseFilterableRepository<StudentAttendanceTimeList, StudentAttendanceTimeListType>
        implements StudentAttendanceTimeListFilterDAO {
    public StudentAttendanceTimeListFilterDAOImpl() {
        super(StudentAttendanceTimeList.class, StudentAttendanceTimeListType.class);
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
