package com.ca.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ca.qa.base.TestBase;
import com.ca.qa.util.TestUtil;

public class CalanderPage extends TestBase{
	HomePage homePage;
	TestUtil util;
	
	@FindBy(xpath="//span[contains(text(),'Calendar')]")
	WebElement calendarIcon;
	
	@FindBy(xpath="//div[contains(@class,'event-list-container ui segment')]/div/div/a[contains(text(),'Manage Calendars')]")
	WebElement manageCalanderLink;
	
	@FindBy(xpath="//div[contains(@class,'calendar-icon-list')]/span/i[contains(@class,'black edit icon')]")
	WebElement editIcon;
	
	@FindBy(xpath="//button/span[contains(@class,'today-button')]")
	WebElement todayButton;
	
	//Initialize the WebElement
	
	public CalanderPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public void clickOnManageCalanderLink() {
		TestUtil util= new TestUtil();
		calendarIcon.click();
		util.clickOutsideToClosePopup();
		util.waitForVisibility(manageCalanderLink, 10);
		manageCalanderLink.click();
		boolean val2 = editIcon.isDisplayed();
		Assert.assertTrue(val2, "edit Icon should display post clicking on manageCalanderLink");
	}
}
