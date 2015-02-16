package sif3.hits.rest.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.SessionInfoCollectionType;
import sif.dd.au30.model.SessionInfoType;
import sif3.hits.domain.model.SessionInfo;
import sif3.hits.service.SessionInfoService;

public class SessionInfoProvider extends HitsBaseProvider<SessionInfoType, SessionInfoCollectionType, SessionInfo, SessionInfoService> {

  protected static final Logger L = LoggerFactory.getLogger(SessionInfoProvider.class);

  /**
   * @param providerID
   *          The ID of the provider.
   * @param serviceProperties
   *          values of provider property file.
   */
  public SessionInfoProvider() {
    super(SessionInfoType.class, "SessionInfo", SessionInfoCollectionType.class, "SessionInfos",
        SessionInfoService.class);
  }
}
