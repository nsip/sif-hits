package sif3.hits.rest.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.GradingAssignmentScoreCollectionType;
import sif.dd.au30.model.GradingAssignmentScoreType;
import sif3.hits.domain.model.GradingAssignmentScore;
import sif3.hits.service.GradingAssignmentScoreService;

public class GradingAssignmentScoreProvider extends HitsBaseProvider<GradingAssignmentScoreType, GradingAssignmentScoreCollectionType, GradingAssignmentScore, GradingAssignmentScoreService> {

  protected static final Logger L = LoggerFactory.getLogger(GradingAssignmentScoreProvider.class);

  /**
   * @param providerID
   *          The ID of the provider.
   * @param serviceProperties
   *          values of provider property file.
   */
  public GradingAssignmentScoreProvider() {
    super(GradingAssignmentScoreType.class, "GradingAssignmentScore", GradingAssignmentScoreCollectionType.class, "GradingAssignmentScores", GradingAssignmentScoreService.class);
  }
}
