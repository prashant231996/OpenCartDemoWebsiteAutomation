package com.inetbanking.pageobjects;

import org.openqa.selenium.By;

public interface StorePageObjects {
	
	By storeLink=By.linkText("Store");
	
	By searchBox=By.id("woocommerce-product-search-field-0");
	
	By searchBtn=By.xpath("//input[@id='woocommerce-product-search-field-0']/following-sibling::button");
	
	By relavanceDropdown=By.xpath("//select[@name='orderby']");
	
	By addToCartBtn=By.xpath("(//a[text()='Add to cart'])[1]");
	
	By viewCartLink=By.linkText("View cart");
	
	By viewCartMenu=By.xpath("(//a[@title='View your shopping cart'])[1]");
	
	By pageNumbers=By.xpath("//ul[@class='page-numbers']//li");
	
	By productsList=By.xpath("//ul[contains(@class,'products')]//li");
	
	By storeTitle=By.xpath("//*[contains(@class,'page-title')]");
	
	By addToCartLink=By.xpath("//a[contains(text(),'cart')]");
	
	By prevPageNumber=By.xpath("//a[@class='prev page-numbers']");
	
	By resultProductCount=By.xpath("//*[contains(@class,'result-count')]");
	
	
	
	
	
	

}
