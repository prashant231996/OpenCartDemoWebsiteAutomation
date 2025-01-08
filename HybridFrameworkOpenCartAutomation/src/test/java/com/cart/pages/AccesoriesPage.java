package com.cart.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.inetbanking.pageobjects.AccesoriesPageObjects;
import com.inetbanking.utilities.MyException;

public class AccesoriesPage extends BasePage implements AccesoriesPageObjects{

	public AccesoriesPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void sortTheProductWithPriceLowToHigh()
	{
		sortProduct("price_Low_High");
	}
	
	public void sortTheProductWithPriceHighToLow()
	{
		sortProduct("price_high_Low");
	}
	
	public int[] getProductsPrice() throws MyException
	{
		List<WebElement>prices=identifyALl(productPrices);
		int priceArray[]=new int[prices.size()];
		int count=0;
		for(WebElement price:prices)
		{
			priceArray[count]=Integer.parseInt(price.getText().substring(1,3));
			count++;
		}
		return priceArray;
	}

}
