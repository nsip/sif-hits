package sif3.hits.rest.provider;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.SchoolCollectionType;
import sif.dd.au30.model.SchoolInfoType;
import sif3.hits.domain.model.SchoolInfo;
import sif3.hits.service.SchoolInfoService;

public class SchoolInfoProvider extends
    HitsBaseProvider<SchoolInfoType, SchoolCollectionType, SchoolInfo, SchoolInfoService> {

  protected static final Logger L = LoggerFactory.getLogger(SchoolInfoProvider.class);

  /**
   * @param providerID
   *          The ID of the provider.
   * @param serviceProperties
   *          values of provider property file.
   */
  public SchoolInfoProvider() {
    super(SchoolInfoType.class, "SchoolInfo", SchoolCollectionType.class, "SchoolInfos", SchoolInfoService.class);
  }

  @Override
  protected List<SchoolInfoType> getSifList(SchoolCollectionType sifCollection) {
    List<SchoolInfoType> result = null;
    if (sifCollection != null) {
      result = sifCollection.getSchoolInfo();
    }
    return result;
  }
}
