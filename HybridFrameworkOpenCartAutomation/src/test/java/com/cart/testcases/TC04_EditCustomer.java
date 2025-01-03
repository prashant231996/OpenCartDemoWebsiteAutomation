package com.cart.testcases;

import org.testng.annotations.Test;

import com.cart.pages.EditCustomerPage;
import com.cart.pages.LoginPage;

public class TC04_EditCustomer extends TestBase{
	
	@Test
	public void editCustomerTest() throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		lp.doLogin(userName, passWord);
		EditCustomerPage ecp=new EditCustomerPage(driver);
		ecp.navigateToCustomerEdit("48345");
	    ecp.editCustomer("Prashant", "ICH.");
	}

}
