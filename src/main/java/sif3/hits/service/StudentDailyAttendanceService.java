package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.StudentDailyAttendanceCollectionType;
import sif.dd.au30.model.StudentDailyAttendanceType;
import sif3.common.exception.UnsupportedQueryException;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.StudentDailyAttendanceConverter;
import sif3.hits.domain.dao.StudentDailyAttendanceDAO;
import sif3.hits.domain.dao.ZoneFilterableRepository;
import sif3.hits.domain.model.StudentDailyAttendance;
import sif3.hits.rest.dto.KeyValuePair;

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

  @Override
  protected Page<StudentDailyAttendance> findByServicePath(List<KeyValuePair> filters, List<String> schoolRefIds,
      PageRequest pageRequest) throws UnsupportedQueryException {

    String studentPersonalRefId = null;
    String schoolInfoRefId = null;

    if (filters != null) {
      for (KeyValuePair filter : filters) {
        if (filter != null && "StudentPersonals".equals(filter.getKey()) && studentPersonalRefId == null) {
          studentPersonalRefId = filter.getValue();
        } else if (filter != null && "SchoolInfos".equals(filter.getKey()) && schoolInfoRefId == null) {
          schoolInfoRefId = filter.getValue();
        } else if (filter != null
            && ("StudentPersonals".equals(filter.getKey()) || "SchoolInfos".equals(filter.getKey()))) {
          throw new UnsupportedQueryException("Invalid service path query - each key can appear only once.");
        }
      }
    }

    if (studentPersonalRefId != null && schoolInfoRefId != null) {
      return studentDailyAttendanceDAO.findAllWithSchoolInfoAndStudentPersonalAndFilter(studentPersonalRefId,
          schoolInfoRefId, schoolRefIds, pageRequest);
    } else if (studentPersonalRefId != null) {
      return studentDailyAttendanceDAO.findAllWithStudentPersonalAndFilter(studentPersonalRefId, schoolRefIds,
          pageRequest);
    } else if (schoolInfoRefId != null) {
      return studentDailyAttendanceDAO.findAllWithSchoolInfoAndFilter(schoolInfoRefId, schoolRefIds, pageRequest);
    } else {
      return super.findByServicePath(filters, schoolRefIds, pageRequest);
    }
  }
}
