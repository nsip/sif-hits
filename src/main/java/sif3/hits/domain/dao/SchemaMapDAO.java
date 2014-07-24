package sif3.hits.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sif3.hits.domain.model.SchemaMap;

public interface SchemaMapDAO extends JpaRepository<SchemaMap, Long> {

  @Query("select m from SchemaMap m where m.zoneId is null and m.contextId is null")
  public SchemaMap findDefault();
  
  @Query("select m from SchemaMap m where m.zoneId = :zoneId and m.contextId is null")
  public SchemaMap findDefaultForZone(@Param("zoneId") String zoneId);

  @Query("select m from SchemaMap m where m.zoneId = :zoneId and m.contextId = :contextId")
  public SchemaMap findOneWithZoneIdAndContextId(@Param("zoneId") String zoneId, @Param("contextId") String contextId);

  
}
