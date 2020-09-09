package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LibraryPatronStatus_Transaction_Checkout")
public class LibraryTransactionCheckout extends HitsEntity {
	private static final long serialVersionUID = 818018019564340272L;

	private Long id;
	private LibraryPatronTransaction transaction;
	private String checkedOutOn;
	private String returnBy;
	private String renewalCount;

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

	public String getCheckedOutOn() {
		return checkedOutOn;
	}

	public void setCheckedOutOn(String checkedOutOn) {
		this.checkedOutOn = checkedOutOn;
	}

	public String getReturnBy() {
		return returnBy;
	}

	public void setReturnBy(String returnBy) {
		this.returnBy = returnBy;
	}

	public String getRenewalCount() {
		return renewalCount;
	}

	public void setRenewalCount(String renewalCount) {
		this.renewalCount = renewalCount;
	}

}
