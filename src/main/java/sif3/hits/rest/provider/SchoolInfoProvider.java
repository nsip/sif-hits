package sif3.hits.rest.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.SchoolInfoCollectionType;
import sif.dd.au30.model.SchoolInfoType;
import sif3.hits.domain.model.SchoolInfo;
import sif3.hits.service.SchoolInfoService;

public class SchoolInfoProvider extends HitsBaseProvider<SchoolInfoType, SchoolInfoCollectionType, SchoolInfo, SchoolInfoService> {

  protected static final Logger L = LoggerFactory.getLogger(SchoolInfoProvider.class);

  /**
   * @param providerID
   *          The ID of the provider.
   * @param serviceProperties
   *          values of provider property file.
   */
  public SchoolInfoProvider() {
    super(SchoolInfoType.class, "SchoolInfo", SchoolInfoCollectionType.class, "SchoolInfos", SchoolInfoService.class);
  }
}
