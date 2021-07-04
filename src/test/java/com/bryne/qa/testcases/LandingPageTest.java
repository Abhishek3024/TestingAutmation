package com.bryne.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bryne.qa.base.BaseClass;
import com.bryne.qa.pages.DashboardPage;
import com.bryne.qa.pages.LandingPage;
import com.bryne.qa.pages.LoginPage;
import com.bryne.qa.pages.MyInfoPage;
import com.bryne.qa.pages.OtpPage;

public class LandingPageTest extends BaseClass{
	
	public LandingPageTest() {
		super();
	}
	
	LoginPage loginPage;
	OtpPage otpPage;
	DashboardPage dashboardPage;
	MyInfoPage myInfoPage;
	LandingPage landingPage;
	
	@BeforeMethod
	public void setup() {
		initialization();
		
		loginPage = new LoginPage();
		otpPage = new OtpPage();
		dashboardPage = new DashboardPage();
		myInfoPage = new MyInfoPage();
		landingPage = new LandingPage();
		
		loginPage.login(prop.getProperty("email"));
		otpPage.EnterOTP();
		otpPage.ClickButton();
	}
	
	@Test
	public void validateList() {
		landingPage.validateListofPerks();
	}
	@AfterMethod
	public void aftermath() {
		driver.quit();
	}
	
}
