package sif3.hits.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.StudentAttendanceTimeListCollectionType;
import sif.dd.au30.model.StudentAttendanceTimeListType;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.StudentAttendanceTimeListConverter;
import sif3.hits.domain.dao.SchoolInfoDAO;
import sif3.hits.domain.dao.StudentAttendanceTimeDAO;
import sif3.hits.domain.dao.StudentAttendanceTimeListDAO;
import sif3.hits.domain.dao.StudentAttendanceTimeOtherCodeDAO;
import sif3.hits.domain.dao.ZoneFilterableRepository;
import sif3.hits.domain.model.StudentAttendanceTime;
import sif3.hits.domain.model.StudentAttendanceTimeList;
import sif3.hits.domain.model.StudentAttendanceTimeOtherCode;
import sif3.hits.rest.dto.RequestDTO;

@Service
public class StudentAttendanceTimeListService extends
    BaseService<StudentAttendanceTimeListType, StudentAttendanceTimeListCollectionType, StudentAttendanceTimeList> {

  @Autowired
  private StudentAttendanceTimeListDAO studentAttendanceTimeListDAO;

  @Autowired
  private StudentAttendanceTimeDAO studentAttendanceTimeDAO;

  @Autowired
  private StudentAttendanceTimeOtherCodeDAO studentAttendanceTimeOtherCodeDAO;

  @Autowired
  private SchoolInfoDAO schoolInfoDAO;

  @Override
  public JpaRepository<StudentAttendanceTimeList, String> getDAO() {
    return studentAttendanceTimeListDAO;
  }

  @Override
  public ZoneFilterableRepository<StudentAttendanceTimeList> getZoneFilterableDAO() {
    return studentAttendanceTimeListDAO;
  }

  @Autowired
  private StudentAttendanceTimeListConverter studentAttendanceTimeListConverter;

  @Override
  public HitsConverter<StudentAttendanceTimeListType, StudentAttendanceTimeList> getConverter() {
    return studentAttendanceTimeListConverter;
  }

  @Override
  protected StudentAttendanceTimeListCollectionType getCollection(List<StudentAttendanceTimeListType> items) {
    StudentAttendanceTimeListCollectionType result = new StudentAttendanceTimeListCollectionType();
    if (items != null) {
      result.getStudentAttendanceTimeList().addAll(items);
    }
    return result;
  }

  @Override
  protected StudentAttendanceTimeList getFiltered(String refId, java.util.List<String> schoolRefIds) {
    StudentAttendanceTimeList result = null;
    if (schoolRefIds != null && !schoolRefIds.isEmpty()) {
      result = getZoneFilterableDAO().findOneWithFilter(refId, schoolRefIds);
    }
    return result;
  }

  @Override
  protected void delete(StudentAttendanceTimeList hitsObject, RequestDTO<StudentAttendanceTimeListType> dto) {
    deleteOtherCodes(hitsObject);
    super.delete(hitsObject, dto);
  }

  private void deleteOtherCodes(StudentAttendanceTimeList hitsObject) {
    studentAttendanceTimeOtherCodeDAO.deleteAllWithStudentAttendanceTimeList(hitsObject);
    studentAttendanceTimeDAO.deleteAllWithStudentAttendanceTimeList(hitsObject);
  }

  @Override
  protected StudentAttendanceTimeList save(StudentAttendanceTimeList hitsObject,
      RequestDTO<StudentAttendanceTimeListType> dto, String zoneId, boolean create) {
    StudentAttendanceTimeList result = null;
    if (!create) {
      deleteOtherCodes(hitsObject);
    }
    if (hitsObject.getAttendanceTimes() != null && !hitsObject.getAttendanceTimes().isEmpty()) {
      Set<StudentAttendanceTime> attendanceTimes = new HashSet<StudentAttendanceTime>();
      attendanceTimes.addAll(hitsObject.getAttendanceTimes());
      hitsObject.getAttendanceTimes().clear();
      result = super.save(hitsObject, dto, zoneId, create);

      for (StudentAttendanceTime attendanceTime : attendanceTimes) {
        if (attendanceTime.getOtherCodes() != null && !attendanceTime.getOtherCodes().isEmpty()) {
          Set<StudentAttendanceTimeOtherCode> otherCodes = new HashSet<StudentAttendanceTimeOtherCode>();
          otherCodes.addAll(attendanceTime.getOtherCodes());
          attendanceTime.getOtherCodes().clear();
          attendanceTime.setStudentAttendanceTimeList(hitsObject);
          studentAttendanceTimeDAO.save(attendanceTime);
          
          for (StudentAttendanceTimeOtherCode otherCode : otherCodes) {
            otherCode.setStudentAttendanceTime(attendanceTime);
            studentAttendanceTimeOtherCodeDAO.save(otherCode);
          }
          attendanceTime.setOtherCodes(otherCodes);
        } else {
          studentAttendanceTimeDAO.save(attendanceTime);
        }
      }
      result.setAttendanceTimes(attendanceTimes);
    } else {
      result = super.save(hitsObject, dto, zoneId, create);
    }
    return result;
  }
}
