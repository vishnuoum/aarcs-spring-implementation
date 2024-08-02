package com.app.aarcs.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ServiceException extends RuntimeException {

	private String errorCode;
	private String errorMessage;
	private HttpStatus httpStatus;

	private ServiceException() {}

	public ServiceException(String errorCode, String errorMessage, HttpStatus httpStatus) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.httpStatus = httpStatus;
	}

	public ServiceException(String errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
	}
}
