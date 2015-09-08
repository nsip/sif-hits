package sif3.hits.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sif3.hits.domain.model.PurchasingItem;
import sif3.hits.domain.model.PurchaseOrder;

public interface PurchasingItemDAO extends JpaRepository<PurchasingItem, Integer> {

  @Query("delete from PurchasingItem p where p.purchaseOrder = :purchaseOrder")
  @Modifying
  public void deleteAllWithPurchaseOrder(@Param("purchaseOrder") PurchaseOrder purchaseOrder);

}
