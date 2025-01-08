package com.inetbanking.pageobjects;

import org.openqa.selenium.By;

public interface AccesoriesPageObjects {
	
	By sortPriceDropdown=By.name("orderby");
	
	By productPrices=By.xpath("//ul[contains(@class,'products')]//li/descendant::bdi");
	
	

}
