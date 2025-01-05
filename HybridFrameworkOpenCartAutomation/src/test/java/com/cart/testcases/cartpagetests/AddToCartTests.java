package com.cart.testcases.cartpagetests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cart.base.TestBase;
import com.cart.pages.HomePage;
import com.cart.pages.LoginPage;
import com.inetbanking.utilities.MyException;
import com.inetbanking.utilities.ReadConfig;

public class AddToCartTests extends TestBase{
	
	@Test(priority=0, description="Sorting products with low to high and adding lowest 3 products to cart")
	public void TC001_add3LowestPriceItemsToCartWith() throws MyException
	{
		homePage=new HomePage(driver);
		storePage=homePage.ClickOnShopNowLink();
		//Adding 3 products to cart with lowest price
		storePage.addNumberOfProductsToCart(3);
		
		
		
	}
	

}
