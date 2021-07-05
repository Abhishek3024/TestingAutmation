package com.bryne.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bryne.qa.base.BaseClass;

public class MyInfoPage extends BaseClass{
	
	@FindBy(xpath = "//div[contains(text(),'Edit My Info')]")
	WebElement editMyInfoButton;
	
	public MyInfoPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	 
	public String createXPATH(String fieldName) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		String beforeXpath = "//div[@class='label' and contains(text(),'";
		String AfterXpath = "')]/following-sibling::div";
		System.out.println(beforeXpath+fieldName+AfterXpath);
		return driver.findElement(By.xpath(beforeXpath+fieldName+AfterXpath)).getText();
	}
	
	public UpdateDetailsPage EditMyInfoButtonClick() {
		editMyInfoButton.click();
		
		return new UpdateDetailsPage();
	}
}
