package com.bryne.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bryne.qa.base.BaseClass;
import com.bryne.qa.pages.LandingPage;
import com.bryne.qa.pages.LoginPage;
import com.bryne.qa.pages.MyInfoPage;
import com.bryne.qa.pages.OtpPage;
import com.bryne.qa.pages.UpdateDetailsPage;
import com.bryne.qa.util.TestUtil;

public class UpdateDetailsPageTest extends BaseClass{
	public UpdateDetailsPageTest() {
		super();
	}
	
	LoginPage loginPage;
	OtpPage otpPage;
	LandingPage landingPage;
	MyInfoPage myInfoPage;
	UpdateDetailsPage updateDetailsPage;
	
	String sheetName = "UpdateDetails";
	
	@BeforeMethod
	public void setup() {
		initialization();
		
		loginPage = new LoginPage();
		otpPage = loginPage.login(prop.getProperty("email"));
		
		otpPage.EnterOTP();
		landingPage = otpPage.ClickButton();
		myInfoPage = landingPage.validateMyInfoLink();
		updateDetailsPage = myInfoPage.EditMyInfoButtonClick();
		
	}
	
	@Test
	public void noOfDisabledItemsTest() {
		Assert.assertEquals(updateDetailsPage.getAllDisabledDetails(), TestUtil.NO_OF_DISABLED_DETAILS);
	}
	
	@Test
	public void updateCountryOfResidenceTest() {
		updateDetailsPage.handleCountryOfResidenceSelect(TestUtil.COUNTRY_AFTER_SELECT);
		updateDetailsPage.clickupdateButton();
		
		Assert.assertEquals(myInfoPage.createXPATH("Country"), TestUtil.COUNTRY_AFTER_SELECT,"Country of Residence is not updating");
	}
	
//	@Test
//	public void updateFirstNameTest() {
//		updateDetailsPage.updateFirstName(TestUtil.U_FIRSTNAME);
//		updateDetailsPage.clickupdateButton();
//		
//		Assert.assertEquals(myInfoPage.createXPATH("First Name"), TestUtil.U_FIRSTNAME);
//	}
//	
//	@Test
//	public void updateLastNameTest() {
//		updateDetailsPage.updateLastName(TestUtil.U_LASTNAME);
//		updateDetailsPage.clickupdateButton();
//		
//		Assert.assertEquals(myInfoPage.createXPATH("Last Name"), TestUtil.U_LASTNAME);
//	}
//	
//	@Test
//	public void updateBusinessPhoneTest() {
//		updateDetailsPage.updateBusinessPhone(TestUtil.U_BUSINESS_PHONE);
//		updateDetailsPage.clickupdateButton();
//		
//		Assert.assertEquals(myInfoPage.createXPATH("Business Phone"), TestUtil.U_BUSINESS_PHONE);
//	}
//	
//	@Test
//	public void updateAddressTest() {
//		updateDetailsPage.updateAddress(TestUtil.U_ADDRESS);
//		updateDetailsPage.clickupdateButton();
//		
//		Assert.assertEquals(myInfoPage.createXPATH("Address"), TestUtil.U_ADDRESS);
//	}
//	
//	@Test
//	public void updateStateTest() {
//		updateDetailsPage.updateState(TestUtil.U_STATE);
//		updateDetailsPage.clickupdateButton();
//		
//		Assert.assertEquals(myInfoPage.createXPATH("State"), TestUtil.U_STATE);
//	}
//	
//	@Test
//	public void updateCityTest() {
//		updateDetailsPage.updateCity(TestUtil.U_CITY);
//		updateDetailsPage.clickupdateButton();
//		
//		Assert.assertEquals(myInfoPage.createXPATH("City"), TestUtil.U_CITY);
//	}
//	
//	@Test
//	public void updateZipTest() {
//		updateDetailsPage.updateZip(TestUtil.U_ZIP);
//		updateDetailsPage.clickupdateButton();
//		
//		Assert.assertEquals(myInfoPage.createXPATH("Zip"), TestUtil.U_ZIP);
//	}
	 
	@DataProvider
	public Object[][] getTestData() {
		Object data[][]= TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(dataProvider="getTestData")
	public void validateUpdateFieldsTest(String Firstname, String LastName, String BusinessPhone, String Address, String State, String Zip, String City) {
		
		updateDetailsPage.validateAlldetails(Firstname, LastName, BusinessPhone, Address, State, Zip, City);
		
		Assert.assertEquals(myInfoPage.createXPATH("First Name"), Firstname);
		Assert.assertEquals(myInfoPage.createXPATH("Last Name"), LastName);
//		Assert.assertEquals(myInfoPage.createXPATH("Business Phone"), BusinessPhone);
		Assert.assertEquals(myInfoPage.createXPATH("Address"), Address);
		Assert.assertEquals(myInfoPage.createXPATH("State"), State);
		Assert.assertEquals(myInfoPage.createXPATH("City"), City);
//		Assert.assertEquals(myInfoPage.createXPATH("Zip"), Zip);
	}
	
	@AfterMethod
	public void aftermath() {
		driver.quit();
	}
	
}
