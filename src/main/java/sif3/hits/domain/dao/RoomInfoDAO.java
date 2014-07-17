package sif3.hits.domain.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sif3.hits.domain.model.RoomInfo;

public interface RoomInfoDAO extends JpaRepository<RoomInfo, String>, ZoneFilterableRepository<RoomInfo> {

  @Query("select r from RoomInfo r where r.schoolInfoRefId in :schoolRefIds")
  @Override
  public Page<RoomInfo> findAllWithFilter(@Param("schoolRefIds") List<String> schoolRefIds, Pageable pageable);
  
  @Query("select r from RoomInfo r where r.refId = :refId and r.schoolInfoRefId in :schoolRefIds")
  @Override
  public RoomInfo findOneWithFilter(@Param("refId") String refId, @Param("schoolRefIds") List<String> schoolRefIds);
}
