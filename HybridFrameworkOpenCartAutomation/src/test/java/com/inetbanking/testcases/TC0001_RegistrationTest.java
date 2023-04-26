package com.inetbanking.testcases;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.inetbanking.pages.RegistrationPage;
import com.inetbanking.utilities.MyException;

public class TC0001_RegistrationTest extends TestBase{
	
	@Test
	public void TC0001_RegistrationTestCase(Method method) throws MyException
	{
		try {
		    getExtentTest().createNode(method.getName());
			registrationPage=new RegistrationPage(driver);
			registrationPage.gotTORegistrationPage();
			getExtentTest().info("Navigated to registration page succesfully");
			registrationPage.doRegistration("TestName","Test@gmail.com", "Test");
			Assert.assertTrue(registrationPage.registerSuc(),"Failed to do registration");
			getExtentTest().info("Registration done succsefully");
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("Failed to do registration");
		}
	}

}
