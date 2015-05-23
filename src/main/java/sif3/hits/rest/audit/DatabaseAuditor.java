package sif3.hits.rest.audit;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import sif3.common.interfaces.Auditor;
import sif3.common.model.audit.AuditRecord;
import sif3.common.model.audit.RequestData;
import sif3.common.model.audit.ResponseData;
import sif3.common.model.audit.SIFData;
import sif3.hits.config.HitsSpringContext;
import sif3.hits.domain.shared.dao.XMLAuditDAO;
import sif3.hits.domain.shared.model.XMLAudit;

import com.google.gson.Gson;

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
  @Transactional(value = "sharedTransactionManager")
  public void audit(AuditRecord auditRecord) {
    XMLAudit xmlAudit = new XMLAudit();
    copyProperties(auditRecord, xmlAudit);
    xmlAuditDAO.save(xmlAudit);
  }

  private void copyProperties(AuditRecord auditRecord, XMLAudit xmlAudit) {
    Gson gson = new Gson();
    if (xmlAudit != null && auditRecord != null) {
      if (auditRecord.getRequestData() != null) {
        RequestData requestData = auditRecord.getRequestData();
        xmlAudit.setRequestTime(requestData.getTimestamp());
        xmlAudit.setClientIp(requestData.getClientIp());
        xmlAudit.setUrl(requestData.getUrl());
        xmlAudit.setMethod(requestData.getMethod());
        xmlAudit.setQueryParameters(requestData.getQueryParameters());
        xmlAudit.setRequestMediaType(requestData.getMediaType());
        xmlAudit.setRequestHeaders(gson.toJson(requestData.getHeaders()));
        xmlAudit.setRequest(requestData.getPayload());
      }
      if (auditRecord.getResponseData() != null) {
        ResponseData responseData = auditRecord.getResponseData();
        xmlAudit.setResponseTime(responseData.getTimestamp());
        xmlAudit.setHttpStatus(responseData.getHttpStatus());
        xmlAudit.setResponseMediaType(responseData.getMediaType());
        xmlAudit.setResponseHeaders(gson.toJson(responseData.getHeaders()));
        xmlAudit.setResponse(responseData.getPayload());
      }
      if (auditRecord.getSifData() != null) {
        SIFData sifData = auditRecord.getSifData();
        xmlAudit.setSolutionId(sifData.getSolutionId());
        xmlAudit.setAppKey(sifData.getAppKey());
        xmlAudit.setUserToken(sifData.getUserToken());
        xmlAudit.setInstanceId(sifData.getInstanceId());
        xmlAudit.setContext(sifData.getContext());
        xmlAudit.setZone(sifData.getZone());
        xmlAudit.setEnvironmentToken(sifData.getEnvironmentId());
        xmlAudit.setSessionToken(sifData.getSessionToken());
      }
    }
  }

}
