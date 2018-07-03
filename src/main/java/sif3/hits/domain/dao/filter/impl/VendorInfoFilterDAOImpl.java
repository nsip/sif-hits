package sif3.hits.domain.dao.filter.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.springframework.stereotype.Repository;

import sif.dd.au30.model.VendorInfoType;
import sif3.hits.domain.dao.filter.VendorInfoFilterDAO;
import sif3.hits.domain.model.LocationInfo;
import sif3.hits.domain.model.PurchaseOrder;
import sif3.hits.domain.model.VendorInfo;

@Repository
public class VendorInfoFilterDAOImpl extends BaseFilterableRepository<VendorInfo, VendorInfoType> implements VendorInfoFilterDAO {
    public VendorInfoFilterDAOImpl() {
        super(VendorInfo.class, VendorInfoType.class);
    }

    @Override
    protected void addServicePathCriteria(Criteria criteria, String key, String value) {
        if ("SchoolInfos".equals(key)) {
            DetachedCriteria locationQuery = DetachedCriteria.forClass(LocationInfo.class);
            locationQuery.add(Restrictions.eq("schoolInfoRefId", value));
            locationQuery.setProjection(Projections.property("refId"));
            
            DetachedCriteria purchaseOrderQuery = DetachedCriteria.forClass(PurchaseOrder.class);
            purchaseOrderQuery.add(Subqueries.propertyIn("locationInfoRefId", locationQuery));
            purchaseOrderQuery.setProjection(Projections.property("vendorInfoRefId"));
            
            criteria.add(Subqueries.propertyIn("refId", purchaseOrderQuery));
        } else {
            super.addServicePathCriteria(criteria, key, value);
        }
    }
    
    
}