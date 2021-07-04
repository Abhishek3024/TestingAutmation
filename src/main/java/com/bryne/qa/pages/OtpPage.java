package com.bryne.qa.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bryne.qa.base.BaseClass;

public class OtpPage extends BaseClass {
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement submitButton; 
	
	@FindBy(xpath="//label[contains(text(),'OTP')]")
	WebElement otpText;
	
	@FindBy(xpath="//p[contains(text(),' Didn’t receive an OTP? Please wait ' )]//span")
	WebElement timer;
	
	@FindBy(xpath="//span[contains(text(),'Resend my OTP')]")
	WebElement resendLink;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement validateOTPButton;
	
	public OtpPage() {
		PageFactory.initElements(driver, this);
	}
	
	

	public void EnterOTP() {
		List<WebElement> lt = driver.findElements(By.xpath("//div[@class='wrapper ']//input"));
//		System.out.println(lt.size());
		for(int i=0;i<6;i++) {
			lt.get(i).sendKeys("9");;
		}
	}
	
	public LandingPage ClickButton() {
		submitButton.click();
		return new LandingPage();
	}
	public String ValidateOtpText() {
		return otpText.getText();
	}
	
	public boolean checkResendLinkDisplayed() throws InterruptedException {
		String starttimer = prop.getProperty("starttimer");
		String stoptimer = prop.getProperty("stoptimer");
		
		try {
			for(int i=Integer.parseInt(starttimer); i>Integer.parseInt(stoptimer);i--) {
				Thread.sleep(1000);
				System.out.println(timer.getText());	
			}	
		} catch (Exception NoSuchElementException) {
			
			System.out.println(resendLink.isDisplayed());
		}
		return resendLink.isDisplayed();
	}
	
	public boolean checkButtonStatus() {
		return submitButton.isEnabled();
	}
	

}
