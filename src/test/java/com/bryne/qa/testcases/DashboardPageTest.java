package com.bryne.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bryne.qa.base.BaseClass;
import com.bryne.qa.pages.DashboardPage;
import com.bryne.qa.pages.LandingPage;
import com.bryne.qa.pages.LoginPage;
import com.bryne.qa.pages.OtpPage;
import com.bryne.qa.util.TestUtil;

public class DashboardPageTest extends BaseClass{

	public DashboardPageTest() {
		super();
	}
	LoginPage loginPage;
	OtpPage otpPage;
	LandingPage landingPage;
	DashboardPage dashboardPage;

	@BeforeMethod
	public void setup() {
		initialization();

		loginPage = new LoginPage();
		otpPage = new OtpPage();
		landingPage = new LandingPage();
		dashboardPage = new DashboardPage();

		loginPage.login(prop.getProperty("email"));
		otpPage.EnterOTP();
		otpPage.ClickButton();
		landingPage.validateDashboardLink();

	}

		@Test
	public void validateRedeemButtonBehaviorTest() {
		Assert.assertEquals( dashboardPage.staticButtonFunction(TestUtil.REWARDS_BUTTON_TEXT), "Transactions History");	
	}

	@Test
	public void validateOrderButtonBehaviorTest() {
		Assert.assertEquals( dashboardPage.staticButtonFunction(TestUtil.ORDER_PRODUCT_BUTTON_TEXT), "Transactions History");	
	}

		@Test
	public void validateTransactionTableBeforeAndAfterLoadMoreClick() {
		//Before Load More button Clicked
		Assert.assertTrue(dashboardPage.loadMoreButton());
		Assert.assertEquals(dashboardPage.noOfRows(), TestUtil.NO_OF_ROWS_BEFORE_LOAD_MORE_CLICK);

		//After the Load More button clicked
		dashboardPage.clickLoadMoreButton();
		Assert.assertEquals(dashboardPage.noOfRows(), TestUtil.NO_OF_ROWS_AFTER_LOAD_MORE_CLICK);
	}

		@Test
	public void validateRewardsTable() {
		Assert.assertEquals( dashboardPage.rewardsCatalogueTable(), TestUtil.NO_OF_ROWS__IN_REWARDS_CATALOG);
	}

	@AfterMethod
	public void aftermath() {
		driver.quit();
	}

}
