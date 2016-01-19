package sif3.hits.rest.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.GradingAssignmentCollectionType;
import sif.dd.au30.model.GradingAssignmentType;
import sif3.hits.domain.model.GradingAssignment;
import sif3.hits.service.GradingAssignmentService;

public class GradingAssignmentProvider extends HitsBaseProvider<GradingAssignmentType, GradingAssignmentCollectionType, GradingAssignment, GradingAssignmentService> {

  protected static final Logger L = LoggerFactory.getLogger(GradingAssignmentProvider.class);

  /**
   * @param providerID
   *          The ID of the provider.
   * @param serviceProperties
   *          values of provider property file.
   */
  public GradingAssignmentProvider() {
    super(GradingAssignmentType.class, "GradingAssignment", GradingAssignmentCollectionType.class, "GradingAssignments", GradingAssignmentService.class);
  }
}
