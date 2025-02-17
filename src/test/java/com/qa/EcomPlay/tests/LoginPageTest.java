package com.qa.EcomPlay.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.EcomPlay.base.BaseTest;
import com.qa.EcomPlay.constants.AppConstants;

public class LoginPageTest extends BaseTest {

	@Test (priority = 1)
	public void loginPageNavigationTest() {
	loginPage =	homePage.navigateToLoginPage();
	String actLoginPageTitle = loginPage.getLoginPageTitle();
	System.out.println("Page Title"+actLoginPageTitle);
	Assert.assertEquals(actLoginPageTitle, AppConstants.LOGIN_PAGE_TITLE);
	}
	
	@Test (priority = 2)
//	public void movetoForgotpwdscreen()
//	{
//		loginPage.forgotPasswordflow();
//	}
	
	
	public void forgotPwdLinkExistTests() {
		
		Assert.assertTrue(loginPage.isForgotPwdLinkExists());
		System.out.println("ForgotPwdflow check2");
	}
	 
	@Test(priority = 3)
	public void appLogin()
	{
		Assert.assertTrue(loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim()));
	}
}
