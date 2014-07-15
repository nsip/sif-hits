package sif3.hits.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sif3.hits.domain.model.TimeTableSubject;
import sif3.hits.domain.model.TimeTableSubjectOtherCode;

public interface TimeTableSubjectOtherCodeDAO extends JpaRepository<TimeTableSubjectOtherCode, String> {
  @Query("delete from TimeTableSubjectOtherCode t where t.timeTableSubjectOtherCodeId.timeTableSubject = :timeTableSubject")
  @Modifying
  public void deleteAllWithTimeTableSubject(@Param("timeTableSubject") TimeTableSubject timeTableSubject);
}
