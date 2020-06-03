package sif3.hits.rest.provider;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.TermInfoCollectionType;
import sif.dd.au30.model.TermInfoType;
import sif3.hits.domain.model.TermInfo;
import sif3.hits.service.TermInfoService;

public class TermInfoProvider extends HitsBaseProvider<TermInfoType, TermInfoCollectionType, TermInfo, TermInfoService> {

  protected static final Logger L = LoggerFactory.getLogger(TermInfoProvider.class);

  /**
   * @param providerID
   *          The ID of the provider.
   * @param serviceProperties
   *          values of provider property file.
   */
  public TermInfoProvider() {
    super(TermInfoType.class, "TermInfo", TermInfoCollectionType.class, "TermInfos", TermInfoService.class);
  }

  @Override
  protected List<TermInfoType> getSifList(TermInfoCollectionType sifCollection) {
    List<TermInfoType> result = null;
    if (sifCollection != null) {
			result = sifCollection.getTermInfo();
    }
    return result;
  }
}
