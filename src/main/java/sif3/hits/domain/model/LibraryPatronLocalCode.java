package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LibraryPatronStatus_LocalCode")
public class LibraryPatronLocalCode extends BaseLocalCode {
	private static final long serialVersionUID = -3635680732278926100L;

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
