//package com.ez.passmgr.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.ez.passmgr.model.User;
//import com.ez.passmgr.repository.UserRepository;
//import com.ez.passmgr.web.dto.UserRegistrationDto;
//
//@Service
//public class UserServiceImpl implements UserService {
//
//	@Autowired
//	private UserRepository userRepository;
//	
//	
//	
//	public UserServiceImpl(UserRepository userRepository) {
//		super();
//		this.userRepository = userRepository;
//	}
//
//
//
//	@Override
//	public User save(UserRegistrationDto registrationDto) {
//		User user = new User(registrationDto.getUsername(), registrationDto.getPassword(), registrationDto.getEmail());
//		return userRepository.save(user);
//	}
//
//}
