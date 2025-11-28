package com.ca.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ca.qa.base.TestBase;
import com.ca.qa.util.TestUtil;

public class HomePage extends TestBase {
	
	//PageFactory for locators
	
	@FindBy(xpath="//div[@id='top-header-menu']/div/span[contains(text(),'sarita kumari')]")
	WebElement titlePostLogin;
	
	@FindBy(xpath="//span[contains(text(),'Calendar')]")
	WebElement calendarIcon;
	
	@FindBy(xpath="//span[contains(text(),'Forms')]")
	WebElement form_icon;
	//Initialize the WebElements
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public void validateUserNavigatedtoHomePagePostLogin() {
		boolean val= titlePostLogin.isDisplayed();
		Assert.assertTrue(val, "Title should display post login");
	}
	
	public CalanderPage clickOnCalendarIcon() {
		boolean val = calendarIcon.isDisplayed();
		Assert.assertTrue(val, "Calendar icon should display post login");
		calendarIcon.click();
		return new CalanderPage();
		
	}
	
	
	public FormPage clickOnFormIcon() {
		boolean val = form_icon.isDisplayed();
		Assert.assertTrue(val, "Form icon should display post login");
		form_icon.click();
		return new FormPage();
		
	}
}
