package com.cart.testcases;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.cart.base.BaseTest;
import com.cart.pages.CheckoutPage;
import com.cart.pages.HomePage;

public class CheckOutPageTest extends BaseTest{
	
	@Test(priority=1,description="Verify mandatory details on checkout page")
	public void TC001()
	{
		try
		{
			getDriver().get(config.getPropertyValue("baseUrl"));
			homePage=new HomePage(getDriver());
			accesoriesPage=homePage.goToAccesoriesPage();
			accesoriesPage.addProductToCart("Anchor Bracelet", "1");
			getDriver().navigate().refresh();
			cartpage=accesoriesPage.navigateToCartPage();
			checkCheckoutPage=cartpage.checkoutProductAddedInCart();
			Assert.assertTrue(checkCheckoutPage.verifyMandatoryDetailsOnCheckoutPage());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test(priority=2,description="Purchase product giving all mandatory detials.")
	public void TC002()
	{
		try
		{
			getDriver().get(config.getPropertyValue("baseUrl"));
			homePage=new HomePage(getDriver());
			accesoriesPage=homePage.goToAccesoriesPage();
			accesoriesPage.addProductToCart("Anchor Bracelet", "1");
			getDriver().navigate().refresh();
			cartpage=accesoriesPage.navigateToCartPage();
			checkCheckoutPage=cartpage.checkoutProductAddedInCart();
		    checkCheckoutPage.addMandatoryDetailsAndDoCheckout("prashant", "more", "India", "Ich", "Maharashtra", "address1", "415115", "testEmail@test.com");
		    Assert.assertTrue(checkCheckoutPage.orderPurchaseSuccessfully());
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	
	
	

}
