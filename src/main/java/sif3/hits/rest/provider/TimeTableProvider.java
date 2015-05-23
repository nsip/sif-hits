package sif3.hits.rest.provider;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.TimeTableCollectionType;
import sif.dd.au30.model.TimeTableType;
import sif3.hits.domain.model.TimeTable;
import sif3.hits.service.TimeTableService;

public class TimeTableProvider extends
    HitsBaseProvider<TimeTableType, TimeTableCollectionType, TimeTable, TimeTableService> {

  protected static final Logger L = LoggerFactory.getLogger(TimeTableProvider.class);

  /**
   * @param providerID
   *          The ID of the provider.
   * @param serviceProperties
   *          values of provider property file.
   */
  public TimeTableProvider() {
    super(TimeTableType.class, "TimeTable", TimeTableCollectionType.class, "TimeTables", TimeTableService.class);
  }

  @Override
  protected List<TimeTableType> getSifList(TimeTableCollectionType sifCollection) {
    List<TimeTableType> result = null;
    if (sifCollection != null) {
      result = sifCollection.getTimeTable();
    }
    return result;
  }
}
