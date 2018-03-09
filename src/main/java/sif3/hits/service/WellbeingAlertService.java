package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.WellbeingAlertCollectionType;
import sif.dd.au30.model.WellbeingAlertType;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.WellbeingAlertConverter;
import sif3.hits.domain.dao.WellbeingAlertDAO;
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.dao.filter.WellbeingAlertFilterDAO;
import sif3.hits.domain.model.WellbeingAlert;

@Service
public class WellbeingAlertService extends BaseService<WellbeingAlertType, WellbeingAlertCollectionType, WellbeingAlert> {

    @Autowired
    private WellbeingAlertConverter wellbeingAlertConverter;

    @Autowired
    private WellbeingAlertDAO wellbeingAlertDAO;

    @Autowired
    private WellbeingAlertFilterDAO wellbeingAlertFilterDAO;

    @Override
    protected WellbeingAlertCollectionType getCollection(List<WellbeingAlertType> items) {
        WellbeingAlertCollectionType result = new WellbeingAlertCollectionType();
        if (items != null) {
            result.getWellbeingAlert().addAll(items);
        }
        return result;
    }

    @Override
    protected HitsConverter<WellbeingAlertType, WellbeingAlert> getConverter() {
        return wellbeingAlertConverter;
    }

    @Override
    protected JpaRepository<WellbeingAlert, String> getDAO() {
        return wellbeingAlertDAO;
    }

    @Override
    protected FilterableRepository<WellbeingAlert, WellbeingAlertType> getFilterableDAO() {
        return wellbeingAlertFilterDAO;
    }
}
