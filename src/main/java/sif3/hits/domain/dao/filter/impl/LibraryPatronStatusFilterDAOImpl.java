package sif3.hits.domain.dao.filter.impl;

import org.springframework.stereotype.Repository;

import sif.dd.au30.model.LibraryPatronStatusType;
import sif3.hits.domain.dao.filter.LibraryPatronStatusFilterDAO;
import sif3.hits.domain.model.LibraryPatronStatus;

@Repository
public class LibraryPatronStatusFilterDAOImpl extends
		BaseFilterableRepository<LibraryPatronStatus, LibraryPatronStatusType> implements LibraryPatronStatusFilterDAO {
	public LibraryPatronStatusFilterDAOImpl() {
		super(LibraryPatronStatus.class, LibraryPatronStatusType.class);
	}
}
