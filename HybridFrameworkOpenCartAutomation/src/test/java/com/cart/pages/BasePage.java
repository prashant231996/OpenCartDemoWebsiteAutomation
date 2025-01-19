package com.cart.pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cart.base.BaseTest;
import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import com.inetbanking.utilities.MyException;
import com.inetbanking.utilities.ProductSortingValue;


public class BasePage{
	
	public WebDriver driver;
	public WebDriverWait wait;
	public Actions action;
	
	@FindBy(xpath="//a[text()='Log out']")
	WebElement logOutLink;
	
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
		wait=new WebDriverWait(driver,10);
		action=new Actions(driver);
	}
	
	public void logOutLink()
	{
		try {
			logOutLink.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean isAlertPresent()
	{
		try {
			driver.switchTo().alert();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public String generateRandomString()
	{
		String randonString=RandomStringUtils.randomAlphabetic(8);
		return randonString;
	}
	
	public String generateRandomNumeric()
	{
		String randomNumber=RandomStringUtils.randomNumeric(4);
		return randomNumber;
	}
	
	public void test()
	{
		
	}
	
	//FindElement Method
	public WebElement identify(By ele) throws MyException
	{
		WebElement element=null;
		try {
			waitTillElementVisible(ele);
		 element=driver.findElement(ele);
		} catch (Exception e) {
			// TODO: handle exception
		}
		 return element;
	}
	
	//FindElements Method
		public List<WebElement> identifyALl(By ele) throws MyException
		{
			List<WebElement> elementList=null;
			try {
				waitTillElementVisible(ele);
				elementList=driver.findElements(ele);
			} catch (Exception e) {
				// TODO: handle exception
			}
			 return elementList;
		}
		
	//IsELementPresent Method
		public boolean isELementPresent(By ele) throws MyException
		{
			boolean flag=false;
			try {
				List<WebElement> elementList=identifyALl(ele);
				if(elementList.size()>0)
				{
					flag=true;
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new MyException("Element not Present over page");
			}
			return flag;
		}
		
	//IsELementDisplayed
		public boolean isELementDisplayed(By ele) throws MyException
		{
			boolean flag=false;
			try {
                waitTillElementVisible(ele);
				flag=driver.findElement(ele).isDisplayed();
			} catch (Exception e) {
				e.printStackTrace();
				throw new MyException("Element not Present over page");
			}
			return flag;
		}
		
	//IsELementDisplayed
				public boolean isELementEnabled(By ele) throws MyException
				{
					boolean flag=false;
					try {
						flag=driver.findElement(ele).isEnabled();
					} catch (Exception e) {
						e.printStackTrace();
						throw new MyException("Element not Present over page");
					}
					return flag;
				}
				
	//Sending Keys/Characters to input text box.
		public void type(By ele, String value) throws MyException
		{
			try {
				waitTillElementVisible(ele);
				identify(ele).clear();
				identify(ele).sendKeys(value);
			} catch (Exception e) {
				e.printStackTrace();
				throw new MyException("Failed to type into textbox..");
			}
		}
		
	//Sending Keys/Charactes through JavascriptExcecutor;
		public void typeUsingJavaScriptExe(By ele, String value) throws MyException
		{
			try {
				WebElement element=identify(ele);
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("arguments[0].value='"+ value +"';", element);
			} catch (Exception e) {
				e.printStackTrace();
				throw new MyException("Failed to type into textbox..");
			}
		}
		
		//Sending Keys/Charactes through ACtions Class;
				public void typeUsingActions(By ele, String value) throws MyException
				{
					Actions act=new Actions(driver);
					try {
						WebElement element=identify(ele);
						act.sendKeys(element, value).build().perform();
					} catch (Exception e) {
						e.printStackTrace();
						throw new MyException("Failed to type into textbox..");
					}
				}
	
	//Click Method
	   public void clickOn(By ele) throws MyException
	   {
		   try {
			wait.until(ExpectedConditions.elementToBeClickable(ele));   
			identify(ele).click();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new MyException("Failed to click on element");
		}
	   }
		
	 //Click Method Using JavaScriptExcecutor
	   public void clickOnElementUsingJavaScriptExe(By ele) throws MyException
	   {
		   try {
			WebElement element=identify(ele);
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new MyException("Failed to click on element");
		}
	   }
	   
	   //Click Method Using Actions class
	   public void clickOnElementUsingActions(By ele) throws MyException
	   {
		   try {
			WebElement element=identify(ele);
	        Actions act=new Actions(driver);
	        act.click(element).build().perform();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new MyException("Failed to click on element");
		}
	   }
	   
	   //Double Click using actions class
	   public void doubleClickOnElement(By ele) throws MyException
	   {
		   try {
			Actions act=new Actions(driver);
			WebElement element=identify(ele);
			act.doubleClick(element).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("Failed to double click on element");
		}
	   }
	   
	   //Double Click using actions class
	   public void MoveToElement(By ele) throws MyException
	   {
		   try {
			Actions act=new Actions(driver);
			WebElement element=identify(ele);
			act.moveToElement(element).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("Failed to double click on element");
		}
	   }
		
	
	//Explicit Waits
		public void waitTillElementVisible(By ele) throws MyException
		{
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(ele));
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				throw new MyException("Element is not visible"+ele);
			}
		}
		
		public void waitTillWebLementVisible(WebElement element) throws MyException
		{
			try {
				wait.until(ExpectedConditions.visibilityOf(element));
			} catch (Exception e) {
				e.printStackTrace();
				throw new MyException("Faile to visible the element");
			}
		}
		
		public void waitTillElementClickable(By ele) throws MyException
		{
			try {
				WebElement element=identify(ele);
				wait.until(ExpectedConditions.elementToBeClickable(element));
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				throw new MyException("Element is not visible"+ele);
			}
		}
		
	//Scroll into view
		public void scrollIntoView(By ele) throws MyException
		{
			try {
				WebElement element=identify(ele);
				//waitTillWebLementVisible(element);
				 // Javascript executor
			      ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
			      Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
				throw new MyException("Failed to scroll to the element");
			}
		}
		
		//Get Text from Elelment
		public String getTextFromElement(By ele) throws MyException
		{
			String text;
			try {
				text=identify(ele).getText();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				throw new MyException("Failed to get text from element");
			}
			return text;
		}
		
		//Select value from dropDown
		public void selectByValue(By ele, String visibleText) throws MyException
		{
			try {
				WebElement element=identify(ele);
				Select dropDown=new Select(element);
				dropDown.selectByVisibleText(visibleText);
			} catch (Exception e) {
				e.printStackTrace();
				throw new MyException("Failed to select from dropdown");
			}
		}
		
		public boolean isElementDisplayed(By ele) throws MyException
		{
			boolean flag=false;
			try {
				flag=identify(ele).isDisplayed();
			} catch (Exception e) {
				e.printStackTrace();
				throw new MyException("Element is not displayed");
			}
			return flag;
		}
		
		//Scroll Upto Bottom of webPage
		public void scrollUptoBottomPfPage()
		{
			try {
				//to perform scroll on an application using Selenium
				   JavascriptExecutor js = (JavascriptExecutor) driver;
				   js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		public void dynamicDropdown()
		{
			try {
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//Validate Broken Links on page
		public boolean validateBrokenLinks(List<WebElement>linksList) throws IOException
		{
			HttpURLConnection conn=null;
			try
			{
			for(WebElement link:linksList)
			{
				String hrefAttr=link.getAttribute("href");
				URL linkurl=new URL(hrefAttr);
				conn=(HttpURLConnection)linkurl.openConnection();
				conn.connect();
				if(conn.getResponseCode()>=400)
				{
					return false;
				}
			}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return false;
			}
			finally
			{
				conn.disconnect();
			}
			return true;
		}
		
		public void sortProduct(String sortingMechanism)
		{
			WebElement dropBtn=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("orderby")));
			Select select=new Select(dropBtn);
			switch(sortingMechanism)
			{
			case "price_Low_High":select.selectByVisibleText(ProductSortingValue.Sort_By_Price_Low_To_High.dropDownValue);
			break;
			case "price_high_Low":select.selectByVisibleText(ProductSortingValue.Sort_By_Price_High_To_Low.dropDownValue);
			break;
			default:System.out.println("Invalid sorting mechanism.");
			}
			
		}
		
		public void searchProduct(String productName)
		{
			WebElement searchText=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("woocommerce-product-search-field-0")));
			searchText.sendKeys(productName);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@value='Search']"))).click();	
		}
		
		public void dragAndDropBy(By ele,int xaxis,int yaxis) throws MyException
		{
			action.dragAndDropBy(identify(ele), xaxis, yaxis);
		}
		
	  //Method to do mouse hover action on element
		public void doMouseHoverOverElement(By ele) throws MyException
		{
			WebElement element=identify(ele);
			waitTillWebLementVisible(element);
			action.moveToElement(element).build().perform();
		}

}
