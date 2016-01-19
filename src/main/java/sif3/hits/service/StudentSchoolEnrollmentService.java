package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.StudentSchoolEnrollmentCollectionType;
import sif.dd.au30.model.StudentSchoolEnrollmentType;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.StudentSchoolEnrollmentConverter;
import sif3.hits.domain.dao.StudentSchoolEnrollmentDAO;
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.dao.filter.StudentSchoolEnrollmentFilterDAO;
import sif3.hits.domain.model.StudentSchoolEnrollment;

@Service
public class StudentSchoolEnrollmentService extends BaseService<StudentSchoolEnrollmentType, StudentSchoolEnrollmentCollectionType, StudentSchoolEnrollment> {

  @Autowired
  private StudentSchoolEnrollmentConverter studentSchoolEnrollmentConverter;

  @Autowired
  private StudentSchoolEnrollmentDAO studentSchoolEnrollmentDAO;

  @Autowired
  private StudentSchoolEnrollmentFilterDAO studentSchoolEnrollmentFilterDAO;

  @Override
  protected StudentSchoolEnrollmentCollectionType getCollection(List<StudentSchoolEnrollmentType> items) {
    StudentSchoolEnrollmentCollectionType result = new StudentSchoolEnrollmentCollectionType();
    if (items != null && !items.isEmpty()) {
      result.getStudentSchoolEnrollment().addAll(items);
    }
    return result;
  }

  @Override
  protected HitsConverter<StudentSchoolEnrollmentType, StudentSchoolEnrollment> getConverter() {
    return studentSchoolEnrollmentConverter;
  }

  @Override
  protected JpaRepository<StudentSchoolEnrollment, String> getDAO() {
    return studentSchoolEnrollmentDAO;
  }

  @Override
  protected FilterableRepository<StudentSchoolEnrollment> getFilterableDAO() {
    return studentSchoolEnrollmentFilterDAO;
  }
}
