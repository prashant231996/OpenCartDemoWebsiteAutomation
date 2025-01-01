package com.cart.pages;

import org.openqa.selenium.WebDriver;

import com.inetbanking.pageobjects.LoginPageObjects;
import com.inetbanking.utilities.MyException;

public class LoginPageNew extends BasePage implements LoginPageObjects{
	
	WebDriver driver;
	
	public LoginPageNew(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public HomePage doLogin(String userName, String pwd) throws MyException
	{
		waitTillElementVisible(accountBtn);
		clickOn(accountBtn);
		waitTillElementVisible(userNameField);
		type(userNameField, userName);
		waitTillElementVisible(passWordField);
		type(passWordField, pwd);
		waitTillElementVisible(userNameField);
		clickOn(loginBtn);
		return new HomePage(this.driver);
	}
	
	public String loginSuccessfullData() throws MyException
	{ String text="";
		try {
			text=getTextFromElement(userNameText);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("Failed to login successfully..");
		}
		return text;
	}
	

}
