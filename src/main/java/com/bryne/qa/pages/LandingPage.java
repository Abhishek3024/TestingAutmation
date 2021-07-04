package com.bryne.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bryne.qa.base.BaseClass;

public class LandingPage extends BaseClass{

	@FindBy(xpath = "//div[contains(text(),'Welcome, Tomtesting Something! ')]")
	WebElement usernameText;
	
	@FindBy(xpath = "//div[@ng-reflect-router-link='/dashboard']//div//p")
	WebElement dashboardViaLink;
	
	@FindBy(xpath = "//div[@ng-reflect-router-link='/myinfo']//div//p")
	WebElement myInfoViaLink;
	
	@FindBy(xpath = "//h1[contains(text(), 'What is Power Perks?')]")
	WebElement whatIsPowerPerksText;
	
	@FindBy(xpath = "//h1[contains(text(), 'What is Power Perks?')]/following-sibling::div//div[@class='col-lg-4 p-50']")
	List<WebElement> listOfPowerPerks;
	
	
	public LandingPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyUserLoggedIn() {
		return usernameText.getText();
	}
	
	public DashboardPage validateDashboardLink() {
		dashboardViaLink.click();
		return new DashboardPage();
	}
	
	public MyInfoPage validateMyInfoLink() {
		myInfoViaLink.click();
		return new MyInfoPage();
	}
	
	public int validateListofPerks() {
		return listOfPowerPerks.size();
	}
	
	public String ValidatePerksTitle() {
		return whatIsPowerPerksText.getText();
	}
	
	
}
