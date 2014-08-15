package sif3.hits.domain.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sif3.hits.domain.model.StaffPersonal;

public interface StaffPersonalDAO extends JpaRepository<StaffPersonal, String>, ZoneFilterableRepository<StaffPersonal> {

  @Query("select distinct s from StaffPersonal s, StaffAssignment a where a.schoolInfoRefId in :schoolRefIds and a.staffPersonalRefId = s.refId")
  @Override
  public Page<StaffPersonal> findAllWithFilter(@Param("schoolRefIds") List<String> schoolRefIds, Pageable pageable);

  @Query("select distinct s from StaffPersonal s, StaffAssignment a where s.refId = :refId and a.schoolInfoRefId in :schoolRefIds and a.staffPersonalRefId = s.refId")
  @Override
  public StaffPersonal findOneWithFilter(@Param("refId") String refId, @Param("schoolRefIds") List<String> schoolRefIds);
}
