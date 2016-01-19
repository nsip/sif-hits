package sif3.hits.domain.dao.filter.impl;

import org.springframework.stereotype.Repository;

import sif3.hits.domain.dao.filter.CalendarDateFilterDAO;
import sif3.hits.domain.model.CalendarDate;

@Repository
public class CalendarDateFilterDAOImpl extends BaseFilterableRepository<CalendarDate>implements CalendarDateFilterDAO {
  public CalendarDateFilterDAOImpl() {
    super(CalendarDate.class);
  }
}
