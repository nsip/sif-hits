package sif3.hits.rest.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.SchoolCourseInfoCollectionType;
import sif.dd.au30.model.SchoolCourseInfoType;
import sif3.hits.domain.model.SchoolCourseInfo;
import sif3.hits.service.SchoolCourseInfoService;

public class SchoolCourseInfoProvider extends HitsBaseProvider<SchoolCourseInfoType, SchoolCourseInfoCollectionType, SchoolCourseInfo, SchoolCourseInfoService> {

  protected static final Logger L = LoggerFactory.getLogger(SchoolCourseInfoProvider.class);

  /**
   * @param providerID
   *          The ID of the provider.
   * @param serviceProperties
   *          values of provider property file.
   */
  public SchoolCourseInfoProvider() {
    super(SchoolCourseInfoType.class, "SchoolCourseInfo", SchoolCourseInfoCollectionType.class, "SchoolCourseInfos", SchoolCourseInfoService.class);
  }
}
