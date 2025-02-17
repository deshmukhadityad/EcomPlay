package com.qa.EcomPlay.pages;

import com.microsoft.playwright.Page;

public class HomePage {
private Page page;
	
	//page constructor
	public HomePage(Page page)
	{
		this.page = page;
	}
	
	// String Locaters  OR Private 
	
	private String search = "input[name='search']";
	private String SearchBtn = "//button[normalize-space()='Search']";
	private String searchtitle  = "//h1[contains (text(),'Search')]";
	private String myAccount = "(//a[@role='button'])[12]";
	private String Login = "//a[contains(.,' Login')]";
	
	
	//page actions 
	
	public String gethomepageTitle()
	{
		String title = page.title();
		System.out.println("Page Title: "+title);
		return title;
		
	}
	
	public String gethomepageURL()
	{
		String url = page.url();
		System.out.println("Page URL: "+ url);
		return url;
	}

	
	public String doSearch(String ProductName)
	{
		page.fill(search, ProductName);
		page.click(SearchBtn);
		String header=  page.textContent(searchtitle);
		System.out.println("Header : "+ header);
		return header;
	}
	
	public LoginPage navigateToLoginPage() {
		 page.locator(myAccount).hover();
//		myAct.hover();
		page.click(Login);
		return new LoginPage(page);
	}
	
}
