package sif3.hits.domain.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sif3.hits.domain.model.NAPTestletTestItem;

public interface NAPTestletTestItemDAO extends JpaRepository<NAPTestletTestItem, Integer> { 
  @Query("from NAPTestletTestItem t where t.napTestlet.refId = :testletRefId and t.napTestItem.refId = :testItemRefId")
  public List<NAPTestletTestItem> findWithRefIds(@Param("testletRefId") String testletRefId, @Param("testItemRefId") String testItemRefId);
}
