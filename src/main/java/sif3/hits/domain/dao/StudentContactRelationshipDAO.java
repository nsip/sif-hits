package sif3.hits.domain.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sif3.hits.domain.model.StudentContactRelationship;

public interface StudentContactRelationshipDAO extends JpaRepository<StudentContactRelationship, String>, ZoneFilterableRepository<StudentContactRelationship> {

  @Query("select distinct s from StudentContactRelationship s where (1 = 1 OR s.refId in (:schoolRefIds))")
  @Override
  public Page<StudentContactRelationship> findAllWithFilter(@Param("schoolRefIds") List<String> schoolRefIds, Pageable pageable);

  @Query("select distinct s from StudentContactRelationship s where s.refId = :refId and (1 = 1 OR s.refId in (:schoolRefIds))")
  @Override
  public StudentContactRelationship findOneWithFilter(@Param("refId") String refId, @Param("schoolRefIds") List<String> schoolRefIds);
}
