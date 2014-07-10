package sif3.hits.service.e;

import org.springframework.http.HttpStatus;

public enum OperationStatus {
  CREATE_OK(true, HttpStatus.CREATED.value(), null), CREATE_ERR_NO_ADVISORY(false, HttpStatus.NOT_ACCEPTABLE.value(),
      "No advisory id supplied and use advisory is true."), CREATE_ERR_EXISTS(false, HttpStatus.CONFLICT.value(),
      "Object with that reference id already exists."), CREATE_ERR_ZONE(false, HttpStatus.NOT_ACCEPTABLE.value(),
      "Unable to determine School for provided zone."), CREATE_ERR_OTHER(false, HttpStatus.INTERNAL_SERVER_ERROR
      .value(), "An unknown error occurred while creating object."), UPDATE_OK(true, HttpStatus.OK.value(), null), UPDATE_ERR_NO_OBJECT(
      false, HttpStatus.NOT_FOUND.value(), "Object with that reference id not found."), UPDATE_ERR_OTHER(false,
      HttpStatus.INTERNAL_SERVER_ERROR.value(), "An unknown error occurred while updating object."), DELETE_OK(true,
      HttpStatus.OK.value(), null), DELETE_ERR_NO_OBJECT(false, HttpStatus.NOT_FOUND.value(),
      "Object with that reference id not found."), DELETE_ERR_OTHER(false, HttpStatus.INTERNAL_SERVER_ERROR.value(),
      "An unknown error occurred while deleting object.");

  OperationStatus(boolean ok, int httpStatus, String message) {
    this.ok = ok;
    this.httpStatus = httpStatus;
    this.message = message;
  }

  public int httpStatus;
  public String message;
  public boolean ok;

  public int getHttpStatus() {
    return httpStatus;
  }

  public String getMessage() {
    return message;
  }

  public boolean isOk() {
    return ok;
  }

}
