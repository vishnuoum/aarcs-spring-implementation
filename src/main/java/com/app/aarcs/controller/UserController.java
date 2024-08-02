package com.app.aarcs.controller;

import com.app.aarcs.controller.requests.users.LoginRequest;
import com.app.aarcs.controller.requests.users.RegisterRequest;
import com.app.aarcs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@RestController
@RequestMapping("/user")
public class UserController {

	private final UserService userService;

	@Autowired
	private UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
		return new ResponseEntity<>(userService.register(request), HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginRequest request) {
		return new ResponseEntity<>(userService.login(request), HttpStatus.OK);
	}
}
