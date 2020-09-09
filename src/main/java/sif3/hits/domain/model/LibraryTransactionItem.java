package sif3.hits.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LibraryPatronStatus_Transaction_Item")
public class LibraryTransactionItem extends HitsEntity {
	private static final long serialVersionUID = 818018019564340272L;

	private Long id;
	private LibraryPatronTransaction transaction;
	private String title;
	private String author;
	private String electronicId;
	private String electronicIdType;
	private String callNumber;
	private String isbn;
	private String cost;
	private String costCurrency;
	private String replacementCost;
	private String replacementCostCurrency;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getElectronicId() {
		return electronicId;
	}

	public void setElectronicId(String electronicId) {
		this.electronicId = electronicId;
	}

	public String getElectronicIdType() {
		return electronicIdType;
	}

	public void setElectronicIdType(String electronicIdType) {
		this.electronicIdType = electronicIdType;
	}

	public String getCallNumber() {
		return callNumber;
	}

	public void setCallNumber(String callNumber) {
		this.callNumber = callNumber;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Column(name = "Cost_Amount")
	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	@Column(name = "Cost_Currency")
	public String getCostCurrency() {
		return costCurrency;
	}

	public void setCostCurrency(String costCurrency) {
		this.costCurrency = costCurrency;
	}

	@Column(name = "ReplacementCost_Amount")
	public String getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(String replacementCost) {
		this.replacementCost = replacementCost;
	}

	@Column(name = "ReplacementCost_Currency")
	public String getReplacementCostCurrency() {
		return replacementCostCurrency;
	}

	public void setReplacementCostCurrency(String replacementCostCurrency) {
		this.replacementCostCurrency = replacementCostCurrency;
	}

	@Column(name = "ItemType")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
