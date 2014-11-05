package sif3.hits.rest.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.CalendarDateCollectionType;
import sif3.hits.domain.model.CalendarDate;
import sif3.hits.service.CalendarDateService;

public class CalendarDateProvider extends
    HitsBaseProvider<sif.dd.au30.model.CalendarDate, CalendarDateCollectionType, CalendarDate, CalendarDateService> {

  protected static final Logger L = LoggerFactory.getLogger(CalendarDateProvider.class);

  /**
   * @param providerID
   *          The ID of the provider.
   * @param serviceProperties
   *          values of provider property file.
   */
  public CalendarDateProvider() {
    super(sif.dd.au30.model.CalendarDate.class, "CalendarDate", CalendarDateCollectionType.class, "CalendarDates",
        CalendarDateService.class);
  }
}
