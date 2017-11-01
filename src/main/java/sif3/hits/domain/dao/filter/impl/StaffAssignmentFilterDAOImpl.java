package sif3.hits.domain.dao.filter.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import sif3.hits.domain.dao.filter.StaffAssignmentFilterDAO;
import sif3.hits.domain.model.StaffAssignment;

@Repository
public class StaffAssignmentFilterDAOImpl extends BaseFilterableRepository<StaffAssignment>implements StaffAssignmentFilterDAO {
  public StaffAssignmentFilterDAOImpl() {
    super(StaffAssignment.class);
  }
  
  protected void addServicePathCriteria(Criteria criteria, String key, String value) {
    if ("SchoolInfos".equals(key)) {
      criteria.add(Restrictions.eq("schoolInfoRefId", value));      
    } else {
      super.addServicePathCriteria(criteria, key, value);
    }
  }

}
