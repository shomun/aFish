package com.shomun.tools;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.shomun.fish.core.data.dao.ShopDAO;
import com.shomun.fish.core.data.dao.UserDAO;
import com.shomun.fish.core.data.entity.Address;
import com.shomun.fish.core.data.entity.Shop;
import com.shomun.fish.core.framework.dao.hibernate.GenericHibernateDAOImpl;

@Transactional
public class DataGenerator {

	ShopDAO shopDao;
	
	
	
	
	public  List<Shop> shopDataGen(){
		String shopDataFileName = "E:/MonirulBACKS/rnd/FishFish/shopMasterLog.csv";
		String shopNameFileName = "E:/MonirulBACKS/rnd/FishFish/shopNames.txt";
		
		List<Shop> shopList = new ArrayList<Shop>();
		List<String> shopDataRows = this.getAllRowsfromFile(shopDataFileName);
		List<String> shopNameRows = this.getAllRowsfromFile(shopNameFileName);
		
		if(shopDataRows != null){
			int count =-1;
			Shop shop = null;
			Address addr = null;
			String[] rowData = null;
			for (int i = 1; i < shopDataRows.size(); i++) {
				shop = new Shop();
				rowData = shopDataRows.get(i).split(",");
				shop.setActivated(true);
				shop.setName(shopNameRows.get(i-1));
				addr = new Address();
				addr.setStreet(rowData[7]+ rowData[8]);
				addr.setCity(rowData[5]);
				addr.setState(rowData[4]);
				addr.setSuburb(rowData[6]);
				addr.setCountry("Japan");
				if(!rowData[10].isEmpty()){
					addr.setLatitude(Float.valueOf(rowData[10]));
				}
				if(!rowData[11].isEmpty()){
					addr.setLongitude(Float.valueOf(rowData[11]));
				}
				if(!rowData[3].isEmpty()){
					rowData[3] = rowData[3].replaceAll("-", "");
					addr.setPostalCode(rowData[3]);
				}
				if(!rowData[2].isEmpty()){
					rowData[2] = rowData[2].replaceAll("-", "");
					addr.setPhone(rowData[2]);
				}
				shop.addAddress(addr);
				shopList.add(shop);
//				shopDao.save(shop);
				
			}
			
		}
		return shopList;
		
	}
	
	private List<String> getAllRowsfromFile(String fileName){
		List<String> rows = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
			String line = null;
			while((line = br.readLine())!= null){
				rows.add(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return rows;
	}
	
	public void setShopDao(ShopDAO shopDao){
		this.shopDao = shopDao;
	}
	
	public DataGenerator(){
		
	}
	
	public static void main(String a[]){
		DataGenerator dGen = new DataGenerator();
		dGen.shopDataGen();
	}
}
