package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.RoomInfoCollectionType;
import sif.dd.au30.model.RoomInfoType;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.RoomInfoConverter;
import sif3.hits.domain.dao.RoomInfoDAO;
import sif3.hits.domain.dao.ZoneFilterableRepository;
import sif3.hits.domain.model.RoomInfo;

@Service
public class RoomInfoService extends BaseService<RoomInfoType, RoomInfoCollectionType, RoomInfo> {

  @Autowired
  private RoomInfoDAO roomInfoDAO;

  @Override
  public JpaRepository<RoomInfo, String> getDAO() {
    return roomInfoDAO;
  }

  @Override
  public ZoneFilterableRepository<RoomInfo> getZoneFilterableDAO() {
    return roomInfoDAO;
  }

  @Autowired
  private RoomInfoConverter studentPersonalConverter;

  @Override
  public HitsConverter<RoomInfoType, RoomInfo> getConverter() {
    return studentPersonalConverter;
  }

  @Override
  protected RoomInfoCollectionType getCollection(List<RoomInfoType> items) {
    RoomInfoCollectionType result = new RoomInfoCollectionType();
    if (items != null) {
      result.getRoomInfo().addAll(items);
    }
    return result;
  }

  @Override
  protected RoomInfo getFiltered(String refId, java.util.List<String> schoolRefIds) {
    RoomInfo result = null;
    if (schoolRefIds != null && !schoolRefIds.isEmpty()) {
      result = roomInfoDAO.findOne(refId);
      if (result != null) {
        if (!schoolRefIds.contains(result.getSchoolInfoRefId())) {
          result = null;
        }
      }
    }
    return result;
  }
}
