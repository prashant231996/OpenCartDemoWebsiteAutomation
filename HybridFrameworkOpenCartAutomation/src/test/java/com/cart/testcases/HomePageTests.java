package com.cart.testcases;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.cart.base.BaseTest;
import com.cart.pages.HomePage;
import com.inetbanking.utilities.ReadConfig;

public class HomePageTests extends BaseTest{
	
	public ReadConfig conf;
	
	@Test(priority=1,description="Mouse hover on cart page logo and chk no product added to cart msg displayed",enabled=false)
	public void TC001()
	{
		try
		{
			getDriver().get(conf.getPropertyValue("baseUrl"));
			homePage=new HomePage(getDriver());
			Assert.assertTrue(homePage.doMouseHoverOnCartLogoWhenNoProductsAdded());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test(priority=1,description="Mouse hover on cart page logo and cart page content displayed")
	public void TC002()
	{
		try
		{
			getDriver().get(conf.getPropertyValue("baseUrl"));
			homePage=new HomePage(getDriver());
			accesoriesPage=homePage.goToAccesoriesPage();
			accesoriesPage.addProductToCart("Anchor Bracelet", "2");
			homePage=accesoriesPage.navigateToHomePage();
			homePage.doMouseHoverOnCartLogoAndSeeMiniCartContent();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
