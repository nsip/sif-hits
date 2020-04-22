package sif3.hits.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Journal_JournalAdjustment")
public class JournalAdjustment {
	private Long id;
	private Journal journal;
	private String debitFinancialAccountRefId;
	private String creditFinancialAccountRefId;
	private String debitAccountCode;
	private String creditAccountCode;
	private String gstCodeOriginal;
	private String gstCodeReplacement;
	private String lineAdjustmentAmount;

	@GeneratedValue
	@Id
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "Journal_RefId")
	public Journal getJournal() {
		return journal;
	}

	public void setJournal(Journal journal) {
		this.journal = journal;
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

	public String getDebitAccountCode() {
		return debitAccountCode;
	}

	public void setDebitAccountCode(String debitAccountCode) {
		this.debitAccountCode = debitAccountCode;
	}

	public String getCreditAccountCode() {
		return creditAccountCode;
	}

	public void setCreditAccountCode(String creditAccountCode) {
		this.creditAccountCode = creditAccountCode;
	}

	public String getGstCodeOriginal() {
		return gstCodeOriginal;
	}

	public void setGstCodeOriginal(String gstCodeOriginal) {
		this.gstCodeOriginal = gstCodeOriginal;
	}

	public String getGstCodeReplacement() {
		return gstCodeReplacement;
	}

	public void setGstCodeReplacement(String gstCodeReplacement) {
		this.gstCodeReplacement = gstCodeReplacement;
	}

	public String getLineAdjustmentAmount() {
		return lineAdjustmentAmount;
	}

	public void setLineAdjustmentAmount(String lineAdjustmentAmount) {
		this.lineAdjustmentAmount = lineAdjustmentAmount;
	}

}
