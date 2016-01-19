package sif3.hits.domain.dao.filter.impl;

import org.springframework.stereotype.Repository;

import sif3.hits.domain.dao.filter.StudentAttendanceTimeListFilterDAO;
import sif3.hits.domain.model.StudentAttendanceTimeList;

@Repository
public class StudentAttendanceTimeListFilterDAOImpl extends BaseFilterableRepository<StudentAttendanceTimeList>implements StudentAttendanceTimeListFilterDAO {
  public StudentAttendanceTimeListFilterDAOImpl() {
    super(StudentAttendanceTimeList.class);
  }
}
