package com.inetbanking.pageobjects;

import org.openqa.selenium.By;

public interface CartPageObjects {

	//By proceedToCheckOutBtn=By.linkText("Proceed to checkout");
	By proceedToCheckOutBtn=By.xpath("//div[@class='wc-proceed-to-checkout']/a");
	
	By cashOnDeliveryOption= By.xpath("//input[@id='payment_method_cod']");
	
	By placeOrderBtn=By.id("place_order");
	
	By firstName=By.id("billing_first_name");
	
	By lastName=By.id("billing_last_name");
	
	By countryDropDoen=By.id("billing_country");
	
	By Address=By.id("billing_address_1");
	
	By city=By.id("billing_city");
	
	By zipCode=By.id("billing_postcode");
	
	By email=By.id("billing_email");
	
	By cartLogo=By.xpath("//a[@title='View your shopping cart']");
	
	By cartPageHeader=By.xpath("//h1[text()='Cart']");
	
	By produDetailsRows=By.xpath("//table/tbody/tr[contains(@class,'cart-form')]");
	
	By updateCartBtn=By.xpath("//button[@name='update_cart']");
	
	By cartUpdatedMsg=By.xpath("//*[contains(text(),'Cart updated')]");
	
	
	
}
