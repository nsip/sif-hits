package sif3.hits.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import sif3.hits.domain.model.TimeTableSubject;

public interface TimeTableSubjectDAO extends JpaRepository<TimeTableSubject, String>, ZoneFilterableRepository<TimeTableSubject> {

}
