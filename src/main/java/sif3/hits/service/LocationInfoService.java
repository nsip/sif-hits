package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.ChargedLocationInfoCollectionType;
import sif.dd.au30.model.ChargedLocationInfoType;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.LocationInfoConverter;
import sif3.hits.domain.dao.LocationInfoDAO;
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.dao.filter.LocationInfoFilterDAO;
import sif3.hits.domain.model.LocationInfo;

@Service
public class LocationInfoService extends BaseService<ChargedLocationInfoType, ChargedLocationInfoCollectionType, LocationInfo> {

  @Autowired
  private LocationInfoConverter locationInfoConverter;

  @Autowired
  private LocationInfoDAO locationInfoDAO;

  @Autowired
  private LocationInfoFilterDAO locationInfoFilterDAO;

  @Override
  protected ChargedLocationInfoCollectionType getCollection(List<ChargedLocationInfoType> items) {
    ChargedLocationInfoCollectionType result = new ChargedLocationInfoCollectionType();
    if (items != null) {
      result.getChargedLocationInfo().addAll(items);
    }
    return result;
  }

  @Override
  protected HitsConverter<ChargedLocationInfoType, LocationInfo> getConverter() {
    return locationInfoConverter;
  }

  @Override
  protected JpaRepository<LocationInfo, String> getDAO() {
    return locationInfoDAO;
  }

  @Override
  protected FilterableRepository<LocationInfo> getFilterableDAO() {
    return locationInfoFilterDAO;
  }

}
