package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtils;

public class RegisterPage extends BasePage {
	
	private ElementUtils elementUtils;
	
	private By headerValue = By.cssSelector("#content h1");
	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmPassword = By.id("input-confirm");
	private By subscribeYes = By.xpath("//label[@class='radio-inline']/input[@value=1]");
	private By subscribeNo = By.xpath("//label[@class='radio-inline']/input[@value=0]");
	private By policyCheckbox = By.xpath("//input[@type='checkbox' and @name='agree']");
	private By continueBtn = By.xpath("//input[@type='submit' and @value='Continue']");
	private By accountCreatedMessage = By.xpath("//div[@id='content']/h1[contains(text(),'Created')]");
	private By logoutLink = By.linkText("Logout");
	private By registerLink = By.linkText("Register");
	
	
	public RegisterPage(WebDriver driver)
	{
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}
	
	
	public String getRegisterPageTitle()
	{
		return elementUtils.waitForTitlePresent(Constants.REGISTER_PAGE_TITLE, 5);
	}
	
	public String getRegisterPageHeaderValue()
	{
		return elementUtils.doGetText(headerValue);
	}
	
	public void getRegisterPageFieldsName()
	{
		
	}
	
	public void doRegisterUser(String fName, String lName, String emaiID, 
			String phoneNo, String pswd, String subscribe)
	{
		elementUtils.doSendKeys(firstName, fName);
		elementUtils.doSendKeys(lastName, lName);
		elementUtils.doSendKeys(email, emaiID);
		elementUtils.doSendKeys(telephone, phoneNo);
		elementUtils.doSendKeys(password, pswd);
		elementUtils.doSendKeys(confirmPassword, pswd);
		
		if(subscribe.equalsIgnoreCase("Yes"))
			elementUtils.doClick(subscribeYes);
		else
			elementUtils.doClick(subscribeNo);
		
		elementUtils.doClick(policyCheckbox);
		elementUtils.doClick(continueBtn);
		
		String text = elementUtils.doGetText(accountCreatedMessage);
		
		if(text.contains(Constants.ACCOUNT_CREATED_MESSAGE))
		{
			elementUtils.doClick(logoutLink);
			elementUtils.doClick(registerLink);
		}
	}
	
/*	public String getAccountCreatedMessage()
	{
		return elementUtils.doGetText(accountCreatedMessage);
	}	*/
}
