package sif3.hits.rest.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.CalendarDateCollectionType;
import sif.dd.au30.model.CalendarDateType;
import sif3.common.exception.PersistenceException;
import sif3.hits.domain.model.CalendarDate;
import sif3.hits.service.CalendarDateService;

public class CalendarDateProvider extends HitsBaseProvider<CalendarDateType, CalendarDateCollectionType, CalendarDate, CalendarDateService> {

  protected static final Logger L = LoggerFactory.getLogger(CalendarDateProvider.class);

  /**
   * @param providerID
   *          The ID of the provider.
   * @param serviceProperties
   *          values of provider property file.
   */
  public CalendarDateProvider() {
    super(CalendarDateType.class, "CalendarDate", CalendarDateCollectionType.class, "CalendarDates", CalendarDateService.class);
  }

  @Override
  protected String getRefId(CalendarDateType sifObject, Class<CalendarDateType> sifClass) throws PersistenceException {

    String result = null;
    if (sifObject != null && sifObject.getCalendarDateRefId() != null) {
      result = sifObject.getCalendarDateRefId();
    }
    return result;
  }

  @Override
  protected void setRefId(CalendarDateType sifObject, Class<CalendarDateType> sifClass, String refId) throws PersistenceException {

    if (refId != null && sifObject != null) {
      sifObject.setCalendarDateRefId(refId);
    }
  }
}
