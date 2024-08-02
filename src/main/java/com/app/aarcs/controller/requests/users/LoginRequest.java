package com.app.aarcs.controller.requests.users;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {

	private String key;
	private String password;
}
