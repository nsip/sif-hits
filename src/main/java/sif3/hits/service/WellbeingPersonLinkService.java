package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.WellbeingPersonLinkCollectionType;
import sif.dd.au30.model.WellbeingPersonLinkType;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.WellbeingPersonLinkConverter;
import sif3.hits.domain.dao.WellbeingPersonLinkDAO;
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.dao.filter.WellbeingPersonLinkFilterDAO;
import sif3.hits.domain.model.WellbeingPersonLink;

@Service
public class WellbeingPersonLinkService extends BaseService<WellbeingPersonLinkType, WellbeingPersonLinkCollectionType, WellbeingPersonLink> {

    @Autowired
    private WellbeingPersonLinkConverter wellbeingPersonLinkConverter;

    @Autowired
    private WellbeingPersonLinkDAO wellbeingPersonLinkDAO;

    @Autowired
    private WellbeingPersonLinkFilterDAO wellbeingPersonLinkFilterDAO;

    @Override
    protected WellbeingPersonLinkCollectionType getCollection(List<WellbeingPersonLinkType> items) {
        WellbeingPersonLinkCollectionType result = new WellbeingPersonLinkCollectionType();
        if (items != null) {
            result.getWellbeingPersonLink().addAll(items);
        }
        return result;
    }

    @Override
    protected HitsConverter<WellbeingPersonLinkType, WellbeingPersonLink> getConverter() {
        return wellbeingPersonLinkConverter;
    }

    @Override
    protected JpaRepository<WellbeingPersonLink, String> getDAO() {
        return wellbeingPersonLinkDAO;
    }

    @Override
    protected FilterableRepository<WellbeingPersonLink, WellbeingPersonLinkType> getFilterableDAO() {
        return wellbeingPersonLinkFilterDAO;
    }
}
