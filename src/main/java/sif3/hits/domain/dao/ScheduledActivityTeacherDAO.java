package sif3.hits.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sif3.hits.domain.model.ScheduledActivity;
import sif3.hits.domain.model.ScheduledActivityTeacher;
import sif3.hits.domain.model.ScheduledActivityTeacherId;

public interface ScheduledActivityTeacherDAO extends
    JpaRepository<ScheduledActivityTeacher, ScheduledActivityTeacherId> {
  @Query("delete from ScheduledActivityTeacher s where s.scheduledActivityTeacherId.scheduledActivity = :scheduledActivity")
  @Modifying
  public void deleteAllWithScheduledActivity(@Param("scheduledActivity") ScheduledActivity scheduledActivity);
}
