package sif3.hits.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sif3.hits.domain.model.StudentAttendanceTimeList;
import sif3.hits.domain.model.StudentAttendanceTimeOtherCode;
import sif3.hits.domain.model.StudentAttendanceTimeOtherCodeId;

public interface StudentAttendanceTimeOtherCodeDAO extends
    JpaRepository<StudentAttendanceTimeOtherCode, StudentAttendanceTimeOtherCodeId> {
  @Query("delete from StudentAttendanceTimeOtherCode a where a.studentAttendanceTimeOtherCodeId.studentAttendanceTime.studentAttendanceTimeId.studentAttendanceTimeList = :studentAttendanceTimeList")
  @Modifying
  public void deleteAllWithStudentAttendanceTimeList(
      @Param("studentAttendanceTimeList") StudentAttendanceTimeList studentAttendanceTimeList);
}
