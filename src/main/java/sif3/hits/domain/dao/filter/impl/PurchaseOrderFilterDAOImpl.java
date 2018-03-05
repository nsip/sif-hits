package sif3.hits.domain.dao.filter.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.springframework.stereotype.Repository;

import sif.dd.au30.model.PurchaseOrderType;
import sif3.hits.domain.dao.filter.PurchaseOrderFilterDAO;
import sif3.hits.domain.model.LocationInfo;
import sif3.hits.domain.model.PurchaseOrder;

@Repository
public class PurchaseOrderFilterDAOImpl extends BaseFilterableRepository<PurchaseOrder, PurchaseOrderType> implements PurchaseOrderFilterDAO {
    public PurchaseOrderFilterDAOImpl() {
        super(PurchaseOrder.class, PurchaseOrderType.class);
    }
    
    @Override
    protected void addServicePathCriteria(Criteria criteria, String key, String value) {
        if ("SchoolInfos".equals(key)) {
            DetachedCriteria locationQuery = DetachedCriteria.forClass(LocationInfo.class);
            locationQuery.add(Restrictions.eq("schoolInfoRefId", value));
            locationQuery.setProjection(Projections.property("refId"));
            criteria.add(Subqueries.propertyIn("locationInfoRefId", locationQuery));
        } else {
            super.addServicePathCriteria(criteria, key, value);
        }
    }
}
