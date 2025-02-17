package com.qa.EcomPlay.Factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightFactory {

	Playwright playwringht;
	Browser browser;
	BrowserContext browserContex; 
	Page page;
	Properties prop;
	
	
	public Page initBrowser(Properties prop) {
		String browserName = prop.getProperty("browser").trim();
		System.out.println("Browser name is: "+browserName);
		
		playwringht = Playwright.create();
		
		switch (browserName.toLowerCase()) {
		case "chromium":
			browser = playwringht.chromium().launch(new LaunchOptions().setHeadless(false));
			break;
			
		case "firefox":
			browser = playwringht.firefox().launch(new LaunchOptions().setHeadless(false));
			break;
		
		case "chrome":
			browser = playwringht.chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false));
			break;
		}
		
		browserContex = browser.newContext();
		page = browserContex.newPage();
		 	
		page.navigate(prop.getProperty("url").trim());
		
		return page;
		
	}
	/**
	 * This method is used to initialize the properties from config file 
	 */
	
	public Properties init_prop()
	{
		
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
		prop = new Properties();
		prop.load(ip);
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
		
	}
}
