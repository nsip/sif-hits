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
import sif3.hits.domain.dao.StudentAttendanceTimeDAO;
import sif3.hits.domain.dao.StudentAttendanceTimeListDAO;
import sif3.hits.domain.dao.StudentAttendanceTimeOtherCodeDAO;
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.dao.filter.StudentAttendanceTimeListFilterDAO;
import sif3.hits.domain.model.StudentAttendanceTime;
import sif3.hits.domain.model.StudentAttendanceTimeList;
import sif3.hits.domain.model.StudentAttendanceTimeOtherCode;
import sif3.hits.rest.dto.RequestDTO;

@Service
public class StudentAttendanceTimeListService extends BaseService<StudentAttendanceTimeListType, StudentAttendanceTimeListCollectionType, StudentAttendanceTimeList> {

  @Autowired
  private StudentAttendanceTimeListConverter studentAttendanceTimeListConverter;

  @Autowired
  private StudentAttendanceTimeListDAO studentAttendanceTimeListDAO;

  @Autowired
  private StudentAttendanceTimeListFilterDAO studentAttendanceTimeListFilterDAO;

  @Autowired
  private StudentAttendanceTimeOtherCodeDAO studentAttendanceTimeOtherCodeDAO;

  @Autowired
  private StudentAttendanceTimeDAO studentAttendanceTimeDAO;

  @Override
  protected StudentAttendanceTimeListCollectionType getCollection(List<StudentAttendanceTimeListType> items) {
    StudentAttendanceTimeListCollectionType result = new StudentAttendanceTimeListCollectionType();
    if (items != null) {
      result.getStudentAttendanceTimeList().addAll(items);
    }
    return result;
  }

  @Override
  protected HitsConverter<StudentAttendanceTimeListType, StudentAttendanceTimeList> getConverter() {
    return studentAttendanceTimeListConverter;
  }

  @Override
  protected JpaRepository<StudentAttendanceTimeList, String> getDAO() {
    return studentAttendanceTimeListDAO;
  }

  @Override
  protected FilterableRepository<StudentAttendanceTimeList> getFilterableDAO() {
    return studentAttendanceTimeListFilterDAO;
  }

  @Override
  protected void deleteChildObjects(StudentAttendanceTimeList hitsObject) {
    studentAttendanceTimeOtherCodeDAO.deleteAllWithStudentAttendanceTimeList(hitsObject);
    studentAttendanceTimeDAO.deleteAllWithStudentAttendanceTimeList(hitsObject);
  }

  @Override
  protected boolean hasChildObjects(StudentAttendanceTimeList hitsObject) {
    return hitsObject != null && hitsObject.getAttendanceTimes() != null && !hitsObject.getAttendanceTimes().isEmpty();
  }

  @Override
  protected StudentAttendanceTimeList saveWithChildObjects(StudentAttendanceTimeList hitsObject, RequestDTO<StudentAttendanceTimeListType> dto, String zoneId, boolean create) {
    StudentAttendanceTimeList result = null;
    Set<StudentAttendanceTime> attendanceTimes = new HashSet<StudentAttendanceTime>();
    attendanceTimes.addAll(hitsObject.getAttendanceTimes());
    hitsObject.getAttendanceTimes().clear();
    result = super.saveWithChildObjects(hitsObject, dto, zoneId, create);

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
    return result;
  }
}
