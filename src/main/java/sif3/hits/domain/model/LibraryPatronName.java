package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LibraryPatronStatus_PatronName")
public class LibraryPatronName extends BaseNameOfRecord {
	private static final long serialVersionUID = 840038004041698968L;

	private LibraryPatronStatus libraryPatronStatus;

	@ManyToOne
	@JoinColumn(name = "LibraryPatronStatus_RefId")
	public LibraryPatronStatus getLibraryPatronStatus() {
		return libraryPatronStatus;
	}

	public void setLibraryPatronStatus(LibraryPatronStatus libraryPatronStatus) {
		this.libraryPatronStatus = libraryPatronStatus;
	}
}
