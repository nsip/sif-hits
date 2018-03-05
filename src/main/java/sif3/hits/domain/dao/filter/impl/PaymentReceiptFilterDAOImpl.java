package sif3.hits.domain.dao.filter.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.springframework.stereotype.Repository;

import sif.dd.au30.model.PaymentReceiptType;
import sif3.hits.domain.dao.filter.PaymentReceiptFilterDAO;
import sif3.hits.domain.model.LocationInfo;
import sif3.hits.domain.model.PaymentReceipt;

@Repository
public class PaymentReceiptFilterDAOImpl extends BaseFilterableRepository<PaymentReceipt, PaymentReceiptType> implements PaymentReceiptFilterDAO {
    public PaymentReceiptFilterDAOImpl() {
        super(PaymentReceipt.class, PaymentReceiptType.class);
    }

    @Override
    protected void addServicePathCriteria(Criteria criteria, String key, String value) {
        if ("SchoolInfos".equals(key)) {
            DetachedCriteria locationQuery = DetachedCriteria.forClass(LocationInfo.class);
            locationQuery.add(Restrictions.eq("schoolInfoRefId", value));
            locationQuery.setProjection(Projections.property("refId"));
            criteria.add(Subqueries.propertyIn("locationInfoRefId", locationQuery));
        } else if ("Invoices".equals(key)) {
            criteria.add(Restrictions.eq("invoiceRefId", value));
        } else {
            super.addServicePathCriteria(criteria, key, value);
        }
    }
}
