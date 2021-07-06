package com.bryne.qa.testcases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bryne.qa.base.BaseClass;
import com.bryne.qa.pages.LandingPage;
import com.bryne.qa.pages.LoginPage;
import com.bryne.qa.pages.OtpPage;
import com.bryne.qa.util.TestUtil;

public class OtpPageTest extends BaseClass{
	
	OtpPage otpPage;
	LandingPage landingPage;
	LoginPage loginPage;
	List<WebElement> op; 
	
	public OtpPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		
		otpPage = new OtpPage();
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("email"));
	}
	
	@Test
	public void completeLoginFlowTest() throws InterruptedException {
		otpPage.EnterOTP(); 
		landingPage = otpPage.ClickButton();  
		Thread.sleep(3000);
		
		Assert.assertEquals(landingPage.verifyUserLoggedIn(),"Welcome, "+TestUtil.U_FIRSTNAME+" "+TestUtil.U_LASTNAME+"! ");
	}
	
	@Test
	public void ResendLinkEnabledafter60sTest() throws InterruptedException {
		Assert.assertEquals(otpPage.checkResendLinkDisplayed(), true);
	}
	
	@Test
	public void ValidateButtonEnabledTest() {
		boolean beforeOTPfilled = otpPage.checkButtonStatus();
		System.out.println(beforeOTPfilled);
		
		Assert.assertTrue(beforeOTPfilled);
		otpPage.EnterOTP();
		boolean afterOTPfilled = otpPage.checkButtonStatus();
		System.out.println(afterOTPfilled);
		
		Assert.assertTrue(afterOTPfilled);
	}
	
	@AfterMethod
	public void aftermath() {
		driver.quit();
	}
	
	
	
	
}
