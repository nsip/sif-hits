package sif3.hits.rest.audit;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif3.infra.rest.audit.AuditRecord;
import sif3.infra.rest.audit.Auditor;

public class LogAuditor implements Auditor {

  private static final Logger L = LoggerFactory.getLogger(LogAuditor.class);
  
  @Override
  public void audit(AuditRecord auditRecord) {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
    StringWriter string = new StringWriter();
    PrintWriter writer = new PrintWriter(string);
    writer.println();
    writer.println("----------");
    writer.print("Date: ");
    writer.println(sdf.format(auditRecord.getRequestTime()));
    writer.print("Solution ID: ");
    writer.println(auditRecord.getSolutionId());
    writer.print("App Key: ");
    writer.println(auditRecord.getAppKey());
    writer.print("User Token: ");
    writer.println(auditRecord.getUserToken());

    writer.print("Context: ");
    writer.println(auditRecord.getContext());
    writer.print("Zone: ");
    writer.println(auditRecord.getZone());

    writer.print("Environment Token: ");
    writer.println(auditRecord.getEnvironmentToken());
    writer.print("Session Token: ");
    writer.println(auditRecord.getSessionToken());

    writer.print("URL: ");
    writer.println(auditRecord.getUrl());
    writer.println("Body: ");
    writer.println("--");
    writer.println(auditRecord.getRequest());
    writer.println("--");
    writer.print("Status:");
    writer.println(auditRecord.getHttpStatus());
    writer.println("Response:");
    writer.println("--");
    writer.println(auditRecord.getResponse());
    writer.println("--");
    writer.print("Date: ");
    writer.println(sdf.format(auditRecord.getResponseTime()));
    writer.println("----------");
    L.info(string.toString());
  }

}
