package sif3.hits.domain.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sif3.hits.domain.model.SchoolInfo;

public interface ZoneDAO extends JpaRepository<SchoolInfo, String> {
  public List<SchoolInfo> findByZoneId(String zoneId);
}
