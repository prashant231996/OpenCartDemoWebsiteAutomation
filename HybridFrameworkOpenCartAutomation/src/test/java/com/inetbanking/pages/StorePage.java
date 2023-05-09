package com.inetbanking.pages;

import org.openqa.selenium.WebDriver;

import com.inetbanking.pageobjects.StorePageObjects;
import com.inetbanking.utilities.MyException;

import junit.framework.Assert;

public class StorePage extends BasePage implements StorePageObjects{
	
	WebDriver lDriver;
	
	public StorePage(WebDriver rDriver)
	{
		this.lDriver=rDriver;
	}
	
	public void searchProduct(String productName) throws MyException
	{
		try {
			clickOn(storeLink);
			type(searchBox, productName);
			clickOn(searchBtn);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("Failed to search Product");
		}
	}
	
	public void sortProduct(String sortingCategory) throws MyException
	{
		try {
			selectByValue(relavanceDropdown, sortingCategory);
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("Failed to search Product");
		}
	}
	
	public void addProductToCart() throws MyException
	{
		try {
			scrollIntoView(addToCartBtn);
			waitTillElementVisible(addToCartBtn);
			clickOn(addToCartBtn);
			waitTillElementVisible(viewCartMenu);
			clickOn(viewCartMenu);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("Failed to search Product");
		}
	}
	
	

}
