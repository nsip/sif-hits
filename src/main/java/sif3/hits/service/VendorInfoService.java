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
import sif3.hits.domain.dao.ZoneFilterableRepository;
import sif3.hits.domain.model.VendorInfo;

@Service
public class VendorInfoService extends BaseService<VendorInfoType, VendorInfoCollectionType, VendorInfo> {

  @Autowired
  private VendorInfoDAO vendorInfoDAO;

  @Override
  public JpaRepository<VendorInfo, String> getDAO() {
    return vendorInfoDAO;
  }

  @Override
  public ZoneFilterableRepository<VendorInfo> getZoneFilterableDAO() {
    return vendorInfoDAO;
  }

  @Autowired
  private VendorInfoConverter locationInfoConverter;

  @Override
  public HitsConverter<VendorInfoType, VendorInfo> getConverter() {
    return locationInfoConverter;
  }

  @Override
  protected VendorInfoCollectionType getCollection(List<VendorInfoType> items) {
    VendorInfoCollectionType result = new VendorInfoCollectionType();
    if (items != null) {
      result.getVendorInfo().addAll(items);
    }
    return result;
  }

  @Override
  protected VendorInfo getFiltered(String refId, java.util.List<String> schoolRefIds) {
    VendorInfo result = null;
    if (schoolRefIds != null && !schoolRefIds.isEmpty()) {
      result = vendorInfoDAO.findOneWithFilter(refId, schoolRefIds);
    }
    return result;
  }
}
