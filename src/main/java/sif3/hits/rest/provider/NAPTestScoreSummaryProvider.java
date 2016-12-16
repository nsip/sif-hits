package sif3.hits.rest.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.NAPTestScoreSummaryCollectionType;
import sif.dd.au30.model.NAPTestScoreSummaryType;
import sif3.hits.domain.model.NAPTestScoreSummary;
import sif3.hits.service.NAPTestScoreSummaryService;

public class NAPTestScoreSummaryProvider extends HitsBaseProvider<NAPTestScoreSummaryType, NAPTestScoreSummaryCollectionType, NAPTestScoreSummary, NAPTestScoreSummaryService> {

  protected static final Logger L = LoggerFactory.getLogger(NAPTestScoreSummaryProvider.class);

  /**
   * @param providerID
   *          The ID of the provider.
   * @param serviceProperties
   *          values of provider property file.
   */
  public NAPTestScoreSummaryProvider() {
    super(NAPTestScoreSummaryType.class, "NAPTestScoreSummary", NAPTestScoreSummaryCollectionType.class, "NAPTestScoreSummarys", NAPTestScoreSummaryService.class);
  }

}
