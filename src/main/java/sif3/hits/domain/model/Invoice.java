package sif3.hits.domain.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Invoice extends HitsEntity {
	private static final long serialVersionUID = 6259403798204083249L;

	private String refId;
	private String invoicedEntity;
	private String invoicedEntitySIFRefObject;
	private String billingDate;
	private String transactionDescription;
	private String billedAmount;
	private String billedAmountType;
	private String ledger;
	private String locationInfoRefId;
	private String taxRate;
	private String taxType;
	private String taxAmount;
	private String createdBy;
	private String approvedBy;
	private String itemDetail;
	private String dueDate;
	private String accountingPeriod;
	private String relatedPurchaseOrderRefId;
	private String voluntary;
	private String formNumber;
	private String localId;
	private List<String> accountCodes;
	private List<String> financialAccountRefIds;

	@Id
	public String getRefId() {
		return refId;
	}

	public void setRefId(String refId) {
		this.refId = refId;
	}

	public String getLocalId() {
		return localId;
	}

	public void setLocalId(String localId) {
		this.localId = localId;
	}

	public String getInvoicedEntity() {
		return invoicedEntity;
	}

	public void setInvoicedEntity(String invoicedEntity) {
		this.invoicedEntity = invoicedEntity;
	}

	@Column(name = "InvoicedEntity_SIFRefObject")
	public String getInvoicedEntitySIFRefObject() {
		return invoicedEntitySIFRefObject;
	}

	public void setInvoicedEntitySIFRefObject(String invoicedEntitySIFRefObject) {
		this.invoicedEntitySIFRefObject = invoicedEntitySIFRefObject;
	}

	public String getBillingDate() {
		return billingDate;
	}

	public void setBillingDate(String billingDate) {
		this.billingDate = billingDate;
	}

	public String getTransactionDescription() {
		return transactionDescription;
	}

	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}

	public String getBilledAmount() {
		return billedAmount;
	}

	public void setBilledAmount(String billedAmount) {
		this.billedAmount = billedAmount;
	}

	public String getBilledAmountType() {
		return billedAmountType;
	}

	public void setBilledAmountType(String billedAmountType) {
		this.billedAmountType = billedAmountType;
	}

	public String getLedger() {
		return ledger;
	}

	public void setLedger(String ledger) {
		this.ledger = ledger;
	}

	@Column(name = "LocationInfo_RefId")
	public String getLocationInfoRefId() {
		return locationInfoRefId;
	}

	public void setLocationInfoRefId(String locationInfoRefId) {
		this.locationInfoRefId = locationInfoRefId;
	}

	public String getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(String taxRate) {
		this.taxRate = taxRate;
	}

	public String getTaxType() {
		return taxType;
	}

	public void setTaxType(String taxType) {
		this.taxType = taxType;
	}

	public String getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(String taxAmount) {
		this.taxAmount = taxAmount;
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

	public String getItemDetail() {
		return itemDetail;
	}

	public void setItemDetail(String itemDetail) {
		this.itemDetail = itemDetail;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getAccountingPeriod() {
		return accountingPeriod;
	}

	public void setAccountingPeriod(String accountingPeriod) {
		this.accountingPeriod = accountingPeriod;
	}

	@Column(name = "Related_PurchaseOrder_RefId")
	public String getRelatedPurchaseOrderRefId() {
		return relatedPurchaseOrderRefId;
	}

	public void setRelatedPurchaseOrderRefId(String relatedPurchaseOrderRefId) {
		this.relatedPurchaseOrderRefId = relatedPurchaseOrderRefId;
	}

	public String getVoluntary() {
		return voluntary;
	}

	public void setVoluntary(String voluntary) {
		this.voluntary = voluntary;
	}

	public String getFormNumber() {
		return formNumber;
	}

	public void setFormNumber(String formNumber) {
		this.formNumber = formNumber;
	}

	@ElementCollection
	@CollectionTable(name = "Invoice_FinancialAccount", joinColumns = @JoinColumn(name = "Invoice_RefId"))
	@Column(name = "FinancialAccount_RefId")
	public List<String> getFinancialAccountRefIds() {
		return financialAccountRefIds;
	}

	public void setFinancialAccountRefIds(List<String> financialAccountRefIds) {
		this.financialAccountRefIds = financialAccountRefIds;
	}

	@ElementCollection
	@CollectionTable(name = "Invoice_AccountCode", joinColumns = @JoinColumn(name = "Invoice_RefId"))
	@Column(name = "AccountCode")
	public List<String> getAccountCodes() {
		return accountCodes;
	}

	public void setAccountCodes(List<String> accountCodes) {
		this.accountCodes = accountCodes;
	}
}
