package sif3.hits.domain.dao.filter.impl;

import org.springframework.stereotype.Repository;

import sif3.hits.domain.dao.filter.PurchaseOrderFilterDAO;
import sif3.hits.domain.model.PurchaseOrder;

@Repository
public class PurchaseOrderFilterDAOImpl extends BaseFilterableRepository<PurchaseOrder>implements PurchaseOrderFilterDAO {
  public PurchaseOrderFilterDAOImpl() {
    super(PurchaseOrder.class);
  }
}
