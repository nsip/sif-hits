package sif3.hits.domain.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sif3.hits.domain.model.RoomInfo;

public interface RoomInfoDAO extends JpaRepository<RoomInfo, String>, ZoneFilterableRepository<RoomInfo> {

  @Query("select s from RoomInfo s where s.schoolInfoRefId in :schoolRefIds")
  @Override
  public Page<RoomInfo> findAllWithFilter(@Param("schoolRefIds") List<String> schoolRefIds, Pageable pageable);
  
}
