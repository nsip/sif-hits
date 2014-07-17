package sif3.hits.domain.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sif3.hits.domain.model.StaffAssignment;

public interface StaffAssignmentDAO extends JpaRepository<StaffAssignment, String>,
    ZoneFilterableRepository<StaffAssignment> {

  @Query("select s from StaffAssignment s where s.schoolInfoRefId in :schoolRefIds")
  @Override
  public Page<StaffAssignment> findAllWithFilter(@Param("schoolRefIds") List<String> schoolRefIds, Pageable pageable);

  @Override
  @Query("select s from StaffAssignment s where s.refId = :refId and s.schoolInfoRefId in :schoolRefIds")
  public StaffAssignment findOneWithFilter(@Param("refId") String refId, @Param("schoolRefIds") List<String> schoolRefIds);
}
