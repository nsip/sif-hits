package sif3.hits.domain.dao.filter.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import sif3.hits.domain.dao.filter.StudentDailyAttendanceFilterDAO;
import sif3.hits.domain.model.StudentDailyAttendance;

@Repository
public class StudentDailyAttendanceFilterDAOImpl extends BaseFilterableRepository<StudentDailyAttendance>implements StudentDailyAttendanceFilterDAO {
  public StudentDailyAttendanceFilterDAOImpl() {
    super(StudentDailyAttendance.class);
  }
  
  @Override
  protected void addServicePathCriteria(Criteria criteria, String key, String value) {
    if ("StudentPersonals".equals(key)) {
      criteria.add(Restrictions.eq("studentPersonalRefId", value));
    } else if ("SchoolInfos".equals(key)) {
      criteria.add(Restrictions.eq("schoolInfoRefId", value));
    } else {
      super.addServicePathCriteria(criteria, key, value);
    }
  }
}
