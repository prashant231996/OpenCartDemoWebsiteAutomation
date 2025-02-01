package com.cart.pages;

import java.util.List;

import org.openqa.selenium.By;
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
	
	public boolean verifyTotalPriceOnCheckoutPage() throws MyException
	{
		double subtotal=0,shipping=0,tax=0,total=0;
		scrollIntoView(yourOrdersHeader);
		List<WebElement>orderPriceRow=identifyALl(yourOrderFoooterTable);
		subtotal=Double.parseDouble(orderPriceRow.get(0).findElement(By.xpath("//td//bdi")).getText().substring(1));
		shipping=Double.parseDouble(orderPriceRow.get(1).findElement(By.xpath("//td[@data-title='Shipping']//bdi")).getText().substring(1));
		tax=Double.parseDouble(orderPriceRow.get(2).findElement(By.xpath("//th[text()='CA State Tax']/following-sibling::td/span")).getText().substring(1));
		total=Double.parseDouble(orderPriceRow.get(3).findElement(By.xpath("//th[text()='Total']/following-sibling::td//bdi")).getText().substring(1));
		if(total==(subtotal+shipping+tax))
			return true;
		else
			return false;
		
	}

}
