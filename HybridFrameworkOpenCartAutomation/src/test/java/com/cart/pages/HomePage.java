package com.cart.pages;

import org.openqa.selenium.WebDriver;

import com.inetbanking.pageobjects.HomePageObjects;
import com.inetbanking.utilities.MyException;

public class HomePage extends BasePage implements HomePageObjects{
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
	}
	
	public void logOutFromApplication()
	{
		try {
			waitTillElementVisible(accountLink);
			clickOn(accountLink);
			waitTillElementVisible(logOutBtn);
			clickOn(logOutBtn);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public StorePage ClickOnShopNowLink() throws MyException
	{
		waitTillElementClickable(shopNowLink);
		clickOn(shopNowLink);
		return new StorePage(this.driver);
	
	}
	
	public AccesoriesPage goToAccesoriesPage() throws MyException
	{
		waitTillElementVisible(accessoriesLink);
		clickOn(accessoriesLink);
		return new AccesoriesPage(driver);
	}
	
	public CartPage navigateToCartPage()
	{
		try
		{
			clickOn(cartLogo);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		return new CartPage(driver);
	}
	
	public boolean doMouseHoverOnCartLogoAndSeeMiniCartContent()
	{
		try
		{
			doMouseHoverOverElement(cartLogo);
			try
			{
			isElementDisplayed(miniCartProductLink);
			isElementDisplayed(removeItemFromMiniCart);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return false;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean doMouseHoverOnCartLogoWhenNoProductsAdded()
	{
		try
		{
			doMouseHoverOverElement(cartLogo);
			try
			{
		    isElementDisplayed(noProductInCartMsg);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return false;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
	

}
