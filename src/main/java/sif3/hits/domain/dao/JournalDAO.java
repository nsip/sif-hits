package sif3.hits.domain.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sif3.hits.domain.model.Journal;

public interface JournalDAO extends JpaRepository<Journal, String>, ZoneFilterableRepository<Journal> {
  @Query("select distinct j from Journal j where (1 = 1 OR j.refId in (:schoolRefIds))")
  @Override
  public Page<Journal> findAllWithFilter(@Param("schoolRefIds") List<String> schoolRefIds, Pageable pageable);

  @Query("select distinct j from Journal j where j.refId = :refId and (1 = 1 OR j.refId in (:schoolRefIds))")
  @Override
  public Journal findOneWithFilter(@Param("refId") String refId, @Param("schoolRefIds") List<String> schoolRefIds);
}
