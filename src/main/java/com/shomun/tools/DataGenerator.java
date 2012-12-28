package com.shomun.tools;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.lang.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.shomun.fish.core.data.dao.ShopDAO;
import com.shomun.fish.core.data.dao.UserDAO;
import com.shomun.fish.core.data.entity.Address;
import com.shomun.fish.core.data.entity.Category;
import com.shomun.fish.core.data.entity.CategoryBasedType;
import com.shomun.fish.core.data.entity.Product;
import com.shomun.fish.core.data.entity.Shop;
import com.shomun.fish.core.framework.dao.hibernate.GenericHibernateDAOImpl;

@Transactional
public class DataGenerator {

	ShopDAO shopDao;
	
	public void addCategoryBaseDataType(){
		Map<String,String[]> data = new HashMap<String, String[]>();
		
		String cusine[] = {"Bangladeshi","Indian","Mexican","Italian","Spanish","French","Japanese","Chinese","American","Turkish","Korean","African"};
		
		String foodType[] = {"veg","non-veg","seafood"};
		String foodGenere[] = {"appitizer","main dish","snacks","desert","drinks"};
		
		
		
		data.put("cusine", cusine);
		data.put("foodType", foodType);
		data.put("foodGenere", foodGenere);
		
		int countMain = 1;
		int countSub = 1;
		CategoryBasedType mainCat = null;
		CategoryBasedType subCat = null;
		
		String subCategory[] = null;
		for (String key : data.keySet()) {
			mainCat = new CategoryBasedType();
			mainCat.setId(String.valueOf(countMain));
			mainCat.setCategoryId("1_1");
			mainCat.setName(key);
			mainCat.setName("text.categorybasedtype.name."+key);
			mainCat.setName("text.categorybasedtype.name."+key);
			mainCat.setParentId("0");
			
			subCategory = data.get(key);
			
			if(subCategory != null){
				for (String name : subCategory) {
					subCat = new CategoryBasedType();
					subCat.setId(String.valueOf(countSub));
					subCat.setCategoryId("1_1");
					subCat.setName(key);
					subCat.setName("text.categorybasedtype.name."+key);
					subCat.setName("text.categorybasedtype.name."+key);
					subCat.setParentId(String.valueOf(countMain));
					
				}
			}
			
			countMain++;
		}
		
	}
	
	public List<Product> productGen(){
		List<Product> productList = new ArrayList<Product>();
		
		String shopDataFileName = "E:/MonirulBACKS/rnd/FishFish/data/indian_food.csv";
		
		
		
		List<String> productDataRows = this.getAllRowsfromFile(shopDataFileName);
		
		
		if(productDataRows != null){
			int count =-1;
			Product product = null;
			Category category = new Category();
			category.setId("2");
			String[] rowData = null;
			String transName = null;
			Random rnd = new Random();
			for (int i = 1; i < productDataRows.size(); i++) {
				product = new Product();
				rowData = productDataRows.get(i).split(",");
				
				product.setName(rowData[0]);
				product.setDescription(rowData[1]);
				product.setUnitPrice( 300+ rnd.nextInt(2000));
				product.setCategoryId(category.getId());
				
				
				productList.add(product);
//				
				
			}
			
		}
		
		return productList;
	}
	
	
	public List<Category> categoryGen(){
		String shopDataFileName = "E:/MonirulBACKS/rnd/FishFish/categoryMasterLog.csv";
		
		
		List<Category> categoryList = new ArrayList<Category>();
		List<String> categoryDataRows = this.getAllRowsfromFile(shopDataFileName);
		
		
		if(categoryDataRows != null){
			int count =-1;
			Category category = null;
			
			String[] rowData = null;
			String transName = null;
			for (int i = 1; i < categoryDataRows.size(); i++) {
				category = new Category();
				rowData = categoryDataRows.get(i).split(",");
				category.setId(rowData[0]);
				//transName = this.TranslateToEng(rowData[1]);
				category.setName(transName);
				category.setParentId(rowData[2]);
				
				//category.setDescription(rowData[0]);
				
				categoryList.add(category);
//				
				
			}
			
		}
		return categoryList;
	}
	
	public String TranslateToEng(String word){
		String url = "http://mymemory.translated.net/api/get?q=" +
				word+"&langpair=ja|en";
		String transtext = null;
		try {
			//String urlEnc =URLEncoder.encode(url);
			URL urll = new URL(url);
			HttpClient client = new DefaultHttpClient();
			URI uri = new URI(urll.getProtocol(),urll.getHost(),urll.getPath(),urll.getQuery(),null);
			HttpResponse response = client.execute(new HttpGet(uri));
			Header[] headers = response.getAllHeaders();
			InputStream responseBody = response.getEntity().getContent();
			StringBuilder builder = new StringBuilder();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(responseBody));
			builder.append("[");
            for (String line = null; (line = bufferedReader.readLine()) != null;) {
                builder.append(line).append("\n");
            }
            builder.append("]");
            JSONArray jsonArray = new JSONArray(builder.toString());
            JSONObject jsonObject = null;
            for (int i = 0; i < jsonArray.length(); i++) {
                jsonObject = jsonArray.getJSONObject(i);
            }
            
            if(jsonObject != null){
            	transtext =(String)((JSONObject)jsonObject.get("responseData")).get("translatedText");
            }
            System.out.println("Translated text for "+ word + "  is : "+ transtext);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return transtext;
	}
	
	private String getValue( NodeList nodeList){
		Node node = null;
		if(nodeList != null){
			for (int i = 0; i < nodeList.getLength(); i++) {
				 node = nodeList.item(i);
				 if(node.getFirstChild() != null){
						return node.getFirstChild().getTextContent();
				 }
			 }
		}
		 
		return "";
	}
	
	
	public  List<Shop> shopDataGen(){
		String shopDataFileName = "E:/MonirulBACKS/rnd/FishFish/data/restaurant_tokyo.csv";
		//String shopNameFileName = "E:/MonirulBACKS/rnd/FishFish/shopNames.txt";
		
		List<Shop> shopList = new ArrayList<Shop>();
		List<String> shopDataRows = this.getAllRowsfromFile(shopDataFileName);
		//List<String> shopNameRows = this.getAllRowsfromFile(shopNameFileName);
		
		if(shopDataRows != null){
			int count =-1;
			Shop shop = null;
			Address addr = null;
			Category category = new Category();
			String[] rowData = null;
			String latLang[] = null;
			for (int i = 1001; i < 1500; i++) {
				shop = new Shop();
				rowData = shopDataRows.get(i).split(",");
				shop.setActivated(true);
				shop.setName(rowData[1]);
				category.setId("2");
				shop.addCategory(category);
//				shop.setName(shopNameRows.get(i-1));
				addr = new Address();
				
				if(!rowData[2].isEmpty()){
					//rowData[2] = rowData[2].replaceAll("-", "");
					addr.setPhone(rowData[2]);
				}
				if(!rowData[3].isEmpty()){
					//rowData[2] = rowData[2].replaceAll("-", "");
					addr.setFax(rowData[3]);
				}
				if(!rowData[4].isEmpty()){
					//rowData[2] = rowData[2].replaceAll("-", "");
					addr.setMobilePhone(rowData[4]);
				}
				
				if(!rowData[5].isEmpty()){
					rowData[5] = rowData[5].replaceAll("-", "");
					addr.setPostalCode(rowData[5]);
				}
				
				
				String japAddr = rowData[6] + rowData[7] + rowData[8] + rowData[9];
				
				if(!rowData[11].isEmpty()){
					if(rowData[11].equals("toukyouto")){
						rowData[11] = "Tokyo";
					}
					rowData[11] = StringUtils.capitalise(rowData[11]);
					
					addr.setState(rowData[11]);
				}
				addr.setCity(rowData[12]);
				addr.setSuburb(rowData[13]);
				addr.setStreet(rowData[14]+ rowData[15]);
				addr.setCountry("Japan");
				latLang = this.getLatLangYahooAPI(japAddr);
				
				if(!latLang[0].isEmpty()){
					addr.setLatitude(Float.valueOf(latLang[0]));
				}
				if(!latLang[1].isEmpty()){
					addr.setLongitude(Float.valueOf(latLang[1]));
				}
				
				
				shop.addAddress(addr);
				shopList.add(shop);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
	
	public String[] getLatLangYahooAPI(String address){
		String url = "http://where.yahooapis.com/geocode?q="+address+"&appid=dj0yJmk9aHJqbTd6dWJ5TWl5JmQ9WVdrOVdqUm9kMGR6TXpRbWNHbzlOakV4TmpNMU5UWXkmcz1jb25zdW1lcnNlY3JldCZ4PTE4";
		String[] latLang = new String[2];
		latLang[0] = "";
		latLang[1] = "";
		DocumentBuilder docBuilder; 
		try {
			docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			 Document srcDoc = docBuilder.parse(url);
//			 NodeList nodeLat = srcDoc.getElementsByTagName("latitude");
//			 NodeList nodeLong = srcDoc.getElementsByTagName("longitude");
			 latLang[0] = this.getValue(srcDoc.getElementsByTagName("latitude"));
 			 latLang[1] = this.getValue(srcDoc.getElementsByTagName("longitude"));
 			 System.out.println("Latitude : " + latLang[0] + "  ----  Longitude : " + latLang[1]);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return latLang;
	}
	
//	private String getValue( NodeList nodeList){
//		Node node = null;
//		if(nodeList != null){
//			for (int i = 0; i < nodeList.getLength(); i++) {
//				 node = nodeList.item(i);
//				 if(node.getFirstChild() != null){
//						return node.getFirstChild().getTextContent();
//				 }
//			 }
//		}
//		 
//		return "";
//	}
	
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
