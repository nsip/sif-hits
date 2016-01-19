package sif3.hits.domain.dao.filter.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import sif3.hits.domain.dao.filter.TimeTableFilterDAO;
import sif3.hits.domain.model.TimeTable;

@Repository
public class TimeTableFilterDAOImpl extends BaseFilterableRepository<TimeTable>implements TimeTableFilterDAO {
  public TimeTableFilterDAOImpl() {
    super(TimeTable.class);
  }
  
  @Override
  protected void addServicePathCriteria(Criteria criteria, String key, String value) {
    if ("SchoolInfos".equals(key)) {
      criteria.createAlias("schoolInfo", "school");
      criteria.add(Restrictions.eq("school.refId", value));
    } else {
      super.addServicePathCriteria(criteria, key, value);
    }
  }
}
