package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Epic-200: Desing Accounts Page")
@Story("Story 201: Design the Accounts Page with title, Header value, section list and item search..")
public class AccountsPageTest extends BaseTest {
	
	@BeforeClass
	public void doAccountsPageSetup()
	{
		accountsPage = loginPage.Dologin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Description("Verify Accounts Page Title..")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 1)
	public void verifyAccountsPageTitle()
	{
		String title = accountsPage.getAccountsPageTitle();
		System.out.println("Home page title is: "+title);
		Assert.assertEquals(title, Constants.ACCOUNTS_PAGE_TITLE);
	}
	
	@Description("Verify Accounts Page Header Value..")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 2)
	public void verifyHeaderValue()
	{
		String headerValue = accountsPage.getHeaderValue();
		System.out.println("Header value is: "+headerValue);
		Assert.assertEquals(headerValue, Constants.ACCOUNTS_PAGE_HEADER_VALUE);
	}
	
	@Description("Verify Accounts Page Section Count..")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 3)
	public void verifyAccountSectionCount()
	{
		Assert.assertEquals(accountsPage.getAccountSectionsCount(), Constants.ACCOUNTS_PAGE_SECTIONS_COUNT);
	}
	
	@Description("Verify Accounts Page Section List..")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 4)
	public void verifyAccountSectionList()
	{
		Assert.assertEquals(accountsPage.getAccountSectionsList(), Constants.getAccountSectionsList());
	}
	
	@Description("Verify Accounts Page Section Links Count..")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 5)
	public void verifyAccountSectionLinksCount()
	{
		Assert.assertEquals(accountsPage.getAccountSectionLinksCount(), Constants.ACCOUNTS_PAGE_SECTION_LINKS_COUNT);
	}
	
	@Description("Verify Accounts Page Section Links..")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 6)
	public void verifyAccountSectionLinks()
	{
		Assert.assertEquals(accountsPage.getAccountSectionsLink(), Constants.getAccountSectionLinks());
	}
	
	@Description("Verify Accounts Page My Account Section Links..")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 7)
	public void verifyMyAccountSectionLinks()
	{
		Assert.assertEquals(accountsPage.getSectionSubLinks("My Account"), Constants.getMyAccountSectionsSubLinks());
	}
	
	@Description("Verify Accounts Page My Orders Section Links..")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 8)
	public void verifyMyOrdersSectionLinks()
	{
		Assert.assertEquals(accountsPage.getSectionSubLinks("My Orders"), Constants.getMyOrdersSectionsSubLinks());
	}
	
	@Description("Verify Accounts Page My Affiliate Account Section Links..")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 9)
	public void verifyMyAffiliateAccountSectionLinks()
	{
		Assert.assertEquals(accountsPage.getSectionSubLinks("My Affiliate Account"), Constants.getMyAffiliateAccountSectionsSubLinks());
	}
	
	@Description("Verify Accounts Page My Newsletter Section Links..")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 10)
	public void verifyNewsletterSectionLinks()
	{
		Assert.assertEquals(accountsPage.getSectionSubLinks("Newsletter"), Constants.getNewsletterSectionsSubLinks());
	}
	
	@Description("Verify Accounts Page Search Item functionality..")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 11)
	public void verifySearchItem()
	{
		accountsPage.doSearch("imac");
	}

}
