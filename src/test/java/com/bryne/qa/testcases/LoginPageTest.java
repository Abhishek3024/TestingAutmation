package com.bryne.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bryne.qa.base.BaseClass;
import com.bryne.qa.pages.LoginPage;
import com.bryne.qa.pages.OtpPage;

public class LoginPageTest extends BaseClass{

	LoginPage loginPage;
	OtpPage otpPage; 
	
	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();

		loginPage = new LoginPage();
	}

//	@Test
	public void LoginTitleTest() {
		String title = loginPage.validateLoginPageTitle(); 
		Assert.assertEquals(title, "Login to your account");
	}
	
	@Test
	public void LoginLogoTest() {
		Assert.assertTrue(loginPage.validateLoginPageLogo());
	}
	
//	@Test
	public void LoginSubHeaderTest() {
		Assert.assertEquals(loginPage.validateLoginPageSubHeader(), "Email address");
	}
	
//	@Test
	public void LoginTest() {
		otpPage = loginPage.login(prop.getProperty("email"));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(otpPage.ValidateOtpText(), "OTP");
		
	}
	
	@AfterMethod
	public void aftermath() {
		driver.quit();
	}

}
