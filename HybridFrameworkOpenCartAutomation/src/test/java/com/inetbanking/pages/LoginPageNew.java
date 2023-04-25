package com.inetbanking.pages;

import com.inetbanking.pageobjects.LoginPageObjects;
import com.inetbanking.utilities.MyException;

public class LoginPageNew extends BasePage implements LoginPageObjects{
	
	public void doLogin(String userName, String pwd) throws MyException
	{
		waitTillElementVisible(userNameField);
		type(userNameField, userName);
		waitTillElementVisible(passWordField);
		type(passWordField, pwd);
		waitTillElementVisible(userNameField);
		clickOn(loginBtn);
		
	}

}
