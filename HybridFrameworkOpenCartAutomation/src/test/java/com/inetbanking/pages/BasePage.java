package com.inetbanking.pages;

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

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import com.inetbanking.testcases.TestBase;
import com.inetbanking.utilities.MyException;


public class BasePage extends TestBase{
	
	public WebDriverWait myWait=new WebDriverWait(driver, 10);
	
	@FindBy(xpath="//a[text()='Log out']")
	WebElement logOutLink;
	
	
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
				myWait.until(ExpectedConditions.visibilityOfElementLocated(ele));
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				throw new MyException("Element is not visible"+ele);
			}
		}
		
		public void waitTillWebLementVisible(WebElement element) throws MyException
		{
			try {
				myWait.until(ExpectedConditions.visibilityOf(element));
			} catch (Exception e) {
				e.printStackTrace();
				throw new MyException("Faile to visible the element");
			}
		}
		
		public void waitTillElementClickable(By ele) throws MyException
		{
			try {
				WebElement element=identify(ele);
				myWait.until(ExpectedConditions.elementToBeClickable(element));
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

}
