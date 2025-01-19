package com.inetbanking.pageobjects;

import org.openqa.selenium.By;

public interface HomePageObjects {
	
	By hpmePageLink=By.linkText("Home");
	
	By accountLink=By.linkText("Account");
	
	By logOutBtn=By.linkText("Log out");
	
	By shopNowLink=By.xpath("//div[@class='wp-block-button']//a[text()='Shop Now']");
	
	By accessoriesLink=By.xpath("//a[text()='Accessories']");
	
	By cartLogo=By.xpath("//a[@title='View your shopping cart']");
	
	By miniCartProductLink=By.xpath("(//li[@class='woocommerce-mini-cart-item mini_cart_item']/descendant::a)[2]");
	
	By removeItemFromMiniCart=By.xpath("//li[@class='woocommerce-mini-cart-item mini_cart_item']/descendant::a[@class='remove remove_from_cart_button']");
	
	By noProductInCartMsg=By.xpath("//*[text()='No products in the cart.']");
	
	
	
	
	
	
	

}
