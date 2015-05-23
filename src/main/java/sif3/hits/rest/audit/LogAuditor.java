package sif3.hits.rest.audit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif3.common.interfaces.Auditor;
import sif3.common.model.audit.AuditRecord;

public class LogAuditor implements Auditor {

  private static final Logger L = LoggerFactory.getLogger(LogAuditor.class);

  @Override
  public void audit(AuditRecord auditRecord) {
    L.info(auditRecord.toString());
  }

}
