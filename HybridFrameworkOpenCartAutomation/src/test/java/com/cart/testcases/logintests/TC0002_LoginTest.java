package com.cart.testcases.logintests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cart.base.BaseTest;
import com.cart.pages.LoginPage;
import com.cart.pages.RegistrationPage;
import com.inetbanking.utilities.MyException;
import com.inetbanking.utilities.ReadConfig;


public class TC0002_LoginTest extends BaseTest{
	
	
	@Test(priority=0,description="Verify mandatory fields on login page",enabled=true)
	public void mandatoryDetailsOnLogin() throws MyException
	{
		//driver.get(baseUrl);
		getDriver().get(baseUrl);
		LoginPage lp=new LoginPage(driverThread.get());
		lp.doLogin("","");
		Assert.assertTrue(lp.verifyMandatoryMsg());
		lp.doLogin(ReadConfig.getPropertyValue("userName"),"");
		Assert.assertTrue(lp.verifyMandatoryMsg());
	}
	

	@Test(priority=1,description="Verify login functionality with invalid credentials",enabled=true)
	public void loginWithInvalidCreds() throws MyException
	{
		//driver.get(baseUrl);
		getDriver().get(baseUrl);
		LoginPage lp=new LoginPage(driverThread.get());
		lp.doLogin(ReadConfig.getPropertyValue("userName"), "InvalidPassword");
		Assert.assertTrue(lp.loginFailed());
		
	}
	
	@Test(priority=2,description="Login to the application using valid credentials",enabled=true)
	public void doLoginInCart() throws MyException
	{
		getDriver().get(baseUrl);
		LoginPage lp=new LoginPage(driverThread.get());
		lp.doLogin(ReadConfig.getPropertyValue("userName"), ReadConfig.getPropertyValue("passWord"));
		Assert.assertEquals("TestName",lp.loginSuccessfullData() );
		Assert.assertTrue(lp.logoutLinkDisplayed());
		lp.logoutFromApplication();
	}
	
	@Test(priority=3, description="Update password of user")
	public void updatePasswordOfUser() throws MyException
	{
		getDriver().get(baseUrl);
		LoginPage lp=new LoginPage(driverThread.get());
		lp.updatePassword(ReadConfig.getPropertyValue("userName"));
		Assert.assertTrue(lp.passwordUpdatedSuccessfully());
	}
	
	@Test(priority=4,description="Validate broken links on page")
	public void validateLinksPresentonLoginPage() throws MyException, IOException
	{
		try
		{
			getDriver().get(baseUrl);
		LoginPage lp=new LoginPage(getDriver());
		lp.navigateToLoginPage();
		Assert.assertTrue(lp.validateBrokenLinksOnPage());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="LoginData")
	public Object[][] getLoginData() throws IOException
	{
		File loginDataFile=new File("./src//test//resources//testData.xlsx");
		FileInputStream fis=new FileInputStream(loginDataFile);
		XSSFWorkbook wb= new XSSFWorkbook(fis);
		XSSFSheet sh=wb.getSheetAt(0);
		int rowCount=sh.getLastRowNum();
		System.out.println("Total No Of Rows="+rowCount);
		int colCount=sh.getRow(0).getLastCellNum();
		System.out.println("Total No of Columns="+colCount);
		Object[][]loginDataArray=new Object[rowCount][colCount];
		for(int i=0;i<rowCount;i++)
		{
			XSSFRow row=sh.getRow(i+1);
			for (int j=0;j<colCount;j++)
			{
				loginDataArray[i][j]=row.getCell(j).getStringCellValue();
			}
		}
		return loginDataArray;
	}
}
