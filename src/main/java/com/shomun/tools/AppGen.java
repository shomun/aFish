package com.shomun.tools;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shomun.fish.core.data.dao.ShopDAO;
import com.shomun.fish.core.data.entity.Shop;
import com.shomun.fish.core.exception.ApplicationException;
import com.shomun.fish.core.exception.SystemException;
import com.shomun.fish.core.service.ShopService;
import com.shomun.fish.core.service.ShopServiceManagerImpl;
import com.shomun.fish.core.service.UserServiceManager;
import com.shomun.fish.core.service.UserServiceManagerImpl;

public class AppGen {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config/service-context.xml");
		Object obj= context.getBean("userServiceManager");
		UserServiceManager userServiceManager = (UserServiceManager)context.getBean("userServiceManager");
		ShopService shopServiceManager = (ShopService)context.getBean("shopServiceManager");
		DataGenerator dataGen = new DataGenerator();
		
		List<Shop> shopList = dataGen.shopDataGen();
		
		for (Shop shop : shopList) {
			try {
				shopServiceManager.addShop(shop);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
