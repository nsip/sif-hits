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
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.dao.filter.RoomInfoFilterDAO;
import sif3.hits.domain.model.RoomInfo;

@Service
public class RoomInfoService extends BaseService<RoomInfoType, RoomInfoCollectionType, RoomInfo> {

  @Autowired
  private RoomInfoConverter roomInfoConverter;
  
  @Autowired
  private RoomInfoDAO roomInfoDAO;

  @Autowired
  private RoomInfoFilterDAO roomInfoFilterDAO;

  @Override
  protected RoomInfoCollectionType getCollection(List<RoomInfoType> items) {
    RoomInfoCollectionType result = new RoomInfoCollectionType();
    if (items != null) {
      result.getRoomInfo().addAll(items);
    }
    return result;
  }

  @Override
  protected HitsConverter<RoomInfoType, RoomInfo> getConverter() {
    return roomInfoConverter;
  }

  @Override
  protected JpaRepository<RoomInfo, String> getDAO() {
    return roomInfoDAO;
  }
  
  @Override
  protected FilterableRepository<RoomInfo,RoomInfoType> getFilterableDAO() {
    return roomInfoFilterDAO;
  }

}
