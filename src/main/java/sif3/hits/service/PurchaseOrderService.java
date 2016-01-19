package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.PurchaseOrderCollectionType;
import sif.dd.au30.model.PurchaseOrderType;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.PurchaseOrderConverter;
import sif3.hits.domain.dao.PurchaseOrderDAO;
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.dao.filter.PurchaseOrderFilterDAO;
import sif3.hits.domain.model.PurchaseOrder;

@Service
public class PurchaseOrderService extends BaseService<PurchaseOrderType, PurchaseOrderCollectionType, PurchaseOrder> {

  @Autowired
  private PurchaseOrderConverter purchaseOrderConverter;

  @Autowired
  private PurchaseOrderDAO purchaseOrderDAO;

  @Autowired
  private PurchaseOrderFilterDAO purchaseOrderFilterDAO;

  @Override
  protected PurchaseOrderCollectionType getCollection(List<PurchaseOrderType> items) {
    PurchaseOrderCollectionType result = new PurchaseOrderCollectionType();
    if (items != null) {
      result.getPurchaseOrder().addAll(items);
    }
    return result;
  }

  @Override
  protected HitsConverter<PurchaseOrderType, PurchaseOrder> getConverter() {
    return purchaseOrderConverter;
  }

  @Override
  protected JpaRepository<PurchaseOrder, String> getDAO() {
    return purchaseOrderDAO;
  }

  @Override
  protected FilterableRepository<PurchaseOrder> getFilterableDAO() {
    return purchaseOrderFilterDAO;
  }

}
