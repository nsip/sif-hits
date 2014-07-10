package sif3.infra.rest.audit.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import sif3.common.CommonConstants;
import sif3.common.model.EnvironmentKey;
import sif3.common.persist.model.SIF3Session;
import sif3.infra.common.interfaces.EnvironmentManager;
import sif3.infra.rest.audit.AuditRecord;
import sif3.infra.rest.resource.BaseResource;

public class AuditRequestWrapper extends HttpServletRequestWrapper implements HttpHeaders {

  private AuditRecord auditRecord = null;
  private RecordingInputStream inputStream = null;
  private RecordingReader reader = null;
  private BaseResource resource = null;
  
  public AuditRequestWrapper(HttpServletRequest request) {
    super(request);
    this.auditRecord = new AuditRecord();
    this.auditRecord.setRequestTime(new Date());
    this.auditRecord.setUrl(request.getRequestURL().toString());
  }
  
  @Override
  public ServletInputStream getInputStream() throws IOException {
    inputStream = new RecordingInputStream(super.getInputStream(), this);
    return inputStream;
  }
  
  @Override
  public BufferedReader getReader() throws IOException {
    reader = new RecordingReader(super.getReader());
    return reader;
  }
  
  public void setResource(BaseResource resource) {
    this.resource = resource;
  }
  
  public String getContent() {
    String result = null;
    if (inputStream != null) {
      result = inputStream.getContent();
    } else if (reader != null) {
      result = reader.getContent();
    }
    return result;
  }
  
  private void auditResource(BaseResource resource) {
    if (resource != null) {
      if (resource.getSifZone() != null) {
        auditRecord.setZone(resource.getSifZone().getId());
      }
      if (resource.getSifContext() != null) {
        auditRecord.setContext(resource.getSifContext().getId());
      }
      if (resource.getSessionToken() != null) {
        auditRecord.setSessionToken(resource.getSessionToken());
      }
      if (resource.getEnvironmentManager() != null) {
        EnvironmentManager environmentManager = resource.getEnvironmentManager();
        if (environmentManager.getEnvironmentInfo() != null && environmentManager.getEnvironmentInfo().getEnvironmentKey() != null) {
          EnvironmentKey environmentKey = resource.getEnvironmentManager().getEnvironmentInfo().getEnvironmentKey();
          auditRecord.setSolutionId(environmentKey.getSolutionID());
          auditRecord.setAppKey(environmentKey.getApplicationKey());
          auditRecord.setInstanceId(environmentKey.getInstanceID());
          auditRecord.setUserToken(environmentKey.getUserToken());
        }

        resource.validSession();
        SIF3Session session = resource.getEnvironmentManager().getSessionBySessionToken(auditRecord.getSessionToken());
//        environmentManager.getEnvironmentInfo().
        if (session != null) {
          auditRecord.setSolutionId(session.getSolutionID());
          auditRecord.setAppKey(session.getApplicationKey());
          auditRecord.setInstanceId(session.getInstanceID());
          auditRecord.setUserToken(session.getUserToken());
          auditRecord.setEnvironmentToken(session.getEnvironmentID());
          if (auditRecord.getZone() == null) {
            auditRecord.setZone(session.getDefaultZone().getId());
          }
          if (auditRecord.getContext() == null) {
            auditRecord.setContext(CommonConstants.DEFAULT_CONTEXT.getId());
          }
        }
      }
    } 
  }

  public AuditRecord getAuditRecord(AuditResponseWrapper httpResponse) {
    AuditRecord result = this.auditRecord;
    if (result != null) {
      result.setRequest(this.getContent());
      result.setMethod(this.getMethod());
      result.setResponseTime(new Date());
      result.setResponse(httpResponse.getContent());
      result.setHttpStatus(httpResponse.getStatus());
      result.setQueryParameters(this.getQueryString());
      result.setRequestHeaders(getHeaderString(this));
      result.setResponseHeaders(getHeaderString(httpResponse));
      auditResource(resource);
    }
    return result;
  }
  
  private String getHeaderString(HttpHeaders httpRequest) {
    String result = null;
    if (httpRequest != null) {
      result = "";
      String prefix = "[ ";   
      Collection<String> headerNames = httpRequest.getHeaderNamesCollection();
      if (headerNames != null) {
        for (String header : headerNames) {
          result += prefix + header + " : " + getHeaderValue(httpRequest.getHeadersCollection(header));
          prefix = " , ";
        }
      }
    }
    return result;
  }
  
  private String getHeaderValue(Collection<String> headerValues) {
    String result = null;
    if (headerValues != null) {
      boolean array = false;   
      result = "";
      for (String value : headerValues) {
        array = !"".equals(result);
        result += (array ? " , " : "") + value;
      }
      if (array) {
        result = "[ " + result + " ]";
      }
    }
    return result;
  }

  @Override
  public Collection<String> getHeaderNamesCollection() {
    Collection<String> result = null; 
    Enumeration<String> headerNames = getHeaderNames();
    if (headerNames != null) {
      result = Collections.list(headerNames);
    }
    return result;
  }

  @Override
  public Collection<String> getHeadersCollection(String name) {
    Collection<String> result = null; 
    Enumeration<String> headers = getHeaders(name);
    if (headers != null) {
      result = Collections.list(headers);
    }
    return result;
  }
}
