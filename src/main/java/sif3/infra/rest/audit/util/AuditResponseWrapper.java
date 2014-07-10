package sif3.infra.rest.audit.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class AuditResponseWrapper extends HttpServletResponseWrapper implements HttpHeaders {

  private TeeOutputStream outputStream = null;
  private TeeWriter writer = null;
  private StringWriter stringWriter = null;
  private ByteArrayOutputStream byteArrayOutputStream = null;

  public AuditResponseWrapper(HttpServletResponse response) {
    super(response);
  }

  @Override
  public ServletOutputStream getOutputStream() throws IOException {
    byteArrayOutputStream = new ByteArrayOutputStream();
    this.outputStream = new TeeOutputStream(super.getOutputStream(), byteArrayOutputStream);
    return this.outputStream;
  }

  @Override
  public PrintWriter getWriter() throws IOException {
    stringWriter = new StringWriter();
    this.writer = new TeeWriter(super.getWriter(), stringWriter);
    return this.writer;
  }

  public String getContent() {
    String result = null;
    if (byteArrayOutputStream != null) {
      result = new String(byteArrayOutputStream.toByteArray());
    } else if (stringWriter != null) {
      result = stringWriter.toString();
    }
    return result;
  }

  @Override
  public Collection<String> getHeaderNamesCollection() {
    return super.getHeaderNames();
  }

  @Override
  public Collection<String> getHeadersCollection(String name) {
    return super.getHeaders(name);
  }
}
