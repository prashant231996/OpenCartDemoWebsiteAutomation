package com.inetbanking.pageobjects;

import org.openqa.selenium.By;

public interface DashboardPageObjects {

	By stroreLink=By.linkText("Store");
	
	By homeLink=By.linkText("Home");
	
	By serachTextBox=By.xpath("//input[@id='woocommerce-product-search-field-0']");
	
	By searchBtn=By.xpath("//button[@value='Search']");
	
	
}
