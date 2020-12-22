package com.ez.passmgr.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.ez.passmgr.model.User;
import com.ez.passmgr.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {
	User save(UserRegistrationDto registrationDto);
}
