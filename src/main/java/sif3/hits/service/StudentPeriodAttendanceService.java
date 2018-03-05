package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.StudentPeriodAttendanceCollectionType;
import sif.dd.au30.model.StudentPeriodAttendanceType;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.StudentPeriodAttendanceConverter;
import sif3.hits.domain.dao.StudentPeriodAttendanceDAO;
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.dao.filter.StudentPeriodAttendanceFilterDAO;
import sif3.hits.domain.model.StudentPeriodAttendance;

@Service
public class StudentPeriodAttendanceService extends BaseService<StudentPeriodAttendanceType, StudentPeriodAttendanceCollectionType, StudentPeriodAttendance> {

  @Autowired
  private StudentPeriodAttendanceConverter studentPeriodAttendanceConverter;

  @Autowired
  private StudentPeriodAttendanceDAO studentPeriodAttendanceDAO;

  @Autowired
  private StudentPeriodAttendanceFilterDAO studentPeriodAttendanceFilterDAO;

  @Override
  protected StudentPeriodAttendanceCollectionType getCollection(List<StudentPeriodAttendanceType> items) {
    StudentPeriodAttendanceCollectionType result = new StudentPeriodAttendanceCollectionType();
    if (items != null) {
      result.getStudentPeriodAttendance().addAll(items);
    }
    return result;
  }

  @Override
  protected HitsConverter<StudentPeriodAttendanceType, StudentPeriodAttendance> getConverter() {
    return studentPeriodAttendanceConverter;
  }

  @Override
  protected JpaRepository<StudentPeriodAttendance, String> getDAO() {
    return studentPeriodAttendanceDAO;
  }

  @Override
  protected FilterableRepository<StudentPeriodAttendance,StudentPeriodAttendanceType> getFilterableDAO() {
    return studentPeriodAttendanceFilterDAO;
  }

}
