package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ExcelUtil;

public class RegisterPageTest extends BaseTest {
	
	@BeforeClass
	public void registerPageSetUp()
	{
		registerPage = loginPage.navigateToRegisterPage();
	}

	@Test(priority = 1)
	public void verifyRegisterPageTitle()
	{
		Assert.assertEquals(registerPage.getRegisterPageTitle(), "Register Account");
	}
	
	@Test(priority = 2)
	public void verifyRegisterPageHeaderValue()
	{
		Assert.assertEquals(registerPage.getRegisterPageHeaderValue(), "Register Account");
	}
	
	@DataProvider
	public Object[][] getRegisterData()
	{
		Object data[][] = ExcelUtil.getTestData(Constants.REGISTER_SHEET_NAME);
		return data;
	}
	
	@Test(priority = 3, dataProvider = "getRegisterData")
	public void verifyUserRegistration(String firstName, String lastName, String email, 
			String telephone, String password, String subscribe)
	{
		registerPage.doRegisterUser(firstName, lastName, email, telephone, password, subscribe);
//		Assert.assertEquals(registerPage.getAccountCreatedMessage(), Constants.ACCOUNT_CREATED_MESSAGE);
	}
}
