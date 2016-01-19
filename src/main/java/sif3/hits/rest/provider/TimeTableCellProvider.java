package sif3.hits.rest.provider;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.TimeTableCellCollectionType;
import sif.dd.au30.model.TimeTableCellType;
import sif3.hits.domain.model.TimeTableCell;
import sif3.hits.service.TimeTableCellService;

public class TimeTableCellProvider extends HitsBaseProvider<TimeTableCellType, TimeTableCellCollectionType, TimeTableCell, TimeTableCellService> {

  protected static final Logger L = LoggerFactory.getLogger(TimeTableCellProvider.class);

  /**
   * @param providerID
   *          The ID of the provider.
   * @param serviceProperties
   *          values of provider property file.
   */
  public TimeTableCellProvider() {
    super(TimeTableCellType.class, "TimeTableCell", TimeTableCellCollectionType.class, "TimeTableCells", TimeTableCellService.class);
  }

  @Override
  protected List<TimeTableCellType> getSifList(TimeTableCellCollectionType sifCollection) {
    List<TimeTableCellType> result = null;
    if (sifCollection != null) {
      result = sifCollection.getTimeTableCell();
    }
    return result;
  }
}
