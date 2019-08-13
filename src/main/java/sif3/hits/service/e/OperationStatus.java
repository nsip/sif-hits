package sif3.hits.service.e;

import org.springframework.http.HttpStatus;

public enum OperationStatus {
  // @formatter:off
  CREATE_OK(true, HttpStatus.CREATED.value(), null), 
  CREATE_ERR_NO_ADVISORY(false, HttpStatus.NOT_ACCEPTABLE.value(), "No advisory data supplied and use advisory is true."),
  CREATE_ERR_EXISTS(false, HttpStatus.CONFLICT.value(), "Object with that reference data already exists."),
  CREATE_ERR_ZONE(false, HttpStatus.NOT_ACCEPTABLE.value(), "Unable to determine School for provided zone."), 
  CREATE_ERR_OTHER(false, HttpStatus.INTERNAL_SERVER_ERROR.value(), "An unknown error occurred while creating object."),
  CREATE_ERR_CONSTRAINT(false, HttpStatus.BAD_REQUEST.value(), "Unable to create object. Constraint Violation."),
  UPDATE_OK(true, HttpStatus.OK.value(), null),
  UPDATE_ERR_REFID_MISMATCH(false, HttpStatus.NOT_ACCEPTABLE.value(), "Unable to update reference data."),
  UPDATE_ERR_NO_OBJECT(false, HttpStatus.NOT_FOUND.value(), "Object with that reference data not found."),
  UPDATE_ERR_OTHER(false, HttpStatus.INTERNAL_SERVER_ERROR.value(), "An unknown error occurred while updating object."),
  UPDATE_ERR_CONSTRAINT(false, HttpStatus.BAD_REQUEST.value(), "Unable to update object. Constraint Violation."),
  DELETE_OK(true, HttpStatus.OK.value(), null), 
  DELETE_ERR_NO_OBJECT(false, HttpStatus.NOT_FOUND.value(), "Object with that reference data not found."),
  DELETE_ERR_INVALID(false, HttpStatus.NOT_ACCEPTABLE.value(), "No advisory Id supplied."),
  DELETE_ERR_OTHER(false, HttpStatus.INTERNAL_SERVER_ERROR.value(), "An unknown error occurred while deleting object."),
  DELETE_ERR_CONSTRAINT(false, HttpStatus.BAD_REQUEST.value(), "Unable to delete object. Constraint Violation."),
  SERVICE_PATH_NOT_FOUND(false, HttpStatus.NOT_FOUND.value(), "Service path not implemented."), 
  UNKNOWN_ERROR(false, HttpStatus.INTERNAL_SERVER_ERROR.value(), "An unknown error has occurred. See server logs for detailed information.");
  // @formatter:on
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
