package com.belfazt.payload;

import javax.validation.constraints.NotBlank;

public class LoginRequest {

	@NotBlank(message = "username cannot be null")
	private String username;
	@NotBlank(message = "password cannot be null")
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
}
