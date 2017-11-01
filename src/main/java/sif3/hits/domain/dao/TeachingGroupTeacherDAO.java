package sif3.hits.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sif3.hits.domain.model.TeachingGroup;
import sif3.hits.domain.model.TeachingGroupTeacher;
import sif3.hits.domain.model.TeachingGroupTeacherId;

public interface TeachingGroupTeacherDAO extends JpaRepository<TeachingGroupTeacher, TeachingGroupTeacherId> {

  @Query("delete from TeachingGroupTeacher t where t.teachingGroupTeacherId.teachingGroup = :teachingGroup")
  @Modifying
  public void deleteAllWithTeachingGroup(@Param("teachingGroup") TeachingGroup teachingGroup);

}
