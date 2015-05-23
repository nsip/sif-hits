package sif3.hits.rest.dto;

import java.io.Serializable;

import sif3.hits.service.e.OperationStatus;

public class ResponseDTO<S> implements Serializable {
  private static final long serialVersionUID = 4264213293591201096L;

  public ResponseDTO(RequestDTO<S> requestDTO, S sifObject, OperationStatus operationStatus) {
    this.requestDTO = requestDTO;
    this.sifObject = sifObject;
    this.operationStatus = operationStatus;
  }

  public ResponseDTO(RequestDTO<S> requestDTO, S sifObject, OperationStatus operationStatus, String detailMessage) {
    this(requestDTO, sifObject, operationStatus);
    this.detailMessage = detailMessage;
  }

  private RequestDTO<S> requestDTO;
  private S sifObject;
  private OperationStatus operationStatus;
  private String detailMessage;

  public RequestDTO<S> getRequestDTO() {
    return requestDTO;
  }

  public void setRequestDTO(RequestDTO<S> requestDTO) {
    this.requestDTO = requestDTO;
  }

  public S getSifObject() {
    return sifObject;
  }

  public void setSifObject(S sifObject) {
    this.sifObject = sifObject;
  }

  public OperationStatus getOperationStatus() {
    return operationStatus;
  }

  public void setOperationStatus(OperationStatus operationStatus) {
    this.operationStatus = operationStatus;
  }

  public String getDetailMessage() {
    return detailMessage;
  }

  public void setDetailMessage(String detailMessage) {
    this.detailMessage = detailMessage;
  }
}
