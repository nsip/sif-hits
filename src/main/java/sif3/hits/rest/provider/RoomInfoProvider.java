package sif3.hits.rest.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.RoomInfoCollectionType;
import sif.dd.au30.model.RoomInfoType;
import sif3.hits.domain.model.RoomInfo;
import sif3.hits.service.RoomInfoService;

public class RoomInfoProvider extends HitsBaseProvider<RoomInfoType, RoomInfoCollectionType, RoomInfo, RoomInfoService> {

  protected static final Logger L = LoggerFactory.getLogger(RoomInfoProvider.class);

  /**
   * @param providerID
   *          The ID of the provider.
   * @param serviceProperties
   *          values of provider property file.
   */
  public RoomInfoProvider() {
    super(RoomInfoType.class, "RoomInfo", RoomInfoCollectionType.class, "RoomInfos", RoomInfoService.class);
  }
}
