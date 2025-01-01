package com.inetbanking.pageobjects;

import org.openqa.selenium.By;

public interface HomePageObjects {
	
	By hpmePageLink=By.linkText("Home");
	
	By accountLink=By.linkText("Account");
	
	By logOutBtn=By.linkText("Log out");
	
	By shopNowLink=By.xpath("//div[@class='wp-block-button']//a[text()='Shop Now']");
	
	

}
