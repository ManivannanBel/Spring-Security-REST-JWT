package com.belfazt.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.belfazt.payload.JwtTokenResponse;
import com.belfazt.payload.LoginRequest;
import com.belfazt.security.JwtTokenProvider;

@RestController
@CrossOrigin
@RequestMapping("/")
public class UserController {
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenProvider tokenProvider;
	
	@PostMapping("login")
	public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest, BindingResult result){
		//System.out.println(loginRequest.getUsername()+" - "+loginRequest.getPassword());
		//System.out.println(bCryptPasswordEncoder.encode("mani"));
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						loginRequest.getUsername(),
						loginRequest.getPassword()
				)
		);
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = "Bearer " + tokenProvider.generateToken(authentication);
		
		return new ResponseEntity<JwtTokenResponse> (new JwtTokenResponse(jwt, true), HttpStatus.OK);
	}
	
}
