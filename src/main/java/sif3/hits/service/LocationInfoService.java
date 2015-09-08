package sif3.hits.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.ChargedLocationInfoCollectionType;
import sif.dd.au30.model.ChargedLocationInfoType;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.LocationInfoConverter;
import sif3.hits.domain.dao.AddressDAO;
import sif3.hits.domain.dao.LocationInfoDAO;
import sif3.hits.domain.dao.ZoneFilterableRepository;
import sif3.hits.domain.model.Address;
import sif3.hits.domain.model.LocationInfo;
import sif3.hits.rest.dto.RequestDTO;

@Service
public class LocationInfoService
    extends BaseService<ChargedLocationInfoType, ChargedLocationInfoCollectionType, LocationInfo> {

  @Autowired
  private LocationInfoDAO locationInfoDAO;

  @Autowired
  private AddressDAO addressDAO;

  @Override
  public JpaRepository<LocationInfo, String> getDAO() {
    return locationInfoDAO;
  }

  @Override
  public ZoneFilterableRepository<LocationInfo> getZoneFilterableDAO() {
    return locationInfoDAO;
  }

  @Autowired
  private LocationInfoConverter locationInfoConverter;

  @Override
  public HitsConverter<ChargedLocationInfoType, LocationInfo> getConverter() {
    return locationInfoConverter;
  }

  @Override
  protected ChargedLocationInfoCollectionType getCollection(List<ChargedLocationInfoType> items) {
    ChargedLocationInfoCollectionType result = new ChargedLocationInfoCollectionType();
    if (items != null) {
      result.getChargedLocationInfo().addAll(items);
    }
    return result;
  }

  @Override
  protected LocationInfo getFiltered(String refId, java.util.List<String> schoolRefIds) {
    LocationInfo result = null;
    if (schoolRefIds != null && !schoolRefIds.isEmpty()) {
      result = locationInfoDAO.findOneWithFilter(refId, schoolRefIds);
    }
    return result;
  }

  @Override
  protected void delete(LocationInfo hitsObject, RequestDTO<ChargedLocationInfoType> dto) {
    deleteAddresses(hitsObject);
    super.delete(hitsObject, dto);
  }

  private void deleteAddresses(LocationInfo hitsObject) {
    addressDAO.deleteAllWithPersonRefId(hitsObject.getRefId());
  }

  @Override
  protected LocationInfo save(LocationInfo hitsObject, RequestDTO<ChargedLocationInfoType> dto, String zoneId,
      boolean create) {

    LocationInfo result = null;
    if (!create) {
      deleteAddresses(hitsObject);
    }
    if (hitsObject.getAddresses() != null && !hitsObject.getAddresses().isEmpty()) {
      Set<Address> addresses = new HashSet<Address>(hitsObject.getAddresses());
      hitsObject.getAddresses().clear();
      result = super.save(hitsObject, dto, zoneId, create);
      for (Address address : addresses) {
        address.setPersonRefId(hitsObject.getRefId());
        addressDAO.save(address);
      }
      result.setAddresses(addresses);
    } else {
      result = super.save(hitsObject, dto, zoneId, create);
    }
    return result;
  }
}
