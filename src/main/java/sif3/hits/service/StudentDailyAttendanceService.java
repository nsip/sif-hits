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
import sif3.hits.domain.dao.ZoneFilterableRepository;
import sif3.hits.domain.model.StudentDailyAttendance;

@Service
public class StudentDailyAttendanceService extends
    BaseService<StudentDailyAttendanceType, StudentDailyAttendanceCollectionType, StudentDailyAttendance> {

  @Autowired
  private StudentDailyAttendanceDAO studentDailyAttendanceDAO;

  @Override
  public JpaRepository<StudentDailyAttendance, String> getDAO() {
    return studentDailyAttendanceDAO;
  }

  @Override
  public ZoneFilterableRepository<StudentDailyAttendance> getZoneFilterableDAO() {
    return studentDailyAttendanceDAO;
  }

  @Autowired
  private StudentDailyAttendanceConverter studentDailyAttendanceConverter;

  @Override
  public HitsConverter<StudentDailyAttendanceType, StudentDailyAttendance> getConverter() {
    return studentDailyAttendanceConverter;
  }

  @Override
  protected StudentDailyAttendanceCollectionType getCollection(List<StudentDailyAttendanceType> items) {
    StudentDailyAttendanceCollectionType result = new StudentDailyAttendanceCollectionType();
    if (items != null) {
      result.getStudentDailyAttendance().addAll(items);
    }
    return result;
  }

  @Override
  protected StudentDailyAttendance getFiltered(String refId, java.util.List<String> schoolRefIds) {
    StudentDailyAttendance result = null;
    if (schoolRefIds != null && !schoolRefIds.isEmpty()) {
      result = studentDailyAttendanceDAO.findOneWithFilter(refId, schoolRefIds);
    }
    return result;
  }
}
