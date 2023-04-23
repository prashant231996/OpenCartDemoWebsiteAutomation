package com.inetbanking.pages;

import org.openqa.selenium.WebDriver;

import com.inetbanking.pageobjects.RegistrationPageObjects;
import com.inetbanking.utilities.MyException;

public class RegistrationPage extends BasePage implements RegistrationPageObjects{
	
	WebDriver ldriver;

	public RegistrationPage(WebDriver driver)
	{
		ldriver=driver;
	}
	
	public void gotTORegistrationPage() throws MyException
	{
		try {
			waitTillElementVisible(myAccountBtn);
			clickOn(myAccountBtn);
			waitTillElementVisible(registerLink);
			clickOn(registerLink);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("Failed to navigate to registration Page");
		}
	}
	
	public void doRegistration(String firstNameVal, String lastNameVal, String emailVal, String passwordVal) throws MyException
	{
		try {
			waitTillElementVisible(firstName);
			type(firstName,firstNameVal );
			waitTillElementVisible(lastName);
			type(lastName,firstNameVal );
			waitTillElementVisible(email);
			type(email,firstNameVal );
			waitTillElementVisible(password);
			type(password,firstNameVal );
			waitTillElementVisible(subScribeNoRadioBtn);
			scrollIntoView(subScribeNoRadioBtn);
			waitTillElementClickable(subScribeNoRadioBtn);
			//clickOn(subScribeNoRadioBtn);
			clickOnElementUsingJavaScriptExe(subScribeNoRadioBtn);
			waitTillElementClickable(privacyPolicyChkBox);
			clickOn(privacyPolicyChkBox);
			waitTillElementClickable(continueBtn);
			clickOn(continueBtn);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("Failed to do registration");
		}
	}
}
