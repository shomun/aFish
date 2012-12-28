package com.shomun.fish.core.service;

import com.shomun.fish.core.data.entity.Category;
import com.shomun.fish.core.data.entity.CategoryBasedType;
import com.shomun.fish.core.data.entity.Product;
import com.shomun.fish.core.data.entity.Shop;
import com.shomun.fish.core.exception.ApplicationException;
import com.shomun.fish.core.exception.SystemException;

public interface ShopService {

	void addShop(Shop shop)throws SystemException,ApplicationException;
	
	void updateShop(Shop shop)throws SystemException,ApplicationException;
	
	void deleteShop(long shopId)throws SystemException,ApplicationException;
	
	void addCategory(Category category)throws SystemException,ApplicationException;
	
	void updateCategory(Category category)throws SystemException,ApplicationException;
	
	void deleteCategory(String categoryId)throws SystemException,ApplicationException;
	
	void addProduct(Product product)throws SystemException,ApplicationException;
	
	void updateProduct(Product product)throws SystemException,ApplicationException;
	
	void deleteProduct(long productId)throws SystemException,ApplicationException;
	
	void addCategoryBaseType(CategoryBasedType categoryBaseType)throws SystemException,ApplicationException;
	
	void updateCategoryBaseType(CategoryBasedType categoryBaseType)throws SystemException,ApplicationException;
	
	void deleteCategoryBaseType(String categoryBaseTypeId)throws SystemException,ApplicationException;
}
