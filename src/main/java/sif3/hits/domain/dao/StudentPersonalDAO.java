package sif3.hits.domain.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sif3.hits.domain.model.StudentPersonal;

public interface StudentPersonalDAO extends JpaRepository<StudentPersonal, String>,
    ZoneFilterableRepository<StudentPersonal> {

  @Query("select s from StudentPersonal s where s.schoolInfoRefId in :schoolRefIds")
  @Override
  public Page<StudentPersonal> findAllWithFilter(@Param("schoolRefIds") List<String> schoolRefIds, Pageable pageable);
  
  @Override
  @Query("select s from StudentPersonal s where s.refId = :refId and s.schoolInfoRefId in :schoolRefIds")
  public StudentPersonal findOneWithFilter(@Param("refId") String refId, @Param("schoolRefIds") List<String> schoolRefIds);
}
