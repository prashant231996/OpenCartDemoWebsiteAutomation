package com.cart.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.FindElements;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.inetbanking.pageobjects.LoginPageObjects;
import com.inetbanking.utilities.MyException;

public class LoginPage extends BasePage implements LoginPageObjects{
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
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
	
	public boolean loginFailed()
	{
		return(wait.until(ExpectedConditions.visibilityOfElementLocated(forgotPwdLink))).isDisplayed();
	}
	
	public boolean logoutLinkDisplayed()
	{
		return wait.until(ExpectedConditions.visibilityOfElementLocated(logoutLink)).isDisplayed();
	}
	
	public void logoutFromApplication()
	{
		wait.until(ExpectedConditions.elementToBeClickable(logoutLink)).click();
	}
	
	public void updatePassword(String userName) throws MyException
	{
		waitTillElementVisible(accountBtn);
		clickOn(accountBtn);
		wait.until(ExpectedConditions.elementToBeClickable(forgotPwdLink)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(resetPwdUserName)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(resetPwdUserName)).sendKeys(userName);
		wait.until(ExpectedConditions.elementToBeClickable(resetPwdBtn)).click();
	}
	
	public boolean passwordUpdatedSuccessfully()
	{
		return wait.until(ExpectedConditions.visibilityOfElementLocated(pwdUpdatedSucMsg)).isDisplayed();
	}
	
	public boolean verifyMandatoryMsg()
	{
		return wait.until(ExpectedConditions.visibilityOfElementLocated(mandatoryErrorMsg)).isDisplayed();
	}
	
	public boolean validateBrokenLinksOnPage() throws MyException, IOException
	{
		try
		{
		List<WebElement>links=identifyALl(linkList);
		return validateBrokenLinks(links);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public void navigateToLoginPage() throws MyException
	{
		waitTillElementVisible(accountBtn);
		clickOn(accountBtn);
	}
	

}
