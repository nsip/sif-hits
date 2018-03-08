package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.WellbeingEventCollectionType;
import sif.dd.au30.model.WellbeingEventType;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.WellbeingEventConverter;
import sif3.hits.domain.dao.WellbeingEventDAO;
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.dao.filter.WellbeingEventFilterDAO;
import sif3.hits.domain.model.WellbeingEvent;

@Service
public class WellbeingEventService extends BaseService<WellbeingEventType, WellbeingEventCollectionType, WellbeingEvent> {

    @Autowired
    private WellbeingEventConverter wellbeingEventConverter;

    @Autowired
    private WellbeingEventDAO wellbeingEventDAO;

    @Autowired
    private WellbeingEventFilterDAO wellbeingEventFilterDAO;

    @Override
    protected WellbeingEventCollectionType getCollection(List<WellbeingEventType> items) {
        WellbeingEventCollectionType result = new WellbeingEventCollectionType();
        if (items != null) {
            result.getWellbeingEvent().addAll(items);
        }
        return result;
    }

    @Override
    protected HitsConverter<WellbeingEventType, WellbeingEvent> getConverter() {
        return wellbeingEventConverter;
    }

    @Override
    protected JpaRepository<WellbeingEvent, String> getDAO() {
        return wellbeingEventDAO;
    }

    @Override
    protected FilterableRepository<WellbeingEvent, WellbeingEventType> getFilterableDAO() {
        return wellbeingEventFilterDAO;
    }
}
