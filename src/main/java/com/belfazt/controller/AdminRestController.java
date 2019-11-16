package com.belfazt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.belfazt.dao.UserRepository;
import com.belfazt.model.User;

@RestController
@CrossOrigin
@RequestMapping("api/admin")
public class AdminRestController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("users")
	public ResponseEntity<?> getUsers() {
		
		Iterable<User> users = userRepository.findAll();
		
		return new ResponseEntity<Iterable<User>>(users, HttpStatus.OK);
		
	}
	
}
