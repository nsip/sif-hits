package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.StudentDailyAttendanceCollectionType;
import sif.dd.au30.model.StudentDailyAttendanceType;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.StudentDailyAttendanceConverter;
import sif3.hits.domain.dao.StudentDailyAttendanceDAO;
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.dao.filter.StudentDailyAttendanceFilterDAO;
import sif3.hits.domain.model.StudentDailyAttendance;

@Service
public class StudentDailyAttendanceService extends BaseService<StudentDailyAttendanceType, StudentDailyAttendanceCollectionType, StudentDailyAttendance> {

  @Autowired
  private StudentDailyAttendanceConverter studentDailyAttendanceConverter;

  @Autowired
  private StudentDailyAttendanceDAO studentDailyAttendanceDAO;

  @Autowired
  private StudentDailyAttendanceFilterDAO studentDailyAttendanceFilterDAO;

  @Override
  protected StudentDailyAttendanceCollectionType getCollection(List<StudentDailyAttendanceType> items) {
    StudentDailyAttendanceCollectionType result = new StudentDailyAttendanceCollectionType();
    if (items != null) {
      result.getStudentDailyAttendance().addAll(items);
    }
    return result;
  }

  @Override
  protected HitsConverter<StudentDailyAttendanceType, StudentDailyAttendance> getConverter() {
    return studentDailyAttendanceConverter;
  }

  @Override
  protected JpaRepository<StudentDailyAttendance, String> getDAO() {
    return studentDailyAttendanceDAO;
  }

  @Override
  protected FilterableRepository<StudentDailyAttendance,StudentDailyAttendanceType> getFilterableDAO() {
    return studentDailyAttendanceFilterDAO;
  }

}
