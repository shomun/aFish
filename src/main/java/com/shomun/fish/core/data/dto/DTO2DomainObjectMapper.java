package com.shomun.fish.core.data.dto;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.mapping.Array;

import com.shomun.fish.core.data.entity.Address;
import com.shomun.fish.core.data.entity.EntityBase;
import com.shomun.fish.core.data.entity.Group;
import com.shomun.fish.core.data.entity.User;
import com.shomun.fish.core.service.DataModel;

public class DTO2DomainObjectMapper {

	public static <T extends EntityBase> T convert(DTODataMap<String, Object> dataMap, Class klass){
		EntityBase entity = null;
		try {
			removePrefixFromKeys(dataMap);
			entity = (EntityBase)klass.newInstance();
			BeanUtils.populate(entity,dataMap );
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (T)entity;
	} 
	
	private static void removePrefixFromKeys(DTODataMap<String, Object> dataMap){
		System.out.println("Helloooo  ");
		String[] keyArray = dataMap.keySet().toArray(new String[dataMap.size()]);
		Object tmp = null;
		for (String key : keyArray) {
			tmp = dataMap.remove(key);
			key = key.substring(key.indexOf('_')+1);
			dataMap.put(key, tmp);
		}
	}
	
	
	public static void main(String[] a){
		DTODataMap<String, Object> data = new DTODataMap<String, Object>();
		data.put(DataModel.User.LOGIN_ID, "shovon");
		data.put(DataModel.User.EMAIL, "shovon");
		
		data.put("new_new123", "shovon");
		
		Group grp = new Group();
		grp.setName("group 1");
		
		List<Group> grpList = new ArrayList<Group>();
		
		grpList.add(grp);
		grp = new Group();
		grp.setName("group 2");
		
		grpList.add(grp);
		data.put(DataModel.User.GROUPS, grpList);
		
		Address addr = new Address();
		addr.setCity("tokyo");
		
		User user = (User) convert(data, User.class);
	} 
	
}
