package com.inetbanking.pageobjects;

import org.openqa.selenium.By;

public interface LoginPageObjects {
	
	By userNameField=By.id("username");
	
	By passWordField=By.id("password");
	
	By loginBtn=By.name("login");
	
	By accountBtn=By.linkText("Account");
	
	By userNameText=By.xpath("(//strong[text()='TestName'])[1]");
	
	

}
