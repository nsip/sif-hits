package sif3.hits.domain.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sif3.hits.domain.model.PurchaseOrder;

public interface PurchaseOrderDAO extends JpaRepository<PurchaseOrder, String>, ZoneFilterableRepository<PurchaseOrder> {
  @Query("select distinct p from PurchaseOrder p where (1 = 1 OR p.refId in (:schoolRefIds))")
  @Override
  public Page<PurchaseOrder> findAllWithFilter(@Param("schoolRefIds") List<String> schoolRefIds, Pageable pageable);

  @Query("select distinct p from PurchaseOrder p where p.refId = :refId and (1 = 1 OR p.refId in (:schoolRefIds))")
  @Override
  public PurchaseOrder findOneWithFilter(@Param("refId") String refId, @Param("schoolRefIds") List<String> schoolRefIds);
}
