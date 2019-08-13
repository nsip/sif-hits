package sif3.hits.domain.dao.filter.impl;

import org.springframework.stereotype.Repository;

import sif.dd.au30.model.FQReportingType;
import sif3.hits.domain.dao.filter.FQReportingFilterDAO;
import sif3.hits.domain.model.FQReporting;

@Repository
public class FQReportingFilterDAOImpl extends BaseFilterableRepository<FQReporting, FQReportingType> implements FQReportingFilterDAO {
    public FQReportingFilterDAOImpl() {
        super(FQReporting.class, FQReportingType.class);
    }
}
