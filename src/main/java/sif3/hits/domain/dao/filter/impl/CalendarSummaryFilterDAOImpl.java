package sif3.hits.domain.dao.filter.impl;

import org.springframework.stereotype.Repository;

import sif.dd.au30.model.CalendarSummaryType;
import sif3.hits.domain.dao.filter.CalendarSummaryFilterDAO;
import sif3.hits.domain.model.CalendarSummary;

@Repository
public class CalendarSummaryFilterDAOImpl extends BaseFilterableRepository<CalendarSummary, CalendarSummaryType> implements CalendarSummaryFilterDAO {
    public CalendarSummaryFilterDAOImpl() {
        super(CalendarSummary.class, CalendarSummaryType.class);
    }
}
