package com.cart.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cart.base.TestBase;
import com.cart.pages.CartPage;
import com.cart.pages.LoginPage;
import com.cart.pages.StorePage;
import com.inetbanking.utilities.MyException;

import junit.framework.Assert;

public class TC0003_AddToCartTest extends TestBase{
	

//	@Test(dataProvider = "getProductDetails",dataProviderClass = com.inetbanking.dataprovider.dataProvider.class)
//	public void addToCartTest(Map<String,String>testData) throws MyException
//	{
//		StorePage sp=new StorePage(driver);
//		sp.serachProduct(testData.get("productName"));
//		sp.sortProduct(testData.get("sortingText"));
//		sp.addProductToCart();
//	}
//	
	@Test(dataProvider = "getProductDetails",dataProviderClass = com.inetbanking.dataprovider.CartDataProvider.class)
	public void addToCartTest(String productName, String sortingText) throws MyException
	{
		StorePage sp=new StorePage(driver);
		sp.searchProduct(productName);
		sp.sortProduct(sortingText);
		sp.addProductToCart();
		CartPage cp=new CartPage(driver);
		cp.proceedToCheckout();
		
	}
	
	@Test
	public void purchaceProductTest()
	{
		CartPage cp=new CartPage(driver);
		cp.placeOrder();
	}
	
	
}
