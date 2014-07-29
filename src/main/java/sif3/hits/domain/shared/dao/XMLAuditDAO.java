package sif3.hits.domain.shared.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import sif3.hits.domain.shared.model.XMLAudit;

public interface XMLAuditDAO extends JpaRepository<XMLAudit, Long> {

}
