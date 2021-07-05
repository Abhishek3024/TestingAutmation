package com.bryne.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bryne.qa.base.BaseClass;
import com.bryne.qa.pages.LandingPage;
import com.bryne.qa.pages.LoginPage;
import com.bryne.qa.pages.MyInfoPage;
import com.bryne.qa.pages.OtpPage;
import com.bryne.qa.pages.UpdateDetailsPage;
import com.bryne.qa.util.TestUtil;

public class MyInfoPageTest extends BaseClass {

	public MyInfoPageTest() {
		super();
	}
	LoginPage loginPage;
	OtpPage otpPage;
	LandingPage landingPage;
	MyInfoPage myInfoPage;
	UpdateDetailsPage updateDetailPage;

	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		otpPage = new OtpPage();
		landingPage = new LandingPage();
		myInfoPage = new MyInfoPage();

		loginPage.login(prop.getProperty("email"));
		otpPage.EnterOTP();
		otpPage.ClickButton();
		landingPage.validateMyInfoLink();
	}

	@Test
	public void validateTitle() {
		myInfoPage.getPageTitle();
	}
	
	@Test
	public void validateFieldValues() {
		Assert.assertEquals( myInfoPage.createXPATH("First Name"), TestUtil.FIRSTNAME);
		Assert.assertEquals( myInfoPage.createXPATH("Last Name"), TestUtil.LASTNAME);
		Assert.assertEquals( myInfoPage.createXPATH("email"), TestUtil.EMAIL);
		Assert.assertEquals( myInfoPage.createXPATH("Mobile Phone"), TestUtil.MOBILE_PHONE);
		Assert.assertEquals( myInfoPage.createXPATH("Business Phone"), TestUtil.BUSINESS_PHONE);
		Assert.assertEquals( myInfoPage.createXPATH("Address"), TestUtil.ADDRESS);
		Assert.assertEquals( myInfoPage.createXPATH("State"), TestUtil.STATE);
		Assert.assertEquals( myInfoPage.createXPATH("Zip"), TestUtil.ZIP);
		Assert.assertEquals( myInfoPage.createXPATH("City"), TestUtil.CITY);
		Assert.assertEquals( myInfoPage.createXPATH("Country"), TestUtil.COUNTRY);
		Assert.assertEquals( myInfoPage.createXPATH("Type of the customer"), TestUtil.TYPE_OF_THE_CUSTOMER);
		Assert.assertEquals( myInfoPage.createXPATH("Joining date"), TestUtil.JOINING_DATE);
		Assert.assertEquals( myInfoPage.createXPATH("Company"), TestUtil.COMPANYS_CUSTOMER_NUMBER);
		Assert.assertEquals( myInfoPage.createXPATH("Company Name"), TestUtil.COMPANY_NAME);
	}
	
	
	@Test
	public void validateEditMyInfoButtonFunctionality() {
		myInfoPage.EditMyInfoButtonClick();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		updateDetailPage = new UpdateDetailsPage();
		Assert.assertTrue(updateDetailPage.updateButtonDetails());
		Assert.assertTrue(updateDetailPage.cancelButtonDetails());
	}
	

//	@AfterMethod
	public void aftermath() {
		driver.quit();
	}
}
