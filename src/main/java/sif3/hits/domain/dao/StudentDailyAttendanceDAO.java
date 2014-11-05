package sif3.hits.domain.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sif3.hits.domain.model.StudentDailyAttendance;

public interface StudentDailyAttendanceDAO extends JpaRepository<StudentDailyAttendance, String>, ZoneFilterableRepository<StudentDailyAttendance> {

  @Query("select distinct a from StudentDailyAttendance a where a.schoolInfoRefId in :schoolRefIds")
  @Override
  public Page<StudentDailyAttendance> findAllWithFilter(@Param("schoolRefIds") List<String> schoolRefIds, Pageable pageable);

  @Override
  @Query("select distinct a from StudentDailyAttendance a where a.schoolInfoRefId in :schoolRefIds and a.refId = :refId")
  public StudentDailyAttendance findOneWithFilter(@Param("refId") String refId, @Param("schoolRefIds") List<String> schoolRefIds);
}
