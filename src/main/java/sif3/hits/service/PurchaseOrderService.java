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
import sif3.hits.domain.dao.PurchaseOrderDAO;
import sif3.hits.domain.dao.PurchasingItemDAO;
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.dao.filter.PurchaseOrderFilterDAO;
import sif3.hits.domain.model.ExpenseAccount;
import sif3.hits.domain.model.PurchaseOrder;
import sif3.hits.domain.model.PurchasingItem;
import sif3.hits.rest.dto.RequestDTO;

@Service
public class PurchaseOrderService extends BaseService<PurchaseOrderType, PurchaseOrderCollectionType, PurchaseOrder> {

  @Autowired
  private PurchaseOrderConverter purchaseOrderConverter;

  @Autowired
  private PurchaseOrderDAO purchaseOrderDAO;
  
  @Autowired
  private PurchasingItemDAO purchasingItemDAO;
  
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
  
//  @Override
//  protected boolean hasChildObjects(PurchaseOrder hitsObject) {
//    return true;
//  }
//  
//  @Override
//  protected PurchaseOrder saveWithChildObjects(PurchaseOrder hitsObject, RequestDTO<PurchaseOrderType> dto, String zoneId, boolean create) {
//    // Hibernate 4 changed the way this works, no longer generates id on child objects.
//    Set<PurchasingItem> purchasingItems = new HashSet<PurchasingItem>();
//    if (hitsObject != null) {
//      if (hitsObject.getPurchasingItems() != null) {
//        for (PurchasingItem purchasingItem : hitsObject.getPurchasingItems()) {
//          if (purchasingItem.getExpenseAccount() != null) {
//            ExpenseAccount expenseAccount = purchasingItem.getExpenseAccount(); 
//            purchasingItem.setExpenseAccount(null);
//            PurchasingItem savedItem = purchasingItemDAO.save(purchasingItem);
//            savedItem.setExpenseAccount(expenseAccount);
//            expenseAccount.setPurchasingItem(savedItem);
//            purchasingItems.add(purchasingItemDAO.save(purchasingItem));
//          }
//        }
//        hitsObject.getPurchasingItems().clear();
//        hitsObject.getPurchasingItems().addAll(purchasingItems);
//      }
//    }
//    return super.saveWithChildObjects(hitsObject, dto, zoneId, create);
//  }

}
