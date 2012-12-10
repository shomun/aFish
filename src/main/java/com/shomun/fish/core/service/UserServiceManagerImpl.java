package com.shomun.fish.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.shomun.fish.core.data.dao.UserDAO;
import com.shomun.fish.core.data.dto.DTODataMap;
import com.shomun.fish.core.data.entity.User;
import com.shomun.fish.core.framework.dao.GeneralDAO;

@Transactional
public class UserServiceManagerImpl implements UserServiceManager {

	
	UserDAO dao;
	
	
	public void setUserDao(UserDAO dao){
		this.dao = dao;
	}

	public DTODataMap<String, Object> doLogin(
			DTODataMap<String, Object> loginDataDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean doLogout(DTODataMap<String, Object> loginDataDTO) {
		// TODO Auto-generated method stub
		return false;
	}

	public User doLogin(String userName, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	public User doUserRegistration(User user) {
		dao.save(user);
		return user;
	}

	public List<User> getAllUsers() {
		return dao.findAll();
	}

	public User getUserById(long id) {
		return dao.find(id);
	}
	
	
	

}
