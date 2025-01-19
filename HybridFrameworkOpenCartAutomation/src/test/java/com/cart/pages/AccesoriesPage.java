package com.cart.pages;

import java.util.List;

import org.apache.tools.ant.types.Quantifier;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.FindElement;

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
	
	public String searchProductAndGetProductTitle(String productName) throws MyException
	{
		searchProduct(productName);
		waitTillElementVisible(productTitle);
		return identify(productTitle).getText();
	}
	
	public boolean verifyProdyuctCatrgoryAsAccesories() throws MyException
	{
		scrollIntoView(productCategory);
		waitTillElementVisible(accesoriesCategoryOption);
		return identify(accesoriesCategoryOption).isSelected();
	}
	
	public String getProductFromBestSeller() throws MyException
	{
		String productName="";
		waitTillElementVisible(productNameFromBestSeller);
		productName=identify(productNameFromBestSeller).getText();
		waitTillElementClickable(productLinkFromBestSeller);
		identify(productLinkFromBestSeller).click();
		return productName;
	}
	
	public String getProductTitle() throws MyException
	{
		waitTillElementVisible(productTitle);
		return identify(productTitle).getText();
	}
	
	public void filterPriceBasedOnSlider() throws MyException
	{
		waitTillElementVisible(minPriceSlider);
		System.out.println(identify(minPriceSlider).getLocation());
		//System.out.println(minPriceSlider);
		dragAndDropBy(minPriceSlider, 500, 834);
	}
	
	public void addProductToCart(String quntity) throws MyException
	{
		type(productQuantity,quntity);
		clickOn(addToCartBtn);	
	}
	
	public boolean addProductToCartSuccessfully(String productName)
	{
		return driver.findElement(By.xpath("//*[text()=' “"+productName+"” has been added to your cart.	']")).isDisplayed();
	}
	
	public boolean addProductToCartSuccessfully(String quantity,String productName)
	{
		return driver.findElement(By.xpath("//*[text()=' "+quantity+" × “"+productName+"” have been added to your cart.	']")).isDisplayed();
	}
	
	
	public boolean chkProductAddedToCartSucMsg(String productName) throws MyException
	{
		return identify(addToCartSucMsg).getText().contains(productName);
	}
	
	public void viewCartPage() throws MyException
	{
		waitTillElementClickable(viewCart);
		clickOn(viewCart);
	}
	
	public boolean addProductToCart(String productName,String quantity) throws MyException
	{
		type(searchProduct, productName);
		clickOn(searchBtn);
		type(productQuantity,quantity);
		clickOn(addToCartBtn);
		return addProductToCartSuccessfully(quantity,productName);
	}
	
	public HomePage navigateToHomePage()
	{
		try
		{
			clickOn(homePageLink);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return new HomePage(driver);
	}
	
	public CartPage navigateToCartPage()
	{
		try
		{
			clickOn(cartLogo);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		return new CartPage(driver);
	}
	
	public CartPage navigateToCartPageWithJs()
	{
		try
		{
			clickOnElementUsingJavaScriptExe(cartLogo);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		return new CartPage(driver);
	}

}
