package com.shomun.fish.rest.controller;

import org.springframework.web.bind.annotation.RequestBody;

import com.shomun.fish.core.data.entity.Address;
import com.shomun.fish.core.data.entity.Category;
import com.shomun.fish.core.data.entity.Product;
import com.shomun.fish.core.data.entity.Shop;
import com.shomun.fish.core.exception.ApplicationException;
import com.shomun.fish.core.exception.SystemException;

public class ShopServiceImpl extends AbstractServiceControllerSupport implements ShopService {

	
	@Override
	public void registerShop(@RequestBody Shop shop, Address address)
			throws ApplicationException, SystemException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addUpdateProduct(@RequestBody Product product)
			throws ApplicationException, SystemException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addUpdateCategory(@RequestBody Category category)
			throws ApplicationException, SystemException {
		// TODO Auto-generated method stub
		
	}

	
}
