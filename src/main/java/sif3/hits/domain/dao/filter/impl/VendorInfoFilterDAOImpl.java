package sif3.hits.domain.dao.filter.impl;

import org.springframework.stereotype.Repository;

import sif3.hits.domain.dao.filter.VendorInfoFilterDAO;
import sif3.hits.domain.model.VendorInfo;

@Repository
public class VendorInfoFilterDAOImpl extends BaseFilterableRepository<VendorInfo>implements VendorInfoFilterDAO {
  public VendorInfoFilterDAOImpl() {
    super(VendorInfo.class);
  }
}