package sif3.hits.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import sif3.hits.domain.model.TimeTableCell;

public interface TimeTableCellDAO extends JpaRepository<TimeTableCell, String> {

}
