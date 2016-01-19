package sif3.hits.rest.provider;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.TeachingGroupCollectionType;
import sif.dd.au30.model.TeachingGroupType;
import sif3.hits.domain.model.TeachingGroup;
import sif3.hits.service.TeachingGroupService;

public class TeachingGroupProvider extends HitsBaseProvider<TeachingGroupType, TeachingGroupCollectionType, TeachingGroup, TeachingGroupService> {

  protected static final Logger L = LoggerFactory.getLogger(TeachingGroupProvider.class);

  /**
   * @param providerID
   *          The ID of the provider.
   * @param serviceProperties
   *          values of provider property file.
   */
  public TeachingGroupProvider() {
    super(TeachingGroupType.class, "TeachingGroup", TeachingGroupCollectionType.class, "TeachingGroups", TeachingGroupService.class);
  }

  @Override
  protected List<TeachingGroupType> getSifList(TeachingGroupCollectionType sifCollection) {
    List<TeachingGroupType> result = null;
    if (sifCollection != null) {
      result = sifCollection.getTeachingGroup();
    }
    return result;
  }
}
