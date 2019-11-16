package com.belfazt.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String username;
	@Column(nullable = false)
	private String password;
	
	private int blocked;
	
	private String roles;
	
	private String permissions;

	public User() {
		
	}

	public User(String username, String password, int blocked, String roles, String permissions) {
		super();
		this.username = username;
		this.password = password;
		this.blocked = blocked;
		this.roles = roles;
		this.permissions = permissions;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public int getBlocked() {
		return blocked;
	}

	public void setBlocked(int blocked) {
		this.blocked = blocked;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}
	
	public List<String> getRolesList(){
		if(roles.length() > 0) {
			return Arrays.asList(roles.split(","));
		}
		return new ArrayList<String>();
	}
	
	public List<String> getPermissionsList(){
		if(permissions.length() > 0) {
			return Arrays.asList(permissions.split(","));
		}
		return new ArrayList<String>();
	}
	
}
