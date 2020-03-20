package sif3.hits.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PaymentReceiptLine {
	private Long id;
	private PaymentReceipt paymentReceipt;
	private String invoiceRefId;
	private String localId;
	private String localPaymentReceiptLineId;
	private String transactionAmount;
	private String transactionAmountType;
	private String financialAccountRefId;
	private String accountCode;
	private String transactionDescription;
	private String taxRate;
	private String taxAmount;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "PaymentReceipt_RefId")
	public PaymentReceipt getPaymentReceipt() {
		return paymentReceipt;
	}

	public void setPaymentReceipt(PaymentReceipt paymentReceipt) {
		this.paymentReceipt = paymentReceipt;
	}

	@Column(name = "Invoice_RefId")
	public String getInvoiceRefId() {
		return invoiceRefId;
	}

	public void setInvoiceRefId(String invoiceRefId) {
		this.invoiceRefId = invoiceRefId;
	}

	public String getLocalId() {
		return localId;
	}

	public void setLocalId(String localId) {
		this.localId = localId;
	}

	public String getLocalPaymentReceiptLineId() {
		return localPaymentReceiptLineId;
	}

	public void setLocalPaymentReceiptLineId(String localPaymentReceiptLineId) {
		this.localPaymentReceiptLineId = localPaymentReceiptLineId;
	}

	@Column(name = "TransactionAmount_Value")
	public String getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	@Column(name = "TransactionAmount_Type")
	public String getTransactionAmountType() {
		return transactionAmountType;
	}

	public void setTransactionAmountType(String transactionAmountType) {
		this.transactionAmountType = transactionAmountType;
	}

	@Column(name = "FinancialAccount_RefId")
	public String getFinancialAccountRefId() {
		return financialAccountRefId;
	}

	public void setFinancialAccountRefId(String financialAccountRefId) {
		this.financialAccountRefId = financialAccountRefId;
	}

	public String getAccountCode() {
		return accountCode;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
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

}
