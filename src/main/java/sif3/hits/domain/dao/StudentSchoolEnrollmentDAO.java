package sif3.hits.domain.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sif3.hits.domain.model.StudentSchoolEnrollment;

public interface StudentSchoolEnrollmentDAO extends JpaRepository<StudentSchoolEnrollment, String>,
    ZoneFilterableRepository<StudentSchoolEnrollment> {

  @Query("select s from StudentSchoolEnrollment s where s.schoolInfoRefId in :schoolRefIds")
  @Override
  public Page<StudentSchoolEnrollment> findAllWithFilter(@Param("schoolRefIds") List<String> schoolRefIds,
      Pageable pageable);

  @Query("select s from StudentSchoolEnrollment s where s.refId = :refId and s.schoolInfoRefId in :schoolRefIds")
  @Override
  public StudentSchoolEnrollment findOneWithFilter(@Param("refId") String refId,
      @Param("schoolRefIds") List<String> schoolRefIds);
}
