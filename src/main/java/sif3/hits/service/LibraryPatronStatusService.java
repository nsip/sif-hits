package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.LibraryPatronStatusCollectionType;
import sif.dd.au30.model.LibraryPatronStatusType;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.LibraryPatronStatusConverter;
import sif3.hits.domain.dao.LibraryPatronStatusDAO;
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.dao.filter.LibraryPatronStatusFilterDAO;
import sif3.hits.domain.model.LibraryPatronStatus;

@Service
public class LibraryPatronStatusService extends BaseService<LibraryPatronStatusType, LibraryPatronStatusCollectionType, LibraryPatronStatus> {

    @Autowired
    private LibraryPatronStatusConverter libraryPatronStatusConverter;

    @Autowired
    private LibraryPatronStatusDAO libraryPatronStatusDAO;

    @Autowired
    private LibraryPatronStatusFilterDAO libraryPatronStatusFilterDAO;

    @Override
    protected LibraryPatronStatusCollectionType getCollection(List<LibraryPatronStatusType> items) {
        LibraryPatronStatusCollectionType result = new LibraryPatronStatusCollectionType();
        if (items != null) {
            result.getLibraryPatronStatus().addAll(items);
        }
        return result;
    }

    @Override
    protected HitsConverter<LibraryPatronStatusType, LibraryPatronStatus> getConverter() {
        return libraryPatronStatusConverter;
    }

    @Override
    protected JpaRepository<LibraryPatronStatus, String> getDAO() {
        return libraryPatronStatusDAO;
    }

    @Override
    protected FilterableRepository<LibraryPatronStatus, LibraryPatronStatusType> getFilterableDAO() {
        return libraryPatronStatusFilterDAO;
    }

}
