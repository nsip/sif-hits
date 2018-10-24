package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.FQReportingCollectionType;
import sif.dd.au30.model.FQReportingType;
import sif3.hits.domain.converter.FQReportingConverter;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.dao.FQReportingDAO;
import sif3.hits.domain.dao.filter.FQReportingFilterDAO;
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.model.FQReporting;

@Service
public class FQReportingService extends BaseService<FQReportingType, FQReportingCollectionType, FQReporting> {

    @Autowired
    private FQReportingConverter fqReportingConverter;

    @Autowired
    private FQReportingDAO fqReportingDAO;

    @Autowired
    private FQReportingFilterDAO fqReportingFilterDAO;

    @Override
    protected FQReportingCollectionType getCollection(List<FQReportingType> items) {
      FQReportingCollectionType result = new FQReportingCollectionType();
      if (items != null) {
        result.getFQReporting().addAll(items);
      }
      return result;
    }

    @Override
    protected HitsConverter<FQReportingType, FQReporting> getConverter() {
      return fqReportingConverter;
    }

    @Override
    protected JpaRepository<FQReporting, String> getDAO() {
      return fqReportingDAO;
    }

    @Override
    protected FilterableRepository<FQReporting,FQReportingType> getFilterableDAO() {
      return fqReportingFilterDAO;
    }
}
