package sif3.hits.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import sif.dd.au30.model.AGStatusReportCollectionType;
import sif.dd.au30.model.AGStatusReportType;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.AGStatusReportConverter;
import sif3.hits.domain.dao.AGStatusReportDAO;
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.dao.filter.AGStatusReportFilterDAO;
import sif3.hits.domain.model.AGStatusReport;

import java.util.List;

@Service
public class AGStatusReportService extends BaseService<AGStatusReportType, AGStatusReportCollectionType, AGStatusReport> {

  @Autowired
  private AGStatusReportConverter agStatusReportConverter;

  @Autowired
  private AGStatusReportDAO agStatusReportDAO;

  @Autowired
  private AGStatusReportFilterDAO agStatusReportFilterDAO;

  @Override
  protected AGStatusReportCollectionType getCollection(List<AGStatusReportType> items) {
    AGStatusReportCollectionType result = new AGStatusReportCollectionType();
    if (items != null) {
      result.getAGStatusReport().addAll(items);
    }
    return result;
  }

  @Override
  protected HitsConverter<AGStatusReportType, AGStatusReport> getConverter() {
    return agStatusReportConverter;
  }

  @Override
  protected JpaRepository<AGStatusReport, String> getDAO() {
    return agStatusReportDAO;
  }

  @Override
  protected FilterableRepository<AGStatusReport,AGStatusReportType> getFilterableDAO() {
    return agStatusReportFilterDAO;
  }
}
