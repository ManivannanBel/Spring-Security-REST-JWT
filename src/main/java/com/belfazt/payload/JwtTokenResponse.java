package com.belfazt.payload;

public class JwtTokenResponse {
	
	private String token;
	private boolean success;
		
	public JwtTokenResponse(String token, boolean success) {
		super();
		this.token = token;
		this.success = success;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	@Override
	public String toString() {
		return "JwtTokenResponse [token=" + token + ", success=" + success + "]";
	}
}
