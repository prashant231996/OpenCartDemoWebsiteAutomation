package com.cart.testcases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cart.base.BaseTest;
import com.cart.pages.CartPage;
import com.cart.pages.HomePage;
import com.cart.pages.LoginPage;
import com.inetbanking.utilities.MyException;
import com.inetbanking.utilities.ReadConfig;

public class CartPageTests extends BaseTest{
	
	@Test(priority=0, description="Sorting products with low to high and adding lowest 3 products to cart",enabled=false)
	public void TC001_add3LowestPriceItemsToCartWith() throws MyException
	{
		homePage=new HomePage(driver);
		storePage=homePage.ClickOnShopNowLink();
		//Adding 3 products to cart with lowest price
		storePage.addNumberOfProductsToCart(3);	
	}
	
	@Test(priority=1,description="Validate item from the cart")
	public void TC002() throws MyException
	{
		try
		{
		getDriver().get(config.getPropertyValue("baseUrl"));
		homePage=new HomePage(getDriver());
		accesoriesPage=homePage.goToAccesoriesPage();
		accesoriesPage.addProductToCart("Anchor Bracelet", "2");
		cartpage=accesoriesPage.navigateToCartPage();
		boolean validate=cartpage.validateProductDetailsFromCartPage("Anchor Bracelet", "10", "2");
		Assert.assertTrue(validate);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	@Test(priority=2,description="Remove item from the cart")
	public void TC003()
	{
		try
		{
			getDriver().get(config.getPropertyValue("baseUrl"));
			homePage=new HomePage(getDriver());
			accesoriesPage=homePage.goToAccesoriesPage();
			accesoriesPage.addProductToCart("Anchor Bracelet", "2");
			cartpage=accesoriesPage.navigateToCartPage();
			cartpage.removeItemFromCart("Anchor Bracelet");
			Assert.assertTrue(cartpage.productRemovedSuccessfully("Anchor Bracelet"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test(priority=3,description="Validate subtotal amount from cart page")
	public void TC004()
	{
		try
		{
			getDriver().get(config.getPropertyValue("baseUrl"));
			homePage=new HomePage(getDriver());
			accesoriesPage=homePage.goToAccesoriesPage();
			accesoriesPage.addProductToCart("Anchor Bracelet", "2");
			cartpage=accesoriesPage.navigateToCartPage();
			Assert.assertTrue(cartpage.validateSubTotalPriceOfProduct("Anchor Bracelet"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test(priority=4,description="Update cart details.")
	public void TC005()
	{
		try
		{
			getDriver().get(config.getPropertyValue("baseUrl"));
			homePage=new HomePage(getDriver());
			accesoriesPage=homePage.goToAccesoriesPage();
			accesoriesPage.addProductToCart("Anchor Bracelet", "2");
			cartpage=accesoriesPage.navigateToCartPage();
			cartpage.updateCartDetails("Anchor Bracelet", "3");
			Assert.assertTrue(cartpage.cartUpdatedSuccessfully());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	

}
