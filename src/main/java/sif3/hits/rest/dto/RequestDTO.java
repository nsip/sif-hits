package sif3.hits.rest.dto;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif3.common.exception.PersistenceException;
import sif3.hits.utils.RefIdGenerator;

public class RequestDTO<S> implements Serializable {
  private static final Logger L = LoggerFactory.getLogger(RequestDTO.class);

  private static final long serialVersionUID = -8643504363564519303L;

  private String advisoryId;
  private String refId;
  private S sifObject;
  private Boolean useAdvisory;

  public RequestDTO(String advisoryId, String refId, Boolean useAdvisory, S sifObject) {
    this.advisoryId = advisoryId;
    this.refId = refId;
    this.sifObject = sifObject;
    this.useAdvisory = useAdvisory;
  }

  public String getAdvisoryId() {
    return advisoryId;
  }

  public void setAdvisoryId(String advisoryId) {
    this.advisoryId = advisoryId;
  }

  public String getRefId() {
    return refId;
  }

  public void setRefId(String refId) {
    this.refId = refId;
  }

  public S getSifObject() {
    return sifObject;
  }

  public void setSifObject(S sifObject) {
    this.sifObject = sifObject;
  }

  public Boolean getUseAdvisory() {
    return useAdvisory;
  }

  public void setUseAdvisory(Boolean useAdvisory) {
    this.useAdvisory = useAdvisory;
  }

  public static <S> RequestDTO<S> getInstance(S sifObject, boolean useAdvisory, Class<S> sifClass)
      throws PersistenceException {
    String refId = null;
    if (sifObject != null) {
      try {
        refId = (String) sifClass.getMethod("getRefId").invoke(sifObject);
      } catch (Exception ex) {
        String singleName = getName(sifClass);
        L.error("Override this method getRefId not implemented on SifObject - " + singleName, ex);
        throw new PersistenceException(singleName + " - Unable to perform conversion.");
      }
    }
    if (!useAdvisory) {
      refId = RefIdGenerator.getRefId();
    }
    return getInstance(sifObject, refId, useAdvisory, sifClass);
  }

  public static <S> RequestDTO<S> getInstance(S sifObject, Class<S> sifClass) throws PersistenceException {
    String refId = null;
    if (sifObject != null) {
      try {
        refId = (String) sifClass.getMethod("getRefId").invoke(sifObject);
      } catch (Exception ex) {
        String singleName = getName(sifClass);
        L.error("Override this method getRefId not implemented on SifObject - " + singleName, ex);
        throw new PersistenceException(singleName + " - Unable to perform conversion.");
      }
    }
    return getInstance(sifObject, refId, sifClass);
  }

  public static <S> RequestDTO<S> getInstance(S sifObject, String resourceId, Class<S> sifClass)
      throws PersistenceException {
    Boolean useAdvisory = null;
    return getInstance(sifObject, resourceId, useAdvisory, sifClass);
  }

  public static <S> RequestDTO<S> getInstance(S sifObject, String resourceId, Boolean useAdvisory, Class<S> sifClass)
      throws PersistenceException {
    String advisoryId = resourceId;
    String refId = resourceId;
    // Delete requests don't contain an Object.
    if (sifObject != null) {
      try {
        advisoryId = (String) sifClass.getMethod("getRefId").invoke(sifObject);
        sifClass.getMethod("setRefId", String.class).invoke(sifObject, refId);
      } catch (Exception ex) {
        String singleName = getName(sifClass);
        L.error("Override this method getRefId/setRefId not implemented on SifObject - " + singleName, ex);
        throw new PersistenceException(singleName + " - Unable to perform conversion.");
      }
    }
    return new RequestDTO<S>(advisoryId, refId, useAdvisory, sifObject);
  }

  private static String getName(Class<?> clazz) {
    String result = "Unknown";
    if (clazz != null) {
      result = clazz.getSimpleName();
    }
    return result;
  }
}
