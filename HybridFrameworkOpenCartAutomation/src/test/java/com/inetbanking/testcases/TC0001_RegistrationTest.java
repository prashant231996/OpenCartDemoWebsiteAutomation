package com.inetbanking.testcases;

import org.testng.annotations.Test;

import com.inetbanking.pages.RegistrationPage;
import com.inetbanking.utilities.MyException;

public class TC0001_RegistrationTest extends TestBase{
	
	@Test
	public void TC0001_RegistrationTestCase() throws MyException
	{
		try {
			registrationPage=new RegistrationPage(driver);
			registrationPage.gotTORegistrationPage();
			registrationPage.doRegistration("TestName","Test@gmail.com", "Test");
			softassert.assertTrue(registrationPage.registerSuc(),"Failed to do registration");
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("Failed to do registration");
		}
	}

}
