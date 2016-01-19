package sif3.hits.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Journal extends HitsEntity {
  private static final long serialVersionUID = 990143218242128343L;

  private String refId;
  private String debitFinancialAccountRefId;
  private String creditFinancialAccountRefId;
  private String originatingTransactionRefId;
  private String originationTransactionSIFRefObject;
  private String amount;
  private String gstCodeOriginal;
  private String gstCodeReplacement;
  private String note;
  private String createdDate;
  private String approvedDate;
  private String createdBy;
  private String approvedBy;

  @Id
  public String getRefId() {
    return refId;
  }

  public void setRefId(String refId) {
    this.refId = refId;
  }

  @Column(name = "Debit_FinancialAccount_RefId")
  public String getDebitFinancialAccountRefId() {
    return debitFinancialAccountRefId;
  }

  public void setDebitFinancialAccountRefId(String debitFinancialAccountRefId) {
    this.debitFinancialAccountRefId = debitFinancialAccountRefId;
  }

  @Column(name = "Credit_FinancialAccount_RefId")
  public String getCreditFinancialAccountRefId() {
    return creditFinancialAccountRefId;
  }

  public void setCreditFinancialAccountRefId(String creditFinancialAccountRefId) {
    this.creditFinancialAccountRefId = creditFinancialAccountRefId;
  }

  @Column(name = "OriginatingTransaction_RefId")
  public String getOriginatingTransactionRefId() {
    return originatingTransactionRefId;
  }

  public void setOriginatingTransactionRefId(String originatingTransactionRefId) {
    this.originatingTransactionRefId = originatingTransactionRefId;
  }

  @Column(name = "OriginatingTransaction_RefId_SIFRefObject")
  public String getOriginationTransactionSIFRefObject() {
    return originationTransactionSIFRefObject;
  }

  public void setOriginationTransactionSIFRefObject(String originationTransactionSIFRefObject) {
    this.originationTransactionSIFRefObject = originationTransactionSIFRefObject;
  }

  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public String getGSTCodeOriginal() {
    return gstCodeOriginal;
  }

  public void setGSTCodeOriginal(String gstCodeOriginal) {
    this.gstCodeOriginal = gstCodeOriginal;
  }

  public String getGSTCodeReplacement() {
    return gstCodeReplacement;
  }

  public void setGSTCodeReplacement(String gstCodeReplacement) {
    this.gstCodeReplacement = gstCodeReplacement;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public String getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(String createdDate) {
    this.createdDate = createdDate;
  }

  public String getApprovedDate() {
    return approvedDate;
  }

  public void setApprovedDate(String approvedDate) {
    this.approvedDate = approvedDate;
  }

  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public String getApprovedBy() {
    return approvedBy;
  }

  public void setApprovedBy(String approvedBy) {
    this.approvedBy = approvedBy;
  }
}
