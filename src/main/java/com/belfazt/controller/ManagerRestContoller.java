package com.belfazt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/manager")
public class ManagerRestContoller {

	@GetMapping("data")
	public ResponseEntity<?> getData(){
		String res = "{\r\n" + 
				"	\"id\": \"0001\",\r\n" + 
				"	\"type\": \"donut\",\r\n" + 
				"	\"name\": \"Cake\",\r\n" + 
				"	\"image\":\r\n" + 
				"		{\r\n" + 
				"			\"url\": \"images/0001.jpg\",\r\n" + 
				"			\"width\": 200,\r\n" + 
				"			\"height\": 200\r\n" + 
				"		},\r\n" + 
				"	\"thumbnail\":\r\n" + 
				"		{\r\n" + 
				"			\"url\": \"images/thumbnails/0001.jpg\",\r\n" + 
				"			\"width\": 32,\r\n" + 
				"			\"height\": 32\r\n" + 
				"		}\r\n" + 
				"}";
		return new ResponseEntity<String>(res, HttpStatus.OK);
	}
	
}
