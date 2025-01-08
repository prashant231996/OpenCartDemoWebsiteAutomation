package com.inetbanking.utilities;

public enum ProductSortingValue {
	
	Sort_By_Price_Low_To_High("Sort by price: low to high"),
	Sort_By_Price_High_To_Low("Sort by price: high to low"),
	Sort_By_Latest("Sort by latest"),
	Sort_By_Average_Rating("Sort by average rating"),
	Sort_By_Popularity("Sort by popularity");
	
	public String dropDownValue;
	
	ProductSortingValue(String dropDownOption)
	{
		this.dropDownValue=dropDownOption;
	}
}
