package sif3.hits.domain.dao.filter.impl;

import org.springframework.stereotype.Repository;

import sif3.hits.domain.dao.filter.StudentAttendanceSummaryFilterDAO;
import sif3.hits.domain.model.StudentAttendanceSummary;

@Repository
public class StudentAttendanceSummaryFilterDAOImpl extends BaseFilterableRepository<StudentAttendanceSummary>implements StudentAttendanceSummaryFilterDAO {
  public StudentAttendanceSummaryFilterDAOImpl() {
    super(StudentAttendanceSummary.class);
  }
}
