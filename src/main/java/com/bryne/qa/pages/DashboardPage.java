package com.bryne.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bryne.qa.base.BaseClass;

public class DashboardPage extends BaseClass{

	@FindBy(xpath="//h1[contains(text(),'You')]")
	WebElement slabDetails;

	@FindBy(xpath = "//div[contains(text(),'Redeem Points')]")
	WebElement redeemButton;
	
	@FindBy(xpath = "//div[contains(text(),'Order Product')]")
	WebElement orderButton;

	@FindBy(xpath = "//table[@id='customers']//tbody//tr")
	List<WebElement> rows;

	@FindBy(xpath = "//div[contains(text(),'Load more')]")
	WebElement loadMoreButton;
	
	@FindBy(xpath = "//h1[contains(text(),'Rewards Catalog')]")
	WebElement rewardsCatalogTitle;
	
	@FindBy(xpath = "//h1[contains(text(),'Rewards Catalog')]/parent::section//div//div//div//div[@class='col-lg-6 rewards-label']")
	List<WebElement> rewardsCatalogTable;

	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public String getSlabDetails() {
		String text = slabDetails.getText();
		String[] arr =  text.split(" ",2);
		String[] arr2 = arr[1].split("!");
		return arr2[0];
	}

	public boolean getRedeemButton() {
		return redeemButton.isEnabled();
	}

	public String staticButtonFunction(String buttonText) {
		if(buttonText.equals("Redeem Points")) {
			redeemButton.click();
			
		} else if(buttonText.equals("Order Product")) {
			orderButton.click();
		}
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());

		driver.switchTo().window(tabs.get(1));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println( driver.getTitle());

		driver.close();
		driver.switchTo().window(tabs.get(0));
		System.out.println(driver.getTitle());
		return driver.getTitle();
	}

	public int noOfRows() {
		return rows.size();
	}

	public void clickLoadMoreButton() {
		loadMoreButton.click();
	}
	
	public boolean loadMoreButton() {
		return loadMoreButton.isDisplayed();
	}
	
	public String rewardsCatalogue() {
		return rewardsCatalogTitle.getText();
	}
	
	public int rewardsCatalogueTable() {
//		System.out.println(rewardsCatalogTable.size());
		for(int i=0;i<rewardsCatalogTable.size();i++) {
			System.out.println(rewardsCatalogTable.get(i).getText());
		}
		
		return rewardsCatalogTable.size();
	}

}
