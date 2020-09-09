package sif3.hits.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LibraryPatronStatus_Transaction_Fine")
public class LibraryTransactionFine extends HitsEntity {
	private static final long serialVersionUID = 818018019564340272L;

	private Long id;
	private LibraryPatronTransaction transaction;
	private String assessed;
	private String description;
	private String amount;
	private String currency;
	private String reference;
	private String type;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "Transaction_Id")
	public LibraryPatronTransaction getTransaction() {
		return transaction;
	}

	public void setTransaction(LibraryPatronTransaction transaction) {
		this.transaction = transaction;
	}

	public String getAssessed() {
		return assessed;
	}

	public void setAssessed(String assessed) {
		this.assessed = assessed;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	@Column(name = "FineType")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
