package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.testlisteners.ExtentReportListener;
import com.qa.hubspot.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

// @Listeners(ExtentReportListener.class)  -- To implement ExtentReport for a particular java class.

@Epic("Epic-100: Login Page Functionality")
@Story("Story 101: Design the Login Page with title, Signup button and login functionality..")
public class LoginPageTest extends BaseTest {
	
	@Description("Verify Login Page Title...")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 1)
	public void verifyLoginPageTitleTest()
	{
		String title = loginPage.getLoginPageTitle();
		System.out.println("Login Page title is: "+title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Description("Verify SignUp button on Login Page...")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority = 2)
	public void verifySignUpButtonTest()
	{
		Assert.assertTrue(loginPage.getSignUpButton(), "Sign Up Button is not available");
	}
	
	@Description("Verify login functionality...")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority = 3)
	public void verifyLoginTest()
	{
		loginPage.Dologin(prop.getProperty("username"), prop.getProperty("password"));
	}

}
