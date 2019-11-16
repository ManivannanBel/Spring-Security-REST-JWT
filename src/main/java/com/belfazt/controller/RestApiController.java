package com.belfazt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api")
public class RestApiController {

	@GetMapping("dataset-1")
	private ResponseEntity<?> dataset1(){
		
		String resDataString = "[\r\n" + 
				"	{\r\n" + 
				"		color: \"red\",\r\n" + 
				"		value: \"#f00\"\r\n" + 
				"	},\r\n" + 
				"	{\r\n" + 
				"		color: \"green\",\r\n" + 
				"		value: \"#0f0\"\r\n" + 
				"	},\r\n" + 
				"	{\r\n" + 
				"		color: \"blue\",\r\n" + 
				"		value: \"#00f\"\r\n" + 
				"	},\r\n" + 
				"	{\r\n" + 
				"		color: \"cyan\",\r\n" + 
				"		value: \"#0ff\"\r\n" + 
				"	},\r\n" + 
				"	{\r\n" + 
				"		color: \"magenta\",\r\n" + 
				"		value: \"#f0f\"\r\n" + 
				"	},\r\n" + 
				"	{\r\n" + 
				"		color: \"yellow\",\r\n" + 
				"		value: \"#ff0\"\r\n" + 
				"	},\r\n" + 
				"	{\r\n" + 
				"		color: \"black\",\r\n" + 
				"		value: \"#000\"\r\n" + 
				"	}\r\n" + 
				"]";
		
		return new ResponseEntity<String>(resDataString, HttpStatus.OK);
	}
	
	@GetMapping("dataset-2")
	private ResponseEntity<?> dataset2(){
		
		String resDataString = "[\r\n" + 
				"	{\r\n" + 
				"		\"id\": \"0001\",\r\n" + 
				"		\"type\": \"donut\",\r\n" + 
				"		\"name\": \"Cake\",\r\n" + 
				"		\"ppu\": 0.55,\r\n" + 
				"		\"batters\":\r\n" + 
				"			{\r\n" + 
				"				\"batter\":\r\n" + 
				"					[\r\n" + 
				"						{ \"id\": \"1001\", \"type\": \"Regular\" },\r\n" + 
				"						{ \"id\": \"1002\", \"type\": \"Chocolate\" },\r\n" + 
				"						{ \"id\": \"1003\", \"type\": \"Blueberry\" },\r\n" + 
				"						{ \"id\": \"1004\", \"type\": \"Devil's Food\" }\r\n" + 
				"					]\r\n" + 
				"			},\r\n" + 
				"		\"topping\":\r\n" + 
				"			[\r\n" + 
				"				{ \"id\": \"5001\", \"type\": \"None\" },\r\n" + 
				"				{ \"id\": \"5002\", \"type\": \"Glazed\" },\r\n" + 
				"				{ \"id\": \"5005\", \"type\": \"Sugar\" },\r\n" + 
				"				{ \"id\": \"5007\", \"type\": \"Powdered Sugar\" },\r\n" + 
				"				{ \"id\": \"5006\", \"type\": \"Chocolate with Sprinkles\" },\r\n" + 
				"				{ \"id\": \"5003\", \"type\": \"Chocolate\" },\r\n" + 
				"				{ \"id\": \"5004\", \"type\": \"Maple\" }\r\n" + 
				"			]\r\n" + 
				"	},\r\n" + 
				"	{\r\n" + 
				"		\"id\": \"0002\",\r\n" + 
				"		\"type\": \"donut\",\r\n" + 
				"		\"name\": \"Raised\",\r\n" + 
				"		\"ppu\": 0.55,\r\n" + 
				"		\"batters\":\r\n" + 
				"			{\r\n" + 
				"				\"batter\":\r\n" + 
				"					[\r\n" + 
				"						{ \"id\": \"1001\", \"type\": \"Regular\" }\r\n" + 
				"					]\r\n" + 
				"			},\r\n" + 
				"		\"topping\":\r\n" + 
				"			[\r\n" + 
				"				{ \"id\": \"5001\", \"type\": \"None\" },\r\n" + 
				"				{ \"id\": \"5002\", \"type\": \"Glazed\" },\r\n" + 
				"				{ \"id\": \"5005\", \"type\": \"Sugar\" },\r\n" + 
				"				{ \"id\": \"5003\", \"type\": \"Chocolate\" },\r\n" + 
				"				{ \"id\": \"5004\", \"type\": \"Maple\" }\r\n" + 
				"			]\r\n" + 
				"	},\r\n" + 
				"	{\r\n" + 
				"		\"id\": \"0003\",\r\n" + 
				"		\"type\": \"donut\",\r\n" + 
				"		\"name\": \"Old Fashioned\",\r\n" + 
				"		\"ppu\": 0.55,\r\n" + 
				"		\"batters\":\r\n" + 
				"			{\r\n" + 
				"				\"batter\":\r\n" + 
				"					[\r\n" + 
				"						{ \"id\": \"1001\", \"type\": \"Regular\" },\r\n" + 
				"						{ \"id\": \"1002\", \"type\": \"Chocolate\" }\r\n" + 
				"					]\r\n" + 
				"			},\r\n" + 
				"		\"topping\":\r\n" + 
				"			[\r\n" + 
				"				{ \"id\": \"5001\", \"type\": \"None\" },\r\n" + 
				"				{ \"id\": \"5002\", \"type\": \"Glazed\" },\r\n" + 
				"				{ \"id\": \"5003\", \"type\": \"Chocolate\" },\r\n" + 
				"				{ \"id\": \"5004\", \"type\": \"Maple\" }\r\n" + 
				"			]\r\n" + 
				"	}\r\n" + 
				"]";
		
		return new ResponseEntity<String>(resDataString, HttpStatus.OK);
	}
	
}
