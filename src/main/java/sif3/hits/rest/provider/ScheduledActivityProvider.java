package sif3.hits.rest.provider;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.ScheduledActivityCollectionType;
import sif.dd.au30.model.ScheduledActivityType;
import sif3.hits.domain.model.ScheduledActivity;
import sif3.hits.service.ScheduledActivityService;

public class ScheduledActivityProvider extends
    HitsBaseProvider<ScheduledActivityType, ScheduledActivityCollectionType, ScheduledActivity, ScheduledActivityService> {

  protected static final Logger L = LoggerFactory.getLogger(ScheduledActivityProvider.class);

  /**
   * @param providerID
   *          The ID of the provider.
   * @param serviceProperties
   *          values of provider property file.
   */
  public ScheduledActivityProvider() {
    super(ScheduledActivityType.class, "ScheduledActivity", ScheduledActivityCollectionType.class, "ScheduledActivitys",
        ScheduledActivityService.class);
  }

  @Override
  protected List<ScheduledActivityType> getSifList(ScheduledActivityCollectionType sifCollection) {
    List<ScheduledActivityType> result = null;
    if (sifCollection != null) {
      result = sifCollection.getScheduledActivity();
    }
    return result;
  }
}
