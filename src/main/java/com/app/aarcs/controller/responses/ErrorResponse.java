package com.app.aarcs.controller.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {

	private String errorCode;
	private String errorMessage;
}
