package sif3.hits.domain.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sif3.hits.domain.model.SchoolInfo;

public interface ZoneSchoolDAO extends JpaRepository<SchoolInfo, String> {
  public SchoolInfo findByRefIdAndZoneId(String refId, String zoneId);
  public List<SchoolInfo> findByZoneId(String zoneId);
}
