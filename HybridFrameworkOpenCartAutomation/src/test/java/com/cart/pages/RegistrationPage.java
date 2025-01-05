package com.cart.pages;

import org.openqa.selenium.WebDriver;

import com.inetbanking.pageobjects.RegistrationPageObjects;
import com.inetbanking.utilities.MyException;

public class RegistrationPage extends BasePage implements RegistrationPageObjects{
	
    WebDriver driver;
	
	public RegistrationPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
	}
	
//	public void gotTORegistrationPage() throws MyException
//	{
//		try {
//			waitTillElementVisible(myAccountBtn);
//			clickOn(myAccountBtn);
//			waitTillElementVisible(registerLink);
//			clickOn(registerLink);
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new MyException("Failed to navigate to registration Page");
//		}
//	}
	
	public void doRegistration(String userName, String emailVal, String passwordVal) throws MyException
	{
		try {
			waitTillElementVisible(userNameField);
			type(userNameField,userName );
			waitTillElementVisible(emailField);
			type(emailField,emailVal );
			waitTillElementVisible(pwdField);
			type(pwdField,passwordVal );
			waitTillElementClickable(registerBtn);
			clickOn(registerBtn);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("Failed to do registration");
		}
	}
	
	public void gotTORegistrationPage() throws MyException
	{
		try {
			waitTillElementVisible(registerLink);
			clickOn(registerLink);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("Failed to navigate to registration Page");
		}
	}
	
	public boolean registerSuc() throws MyException
	{
		boolean flag=false;
		try {
			flag=isELementDisplayed(regSucMsg);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("Failed to do registration.");
		}
		return flag;
	}
}
