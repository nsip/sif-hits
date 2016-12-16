package sif3.hits.domain.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sif3.hits.domain.model.NAPTestItem;

public interface NAPTestItemDAO extends BaseRepository<NAPTestItem> {

  @Query("from NAPTestItem t where t.localId = :localId")
  public List<NAPTestItem> findWithLocalId(@Param("localId") String localId);

}
