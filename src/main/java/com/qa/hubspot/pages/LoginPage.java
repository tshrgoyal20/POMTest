package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtils;

import io.qameta.allure.Step;

public class LoginPage extends BasePage {
	
	public WebDriver driver;
	private ElementUtils elementUtil;
	
	// 1. By locators
	private By emailID = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@type='submit' and @value='Login']");
	private By SingUpButton = By.xpath("//a[text()='Continue']");
	private By registerLink = By.linkText("Register");
	
	
	// 2. Constructor of page class
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		elementUtil = new ElementUtils(driver);
	}
	
	
	// 3. Page actions: features(behavior) of the page in the form of methods.
	@Step("Getting login page title..")
	public String getLoginPageTitle()
	{
		return elementUtil.waitForTitlePresent(Constants.LOGIN_PAGE_TITLE, 10);
	}
	
	@Step("Checking Signup button on login page..")
	public boolean getSignUpButton()
	{
		return elementUtil.doIsDisplayed(SingUpButton);
	}
	
	@Step("Login with username: {0} and password: {1}")
	public AccountsPage Dologin(String uname, String pswd)
	{
	/*	driver.findElement(emailID).sendKeys(uname);
		driver.findElement(password).sendKeys(pswd);
		driver.findElement(loginBtn).click();	*/
		
		elementUtil.doSendKeys(emailID, uname);
		elementUtil.doSendKeys(password, pswd);
		elementUtil.doClick(loginBtn);
		
		return new AccountsPage(driver);
	}
	
	@Step("Navigating to Register Page..")
	public RegisterPage navigateToRegisterPage()
	{
		elementUtil.doClick(registerLink);
		
		return new RegisterPage(driver);
	}

}
