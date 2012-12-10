package com.shomun.fish.core.service;

public interface DataModel {

	public interface User{
		String ID = "user_id";
		
		String NAME = "user_name";
		
		String LOGIN_ID= "user_loginId";
		
		String EMAIL = "user_email";
		
		String IS_LOGGED_IN = "user_isLoggedIn";
		
		String LAST_LOGIN_TIME= "user_last_login_time";
		
		String DISPLAY_NAME = "user_display_name";
		
		String GROUPS = "user_groups";
		
		String ROLES = "user_roles";
		
		String ADDRESS = "user_address";
	}
	
}
