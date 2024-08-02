package com.app.aarcs.controller.requests.users;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {

	private String username;
	private String phone;
	private String mail;
	private String password;
}
