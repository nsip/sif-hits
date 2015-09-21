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
import sif3.hits.domain.dao.ZoneFilterableRepository;
import sif3.hits.domain.model.PurchaseOrder;

@Service
public class PurchaseOrderService extends BaseService<PurchaseOrderType, PurchaseOrderCollectionType, PurchaseOrder> {

  @Autowired
  private PurchaseOrderDAO purchaseOrderDAO;

  @Override
  public JpaRepository<PurchaseOrder, String> getDAO() {
    return purchaseOrderDAO;
  }

  @Override
  public ZoneFilterableRepository<PurchaseOrder> getZoneFilterableDAO() {
    return purchaseOrderDAO;
  }

  @Autowired
  private PurchaseOrderConverter locationInfoConverter;

  @Override
  public HitsConverter<PurchaseOrderType, PurchaseOrder> getConverter() {
    return locationInfoConverter;
  }

  @Override
  protected PurchaseOrderCollectionType getCollection(List<PurchaseOrderType> items) {
    PurchaseOrderCollectionType result = new PurchaseOrderCollectionType();
    if (items != null) {
      result.getPurchaseOrder().addAll(items);
    }
    return result;
  }

  @Override
  protected PurchaseOrder getFiltered(String refId, java.util.List<String> schoolRefIds) {
    PurchaseOrder result = null;
    if (schoolRefIds != null && !schoolRefIds.isEmpty()) {
      result = purchaseOrderDAO.findOneWithFilter(refId, schoolRefIds);
    }
    return result;
  }
}
