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
import sif3.hits.domain.dao.ZoneFilterableRepository;
import sif3.hits.domain.model.StudentPeriodAttendance;

@Service
public class StudentPeriodAttendanceService extends
    BaseService<StudentPeriodAttendanceType, StudentPeriodAttendanceCollectionType, StudentPeriodAttendance> {

  @Autowired
  private StudentPeriodAttendanceDAO studentPeriodAttendanceDAO;

  @Override
  public JpaRepository<StudentPeriodAttendance, String> getDAO() {
    return studentPeriodAttendanceDAO;
  }

  @Override
  public ZoneFilterableRepository<StudentPeriodAttendance> getZoneFilterableDAO() {
    return studentPeriodAttendanceDAO;
  }

  @Autowired
  private StudentPeriodAttendanceConverter studentPeriodAttendanceConverter;

  @Override
  public HitsConverter<StudentPeriodAttendanceType, StudentPeriodAttendance> getConverter() {
    return studentPeriodAttendanceConverter;
  }

  @Override
  protected StudentPeriodAttendanceCollectionType getCollection(List<StudentPeriodAttendanceType> items) {
    StudentPeriodAttendanceCollectionType result = new StudentPeriodAttendanceCollectionType();
    if (items != null) {
      result.getStudentPeriodAttendance().addAll(items);
    }
    return result;
  }

  @Override
  protected StudentPeriodAttendance getFiltered(String refId, java.util.List<String> schoolRefIds) {
    StudentPeriodAttendance result = null;
    if (schoolRefIds != null && !schoolRefIds.isEmpty()) {
      result = studentPeriodAttendanceDAO.findOneWithFilter(refId, schoolRefIds);
    }
    return result;
  }
}
