package com.inetbanking.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pages.LoginPageNew;
import com.inetbanking.utilities.MyException;

import junit.framework.Assert;

public class TC0002_LoginTest extends TestBase{

	
	@Test(dataProvider = "LoginData",dataProviderClass = com.inetbanking.testcases.TC0002_LoginTest.class)
	public void doLoginInCart(String userName, String password) throws MyException
	{
		LoginPageNew lp=new LoginPageNew(driver);
		lp.doLogin(userName, password);
		Assert.assertEquals("TestName",lp.loginSuccessfullData() );
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
