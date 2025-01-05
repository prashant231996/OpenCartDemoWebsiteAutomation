package com.inetbanking.pageobjects;

import org.openqa.selenium.By;

public interface LoginPageObjects {
	
	By userNameField=By.id("username");
	
	By passWordField=By.id("password");
	
	By loginBtn=By.name("login");
	
	By accountBtn=By.linkText("Account");
	
	By userNameText=By.tagName("strong");
	
	By forgotPwdLink=By.xpath("//a[text()='Lost your password?']");
	
	By logoutLink=By.xpath("//a[text()='Logout']");
	
	By resetPwdUserName=By.name("user_login");
	
	By resetPwdBtn=By.xpath("//button[@value='Reset password']");
	
	By pwdUpdatedSucMsg=By.xpath("//*[contains(text(),'A password reset email has been sent to the email address')]");
	
	By mandatoryErrorMsg=By.xpath("//li/strong[contains(text(),'Error')]");
	
	By linkList=By.tagName("a");
	
	
	

}
