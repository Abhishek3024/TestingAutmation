package com.bryne.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bryne.qa.base.BaseClass;
import com.bryne.qa.pages.DashboardPage;
import com.bryne.qa.pages.LandingPage;
import com.bryne.qa.pages.LoginPage;
import com.bryne.qa.pages.MyInfoPage;
import com.bryne.qa.pages.OtpPage;
import com.bryne.qa.util.TestUtil;

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
		otpPage = loginPage.login(prop.getProperty("email"));
		dashboardPage = new DashboardPage();
		myInfoPage = new MyInfoPage();
		
		otpPage.EnterOTP();
		landingPage = otpPage.ClickButton();
	}
	
	@Test
	public void validatePerksDetailsTest() {
		
		Assert.assertEquals(landingPage.ValidatePerksTitle(), TestUtil.PERKS_SECTION_1_TITLE);
		
		Assert.assertEquals(landingPage.validateListofPerks(), TestUtil.PERKS_SECTION_1_NO_OF_COL);
	}
	
	@Test
	public void validateDashboardViaLinkTest() {
		dashboardPage = landingPage.validateDashboardLink();
	}
	
	@Test
	public void validateMyInfoViaLinkTest() {
		myInfoPage = landingPage.validateMyInfoLink();
	}
	
	@Test
	public void validateWhatAreBenefitssSection() {
		Assert.assertEquals(landingPage.ValidateBenefitsTitle(), TestUtil.BENEFITS_TITLE);
	}
	
	@Test
	public void validateRewardsCatalogueSection() {
		Assert.assertEquals(landingPage.ValidateRewardsCatalogueTitle(), TestUtil.REWARDS_CATALOGUE);
	}
	
	@Test
	public void validateHowCanIEarnSection() {
		Assert.assertEquals(landingPage.ValidateHowCanIEarnTitle(), TestUtil.HOW_CAN_I_EARN_TITLE);
	}
	
	@Test
	public void validateFAQSectionTest() {
		Assert.assertEquals(landingPage.ValidateFAQTitle(), TestUtil.FAQ);
	}
	
	@Test
	public void validateCheckYourStatusButtonBehavior() {
		landingPage.ValidateDashboardviaButton();
		Assert.assertEquals(dashboardPage.getSlabDetails(), TestUtil.SLAB_NAME);
		Assert.assertEquals(dashboardPage.getTitle(),TestUtil.DASHBOARD_SCREEN_TITLE);
	}

	@AfterMethod
	public void aftermath() {
		driver.quit();
	}
	
}
