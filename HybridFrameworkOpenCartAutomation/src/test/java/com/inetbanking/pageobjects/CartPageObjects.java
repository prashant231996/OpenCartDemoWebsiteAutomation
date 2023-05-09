package com.inetbanking.pageobjects;

import org.openqa.selenium.By;

public interface CartPageObjects {

	//By proceedToCheckOutBtn=By.linkText("Proceed to checkout");
	By proceedToCheckOutBtn=By.xpath("//div[@class='wc-proceed-to-checkout']/a");
	
	By cashOnDeliveryOption= By.xpath("//input[@id='payment_method_cod']");
	
	By placeOrderBtn=By.id("place_order");
}
