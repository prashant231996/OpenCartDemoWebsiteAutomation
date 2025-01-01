package com.cart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.FindElements;

import com.inetbanking.pageobjects.StorePageObjects;
import com.inetbanking.utilities.MyException;
import com.inetbanking.utilities.ReadConfig;

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
	
	public List<WebElement> getSortedProductListWithPriceLowToHigh()
	{
		List<WebElement>productList=new ArrayList<WebElement>();
		try
		{
			sortProduct(ReadConfig.getPropertyValue("sortWitPriceLowToHigh"));
			waitTillElementVisible(pageNumbers);
			List<WebElement>productPagesCount=identifyALl(pageNumbers);
			List<WebElement>pageTwoProducts=null;
			int pageCount=productPagesCount.size()-1;
			for(int i=0;i<pageCount;i++)
			{
				if(i!=0)
				{
				scrollIntoView(pageNumbers);
				productPagesCount.get(i).click();
				waitTillElementVisible(storeTitle);
				}
				if(productList.isEmpty())
				{
				productList=identifyALl(productsList);
				}
				else
				{
					pageTwoProducts=identifyALl(productsList);
				}
					
			}
			if(!productList.addAll(pageTwoProducts))
			{
				System.out.println("Something wrong while getting products list..");
			}
			scrollIntoView(prevPageNumber);
			clickOn(prevPageNumber);
			waitTillElementVisible(storeTitle);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return productList;
	}
	
	public void addNumberOfProductsToCart(int productCount)
	{
		try
		{
		List<WebElement>products=getSortedProductListWithPriceLowToHigh();
		for(int i=0;i<productCount;i++)
		{
			waitTillWebLementVisible(products.get(i));
			products.get(i).findElement(addToCartLink).click();
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public int getProductCountFromStorePage()
	{
		try
		{
			return Integer.parseInt((getTextFromElement(resultProductCount).split(" "))[3]);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 0;
		}
	}
	
	

}
