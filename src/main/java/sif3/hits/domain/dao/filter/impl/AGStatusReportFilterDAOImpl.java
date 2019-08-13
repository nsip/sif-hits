package sif3.hits.domain.dao.filter.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.springframework.stereotype.Repository;
import sif.dd.au30.model.AGStatusReportType;
import sif3.hits.domain.dao.filter.AGStatusReportFilterDAO;
import sif3.hits.domain.model.AGStatusReport;
import sif3.hits.domain.model.StaffAssignment;

@Repository
public class AGStatusReportFilterDAOImpl extends BaseFilterableRepository<AGStatusReport, AGStatusReportType> implements AGStatusReportFilterDAO {
    public AGStatusReportFilterDAOImpl() {
        super(AGStatusReport.class, AGStatusReportType.class);
    }
}
