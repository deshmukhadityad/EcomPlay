package com.qa.EcomPlay.base;

import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.microsoft.playwright.Page;
import com.qa.EcomPlay.Factory.PlaywrightFactory;
import com.qa.EcomPlay.pages.HomePage;
import com.qa.EcomPlay.pages.LoginPage;

public class BaseTest {
	
	PlaywrightFactory pf;
	Page page;
	
	protected Properties prop;
	
	protected HomePage homePage;
	protected LoginPage loginPage;
	
	
	@BeforeClass
	public void startup() {
		
		pf= new PlaywrightFactory();
		prop = pf.init_prop();
		page = pf.initBrowser(prop);
		homePage = new HomePage(page);
		
	}
	
	
	@AfterClass
	public void tearDown() {
		page.context().browser().close();
		
	}

}
