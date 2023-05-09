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
	
	

}
