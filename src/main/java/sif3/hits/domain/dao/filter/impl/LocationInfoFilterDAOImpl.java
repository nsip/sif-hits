package sif3.hits.domain.dao.filter.impl;

import org.springframework.stereotype.Repository;

import sif3.hits.domain.dao.filter.LocationInfoFilterDAO;
import sif3.hits.domain.model.LocationInfo;

@Repository
public class LocationInfoFilterDAOImpl extends BaseFilterableRepository<LocationInfo>implements LocationInfoFilterDAO {
  public LocationInfoFilterDAOImpl() {
    super(LocationInfo.class);
  }
}
