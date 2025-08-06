package com.demo.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.demo.dto.users.LoginUserDto;
import com.demo.dto.users.RegisterUserDto;
import com.demo.entities.User;
import com.demo.iRepository.IUserRepository;

@Service
public class AuthenticationService {
	private final IUserRepository userRepository;

	private final PasswordEncoder passwordEncoder;

	private final AuthenticationManager authenticationManager;

	public AuthenticationService(IUserRepository userRepository, AuthenticationManager authenticationManager,
			PasswordEncoder passwordEncoder) {
		this.authenticationManager = authenticationManager;
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public User signup(RegisterUserDto input) {
		User user = new User().setFullName(input.getFullName()).setEmail(input.getEmail().toString())
				.setPassword(passwordEncoder.encode(input.getPassword()));

		return userRepository.save(user);
	}

	public User authenticate(LoginUserDto input) {
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(input.getEmail(), input.getPassword()));

		return userRepository.findByEmail(input.getEmail()).orElseThrow();
	}
}
