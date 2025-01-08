package com.cart.testcases.accesoriestests;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.cart.base.BaseTest;
import com.cart.pages.AccesoriesPage;
import com.cart.pages.HomePage;

public class AccesoriesTest extends BaseTest{
	
	@Test(priority=1,description="Sort the product with respect to price from low to high")
	public void TC_001()
	{
		try
		{
			getDriver().get(baseUrl);
			HomePage hmPage=new HomePage(getDriver());
			AccesoriesPage accesoriesPage=hmPage.goToAccesoriesPage();
			accesoriesPage.sortTheProductWithPriceLowToHigh();
			int[]prices=accesoriesPage.getProductsPrice();
			int min=0;
			boolean flag=false;
		   for(int price:prices)
		   {
			   if(price>min)
			   {
				   
			   }
			   else
			   {
				   flag=true;
				   break;
			   }
		   }
		   Assert.assertFalse(flag);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			
		}
	}
	
	@Test(priority=2,description="Sort the product with respect to price from high to low")
	public void TC_002()
	{
		try
		{
			getDriver().get(baseUrl);
			HomePage hmPage=new HomePage(getDriver());
			AccesoriesPage accesoriesPage=hmPage.goToAccesoriesPage();
			accesoriesPage.sortTheProductWithPriceHighToLow();
			int[]prices=accesoriesPage.getProductsPrice();
			int max=10000;
			boolean flag=false;
		   for(int price:prices)
		   {
			   if(price<max)
			   {
				 
			   }
			   else
			   {
				   flag=true;
				   break;
			   }
		   }
		   Assert.assertFalse(flag);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			
		}
	}

}
