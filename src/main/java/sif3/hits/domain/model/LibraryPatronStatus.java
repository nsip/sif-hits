package sif3.hits.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class LibraryPatronStatus extends HitsEntity {
	private static final long serialVersionUID = -7662410934656860141L;

	private String refId;
	private String libraryType;
	private String patronRefId;
	private String patronLocalId;
	private String patronRefObject;
	private String numberOfCheckouts;
	private String numberOfHoldItems;
	private String numberOfOverdues;
	private String numberOfFines;
	private String fineAmount;
	private String fineCurrency;
	private String numberOfRefunds;
	private String refundAmount;
	private String refundCurrency;

	private List<LibraryPatronName> patronNames;
	private List<LibraryPatronElectronicId> electronicIdList;
	private List<LibraryPatronTransaction> transactionList;
	private List<LibraryPatronMessage> messageList;
	private List<LibraryPatronLocalCode> localCodeList;

	@Id
	public String getRefId() {
		return refId;
	}

	public void setRefId(String refId) {
		this.refId = refId;
	}

	public String getLibraryType() {
		return libraryType;
	}

	public void setLibraryType(String libraryType) {
		this.libraryType = libraryType;
	}

	public String getPatronRefId() {
		return patronRefId;
	}

	public void setPatronRefId(String patronRefId) {
		this.patronRefId = patronRefId;
	}

	public String getPatronLocalId() {
		return patronLocalId;
	}

	public void setPatronLocalId(String patronLocalId) {
		this.patronLocalId = patronLocalId;
	}

	public String getPatronRefObject() {
		return patronRefObject;
	}

	public void setPatronRefObject(String patronRefObject) {
		this.patronRefObject = patronRefObject;
	}

	public String getNumberOfCheckouts() {
		return numberOfCheckouts;
	}

	public void setNumberOfCheckouts(String numberOfCheckouts) {
		this.numberOfCheckouts = numberOfCheckouts;
	}

	public String getNumberOfHoldItems() {
		return numberOfHoldItems;
	}

	public void setNumberOfHoldItems(String numberOfHoldItems) {
		this.numberOfHoldItems = numberOfHoldItems;
	}

	public String getNumberOfOverdues() {
		return numberOfOverdues;
	}

	public void setNumberOfOverdues(String numberOfOverdues) {
		this.numberOfOverdues = numberOfOverdues;
	}

	public String getNumberOfFines() {
		return numberOfFines;
	}

	public void setNumberOfFines(String numberOfFines) {
		this.numberOfFines = numberOfFines;
	}

	@Column(name = "FineAmount_Amount")
	public String getFineAmount() {
		return fineAmount;
	}

	public void setFineAmount(String fineAmount) {
		this.fineAmount = fineAmount;
	}

	@Column(name = "FineAmount_Currency")
	public String getFineCurrency() {
		return fineCurrency;
	}

	public void setFineCurrency(String fineCurrency) {
		this.fineCurrency = fineCurrency;
	}

	public String getNumberOfRefunds() {
		return numberOfRefunds;
	}

	public void setNumberOfRefunds(String numberOfRefunds) {
		this.numberOfRefunds = numberOfRefunds;
	}

	@Column(name = "RefundAmount_Amount")
	public String getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(String refundAmount) {
		this.refundAmount = refundAmount;
	}

	@Column(name = "RefundAmount_Currency")
	public String getRefundCurrency() {
		return refundCurrency;
	}

	public void setRefundCurrency(String refundCurrency) {
		this.refundCurrency = refundCurrency;
	}

	// Actually OneToOne but easier to manager in hibernate this way.
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "libraryPatronStatus")
	public List<LibraryPatronName> getPatronNames() {
		return patronNames;
	}

	public void setPatronNames(List<LibraryPatronName> patronNames) {
		this.patronNames = patronNames;
	}

	@Transient
	public LibraryPatronName getPatronName() {
		LibraryPatronName result = null;
		if (this.patronNames != null && !this.patronNames.isEmpty()) {
			result = this.getPatronNames().get(0);
		}
		return result;
	}

	@Transient
	public void setPatronName(LibraryPatronName patronName) {
		if (this.patronNames == null) {
			this.patronNames = new ArrayList<>();
		}
		this.patronNames.clear();
		if (patronName != null) {
			this.patronNames.add(patronName);
			patronName.setLibraryPatronStatus(this);
		}

	}

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "libraryPatronStatus")
	public List<LibraryPatronElectronicId> getElectronicIdList() {
		return electronicIdList;
	}

	public void setElectronicIdList(List<LibraryPatronElectronicId> electronicIdList) {
		this.electronicIdList = electronicIdList;
	}

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "libraryPatronStatus")
	public List<LibraryPatronTransaction> getTransactionList() {
		return transactionList;
	}

	public void setTransactionList(List<LibraryPatronTransaction> transactionList) {
		this.transactionList = transactionList;
	}

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "libraryPatronStatus")
	public List<LibraryPatronMessage> getMessageList() {
		return messageList;
	}

	public void setMessageList(List<LibraryPatronMessage> messageList) {
		this.messageList = messageList;
	}

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "libraryPatronStatus")
	public List<LibraryPatronLocalCode> getLocalCodeList() {
		return localCodeList;
	}

	public void setLocalCodeList(List<LibraryPatronLocalCode> localCodeList) {
		this.localCodeList = localCodeList;
	}
}
