package sif3.hits.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LibraryPatronStatus_Transaction_HoldInfo")
public class LibraryTransactionHold extends HitsEntity {
	private static final long serialVersionUID = 818018019564340272L;

	private Long id;
	private LibraryPatronTransaction transaction;
	private String datePlaced;
	private String dateNeeded;
	private String reservationExpiry;
	private String madeAvailable;
	private String expires;
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

	public String getDatePlaced() {
		return datePlaced;
	}

	public void setDatePlaced(String datePlaced) {
		this.datePlaced = datePlaced;
	}

	public String getDateNeeded() {
		return dateNeeded;
	}

	public void setDateNeeded(String dateNeeded) {
		this.dateNeeded = dateNeeded;
	}

	public String getReservationExpiry() {
		return reservationExpiry;
	}

	public void setReservationExpiry(String reservationExpiry) {
		this.reservationExpiry = reservationExpiry;
	}

	public String getMadeAvailable() {
		return madeAvailable;
	}

	public void setMadeAvailable(String madeAvailable) {
		this.madeAvailable = madeAvailable;
	}

	public String getExpires() {
		return expires;
	}

	public void setExpires(String expires) {
		this.expires = expires;
	}

	@Column(name = "HoldType")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
