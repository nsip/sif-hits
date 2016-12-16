package sif3.hits.domain.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sif3.hits.domain.model.NAPTestlet;

public interface NAPTestletDAO extends BaseRepository<NAPTestlet> {

  @Query("from NAPTestlet t where t.localId = :localId")
  public List<NAPTestlet> findWithLocalId(@Param("localId") String localId);
  
}
