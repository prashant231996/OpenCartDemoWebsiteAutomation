package com.inetbanking.testcases;

import java.io.IOException;
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
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import com.inetbanking.dataprovider.dataProvider;
import com.inetbanking.pages.RegistrationPage;
import com.inetbanking.utilities.ExtentReporter;
import com.inetbanking.utilities.MyException;
import com.inetbanking.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	ReadConfig readconfig=new ReadConfig();
	
	public static WebDriver driver;
	public String userName=readconfig.getUserNAme();
	public String passWord=readconfig.getPassword();
	public String baseUrl=readconfig.getApplicationURL();
	public static Logger log;
	public dataProvider db;
	public String sheetName="NEW CUSTOMER";
	//public WebDriverWait myWait;
	//public JavaScriptExecutor js;
	public static RegistrationPage registrationPage;
	
	protected static ExtentReports extentReport=new ExtentReports();
	protected static ExtentTest extentTest;
	protected static ThreadLocal<ExtentTest>extentTestThread=new ThreadLocal<ExtentTest>();
	
	SoftAssert softassert=new SoftAssert();
	
	@Parameters("browser")
	@BeforeTest
	public void setUp(String br)
	{
		log=LogManager.getLogger(TestBase.class);
		/*try {
			db.createWorkBook();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
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
		driver.get(baseUrl);
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
	
	

	

}
