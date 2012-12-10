package com.shomun.fish.core.service;

import java.util.List;

import com.shomun.fish.core.data.dto.DTODataMap;
import com.shomun.fish.core.data.entity.User;

public interface UserServiceManager {

	DTODataMap<String, Object> doLogin(DTODataMap<String, Object> loginDataDTO);
	
	boolean doLogout(DTODataMap<String, Object> loginDataDTO);
	
	User doLogin(String userName, String password);
	
	User doUserRegistration(User user);
	
	List<User> getAllUsers();
	
	User getUserById(long id);
	
}
