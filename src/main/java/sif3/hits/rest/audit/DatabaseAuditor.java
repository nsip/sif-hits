package sif3.hits.rest.audit;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import sif3.hits.config.HitsSpringContext;
import sif3.hits.domain.dao.XMLAuditDAO;
import sif3.hits.domain.model.XMLAudit;
import sif3.infra.rest.audit.AuditRecord;
import sif3.infra.rest.audit.Auditor;

@Component
public class DatabaseAuditor implements Auditor {

  private XMLAuditDAO xmlAuditDAO;

  public DatabaseAuditor() {
    initialise();
  }

  private void initialise() {
    if (xmlAuditDAO == null) {
      xmlAuditDAO = HitsSpringContext.getBean(XMLAuditDAO.class);
    }
  }

  @Override
  @Transactional
  public void audit(AuditRecord auditRecord) {
    XMLAudit xmlAudit = new XMLAudit();
    BeanUtils.copyProperties(auditRecord, xmlAudit);
    xmlAuditDAO.save(xmlAudit);
  }

}
