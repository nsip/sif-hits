package sif3.hits.domain.dao.filter.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import sif3.hits.domain.dao.filter.TimeTableSubjectFilterDAO;
import sif3.hits.domain.model.TimeTableSubject;

@Repository
public class TimeTableSubjectFilterDAOImpl extends BaseFilterableRepository<TimeTableSubject>implements TimeTableSubjectFilterDAO {
  public TimeTableSubjectFilterDAOImpl() {
    super(TimeTableSubject.class);
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
