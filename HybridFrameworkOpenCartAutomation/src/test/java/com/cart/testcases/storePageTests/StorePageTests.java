package com.cart.testcases.storePageTests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cart.pages.HomePage;
import com.cart.testcases.TestBase;
import com.inetbanking.utilities.MyException;


public class StorePageTests extends TestBase{
	
	@Test(priority=0, description="GEt products count from store page")
	public void TC001_add3LowestPriceItemsToCartWith() throws MyException
	{
		homePage=new HomePage(driver);
		storePage=homePage.ClickOnShopNowLink();
		List<WebElement>products=storePage.getSortedProductListWithPriceLowToHigh();
		Assert.assertEquals(products.size(), storePage.getProductCountFromStorePage());
		
		
	}

}
