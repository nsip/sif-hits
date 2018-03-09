package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.WellbeingCharacteristicCollectionType;
import sif.dd.au30.model.WellbeingCharacteristicType;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.WellbeingCharacteristicConverter;
import sif3.hits.domain.dao.WellbeingCharacteristicDAO;
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.dao.filter.WellbeingCharacteristicFilterDAO;
import sif3.hits.domain.model.WellbeingCharacteristic;

@Service
public class WellbeingCharacteristicService extends BaseService<WellbeingCharacteristicType, WellbeingCharacteristicCollectionType, WellbeingCharacteristic> {

    @Autowired
    private WellbeingCharacteristicConverter wellbeingCharacteristicConverter;

    @Autowired
    private WellbeingCharacteristicDAO wellbeingCharacteristicDAO;

    @Autowired
    private WellbeingCharacteristicFilterDAO wellbeingCharacteristicFilterDAO;

    @Override
    protected WellbeingCharacteristicCollectionType getCollection(List<WellbeingCharacteristicType> items) {
        WellbeingCharacteristicCollectionType result = new WellbeingCharacteristicCollectionType();
        if (items != null) {
            result.getWellbeingCharacteristic().addAll(items);
        }
        return result;
    }

    @Override
    protected HitsConverter<WellbeingCharacteristicType, WellbeingCharacteristic> getConverter() {
        return wellbeingCharacteristicConverter;
    }

    @Override
    protected JpaRepository<WellbeingCharacteristic, String> getDAO() {
        return wellbeingCharacteristicDAO;
    }

    @Override
    protected FilterableRepository<WellbeingCharacteristic, WellbeingCharacteristicType> getFilterableDAO() {
        return wellbeingCharacteristicFilterDAO;
    }
}
