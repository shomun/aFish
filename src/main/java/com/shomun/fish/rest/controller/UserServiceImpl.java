package com.shomun.fish.rest.controller;

import java.lang.annotation.Retention;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.shomun.fish.core.data.entity.Address;
import com.shomun.fish.core.data.entity.User;
import com.shomun.fish.core.service.UserServiceManager;

@Controller
@RequestMapping("/user")
public class UserServiceImpl {

	@Autowired
	UserServiceManager userServiceManager;
	
	@RequestMapping(method=RequestMethod.POST,value="/register", headers="content-type=application/x-www-form-urlencoded")
	public void registerUSer(@ModelAttribute User user,@ModelAttribute Address addr) {
		System.out.println("Name : " + addr.getStreet());
		user.addAddress(addr);
		userServiceManager.doUserRegistration(user);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/hello")
	@ResponseBody
	public String sayHello(){
		return "hello monirul " ;
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/find",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public User getUser(@RequestParam("id") long id){
		User user = userServiceManager.getUserById(id);
		return user;
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/findall",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<User> getAllUser(){
		List<User> userList = userServiceManager.getAllUsers();

		return userList;
	}

}
