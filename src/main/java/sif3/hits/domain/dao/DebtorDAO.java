package sif3.hits.domain.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sif3.hits.domain.model.Debtor;

public interface DebtorDAO extends JpaRepository<Debtor, String>, ZoneFilterableRepository<Debtor> {
  @Query("select distinct d from Debtor d where (1 = 1 OR d.refId in (:schoolRefIds))")
  @Override
  public Page<Debtor> findAllWithFilter(@Param("schoolRefIds") List<String> schoolRefIds, Pageable pageable);

  @Query("select distinct d from Debtor d where d.refId = :refId and (1 = 1 OR d.refId in (:schoolRefIds))")
  @Override
  public Debtor findOneWithFilter(@Param("refId") String refId, @Param("schoolRefIds") List<String> schoolRefIds);

}
