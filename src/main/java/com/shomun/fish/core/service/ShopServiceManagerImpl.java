package com.shomun.fish.core.service;

import org.springframework.transaction.annotation.Transactional;

import com.shomun.fish.core.data.dao.CategoryDAO;
import com.shomun.fish.core.data.dao.ProductDAO;
import com.shomun.fish.core.data.dao.ShopDAO;
import com.shomun.fish.core.data.entity.Category;
import com.shomun.fish.core.data.entity.Product;
import com.shomun.fish.core.data.entity.Shop;
import com.shomun.fish.core.exception.ApplicationException;
import com.shomun.fish.core.exception.SystemException;

@Transactional
public class ShopServiceManagerImpl extends AbstractService implements ShopService{

	
	private ShopDAO shopDao;
	
	private CategoryDAO categoryDao;
	
	private ProductDAO productDao;
	
	

	public void setShopDao(ShopDAO shopDao) {
		this.shopDao = shopDao;
	}

	public void setCategoryDao(CategoryDAO categoryDao) {
		this.categoryDao = categoryDao;
	}

	public void setProductDao(ProductDAO productDao) {
		this.productDao = productDao;
	}

	
	public void addShop(Shop shop) throws SystemException, ApplicationException {
		shopDao.save(shop);
		
	}

	public void updateShop(Shop shop) throws SystemException,
			ApplicationException {
		// TODO Auto-generated method stub
		
	}

	public void deleteShop(long shopId) throws SystemException,
			ApplicationException {
		// TODO Auto-generated method stub
		
	}

	public void addCategory(Category category) throws SystemException,
			ApplicationException {
		// TODO Auto-generated method stub
		
	}

	public void updateCategory(Category category) throws SystemException,
			ApplicationException {
		// TODO Auto-generated method stub
		
	}

	public void deleteCategory(String categoryId) throws SystemException,
			ApplicationException {
		// TODO Auto-generated method stub
		
	}

	public void addProduct(Product product) throws SystemException,
			ApplicationException {
		// TODO Auto-generated method stub
		
	}

	public void updateProduct(Product product) throws SystemException,
			ApplicationException {
		// TODO Auto-generated method stub
		
	}

	public void deleteProduct(long productId) throws SystemException,
			ApplicationException {
		// TODO Auto-generated method stub
		
	}

	
}
