package sif3.hits.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sif3.hits.domain.model.StudentPersonalOtherId;
import sif3.hits.domain.model.StudentPersonalOtherIdId;

public interface StudentPersonalOtherIdDAO extends
    JpaRepository<StudentPersonalOtherId, StudentPersonalOtherIdId> {
  @Query("delete from StudentPersonalOtherId s where s.studentPersonalOtherIdId.studentPersonal.refId = :studentPersonalRefId")
  @Modifying
  public void deleteAllWithStudentPersonal(@Param("studentPersonalRefId") String studentPersonalRefId);
}
