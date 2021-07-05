package com.bryne.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.bryne.qa.base.BaseClass;

public class UpdateDetailsPage extends BaseClass {
	@FindBy(xpath="//button[@type='submit' and contains(text(),'Update')]")
	WebElement updateButton;
	
	@FindBy(xpath="//div[contains(text(),'Cancel')]")
	WebElement cancelButton;
	
	@FindAll({
		@FindBy(xpath = "//input[@ng-reflect-is-disabled='true']/preceding-sibling::label"),
		@FindBy(xpath = "//input[@ng-reflect-is-disabled='true']/parent::div/preceding-sibling::label[contains(text(),'Mobile')]")
	})
	List<WebElement> allDisabledDetails;
	
	@FindBy(xpath="//select[@name='country_of_residence']")
	WebElement selectElement;
	
	@FindBy(xpath="//label[contains(text(),'First name')]/following-sibling::input")
	WebElement firstName;
	
	@FindBy(xpath="//label[contains(text(),'Last name')]/following-sibling::input")
	WebElement lastName;
	
	@FindBy(xpath="//label[contains(text(),'Business Phone')]/following-sibling::input")
	WebElement businessPhone;
	
	@FindBy(xpath="//label[contains(text(),'Address')]/following-sibling::input")
	WebElement address;
	
	@FindBy(xpath="//label[contains(text(),'State')]/following-sibling::input")
	WebElement state;
	
	@FindBy(xpath="//label[contains(text(),'City')]/following-sibling::input")
	WebElement city;
	
	@FindBy(xpath="//label[contains(text(),'Zip')]/following-sibling::input")
	WebElement zip;
	
	public UpdateDetailsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean updateButtonDetails() {
		return updateButton.isDisplayed();
	}
	
	public boolean cancelButtonDetails() {
		return cancelButton.isDisplayed();
	}
	
	public int getAllDisabledDetails() {
		ArrayList<String> listOfDisabledItems = new ArrayList<String>();
		for(int i=0;i<allDisabledDetails.size();i++) {
			listOfDisabledItems.add(allDisabledDetails.get(i).getText());
		}
		
		return listOfDisabledItems.size();
	}
	
	public void handleCountryOfResidenceSelect(String CountryName) {
		Select select = new Select(selectElement);
		
		select.selectByVisibleText(CountryName);
	}
	
	public void clickupdateButton() {
		updateButton.click();
	}
	
	public void clickUpdateButton() {
		cancelButton.click();
	}
	
	public void updateFirstName(String Firstname) {
		firstName.clear();
		firstName.sendKeys(Firstname);
	}
	
	public void updateLastName(String Lastname) {
		lastName.clear();
		lastName.sendKeys(Lastname);
	}
	
	public void updateBusinessPhone(String BusinessPhone) {
		businessPhone.clear();
		businessPhone.sendKeys(BusinessPhone);
	}
	
	public void updateAddress(String Address) {
		address.clear();
		address.sendKeys(Address);
	}
	
	public void updateState(String State) {
		state.clear();
		state.sendKeys(State);
	}
	
	public void updateCity(String City) {
		city.clear();
		city.sendKeys(City);
	}
	
	public void updateZip(String Zip) {
		zip.clear();
		zip.sendKeys(Zip);
	}
}
