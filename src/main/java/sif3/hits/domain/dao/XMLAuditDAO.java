package sif3.hits.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import sif3.hits.domain.model.XMLAudit;

public interface XMLAuditDAO extends JpaRepository<XMLAudit, Long> {

}
