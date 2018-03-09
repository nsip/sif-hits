package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.WellbeingAppealCollectionType;
import sif.dd.au30.model.WellbeingAppealType;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.WellbeingAppealConverter;
import sif3.hits.domain.dao.WellbeingAppealDAO;
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.dao.filter.WellbeingAppealFilterDAO;
import sif3.hits.domain.model.WellbeingAppeal;

@Service
public class WellbeingAppealService extends BaseService<WellbeingAppealType, WellbeingAppealCollectionType, WellbeingAppeal> {

    @Autowired
    private WellbeingAppealConverter wellbeingAppealConverter;

    @Autowired
    private WellbeingAppealDAO wellbeingAppealDAO;

    @Autowired
    private WellbeingAppealFilterDAO wellbeingAppealFilterDAO;

    @Override
    protected WellbeingAppealCollectionType getCollection(List<WellbeingAppealType> items) {
        WellbeingAppealCollectionType result = new WellbeingAppealCollectionType();
        if (items != null) {
            result.getWellbeingAppeal().addAll(items);
        }
        return result;
    }

    @Override
    protected HitsConverter<WellbeingAppealType, WellbeingAppeal> getConverter() {
        return wellbeingAppealConverter;
    }

    @Override
    protected JpaRepository<WellbeingAppeal, String> getDAO() {
        return wellbeingAppealDAO;
    }

    @Override
    protected FilterableRepository<WellbeingAppeal, WellbeingAppealType> getFilterableDAO() {
        return wellbeingAppealFilterDAO;
    }
}
