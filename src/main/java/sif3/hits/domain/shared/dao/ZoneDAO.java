package sif3.hits.domain.shared.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sif3.hits.domain.shared.model.Zone;

public interface ZoneDAO extends JpaRepository<Zone, Long> {

  @Query("select z from Zone z where z.zoneId is null and z.contextId is null")
  public Zone findDefault();
  
  @Query("select z from Zone z where z.zoneId = :zoneId and z.contextId is null")
  public Zone findDefaultForZone(@Param("zoneId") String zoneId);

  @Query("select z from Zone z where z.zoneId = :zoneId and z.contextId = :contextId")
  public Zone findOneWithZoneIdAndContextId(@Param("zoneId") String zoneId, @Param("contextId") String contextId);
  
}
