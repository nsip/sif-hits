package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.WellbeingResponseCollectionType;
import sif.dd.au30.model.WellbeingResponseType;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.WellbeingResponseConverter;
import sif3.hits.domain.dao.WellbeingResponseDAO;
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.dao.filter.WellbeingResponseFilterDAO;
import sif3.hits.domain.model.WellbeingResponse;

@Service
public class WellbeingResponseService extends BaseService<WellbeingResponseType, WellbeingResponseCollectionType, WellbeingResponse> {

    @Autowired
    private WellbeingResponseConverter wellbeingResponseConverter;

    @Autowired
    private WellbeingResponseDAO wellbeingResponseDAO;

    @Autowired
    private WellbeingResponseFilterDAO wellbeingResponseFilterDAO;

    @Override
    protected WellbeingResponseCollectionType getCollection(List<WellbeingResponseType> items) {
        WellbeingResponseCollectionType result = new WellbeingResponseCollectionType();
        if (items != null) {
            result.getWellbeingResponse().addAll(items);
        }
        return result;
    }

    @Override
    protected HitsConverter<WellbeingResponseType, WellbeingResponse> getConverter() {
        return wellbeingResponseConverter;
    }

    @Override
    protected JpaRepository<WellbeingResponse, String> getDAO() {
        return wellbeingResponseDAO;
    }

    @Override
    protected FilterableRepository<WellbeingResponse, WellbeingResponseType> getFilterableDAO() {
        return wellbeingResponseFilterDAO;
    }
}
