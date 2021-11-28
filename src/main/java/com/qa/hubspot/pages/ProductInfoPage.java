package com.qa.hubspot.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.ElementUtils;

public class ProductInfoPage extends BasePage {
	
	public WebDriver driver;
	private ElementUtils elementutils;
	
	private By productName = By.cssSelector("#content h1");
	private By productMetaData = By.cssSelector("#content .list-unstyled:nth-of-type(1) li");
	private By productPrice = By.cssSelector("#content .list-unstyled:nth-of-type(2) li");
	private By quantity = By.id("input-quantity");
	private By addToCartButton = By.xpath("//button[@id='button-cart' and text()='Add to Cart']");
	private By addToCartSuccessMessage = By.xpath("//ul[@class='breadcrumb']//following-sibling::div[1]");
	private By productImages = By.cssSelector(".thumbnails img");
	
	
	public ProductInfoPage(WebDriver driver)
	{
		this.driver = driver;
		elementutils = new ElementUtils(driver);
	}
	
	
	public Map<String, String> getProductInformation()
	{
		Map<String, String> productInfoMap = new HashMap<>();
		productInfoMap.put("name", elementutils.doGetText(productName).trim());
		
		List<WebElement> productMetaDataList = elementutils.getElements(productMetaData);
		for(WebElement e : productMetaDataList)
		{
			productInfoMap.put(e.getText().split(":")[0].trim(), e.getText().split(":")[1].trim());
		}
		
		List<WebElement> productPriceList = elementutils.getElements(productPrice);
		productInfoMap.put("price", productPriceList.get(0).getText().trim());
		productInfoMap.put("exTaxPrice", productPriceList.get(1).getText().split(":")[1].trim());
		
		return productInfoMap;
	}
	
	public int numberOfProductImages()
	{
		int imagesCount = elementutils.getElements(productImages).size();
		System.out.println("Total number of images: "+imagesCount);
		return imagesCount;
	}
	
	public void selectQuantity(String qty)
	{
		elementutils.doSendKeys(quantity, qty);
	}
	
	public void addToCart()
	{
		elementutils.doClick(addToCartButton);
//		elementutils.waitForElementToBeLocated(addToCartButton, 5);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String text = elementutils.doGetText(addToCartSuccessMessage);
		System.out.println("Add to cart success message: "+text);
	}
	
	public String getProductInfoPageTitle(String productName)
	{
		return elementutils.waitForTitlePresent(productName, 5);
	}

}
