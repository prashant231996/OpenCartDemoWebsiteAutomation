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
	
	By minPriceSlider=By.xpath("(//*[@class='ui-slider-handle ui-corner-all ui-state-default'])[1]");
	
	By maxPriceSlider=By.xpath("(//*[@class='ui-slider-handle ui-corner-all ui-state-default'])[2]");
	
	By productQuantity=By.xpath("//input[starts-with(@id,'quantity')]");
	
	By addToCartBtn=By.name("add-to-cart");
	
	By viewCart=By.xpath("//div[@role='alert']/descendant::a[text()='View cart']");
	
	By searchProduct=By.xpath("//input[contains(@placeholder,'Search product')]");
	
	By searchBtn=By.xpath("//button[@value='Search']");
	
	By homePageLink=By.xpath("//a[text()='Home']");
	
	By cartLogo=By.xpath("//a[@title='View your shopping cart']");
	
	By addToCartSucMsg=By.xpath("//div[@role='alert']");
	
	
	
	
	
	
	
	
	
	

}
