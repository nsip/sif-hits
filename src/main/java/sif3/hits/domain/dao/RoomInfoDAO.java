package sif3.hits.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import sif3.hits.domain.model.RoomInfo;

public interface RoomInfoDAO extends JpaRepository<RoomInfo, String> {

}
