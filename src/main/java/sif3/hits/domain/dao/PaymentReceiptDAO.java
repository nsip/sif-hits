package sif3.hits.domain.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sif3.hits.domain.model.PaymentReceipt;

public interface PaymentReceiptDAO extends JpaRepository<PaymentReceipt, String>, ZoneFilterableRepository<PaymentReceipt> {
  @Query("select distinct p from PaymentReceipt p where (1 = 1 OR p.refId in (:schoolRefIds))")
  @Override
  public Page<PaymentReceipt> findAllWithFilter(@Param("schoolRefIds") List<String> schoolRefIds, Pageable pageable);

  @Query("select distinct p from PaymentReceipt p where p.refId = :refId and (1 = 1 OR p.refId in (:schoolRefIds))")
  @Override
  public PaymentReceipt findOneWithFilter(@Param("refId") String refId, @Param("schoolRefIds") List<String> schoolRefIds);
}
