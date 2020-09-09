package sif3.hits.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LibraryPatronStatus_ElectronicId")
public class LibraryPatronElectronicId {

	private Long id;
	private LibraryPatronStatus libraryPatronStatus;
	private String electronicId;
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
	@JoinColumn(name = "LibraryPatronStatus_RefId")
	public LibraryPatronStatus getLibraryPatronStatus() {
		return libraryPatronStatus;
	}

	public void setLibraryPatronStatus(LibraryPatronStatus libraryPatronStatus) {
		this.libraryPatronStatus = libraryPatronStatus;
	}

	public String getElectronicId() {
		return electronicId;
	}

	public void setElectronicId(String electronicId) {
		this.electronicId = electronicId;
	}

	@Column(name = "ElectronicIdType")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
