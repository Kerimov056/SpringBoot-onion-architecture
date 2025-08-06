package com.demo.Controller;

import java.awt.PageAttributes.MediaType;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.demo.dto.users.LoginResponse;
import com.demo.dto.users.LoginUserDto;
import com.demo.dto.users.RegisterUserDto;
import com.demo.entities.User;
import com.demo.service.AuthenticationService;
import com.demo.service.JwtService;

import jakarta.validation.Valid;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
	private final JwtService jwtService;

	private final AuthenticationService authenticationService;

	public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
		this.jwtService = jwtService;
		this.authenticationService = authenticationService;
	}

	@PostMapping("/signup")
	public ResponseEntity<User> register(@RequestBody @Valid RegisterUserDto registerUserDto) {
		User registeredUser = authenticationService.signup(registerUserDto);

		return ResponseEntity.ok(registeredUser);
	}

	// @CrossOrigin
	@PostMapping(value = "/login", produces = "application/json")
	public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
	    User authenticatedUser = authenticationService.authenticate(loginUserDto);

	    String jwtToken = jwtService.generateToken(authenticatedUser);

	    LoginResponse loginResponse = new LoginResponse()
	        .setToken(jwtToken)
	        .setExpiresIn(jwtService.getExpirationTime());

	    return ResponseEntity.ok(loginResponse);
	}

}