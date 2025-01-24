package com.cart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.inetbanking.pageobjects.CheckoutPageObjects;
import com.inetbanking.utilities.MyException;

public class CheckoutPage extends BasePage implements CheckoutPageObjects{

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean verifyMandatoryDetailsOnCheckoutPage() throws MyException
	{
		scrollIntoView(placeOrderBtn);
		clickOn(placeOrderBtn);
		scrollIntoView(mandatoryDetailsErr);
		return isElementDisplayed(mandatoryDetailsErr);
	}
	
	public void addMandatoryDetailsAndDoCheckout(String firstnameField, String lastnameField, String countryname,
			String cityname,String stateName,String address1,String postalCode, String email) throws MyException
	{
	   type(billingFirstName, firstnameField);
	   type(billingLastName, lastnameField);
	   selectCountry(countryname);
	   type(billingAdressOnse, address1);
	   type(billingCity, cityname);
	   selectState(stateName);
	   type(zipCodeField, postalCode);
	   type(emailField, email);
	   clickOn(cashOnDeliveryOption);
	   clickOn(placeOrderBtn);
	}
	
	public void selectCountry(String countryName) throws MyException
	{
	   WebElement countrydropDown=identify(selectCountryDropdown);
       Select select=new Select(countrydropDown);
       select.selectByVisibleText(countryName);
	}
	
	public void selectState(String stateName) throws MyException
	{
		WebElement stateNameEle=identify(billingState);
		Select stateEleDropdown=new Select(stateNameEle);
		stateEleDropdown.selectByVisibleText(stateName);
	}
	
	public boolean orderPurchaseSuccessfully()
	{
		return wait.until(ExpectedConditions.visibilityOfElementLocated(orderPurchaseMsg)).isDisplayed();
	}

}
