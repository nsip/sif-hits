package sif3.hits.domain.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sif3.hits.domain.model.FinancialAccount;

public interface FinancialAccountDAO extends JpaRepository<FinancialAccount, String>, ZoneFilterableRepository<FinancialAccount> {
  @Query("select distinct f from FinancialAccount f where (1 = 1 OR f.refId in (:schoolRefIds))")
  @Override
  public Page<FinancialAccount> findAllWithFilter(@Param("schoolRefIds") List<String> schoolRefIds, Pageable pageable);

  @Query("select distinct f from FinancialAccount f where f.refId = :refId and (1 = 1 OR f.refId in (:schoolRefIds))")
  @Override
  public FinancialAccount findOneWithFilter(@Param("refId") String refId, @Param("schoolRefIds") List<String> schoolRefIds);

}
