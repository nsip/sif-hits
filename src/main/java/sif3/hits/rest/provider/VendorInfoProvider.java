package sif3.hits.rest.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.VendorInfoCollectionType;
import sif.dd.au30.model.VendorInfoType;
import sif3.hits.domain.model.VendorInfo;
import sif3.hits.service.VendorInfoService;

public class VendorInfoProvider extends
    HitsBaseProvider<VendorInfoType, VendorInfoCollectionType, VendorInfo, VendorInfoService> {

  protected static final Logger L = LoggerFactory.getLogger(VendorInfoProvider.class);

  /**
   * @param providerID
   *          The ID of the provider.
   * @param serviceProperties
   *          values of provider property file.
   */
  public VendorInfoProvider() {
    super(VendorInfoType.class, "VendorInfo", VendorInfoCollectionType.class, "VendorInfos",
        VendorInfoService.class);
  }
}
