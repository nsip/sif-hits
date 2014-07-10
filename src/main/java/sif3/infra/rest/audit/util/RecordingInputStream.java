package sif3.infra.rest.audit.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletInputStream;

import sif3.infra.rest.audit.AuditableInputStream;
import sif3.infra.rest.resource.BaseResource;

public class RecordingInputStream extends ServletInputStream implements AuditableInputStream {

  private AuditRequestWrapper request = null;
  protected InputStream inputStream = null;
  private ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

  public RecordingInputStream(InputStream inputStream, AuditRequestWrapper request) {
    this.inputStream = inputStream;
    this.request = request;
  }
  
  public void setResource(BaseResource resource) {
    if (request != null) request.setResource(resource);
  }

  @Override
  public int available() throws IOException {
    return inputStream.available();
  }

  @Override
  public void close() throws IOException {
    inputStream.close();
  }

  @Override
  public synchronized void mark(int readlimit) {
    inputStream.mark(readlimit);
  }

  @Override
  public boolean markSupported() {
    return inputStream.markSupported();
  }

  @Override
  public int read() throws IOException {
    int result = inputStream.read();
    byteArrayOutputStream.write(result);
    return result;
  }

  @Override
  public synchronized void reset() throws IOException {
    inputStream.reset();
  }
  
  public String getContent() {
    return new String(byteArrayOutputStream.toByteArray());
  }
}
