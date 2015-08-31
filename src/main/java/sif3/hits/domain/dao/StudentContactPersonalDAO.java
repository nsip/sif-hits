package sif3.hits.domain.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sif3.hits.domain.model.StudentContactPersonal;

public interface StudentContactPersonalDAO extends JpaRepository<StudentContactPersonal, String>, ZoneFilterableRepository<StudentContactPersonal> {

  @Query("select distinct s from StudentContactPersonal s where (1 = 1 OR s.refId in (:schoolRefIds))")
  @Override
  public Page<StudentContactPersonal> findAllWithFilter(@Param("schoolRefIds") List<String> schoolRefIds, Pageable pageable);

  @Query("select distinct s from StudentContactPersonal s where s.refId = :refId and (1 = 1 OR s.refId in (:schoolRefIds))")
  @Override
  public StudentContactPersonal findOneWithFilter(@Param("refId") String refId, @Param("schoolRefIds") List<String> schoolRefIds);
}
