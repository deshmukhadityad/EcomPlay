package com.qa.EcomPlay.pages;

import com.microsoft.playwright.Page;

public class LoginPage {
	private Page page;

	private String emailId = "//*[@name='email']";
	private String passWord = "//*[@name='password']";
	private String loginBtn = "//input[@value='Login']";
//	private String forgotPasswordLink = "(//a[normalize-space()='Forgotten Password'])[1] ";
	private String forgotPasswordLink = "//a[text()='Forgotten Password']";
	private String Logoutbtn = "//a[contains(text(),'Logout')]";

	public LoginPage(Page page) {
		this.page = page;
	}

	public String getLoginPageTitle() {
		return page.title();
	}

	public boolean isForgotPwdLinkExists() {
		
		   try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		  
		return page.isVisible(forgotPasswordLink);

	}

	public void forgotPasswordflow() {
		System.out.println("ForgotPwdflow");
		page.click(forgotPasswordLink);
	}

	public boolean doLogin(String appUserName, String appPassword) {
		System.out.println("App credentials: " + appUserName + "&" + appPassword);
		page.fill(emailId, appUserName);
		page.fill(passWord, appPassword);
		page.click(loginBtn);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  System.out.println("LogoutSuccessfully started ....");
		  page.setDefaultNavigationTimeout(7000); try { Thread.sleep(3000); } catch
		  (InterruptedException e) { // TODO Auto-generated catch block
		  e.printStackTrace(); }
		 
		if (page.isVisible(Logoutbtn)) {
			System.out.println("LogoutSuccessfully ....");
			page.click(Logoutbtn);
			return true;

		}
		return false;

	}
}
