package com.cart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageU extends BasePage{
	
    WebDriver driver;
	
	public LoginPageU(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
	}
	
	@FindBy(name="uid")
	WebElement userId;
	
	@FindBy(name="password")
	WebElement pwd;
	
	@FindBy(name="btnLogin")
	WebElement loginBtn;
	
	public void setUserName(String userName)
	{
		userId.sendKeys(userName);
	}
	
	public void setPassword(String password)
	{
		pwd.sendKeys(password);
	}
	
	public void clickLogin()
	{
		loginBtn.click();
	}
	
	public void doLogin(String userName,String password)
	{
		setUserName(userName);
		setPassword(password);
		clickLogin();
	}
	

}
