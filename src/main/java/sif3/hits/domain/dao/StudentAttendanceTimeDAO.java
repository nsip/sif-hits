package sif3.hits.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sif3.hits.domain.model.StudentAttendanceTime;
import sif3.hits.domain.model.StudentAttendanceTimeId;
import sif3.hits.domain.model.StudentAttendanceTimeList;

public interface StudentAttendanceTimeDAO extends JpaRepository<StudentAttendanceTime, StudentAttendanceTimeId> {
  @Query("delete from StudentAttendanceTime a where a.studentAttendanceTimeId.studentAttendanceTimeList = :studentAttendanceTimeList")
  @Modifying
  public void deleteAllWithStudentAttendanceTimeList(
      @Param("studentAttendanceTimeList") StudentAttendanceTimeList studentAttendanceTimeList);
}
