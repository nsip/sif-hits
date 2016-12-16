package sif3.hits.domain.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sif3.hits.domain.model.NAPTest;

public interface NAPTestDAO extends BaseRepository<NAPTest> {
  
  @Query("from NAPTest t where t.localId = :localId")
  public List<NAPTest> findWithLocalId(@Param("localId") String localId);
  

}
