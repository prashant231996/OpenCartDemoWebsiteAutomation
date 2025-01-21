package com.cart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.inetbanking.pageobjects.CartPageObjects;
import com.inetbanking.utilities.MyException;

public class CartPage extends BasePage implements CartPageObjects{
	WebDriver driver;

	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
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
	
	public void fillCustomerDetails(String name, String lName, String country, String address, String cityName, String stateName, String emailId)
	{
		try {
			waitTillElementVisible(firstName);
			type(firstName, name);
			waitTillElementVisible(lastName);
			type(lastName, lName);
			waitTillElementVisible(countryDropDoen);
			selectByValue(countryDropDoen, country);
			waitTillElementVisible(Address);
			type(Address, address);
			waitTillElementVisible(city);
			type(city, cityName);
			waitTillElementVisible(city);
			type(city, cityName);
			waitTillElementVisible(city);
			type(city, cityName);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
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
	
	public boolean validateProductDetailsFromCartPage(String productname, String productprice,String quantity)
	{
		boolean flag=false;
		try
		{
			List<WebElement>productRows=identifyALl(produDetailsRows);
			for(int i=0;i<productRows.size();i++)
			{
				List<WebElement>productColumns=productRows.get(i).findElements(By.tagName("td"));
				for(int j=0;j<productColumns.size();j++)
				{
					if(j==2)
					{
						if(productColumns.get(j).findElement(By.tagName("a")).getText().equalsIgnoreCase(productname))
						{
							flag=true;
						}
						else
						{
							return false;
						}
					}
					if(j==3)
					{
						if(productColumns.get(j).findElement(By.xpath("//span/bdi")).getText().contains(productprice))
						{
							flag=true;
						}
						else
						{
							return false;
						}
					}
					if(j==4)
					{
						if(productColumns.get(j).findElement(By.xpath("//div/input")).getAttribute("value").equalsIgnoreCase(quantity))
						{
							flag=true;
						}
						else
						{
							return false;
						}
					}
					
//					switch(j)
//					{
//					case 2:flag=productColumns.get(j).findElement(By.tagName("a")).getText().equalsIgnoreCase(productname);
//					break;
//					case 3:flag=productColumns.get(j).findElement(By.xpath("//span/bdi")).getText().contains(productprice);
//					break;
//					case 4:flag=productColumns.get(j).findElement(By.xpath("//div/input")).getAttribute("value").equalsIgnoreCase(quantity);
//					break;
//					default:
//						continue;
//					}
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return flag;
	}
	
	public void removeItemFromCart(String productname)
	{
		try
		{
			List<WebElement>productRows=identifyALl(produDetailsRows);
			for(int i=0;i<productRows.size();i++)
			{
				if(productRows.get(i).findElement(By.xpath("//td[@class='product-name']/a")).getText().equalsIgnoreCase(productname))
                  {
	                    productRows.get(i).findElement(By.xpath("//td[@class='product-remove']/a")).click(); 
	                    break;
                   }
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public boolean productRemovedSuccessfully(String productname)
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'"+productname+"” removed')]")));
			return driver.findElement(By.xpath("//*[contains(text(),'"+productname+"” removed')]")).isDisplayed();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean validateSubTotalPriceOfProduct(String productname)
	{
		try
		{
			List<WebElement>productRows=identifyALl(produDetailsRows);
			for(int i=0;i<productRows.size();i++)
			{
				if(productRows.get(i).findElement(By.xpath("//td[@class='product-name']/a")).getText().equalsIgnoreCase(productname))
				{
					double price=Double.parseDouble(productRows.get(i).findElement(By.xpath("//td[@class='product-price']/descendant::bdi")).getText().substring(1));
					double quantity=Double.parseDouble(productRows.get(i).findElement(By.xpath("//td[@class='product-quantity']/div/input")).getAttribute("value"));
					double subTotal=Double.parseDouble(productRows.get(i).findElement(By.xpath("//td[@class='product-subtotal']/descendant::bdi")).getText().substring(1));
					if(price*quantity == subTotal)
					{
						return true;
					}
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return false;
	}
	
	public void updateCartDetails(String productname, String updatedCount)
	{
		try
		{
			List<WebElement>produtDetailRows=identifyALl(produDetailsRows);
			for(int i=0;i<produtDetailRows.size();i++)
			{
				if(produtDetailRows.get(i).findElement(By.xpath("//td[@class='product-name']/descendant::a")).getText().equalsIgnoreCase(productname))
				{
					produtDetailRows.get(i).findElement(By.xpath("//td[@class='product-quantity']/descendant::input")).clear();
					produtDetailRows.get(i).findElement(By.xpath("//td[@class='product-quantity']/descendant::input")).sendKeys(updatedCount);
					break;
				}
			}
			clickOn(updateCartBtn);
		}
		catch(Exception e)
		{
		  e.printStackTrace();
		}
	}
	
	public boolean cartUpdatedSuccessfully() throws MyException
	{
		return isElementDisplayed(cartUpdatedMsg);
	}
	
	public void applyCouponToaddedItems(String couponCodeValue) throws MyException
	{
		type(couponCode, couponCodeValue);
		clickOn(applyCouponBtn);
	}
	
	public boolean couponNotExistMsg(String couponCode) 
	{
		return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'Coupon \""+couponCode+"\" does not exist!')]")))).isDisplayed();
	}
	
	public boolean validateTotalPriceFromCartTotals()
	{
		double subTotal=0,shippingCharge=0,tax=0,total=0;
		try
		{
			List<WebElement>cartTotalRows=identifyALl(cartTotalsRows);
			subTotal=Double.parseDouble(cartTotalRows.get(0).findElement(By.xpath("//td//bdi")).getText().substring(1));
			shippingCharge=Double.parseDouble(cartTotalRows.get(1).findElement(By.xpath("//td[@data-title='Shipping']//bdi")).getText().substring(1));
			tax=Double.parseDouble(cartTotalRows.get(2).findElement(By.xpath("//td[@data-title='CA State Tax']/span")).getText().substring(1));
			total=Double.parseDouble(cartTotalRows.get(3).findElement(By.xpath("//td[@data-title='Total']//bdi")).getText().substring(1));
			if(total==subTotal+shippingCharge+tax)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean isCartEmpty()
	{
		return wait.until(ExpectedConditions.visibilityOfElementLocated(emptyCartMsg)).isDisplayed();
	}
	
}
