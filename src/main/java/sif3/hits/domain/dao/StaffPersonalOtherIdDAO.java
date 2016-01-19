package sif3.hits.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sif3.hits.domain.model.StaffPersonal;
import sif3.hits.domain.model.StaffPersonalOtherId;
import sif3.hits.domain.model.StaffPersonalOtherIdId;

public interface StaffPersonalOtherIdDAO extends JpaRepository<StaffPersonalOtherId, StaffPersonalOtherIdId> {
  @Query("delete from StaffPersonalOtherId s where s.staffPersonalOtherIdId.staffPersonal = :staffPersonal")
  @Modifying
  public void deleteAllWithStaffPersonal(@Param("staffPersonal") StaffPersonal staffPersonal);
}
