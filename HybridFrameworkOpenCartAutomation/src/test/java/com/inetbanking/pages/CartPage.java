package com.inetbanking.pages;

import org.openqa.selenium.WebDriver;

import com.inetbanking.pageobjects.CartPageObjects;
import com.inetbanking.utilities.MyException;

public class CartPage extends BasePage implements CartPageObjects{
	WebDriver lDriver;

	public CartPage(WebDriver rDriver)
	{
		lDriver=rDriver;
	}

	public void proceedToCheckout() throws MyException
	{
		try {
			//scrollIntoView(proceedToCheckOutBtn);
			scrollUptoBottomPfPage();
			Thread.sleep(2000);
			waitTillElementClickable(proceedToCheckOutBtn);
			clickOn(proceedToCheckOutBtn);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("Failed to click on proceed to checkout button");
		}
	}
	
	public void placeOrder()
	{
		try {
			scrollIntoView(placeOrderBtn);
			waitTillElementVisible(cashOnDeliveryOption);
			clickOn(cashOnDeliveryOption);
			waitTillElementVisible(placeOrderBtn);
			clickOn(placeOrderBtn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
