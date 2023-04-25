package com.inetbanking.pageobjects;

import org.openqa.selenium.By;

public interface RegistrationPageObjects {
	
	By myAccountBtn=By.xpath("//span[text()='My Account']");
	
	By registerLink=By.linkText("Account");
	
	By userNameField=By.id("reg_username");
	
	By emailField=By.id("reg_email");
	
	By pwdField=By.id("reg_password");
	
	By registerBtn=By.name("register");
	
	By firstName= By.name("firstname");
	
	By lastName=By.id("input-lastname");
	
	By email= By.id("input-email");
	
	By password=By.id("input-password");
	
	By subScribeNoRadioBtn=By.xpath("(//div[@class='form-check form-check-inline']/input[@type='radio'])[2]");
	
	By subScribeYesRadioBtn=By.xpath("(//div[@class='form-check form-check-inline']/input[@type='radio'])[1]");
	
	By privacyPolicyChkBox=By.name("agree");
	
	By continueBtn=By.xpath("//button[text()='Continue']");

}
