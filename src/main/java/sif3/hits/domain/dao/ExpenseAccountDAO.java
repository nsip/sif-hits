package sif3.hits.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sif3.hits.domain.model.ExpenseAccount;
import sif3.hits.domain.model.PurchaseOrder;

public interface ExpenseAccountDAO extends JpaRepository<ExpenseAccount, Integer> {
  @Query("delete from ExpenseAccount e where e.purchasingItem in (select i from PurchaseOrder p join p.purchasingItems i where p = :purchaseOrder)")
  @Modifying
  public void deleteAllWithPurchaseOrder(@Param("purchaseOrder") PurchaseOrder purchaseOrder);

}
