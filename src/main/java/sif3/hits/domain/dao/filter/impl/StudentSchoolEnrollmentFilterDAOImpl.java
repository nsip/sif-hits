package sif3.hits.domain.dao.filter.impl;

import org.springframework.stereotype.Repository;

import sif3.hits.domain.dao.filter.StudentSchoolEnrollmentFilterDAO;
import sif3.hits.domain.model.StudentSchoolEnrollment;

@Repository
public class StudentSchoolEnrollmentFilterDAOImpl extends BaseFilterableRepository<StudentSchoolEnrollment>implements StudentSchoolEnrollmentFilterDAO {
  public StudentSchoolEnrollmentFilterDAOImpl() {
    super(StudentSchoolEnrollment.class);
  }
}
