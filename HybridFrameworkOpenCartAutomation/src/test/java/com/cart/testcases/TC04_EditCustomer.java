package com.cart.testcases;

import org.testng.annotations.Test;

import com.cart.base.TestBase;
import com.cart.pages.EditCustomerPage;
import com.cart.pages.LoginPageU;

public class TC04_EditCustomer extends TestBase{
	
	@Test
	public void editCustomerTest() throws InterruptedException
	{
		LoginPageU lp=new LoginPageU(driver);
		lp.doLogin(userName, passWord);
		EditCustomerPage ecp=new EditCustomerPage(driver);
		ecp.navigateToCustomerEdit("48345");
	    ecp.editCustomer("Prashant", "ICH.");
	}

}
