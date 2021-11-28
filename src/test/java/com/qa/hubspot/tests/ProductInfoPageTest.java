package com.qa.hubspot.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;

public class ProductInfoPageTest extends BaseTest {
	
	@BeforeClass
	public void doProductsInfoPageSetup()
	{
		accountsPage = loginPage.Dologin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 2)
	public void verifyProductInfoPageTitle()
	{
//		accountsPage.doSearch("MacBook Pro");
//		productInfoPage = accountsPage.selectProductFromResult("MacBook Pro");
		Assert.assertEquals(productInfoPage.getProductInfoPageTitle("MacBook Pro"), "MacBook Pro");
	}
	
	@Test(priority = 1)
	public void verifyProductInfo()
	{
		String prodName = "MacBook";
		
		Assert.assertTrue(accountsPage.doSearch(prodName));
		productInfoPage = accountsPage.selectProductFromResult("MacBook Pro");
		Assert.assertEquals(productInfoPage.numberOfProductImages(), 4);
		Map<String, String> productInfo = productInfoPage.getProductInformation();
		System.out.println("\nProduct Info: "+productInfo);
		
		Assert.assertEquals(productInfo.get("name"), "MacBook Pro");
		Assert.assertEquals(productInfo.get("Brand"), "Apple");
		Assert.assertEquals(productInfo.get("Availability"), "Out Of Stock");
		Assert.assertEquals(productInfo.get("price"), "$2,000.00");
		Assert.assertEquals(productInfo.get("Product Code"), "Product 18");
		Assert.assertEquals(productInfo.get("Reward Points"), "800");
		Assert.assertEquals(productInfo.get("exTaxPrice"), "$2,000.00");
	}
	
	@Test(priority = 3)
	public void verifyselectProductQuantity()
	{
		productInfoPage.selectQuantity("2");
	}
	
	@Test(priority = 4)
	public void verifyAddToCart()
	{
		productInfoPage.addToCart();
	}

}
