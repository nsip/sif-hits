package sif3.hits.domain.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PurchaseOrder_PurchasingItems")
public class PurchasingItem extends HitsEntity {
  private static final long serialVersionUID = 2728138509709013437L;

  private Integer id;
  private PurchaseOrder purchaseOrder;
  private String itemNumber;
  private String itemDescription;
  private String quantity;
  private String unitCost;
  private String quantityDelivered;
  private ExpenseAccount expenseAccount;

  @Id
  @GeneratedValue
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @ManyToOne
  @JoinColumn(name = "PurchaseOrder_RefId")
  public PurchaseOrder getPurchaseOrder() {
    return purchaseOrder;
  }

  public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
    this.purchaseOrder = purchaseOrder;
  }

  public String getItemNumber() {
    return itemNumber;
  }

  public void setItemNumber(String itemNumber) {
    this.itemNumber = itemNumber;
  }

  public String getItemDescription() {
    return itemDescription;
  }

  public void setItemDescription(String itemDescription) {
    this.itemDescription = itemDescription;
  }

  public String getQuantity() {
    return quantity;
  }

  public void setQuantity(String quantity) {
    this.quantity = quantity;
  }

  public String getUnitCost() {
    return unitCost;
  }

  public void setUnitCost(String unitCost) {
    this.unitCost = unitCost;
  }

  public String getQuantityDelivered() {
    return quantityDelivered;
  }

  public void setQuantityDelivered(String quantityDelivered) {
    this.quantityDelivered = quantityDelivered;
  }

  @OneToOne(mappedBy = "purchasingItem", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
  public ExpenseAccount getExpenseAccount() {
    return expenseAccount;
  }

  public void setExpenseAccount(ExpenseAccount expenseAccount) {
    this.expenseAccount = expenseAccount;
  }

}
