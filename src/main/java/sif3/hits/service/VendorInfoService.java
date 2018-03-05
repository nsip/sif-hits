package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.VendorInfoCollectionType;
import sif.dd.au30.model.VendorInfoType;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.VendorInfoConverter;
import sif3.hits.domain.dao.VendorInfoDAO;
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.dao.filter.VendorInfoFilterDAO;
import sif3.hits.domain.model.VendorInfo;

@Service
public class VendorInfoService extends BaseService<VendorInfoType, VendorInfoCollectionType, VendorInfo> {

  @Autowired
  private VendorInfoConverter locationInfoConverter;

  @Autowired
  private VendorInfoDAO vendorInfoDAO;

  @Autowired
  private VendorInfoFilterDAO vendorInfoFilterDAO;

  @Override
  protected VendorInfoCollectionType getCollection(List<VendorInfoType> items) {
    VendorInfoCollectionType result = new VendorInfoCollectionType();
    if (items != null) {
      result.getVendorInfo().addAll(items);
    }
    return result;
  }

  @Override
  protected HitsConverter<VendorInfoType, VendorInfo> getConverter() {
    return locationInfoConverter;
  }

  @Override
  protected JpaRepository<VendorInfo, String> getDAO() {
    return vendorInfoDAO;
  }

  @Override
  protected FilterableRepository<VendorInfo,VendorInfoType> getFilterableDAO() {
    return vendorInfoFilterDAO;
  }
}
