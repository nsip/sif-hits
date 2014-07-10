package sif3.hits.rest.provider;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.StaffAssignmentCollectionType;
import sif.dd.au30.model.StaffAssignmentType;
import sif3.hits.domain.model.StaffAssignment;
import sif3.hits.service.StaffAssignmentService;

public class StaffAssignmentProvider extends
    HitsBaseProvider<StaffAssignmentType, StaffAssignmentCollectionType, StaffAssignment, StaffAssignmentService> {

  protected static final Logger L = LoggerFactory.getLogger(StaffAssignmentProvider.class);

  /**
   * @param providerID
   *          The ID of the provider.
   * @param serviceProperties
   *          values of provider property file.
   */
  public StaffAssignmentProvider() {
    super(StaffAssignmentType.class, "StaffAssignment", StaffAssignmentCollectionType.class, "StaffAssignments",
        StaffAssignmentService.class);
  }

  @Override
  protected List<StaffAssignmentType> getSifList(StaffAssignmentCollectionType sifCollection) {
    List<StaffAssignmentType> result = null;
    if (sifCollection != null) {
      result = sifCollection.getStaffAssignment();
    }
    return result;
  }
}
