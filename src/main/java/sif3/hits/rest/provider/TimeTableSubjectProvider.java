package sif3.hits.rest.provider;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.TimeTableSubjectCollectionType;
import sif.dd.au30.model.TimeTableSubjectType;
import sif3.hits.domain.model.TimeTableSubject;
import sif3.hits.service.TimeTableSubjectService;

public class TimeTableSubjectProvider extends HitsBaseProvider<TimeTableSubjectType, TimeTableSubjectCollectionType, TimeTableSubject, TimeTableSubjectService> {

  protected static final Logger L = LoggerFactory.getLogger(TimeTableSubjectProvider.class);

  /**
   * @param providerID
   *          The ID of the provider.
   * @param serviceProperties
   *          values of provider property file.
   */
  public TimeTableSubjectProvider() {
    super(TimeTableSubjectType.class, "TimeTableSubject", TimeTableSubjectCollectionType.class, "TimeTableSubjects", TimeTableSubjectService.class);
  }

  @Override
  protected List<TimeTableSubjectType> getSifList(TimeTableSubjectCollectionType sifCollection) {
    List<TimeTableSubjectType> result = null;
    if (sifCollection != null) {
      result = sifCollection.getTimeTableSubject();
    }
    return result;
  }
}
