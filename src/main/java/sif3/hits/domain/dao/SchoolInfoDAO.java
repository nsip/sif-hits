package sif3.hits.domain.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sif3.hits.domain.model.SchoolInfo;

public interface SchoolInfoDAO extends BaseRepository<SchoolInfo> {

  @Query("from SchoolInfo s where s.acaraId = :acaraId")
  public List<SchoolInfo> findWithAcaraId(@Param("acaraId") String acaraId);

}
