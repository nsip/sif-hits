package sif3.hits.rest.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.ChargedLocationInfoCollectionType;
import sif.dd.au30.model.ChargedLocationInfoType;
import sif3.hits.domain.model.LocationInfo;
import sif3.hits.service.LocationInfoService;

public class LocationInfoProvider extends
    HitsBaseProvider<ChargedLocationInfoType, ChargedLocationInfoCollectionType, LocationInfo, LocationInfoService> {

  protected static final Logger L = LoggerFactory.getLogger(LocationInfoProvider.class);

  /**
   * @param providerID
   *          The ID of the provider.
   * @param serviceProperties
   *          values of provider property file.
   */
  public LocationInfoProvider() {
    super(ChargedLocationInfoType.class, "ChargedLocationInfo", ChargedLocationInfoCollectionType.class, "ChargedLocationInfos",
        LocationInfoService.class);
  }
  
  @Override
  public String getCollectionMethod() {
    return "ChargedLocationInfo";
  }
}
