package sif3.hits.rest.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.CalendarDateCollectionType;
import sif3.common.exception.PersistenceException;
import sif3.hits.domain.model.CalendarDate;
import sif3.hits.service.CalendarDateService;

public class CalendarDateProvider extends HitsBaseProvider<sif.dd.au30.model.CalendarDate, CalendarDateCollectionType, CalendarDate, CalendarDateService> {

  protected static final Logger L = LoggerFactory.getLogger(CalendarDateProvider.class);

  /**
   * @param providerID
   *          The ID of the provider.
   * @param serviceProperties
   *          values of provider property file.
   */
  public CalendarDateProvider() {
    super(sif.dd.au30.model.CalendarDate.class, "CalendarDate", CalendarDateCollectionType.class, "CalendarDates", CalendarDateService.class);
  }

  @Override
  protected String getRefId(sif.dd.au30.model.CalendarDate sifObject, Class<sif.dd.au30.model.CalendarDate> sifClass) throws PersistenceException {

    String result = null;
    if (sifObject != null && sifObject.getCalendarDateRefId() != null) {
      result = sifObject.getCalendarDateRefId();
    }
    return result;
  }

  @Override
  protected void setRefId(sif.dd.au30.model.CalendarDate sifObject, Class<sif.dd.au30.model.CalendarDate> sifClass, String refId) throws PersistenceException {

    if (refId != null && sifObject != null) {
      sifObject.setCalendarDateRefId(refId);
    }
  }
}
