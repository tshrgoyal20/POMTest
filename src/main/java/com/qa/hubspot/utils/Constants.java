package com.qa.hubspot.utils;

import java.util.ArrayList;
import java.util.List;

public class Constants {
	
	public static final String LOGIN_PAGE_TITLE = "Account Login1";
	public static final String ACCOUNTS_PAGE_TITLE = "My Account";
	public static final String REGISTER_PAGE_TITLE = "Register Account";
	
	public static final String ACCOUNTS_PAGE_HEADER_VALUE = "Your Store";
	
	public static final int ACCOUNTS_PAGE_SECTIONS_COUNT = 4;
	
	public static final String REGISTER_SHEET_NAME = "registration";
	
	public static final String ACCOUNT_CREATED_MESSAGE = "Your Account Has Been Created!";
	
	public static List<String> getAccountSectionsList()
	{
		List<String> list = new ArrayList<>();
		list.add("My Account");
		list.add("My Orders");
		list.add("My Affiliate Account");
		list.add("Newsletter");
		
		return list;
	}
	
	public static final int ACCOUNTS_PAGE_SECTION_LINKS_COUNT = 13;
	
	public static List<String> getAccountSectionLinks()
	{
		List<String> list = new ArrayList<>();
		list.add("My Account");
		list.add("Edit Account");
		list.add("Password");
		list.add("Address Book");
		list.add("Wish List");
		list.add("Order History");
		list.add("Downloads");
		list.add("Recurring payments");
		list.add("Reward Points");
		list.add("Returns");
		list.add("Transactions");
		list.add("Newsletter");
		list.add("Logout");
		
		return list;
	}
	
	public static List<String> getMyAccountSectionsSubLinks()
	{
		List<String> list = new ArrayList<>();
		list.add("Edit your account information");
		list.add("Change your password");
		list.add("Modify your address book entries");
		list.add("Modify your wish list");
		
		return list;
	}
	
	public static List<String> getMyOrdersSectionsSubLinks()
	{
		List<String> list = new ArrayList<>();
		list.add("View your order history");
		list.add("Downloads");
		list.add("Your Reward Points");
		list.add("View your return requests");
		list.add("Your Transactions");
		list.add("Recurring payments");
		
		return list;
	}
	
	public static List<String> getMyAffiliateAccountSectionsSubLinks()
	{
		List<String> list = new ArrayList<>();
		list.add("Register for an affiliate account");
		
		return list;
	}
	
	public static List<String> getNewsletterSectionsSubLinks()
	{
		List<String> list = new ArrayList<>();
		list.add("Subscribe / unsubscribe to newsletter");
		
		return list;
	}

}
