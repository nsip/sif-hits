package sif3.hits.domain.model;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class PaymentReceipt extends HitsEntity {
  private static final long serialVersionUID = -2475556028791362460L;

  private String refId;
  private String transactionType;
  private String invoiceRefId;
  private String vendorInfoRefId;
  private String debtorRefId;
  private String purchaseOrderRefId;
  private String locationInfoRefId;
  private String transactionDate;
  private String receivedAmount;
  private String receivedAmountType;
  private String receivedTransactionId;
  private String transactionDescription;
  private String taxRate;
  private String taxAmount;
  private String transactionMethod;
  private String chequeNumber;
  private String transactionNote;
  private String accountingPeriod;
  private Set<String> financialAccountRefIds;

  @Id
  public String getRefId() {
    return refId;
  }

  public void setRefId(String refId) {
    this.refId = refId;
  }

  public String getTransactionType() {
    return transactionType;
  }

  public void setTransactionType(String transactionType) {
    this.transactionType = transactionType;
  }

  @Column(name = "Invoice_RefId")
  public String getInvoiceRefId() {
    return invoiceRefId;
  }

  public void setInvoiceRefId(String invoiceRefId) {
    this.invoiceRefId = invoiceRefId;
  }

  @Column(name = "VendorInfo_RefId")
  public String getVendorInfoRefId() {
    return vendorInfoRefId;
  }

  public void setVendorInfoRefId(String vendorInfoRefId) {
    this.vendorInfoRefId = vendorInfoRefId;
  }

  @Column(name = "Debtor_RefId")
  public String getDebtorRefId() {
    return debtorRefId;
  }

  public void setDebtorRefId(String debtorRefId) {
    this.debtorRefId = debtorRefId;
  }

  @Column(name = "PurchaseOrder_RefId")
  public String getPurchaseOrderRefId() {
    return purchaseOrderRefId;
  }

  public void setPurchaseOrderRefId(String purchaseOrderRefId) {
    this.purchaseOrderRefId = purchaseOrderRefId;
  }

  @Column(name = "LocationInfo_RefId")
  public String getLocationInfoRefId() {
    return locationInfoRefId;
  }

  public void setLocationInfoRefId(String locationInfoRefId) {
    this.locationInfoRefId = locationInfoRefId;
  }

  public String getTransactionDate() {
    return transactionDate;
  }

  public void setTransactionDate(String transactionDate) {
    this.transactionDate = transactionDate;
  }

  public String getReceivedAmount() {
    return receivedAmount;
  }

  public void setReceivedAmount(String receivedAmount) {
    this.receivedAmount = receivedAmount;
  }

  public String getReceivedAmountType() {
    return receivedAmountType;
  }

  public void setReceivedAmountType(String receivedAmountType) {
    this.receivedAmountType = receivedAmountType;
  }

  public String getReceivedTransactionId() {
    return receivedTransactionId;
  }

  public void setReceivedTransactionId(String receivedTransactionId) {
    this.receivedTransactionId = receivedTransactionId;
  }

  public String getTransactionDescription() {
    return transactionDescription;
  }

  public void setTransactionDescription(String transactionDescription) {
    this.transactionDescription = transactionDescription;
  }

  public String getTaxRate() {
    return taxRate;
  }

  public void setTaxRate(String taxRate) {
    this.taxRate = taxRate;
  }

  public String getTaxAmount() {
    return taxAmount;
  }

  public void setTaxAmount(String taxAmount) {
    this.taxAmount = taxAmount;
  }

  public String getTransactionMethod() {
    return transactionMethod;
  }

  public void setTransactionMethod(String transactionMethod) {
    this.transactionMethod = transactionMethod;
  }

  public String getChequeNumber() {
    return chequeNumber;
  }

  public void setChequeNumber(String chequeNumber) {
    this.chequeNumber = chequeNumber;
  }

  public String getTransactionNote() {
    return transactionNote;
  }

  public void setTransactionNote(String transactionNote) {
    this.transactionNote = transactionNote;
  }

  public String getAccountingPeriod() {
    return accountingPeriod;
  }

  public void setAccountingPeriod(String accountingPeriod) {
    this.accountingPeriod = accountingPeriod;
  }

  @ElementCollection
  @CollectionTable(name = "PaymentReceipt_FinancialAccount", joinColumns = @JoinColumn(name = "PaymentReceipt_RefId") )
  @Column(name = "FinancialAccount_RefId")
  public Set<String> getFinancialAccountRefIds() {
    return financialAccountRefIds;
  }

  public void setFinancialAccountRefIds(Set<String> financialAccountRefIds) {
    this.financialAccountRefIds = financialAccountRefIds;
  }
}
