package sif3.hits.domain.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sif3.hits.domain.model.StudentDailyAttendance;

public interface StudentDailyAttendanceDAO extends JpaRepository<StudentDailyAttendance, String>,
    ZoneFilterableRepository<StudentDailyAttendance> {

  @Query("select distinct a from StudentDailyAttendance a where a.schoolInfoRefId in :schoolRefIds")
  @Override
  public Page<StudentDailyAttendance> findAllWithFilter(@Param("schoolRefIds") List<String> schoolRefIds,
      Pageable pageable);

  @Override
  @Query("select distinct a from StudentDailyAttendance a where a.schoolInfoRefId in :schoolRefIds and a.refId = :refId")
  public StudentDailyAttendance findOneWithFilter(@Param("refId") String refId,
      @Param("schoolRefIds") List<String> schoolRefIds);

  @Query("select distinct a from StudentDailyAttendance a where a.schoolInfoRefId in :schoolRefIds and a.studentPersonalRefId = :studentPersonalRefId")
  public Page<StudentDailyAttendance> findAllWithStudentPersonalAndFilter(
      @Param("studentPersonalRefId") String studentPersonalRefId, @Param("schoolRefIds") List<String> schoolRefIds,
      Pageable pageable);

  @Query("select distinct a from StudentDailyAttendance a where a.schoolInfoRefId in :schoolRefIds and a.schoolInfoRefId = :schoolInfoRefId")
  public Page<StudentDailyAttendance> findAllWithSchoolInfoAndFilter(@Param("schoolInfoRefId") String schoolInfoRefId,
      @Param("schoolRefIds") List<String> schoolRefIds, Pageable pageable);

  @Query("select distinct a from StudentDailyAttendance a where a.schoolInfoRefId in :schoolRefIds and a.studentPersonalRefId = :studentPersonalRefId and a.schoolInfoRefId = :schoolInfoRefId")
  public Page<StudentDailyAttendance> findAllWithSchoolInfoAndStudentPersonalAndFilter(
      @Param("studentPersonalRefId") String studentPersonalRefId, @Param("schoolInfoRefId") String schoolInfoRefId,
      @Param("schoolRefIds") List<String> schoolRefIds, Pageable pageable);

}
