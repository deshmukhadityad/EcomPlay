package com.qa.EcomPlay.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.EcomPlay.base.BaseTest;
import com.qa.EcomPlay.constants.AppConstants;

public class HomePageTest extends BaseTest {
	
	@Test
	public void HomePageTitleTest() {
		String actualTitle = homePage.gethomepageTitle();
		Assert.assertEquals(actualTitle, AppConstants.HOME_PAGE_TITLE);
	}
	
	@Test
	public void HomePageURLTest() {
		String actualurl = homePage.gethomepageURL();
		Assert.assertEquals(actualurl, prop.getProperty("url"));
	}
	
	@DataProvider
	public Object[][] getProductData() {
		return new Object[] [] {
			{"Macbook"},
			{"Imac"},
			{"Samsung"}
		};
	}
	
	@Test(dataProvider = "getProductData")
	public void SearchTest(String  ProductName) {
		String actualsearchheader = homePage.doSearch(ProductName);
		Assert.assertEquals(actualsearchheader, "Search - "+ProductName);
	}

}
