package sif3.hits.rest.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.PersonalisedPlanCollectionType;
import sif.dd.au30.model.PersonalisedPlanType;
import sif3.hits.domain.model.PersonalisedPlan;
import sif3.hits.service.PersonalisedPlanService;

public class PersonalisedPlanProvider extends HitsBaseProvider<PersonalisedPlanType, PersonalisedPlanCollectionType, PersonalisedPlan, PersonalisedPlanService> {

  protected static final Logger L = LoggerFactory.getLogger(PersonalisedPlanProvider.class);

  /**
   * @param providerID
   *          The ID of the provider.
   * @param serviceProperties
   *          values of provider property file.
   */
  public PersonalisedPlanProvider() {
    super(PersonalisedPlanType.class, "PersonalisedPlan", PersonalisedPlanCollectionType.class, "PersonalisedPlans", PersonalisedPlanService.class);
  }
}
