package sif3.hits.rest.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sif.dd.au30.model.AGStatusReportCollectionType;
import sif.dd.au30.model.AGStatusReportType;
import sif3.hits.domain.model.AGStatusReport;
import sif3.hits.service.AGStatusReportService;

public class AGStatusReportProvider extends HitsBaseProvider<AGStatusReportType, AGStatusReportCollectionType, AGStatusReport, AGStatusReportService> {

  protected static final Logger L = LoggerFactory.getLogger(AGStatusReportProvider.class);

  /**
   * @param providerID
   *          The ID of the provider.
   * @param serviceProperties
   *          values of provider property file.
   */
  public AGStatusReportProvider() {
    super(AGStatusReportType.class, "AGStatusReport", AGStatusReportCollectionType.class, "AGStatusReports", AGStatusReportService.class);
  }
}
