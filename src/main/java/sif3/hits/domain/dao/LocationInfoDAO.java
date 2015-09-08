package sif3.hits.domain.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sif3.hits.domain.model.LocationInfo;

public interface LocationInfoDAO extends JpaRepository<LocationInfo, String>, ZoneFilterableRepository<LocationInfo> {
  @Query("select distinct l from LocationInfo l where (1 = 1 OR l.refId in (:schoolRefIds))")
  @Override
  public Page<LocationInfo> findAllWithFilter(@Param("schoolRefIds") List<String> schoolRefIds, Pageable pageable);

  @Query("select distinct l from LocationInfo l where l.refId = :refId and (1 = 1 OR l.refId in (:schoolRefIds))")
  @Override
  public LocationInfo findOneWithFilter(@Param("refId") String refId, @Param("schoolRefIds") List<String> schoolRefIds);
}
