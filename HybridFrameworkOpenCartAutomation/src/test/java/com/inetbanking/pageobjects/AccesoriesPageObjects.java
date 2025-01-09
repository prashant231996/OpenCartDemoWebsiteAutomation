package com.inetbanking.pageobjects;

import org.openqa.selenium.By;

public interface AccesoriesPageObjects {
	
	By sortPriceDropdown=By.name("orderby");
	
	By productPrices=By.xpath("//ul[contains(@class,'products')]//li/descendant::bdi");
	
	By productTitle=By.xpath("//h1[contains(@class,'product_title')]");
	
	By accesoriesCategoryOption=By.xpath("//option[@value='accessories']");
	
	By productCategory=By.xpath("//*[text()='Browse By Categories']");
	
	By productLinkFromBestSeller=By.xpath("//h2[text()='Our Best Sellers']/following-sibling::*//li/a");
	
	By productNameFromBestSeller=By.xpath("//h2[text()='Our Best Sellers']/following-sibling::*//li/a//span");
	
	
	
	
	
	
	

}
