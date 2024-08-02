package com.app.aarcs.exception;


import com.app.aarcs.controller.responses.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ServiceExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = ServiceException.class)
	protected ResponseEntity<Object> handleConflict(ServiceException ex) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorCode(ex.getErrorCode());
		errorResponse.setErrorMessage(ex.getErrorMessage());
		return new ResponseEntity<>(errorResponse, ex.getHttpStatus());
	}
}
