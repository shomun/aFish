package com.shomun.fish.core.security;

import java.util.Map;

import com.shomun.fish.core.data.entity.EntityBase;
import com.shomun.fish.core.data.entity.User;

public interface SecurityManager {

	boolean doLogin(String userName,String password);
	
	User registerNewUser(User user);
	
//	<T  extends EntityBase> Map<String, T> lookup(String searchString, String FilterType);
//	
//	boolean hasAccessPermission(String actionId);
//	
//	boolean hasDataModelPermission(String dataModelId);
	
}
