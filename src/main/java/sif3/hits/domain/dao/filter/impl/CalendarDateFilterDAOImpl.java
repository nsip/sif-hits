package sif3.hits.domain.dao.filter.impl;

import org.springframework.stereotype.Repository;

import sif.dd.au30.model.CalendarDateType;
import sif3.hits.domain.dao.filter.CalendarDateFilterDAO;
import sif3.hits.domain.model.CalendarDate;

@Repository
public class CalendarDateFilterDAOImpl extends BaseFilterableRepository<CalendarDate, CalendarDateType> implements CalendarDateFilterDAO {
    public CalendarDateFilterDAOImpl() {
        super(CalendarDate.class, CalendarDateType.class);
    }
}
