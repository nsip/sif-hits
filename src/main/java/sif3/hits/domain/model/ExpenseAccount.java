package sif3.hits.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "PurchaseOrder_PurchasingItem_ExpenseAccount")
public class ExpenseAccount extends HitsEntity {
  private static final long serialVersionUID = 6301596425149675114L;

  private Integer purchasingItemId;
  private PurchasingItem purchasingItem;
  private String accountCode;
  private String amount;
  private String financialAccountRefId;
  private String accountingPeriod;

  @Id
  @GeneratedValue(generator = "SharedPrimaryKeyGenerator")
  @GenericGenerator(name = "SharedPrimaryKeyGenerator", strategy = "foreign", parameters = @Parameter(name = "property", value = "purchasingItem") )
  @Column(name = "purchasingItemId", unique = true, nullable = false)
  public Integer getPurchasingItemId() {
    return purchasingItemId;
  }

  public void setPurchasingItemId(Integer purchasingItemId) {
    this.purchasingItemId = purchasingItemId;
  }

  @OneToOne
  @PrimaryKeyJoinColumn
  public PurchasingItem getPurchasingItem() {
    return purchasingItem;
  }

  public void setPurchasingItem(PurchasingItem purchasingItem) {
    this.purchasingItem = purchasingItem;
  }

  public String getAccountCode() {
    return accountCode;
  }

  public void setAccountCode(String accountCode) {
    this.accountCode = accountCode;
  }

  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  @Column(name = "FinancialAccount_RefId")
  public String getFinancialAccountRefId() {
    return financialAccountRefId;
  }

  public void setFinancialAccountRefId(String financialAccountRefId) {
    this.financialAccountRefId = financialAccountRefId;
  }

  public String getAccountingPeriod() {
    return accountingPeriod;
  }

  public void setAccountingPeriod(String accountingPeriod) {
    this.accountingPeriod = accountingPeriod;
  }
}
