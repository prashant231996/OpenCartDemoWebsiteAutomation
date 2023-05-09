package com.inetbanking.pages;

import com.inetbanking.pageobjects.HomePageObjects;

public class HomePage extends BasePage implements HomePageObjects{
	
	public void logOutFromApplication()
	{
		try {
			waitTillElementVisible(accountLink);
			clickOn(accountLink);
			waitTillElementVisible(logOutBtn);
			clickOn(logOutBtn);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
