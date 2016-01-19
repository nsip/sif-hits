package sif3.hits.domain.dao.filter.impl;

import org.springframework.stereotype.Repository;

import sif3.hits.domain.dao.filter.RoomInfoFilterDAO;
import sif3.hits.domain.model.RoomInfo;

@Repository
public class RoomInfoFilterDAOImpl extends BaseFilterableRepository<RoomInfo>implements RoomInfoFilterDAO {
  public RoomInfoFilterDAOImpl() {
    super(RoomInfo.class);
  }
}
