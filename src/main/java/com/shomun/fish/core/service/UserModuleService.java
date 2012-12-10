package com.shomun.fish.core.service;

import com.shomun.fish.core.data.entity.EntityBase;
import com.shomun.fish.core.data.entity.Group;
import com.shomun.fish.core.data.entity.User;

public interface UserModuleService extends ServiceController{

	
	
	
	User registerUser(User user);
	
	User updateUser(User user);
	
	<T extends EntityBase> T addEntity(T entity, UserModule entityType);
	
	<T extends EntityBase> T updateEntity(T entity, UserModule entityType);
	
	<T extends EntityBase> boolean removeEntity(T entity, UserModule entityType);
	
	<T extends EntityBase> boolean  removeGroupById(long Id, UserModule entityType);
	
	<T extends EntityBase> T  findEntityById(long Id, Class<T> type);
	
//	<T extends EntityBase> T  findEntity(long Id, Class<T> type);
	
//	Group updateGroup(Group group);
//	
//	Group removeGroup(Group group);
//	
//	Group removeGroupById(String groupId);
}
