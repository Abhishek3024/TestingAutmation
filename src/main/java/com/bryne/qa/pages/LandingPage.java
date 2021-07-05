package com.bryne.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bryne.qa.base.BaseClass;

public class LandingPage extends BaseClass{

	@FindBy(xpath = "//div[contains(text(),'Welcome, Tomtesting Something! ')]")
	WebElement usernameText;
	
	@FindBy(xpath = "//div[@ng-reflect-router-link='/dashboard']")
	WebElement dashboardViaLink;
	
	@FindBy(xpath = "//div[@ng-reflect-router-link='/myinfo']")
	WebElement myInfoViaLink;
	
	@FindBy(xpath = "//h1[contains(text(), 'What is Power Perks?')]")
	WebElement whatIsPowerPerksText;
	
	@FindBy(xpath = "//h1[contains(text(), 'What are the Benefits?')]")
	WebElement whatAreBenefitsText;
	
	@FindBy(xpath = "//h1[contains(text(), 'Rewards Catalog')]")
	WebElement rewardCataloguesText;
	
	@FindBy(xpath = "//h1[contains(text(), 'How Can I Earn?')]")
	WebElement howCanIEarnText;
	
	@FindBy(xpath = "//h1[contains(text(), 'FAQ')]")
	WebElement FAQText;
	
	@FindBy(xpath = "//div[contains(text(), 'Check Your Status')]")
	WebElement checkyourStatusButton; 
	
	
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
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		myInfoViaLink.click();
		return new MyInfoPage();
	}
	
	public int validateListofPerks() {
		return listOfPowerPerks.size();
	}
	
	public String ValidatePerksTitle() {
		return whatIsPowerPerksText.getText();
	}
	
	public String ValidateBenefitsTitle() {
		return whatAreBenefitsText.getText();
	}
	
	public String ValidateRewardsCatalogueTitle() {
		return rewardCataloguesText.getText();
	}
	
	public String ValidateHowCanIEarnTitle() {
		return howCanIEarnText.getText();
	}
	
	public String ValidateFAQTitle() {
		return FAQText.getText();
	}
	
	public DashboardPage ValidateDashboardviaButton() {
		checkyourStatusButton.click();
		
		return new DashboardPage();
	}
}
