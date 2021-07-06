package com.bryne.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bryne.qa.base.BaseClass;

public class LoginPage extends BaseClass{
	
	@FindBy(id="emailaddress")
	WebElement Email;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement getOtpButton;
	
	@FindBy(className="header-logo")
	WebElement Logo;
	
	@FindBy(xpath="//label[contains(text(),'Email address')]") // We can also use //h1[contains(text(),'Login')] as xpath
	WebElement logintext;
	
	// Initialising the Page Web Objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateLoginPageLogo() {
		return Logo.isDisplayed();
	}
	
	public String validateLoginPageSubHeader() {
		return logintext.getText();
	}
	
	public OtpPage login(String email) {
		Email.sendKeys(email);
		getOtpButton.click();
		
		return new OtpPage();
	}
	
	
	
}
