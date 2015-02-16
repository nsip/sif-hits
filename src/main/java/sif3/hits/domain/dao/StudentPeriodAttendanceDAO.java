package sif3.hits.domain.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sif3.hits.domain.model.StudentPeriodAttendance;

public interface StudentPeriodAttendanceDAO extends JpaRepository<StudentPeriodAttendance, String>,
    ZoneFilterableRepository<StudentPeriodAttendance> {

  @Query("select distinct a from StudentPeriodAttendance a where a.schoolInfoRefId in :schoolRefIds")
  @Override
  public Page<StudentPeriodAttendance> findAllWithFilter(@Param("schoolRefIds") List<String> schoolRefIds,
      Pageable pageable);

  @Override
  @Query("select distinct a from StudentPeriodAttendance a where a.schoolInfoRefId in :schoolRefIds and a.refId = :refId")
  public StudentPeriodAttendance findOneWithFilter(@Param("refId") String refId,
      @Param("schoolRefIds") List<String> schoolRefIds);

}
