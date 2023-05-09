package com.inetbanking.pages;

import org.openqa.selenium.WebDriver;

import com.inetbanking.pageobjects.LoginPageObjects;
import com.inetbanking.utilities.MyException;

public class LoginPageNew extends BasePage implements LoginPageObjects{
	
	WebDriver lDriver;
	
	public LoginPageNew(WebDriver rDriver)
	{
		lDriver=rDriver;
	}
	
	
	public void doLogin(String userName, String pwd) throws MyException
	{
		waitTillElementVisible(accountBtn);
		clickOn(accountBtn);
		waitTillElementVisible(userNameField);
		type(userNameField, userName);
		waitTillElementVisible(passWordField);
		type(passWordField, pwd);
		waitTillElementVisible(userNameField);
		clickOn(loginBtn);
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
