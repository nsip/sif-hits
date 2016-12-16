package sif3.hits.domain.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sif3.hits.domain.model.StudentPersonal;

public interface StudentPersonalDAO extends BaseRepository<StudentPersonal> {

  @Query("from StudentPersonal s where s.refId in (select sid.studentPersonalOtherIdId.studentPersonal.refId from StudentPersonalOtherId sid where sid.studentPersonalOtherIdId.otherIdType = :idType and sid.studentPersonalOtherIdId.otherId = :idValue)")
  public List<StudentPersonal> findWithOtherId(@Param("idType") String idType, @Param("idValue") String idValue);

}