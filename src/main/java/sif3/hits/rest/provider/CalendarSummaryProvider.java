package sif3.hits.rest.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.CalendarSummaryCollectionType;
import sif.dd.au30.model.CalendarSummaryType;
import sif3.hits.domain.model.CalendarSummary;
import sif3.hits.service.CalendarSummaryService;

public class CalendarSummaryProvider extends
    HitsBaseProvider<CalendarSummaryType, CalendarSummaryCollectionType, CalendarSummary, CalendarSummaryService> {

  protected static final Logger L = LoggerFactory.getLogger(CalendarSummaryProvider.class);

  /**
   * @param providerID
   *          The ID of the provider.
   * @param serviceProperties
   *          values of provider property file.
   */
  public CalendarSummaryProvider() {
    super(CalendarSummaryType.class, "CalendarSummary", CalendarSummaryCollectionType.class, "CalendarSummarys",
        CalendarSummaryService.class);
  }
}
