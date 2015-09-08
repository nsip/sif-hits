package sif3.hits.rest.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.FinancialClassificationCollectionType;
import sif.dd.au30.model.FinancialClassificationType;
import sif3.hits.domain.model.FinancialClass;
import sif3.hits.service.FinancialClassService;

public class FinancialClassificationProvider extends
    HitsBaseProvider<FinancialClassificationType, FinancialClassificationCollectionType, FinancialClass, FinancialClassService> {

  protected static final Logger L = LoggerFactory.getLogger(FinancialClassificationProvider.class);

  /**
   * @param providerID
   *          The ID of the provider.
   * @param serviceProperties
   *          values of provider property file.
   */
  public FinancialClassificationProvider() {
    super(FinancialClassificationType.class, "FinancialClassification", FinancialClassificationCollectionType.class,
        "FinancialClassifications", FinancialClassService.class);
  }
  
  @Override
  public String getCollectionMethod() {
    return "FinancialClassification";
  }
}
