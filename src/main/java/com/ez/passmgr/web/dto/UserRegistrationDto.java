package com.ez.passmgr.web.dto;

import java.util.Collection;

import com.ez.passmgr.model.Role;

public class UserRegistrationDto {

	private String password;
	private String email;
	private Collection<Role> roles;

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public UserRegistrationDto() {
		super();
	}
	
	public UserRegistrationDto(String password, String email, Collection<Role> roles) {
		super();
		this.email = email;
		this.password = password;
		this.roles = roles;
		
	}

	

}
