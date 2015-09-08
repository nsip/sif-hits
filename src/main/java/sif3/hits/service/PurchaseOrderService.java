package sif3.hits.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.PurchaseOrderCollectionType;
import sif.dd.au30.model.PurchaseOrderType;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.PurchaseOrderConverter;
import sif3.hits.domain.dao.ExpenseAccountDAO;
import sif3.hits.domain.dao.PurchaseOrderDAO;
import sif3.hits.domain.dao.PurchasingItemDAO;
import sif3.hits.domain.dao.ZoneFilterableRepository;
import sif3.hits.domain.model.ExpenseAccount;
import sif3.hits.domain.model.PurchaseOrder;
import sif3.hits.domain.model.PurchasingItem;
import sif3.hits.rest.dto.RequestDTO;

@Service
public class PurchaseOrderService extends BaseService<PurchaseOrderType, PurchaseOrderCollectionType, PurchaseOrder> {

  @Autowired
  private PurchaseOrderDAO purchaseOrderDAO;

  @Autowired
  private PurchasingItemDAO purchasingItemDAO;
  
  @Autowired
  private ExpenseAccountDAO expenseAccountDAO;

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

  @Override
  protected void delete(PurchaseOrder hitsObject, RequestDTO<PurchaseOrderType> dto) {
    deleteChildren(hitsObject);
    super.delete(hitsObject, dto);
  }

  private void deleteChildren(PurchaseOrder hitsObject) {
//    expenseAccountDAO.deleteAllWithPurchaseOrder(hitsObject);
//    purchasingItemDAO.deleteAllWithPurchaseOrder(hitsObject);
  }

  @Override
  protected PurchaseOrder save(PurchaseOrder hitsObject, RequestDTO<PurchaseOrderType> dto, String zoneId, boolean create) {
    PurchaseOrder result = null;
    if (!create) {
      deleteChildren(hitsObject);
    }
    if (hitsObject.getPurchasingItems() != null && !hitsObject.getPurchasingItems().isEmpty()) {
      Set<PurchasingItem> savedItems = new HashSet<PurchasingItem>();
      Set<PurchasingItem> purchasingItems = new HashSet<PurchasingItem>(hitsObject.getPurchasingItems());
      hitsObject.getPurchasingItems().clear();
      result = super.save(hitsObject, dto, zoneId, create);
      for (PurchasingItem purchasingItem : purchasingItems) {
        ExpenseAccount expenseAccount = purchasingItem.getExpenseAccount();
        purchasingItem.setExpenseAccount(null);
        purchasingItem.setPurchaseOrder(result);
        purchasingItem = purchasingItemDAO.save(purchasingItem);
        
        expenseAccount.setPurchasingItem(purchasingItem);
        expenseAccount = expenseAccountDAO.save(expenseAccount);
        
        purchasingItem.setExpenseAccount(expenseAccount);
        savedItems.add(purchasingItem);
      }
      result.setPurchasingItems(savedItems);
    } else {
      result = super.save(hitsObject, dto, zoneId, create);
    }
    return result;
  }
}
