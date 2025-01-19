package com.cart.base;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.cart.pages.AccesoriesPage;
import com.cart.pages.CartPage;
import com.cart.pages.HomePage;
import com.cart.pages.LoginPageU;
import com.cart.pages.LoginPage;
import com.cart.pages.RegistrationPage;
import com.cart.pages.StorePage;
import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import com.inetbanking.dataprovider.dataProvider;
import com.inetbanking.utilities.ExtentReporter;
import com.inetbanking.utilities.MyException;
import com.inetbanking.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	public String userName=ReadConfig.getPropertyValue("userName");
	public String passWord=ReadConfig.getPropertyValue("passWord");
	public String baseUrl=ReadConfig.getPropertyValue("baseUrl");
	public static Logger log;
	public dataProvider db;
	public String sheetName="NEW CUSTOMER";
	//public WebDriverWait myWait;
	//public JavaScriptExecutor js;
	
	protected static ExtentReports extentReport=new ExtentReports();
	protected static ExtentTest extentTest;
	protected static ThreadLocal<ExtentTest>extentTestThread=new ThreadLocal<ExtentTest>();
	protected static ThreadLocal<WebDriver>driverThread=new ThreadLocal<WebDriver>();
	
	//Pages object
	protected static RegistrationPage registrationPage;
	protected static LoginPage loginPage;
	protected static HomePage homePage;
	protected static StorePage storePage;
	protected static AccesoriesPage accesoriesPage;
	protected static CartPage cartpage;
	public WebDriverWait wait;
	public Actions act;
	public ReadConfig config;
	
	SoftAssert softassert=new SoftAssert();
	
	@Parameters("browser")
	@BeforeTest
	public void setUp(String br)
	{
		log=LogManager.getLogger(BaseTest.class);
		if(br.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(br.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(br.equalsIgnoreCase("ie"))
		{
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//myWait=new WebDriverWait(driver, 10);
		//js=(JavaScriptExecutor)driver;
		extentReport=ExtentReporter.getExtentReports();
		driverThread.set(driver);
	}
	
	@AfterClass
	public void tearDown()
	{
		//driver.quit();
		softassert.assertAll();
	}
	
	
	@FindBy(xpath="//a[text()='Log out']")
	WebElement logOutLink;
	
	
	public void clicklogOutLink()
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
	
	public void setExtentTest(ExtentTest test)
	{
		extentTestThread.set(test);
	}
	
	public ExtentTest getExtentTest()
	{
		return extentTestThread.get();
	}
	
	public WebDriver getDriver()
	{
		return driverThread.get();
	}
	
	public void setDriver(WebDriver driver)
	{
		driverThread.set(driver);
	}
	

	

}
