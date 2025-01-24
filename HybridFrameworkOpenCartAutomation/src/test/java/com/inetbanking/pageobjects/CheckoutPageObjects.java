package com.inetbanking.pageobjects;

import org.openqa.selenium.By;

public interface CheckoutPageObjects {
	
	By placeOrderBtn=By.id("place_order");
	
	By mandatoryDetailsErr=By.xpath("//*[contains(@class,'NoticeGroup-checkout')]");
	
	By billingFirstName=By.id("billing_first_name");
	
	By billingLastName=By.id("billing_last_name");
	
	By billingCompany=By.id("billing_company");
	
	By selectCountryDropdown=By.id("billing_country");
	
	By billingAdressOnse=By.id("billing_address_1");
	
	By billingAdressTwo=By.id("billing_address_2");
	
	By billingCity=By.id("billing_city");
	
	By countryDropdown=By.id("billing_state");
	
	By zipCodeField=By.id("billing_postcode");
	
	By emailField=By.id("billing_email");
	
	By bankTransferOption=By.id("payment_method_bacs");
	
	By cashOnDeliveryOption=By.id("payment_method_cod");
	
	By billingState=By.id("billing_state");
	
	By orderPurchaseMsg=By.xpath("//*[contains(text(),'Thank you. Your order has been received.')]");

}
