package sif3.hits.domain.dao.filter.impl;

import org.springframework.stereotype.Repository;

import sif3.hits.domain.dao.filter.StudentPeriodAttendanceFilterDAO;
import sif3.hits.domain.model.StudentPeriodAttendance;

@Repository
public class StudentPeriodAttendanceFilterDAOImpl extends BaseFilterableRepository<StudentPeriodAttendance>implements StudentPeriodAttendanceFilterDAO {
  public StudentPeriodAttendanceFilterDAOImpl() {
    super(StudentPeriodAttendance.class);
  }
}
