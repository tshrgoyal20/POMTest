package com.qa.hubspot.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtils;

import io.qameta.allure.Step;

public class AccountsPage extends BasePage {
		
	public WebDriver driver;
	private ElementUtils elementUtil;
		
	private By header = By.cssSelector("div#logo a");
	private By accountSectionHeaders = By.cssSelector("div#content h2");
	private By searchTextField = By.cssSelector("div#search input[name='search']");
	private By searchButton = By.cssSelector("div#search button[type='button']");
	private By searchItem = By.cssSelector(".product-layout .product-thumb");
	private By sectionLinks = By.cssSelector(".list-group a");
	private By productListFromSearch = By.cssSelector(".product-thumb h4 a");
	
	
	public AccountsPage(WebDriver driver)
	{
		this.driver = driver;
		elementUtil = new ElementUtils(driver);
	}
	
	@Step("Getting Accounts Page title..")
	public String getAccountsPageTitle()
	{
		return elementUtil.waitForTitlePresent(Constants.ACCOUNTS_PAGE_TITLE, 10);
	}
	
	@Step("Getting Accounts Page Header value..")
	public String getHeaderValue()
	{
		if(elementUtil.doIsDisplayed(header))
		{
			return elementUtil.doGetText(header);
		}
		else
			return null;
	}
	
	@Step("Getting Accounts Page Section Count..")
	public int getAccountSectionsCount()
	{
		return elementUtil.getElements(accountSectionHeaders).size();
	}
	
	@Step("Getting Accounts Page Accounts Section List..")
	public List<String> getAccountSectionsList()
	{
		List<String> accountsList = new ArrayList<>();
		List<WebElement> accSectionList = elementUtil.getElements(accountSectionHeaders);
		
		System.out.println("\nAccount Sections List:");
		for(WebElement e: accSectionList)
		{
			accountsList.add(e.getText());
			System.out.println(e.getText());
		}
		
		return accountsList;
	}
	
	@Step("Getting Accounts Page Accounts Section Links Count..")
	public int getAccountSectionLinksCount()
	{
		return elementUtil.getElements(sectionLinks).size();
	}
	
	@Step("Getting Accounts Page Account Section Link..")
	public List<String> getAccountSectionsLink()
	{
		List<String> accountsLinks = new ArrayList<>();
		List<WebElement> accSectionLinks = elementUtil.getElements(sectionLinks);
		
		System.out.println("\nAccount Sections Links:");
		for(WebElement e: accSectionLinks)
		{
			accountsLinks.add(e.getText());
			System.out.println(e.getText());
		}
		
		return accountsLinks;
	}
	
	@Step("Getting Accounts Page Sub-links of Section name: {0}")
	public List<String> getSectionSubLinks(String sectionName)
	{
		List<String> sectionSubLinks = new ArrayList<>();
		List<WebElement> accSectionSubLinks = elementUtil.getElements(By.xpath("//h2[text()='"+sectionName+"']//following-sibling::ul[1]/li"));
		
		System.out.println("\n"+sectionName+" Sections Sub-Links:");
		for(WebElement e: accSectionSubLinks)
		{
			sectionSubLinks.add(e.getText());
			System.out.println(e.getText());
		}
		
		return sectionSubLinks;
	}
	
	@Step("Search on Accounts Page with product: {0}")
	public boolean doSearch(String productName)
	{
		elementUtil.doSendKeys(searchTextField, productName);
		elementUtil.doClick(searchButton);
		
		if(elementUtil.getElements(searchItem).size()>0)
			return true;
		else
			return false;
	}
	
	@Step("Select desired product from Result list with name: {0}")
	public ProductInfoPage selectProductFromResult(String productName)
	{
		List<WebElement> resultItemList = elementUtil.getElements(productListFromSearch);
		System.out.println("Total number of item displayed: "+resultItemList.size());
		
		for(WebElement e : resultItemList)
		{
			if(e.getText().equals(productName))
			{
				e.click();
				break;
			}
		//	System.out.println(e.getText());
		}
		
		return new ProductInfoPage(driver);
	}

}
