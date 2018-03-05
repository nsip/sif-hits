package sif3.hits.domain.dao.filter.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import sif.dd.au30.model.ChargedLocationInfoType;
import sif3.hits.domain.dao.filter.LocationInfoFilterDAO;
import sif3.hits.domain.model.LocationInfo;

@Repository
public class LocationInfoFilterDAOImpl extends BaseFilterableRepository<LocationInfo, ChargedLocationInfoType> implements LocationInfoFilterDAO {
    public LocationInfoFilterDAOImpl() {
        super(LocationInfo.class, ChargedLocationInfoType.class);
    }
    
    @Override
    protected void addServicePathCriteria(Criteria criteria, String key, String value) {
        if ("SchoolInfos".equals(key)) {
            criteria.add(Restrictions.eq("schoolInfoRefId", value));
        } else {
            super.addServicePathCriteria(criteria, key, value);
        }
    }
}
