package com.app.aarcs.exception;

import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

public class ServiceExceptionFactory {

	private static Map<String, ServiceException> errorMap = new HashMap<>();

	public void add(String errorCode, String errorMessage, HttpStatus httpStatus) {
		errorMap.put(errorCode, new ServiceException(errorCode, errorMessage, httpStatus));
	}
	
	public ServiceException generateException(String errorCode) {
		return errorMap.get(errorCode);
	}

	public ServiceException generateCustomizedException(String errorCode, String errorMessage, HttpStatus httpStatus) {
		return new ServiceException(errorCode, errorMessage, httpStatus);
	}
}
