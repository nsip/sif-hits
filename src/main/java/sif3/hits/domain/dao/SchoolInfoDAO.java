package sif3.hits.domain.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sif3.hits.domain.model.SchoolInfo;

public interface SchoolInfoDAO extends JpaRepository<SchoolInfo, String>, ZoneFilterableRepository<SchoolInfo> {

  @Query("select s from SchoolInfo s where s.refId in :schoolRefIds")
  @Override
  public Page<SchoolInfo> findAllWithFilter(@Param("schoolRefIds") List<String> schoolRefIds, Pageable pageable);

}
