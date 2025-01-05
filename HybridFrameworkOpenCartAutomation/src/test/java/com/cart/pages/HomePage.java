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

}
