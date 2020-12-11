package sif3.hits.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "LibraryPatronStatus_Transaction")
public class LibraryPatronTransaction {
	private Long id;
	private LibraryPatronStatus libraryPatronStatus;

	private List<LibraryTransactionItem> itemList;
	private List<LibraryTransactionCheckout> checkoutList;
	private List<LibraryTransactionHold> holdList;
	private List<LibraryTransactionFine> fineList;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "LibraryPatronStatus_RefId")
	public LibraryPatronStatus getLibraryPatronStatus() {
		return libraryPatronStatus;
	}

	public void setLibraryPatronStatus(LibraryPatronStatus libraryPatronStatus) {
		this.libraryPatronStatus = libraryPatronStatus;
	}

	// Actually One-To-One but easier to manage this way
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "transaction")
	public List<LibraryTransactionItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<LibraryTransactionItem> itemList) {
		this.itemList = itemList;
	}

	@Transient
	public LibraryTransactionItem getTransactionItem() {
		LibraryTransactionItem result = null;
		if (this.itemList != null && !this.itemList.isEmpty()) {
			result = this.itemList.get(0);
		}
		return result;
	}

	@Transient
	public void setTransactionItem(LibraryTransactionItem libraryTransactionItem) {
		if (this.itemList == null) {
			this.itemList = new ArrayList<>();
		}
		this.itemList.clear();
		if (libraryTransactionItem != null) {
			this.itemList.add(libraryTransactionItem);
			libraryTransactionItem.setTransaction(this);
		}
	}

	// Actually One-To-One but easier to manage this way
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "transaction")
	public List<LibraryTransactionCheckout> getCheckoutList() {
		return checkoutList;
	}

	public void setCheckoutList(List<LibraryTransactionCheckout> checkoutList) {
		this.checkoutList = checkoutList;
	}
	
	@Transient
	public LibraryTransactionCheckout getCheckout() {
		LibraryTransactionCheckout result = null;
		if (this.checkoutList != null && !this.checkoutList.isEmpty()) {
			result = this.checkoutList.get(0);
		}
		return result;
	}

	@Transient
	public void setCheckout(LibraryTransactionCheckout libraryTransactionCheckout) {
		if (this.checkoutList == null) {
			this.checkoutList = new ArrayList<>();
		}
		this.checkoutList.clear();
		if (libraryTransactionCheckout != null) {
			this.checkoutList.add(libraryTransactionCheckout);
			libraryTransactionCheckout.setTransaction(this);
		}
	}


	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "transaction")
	public List<LibraryTransactionHold> getHoldList() {
		return holdList;
	}

	public void setHoldList(List<LibraryTransactionHold> holdList) {
		this.holdList = holdList;
	}

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "transaction")
	public List<LibraryTransactionFine> getFineList() {
		return fineList;
	}

	public void setFineList(List<LibraryTransactionFine> fineList) {
		this.fineList = fineList;
	}

}
