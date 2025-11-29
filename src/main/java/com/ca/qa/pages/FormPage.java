package com.ca.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ca.qa.base.TestBase;
import com.ca.qa.util.TestUtil;

public class FormPage extends TestBase{
	TestUtil util;
	HomePage homepage;
	@FindBy(xpath="//button[contains(text(),'Add')]")
	WebElement add_btn;
	
	@FindBy(xpath="//input[@name='name']")
	WebElement name_field;
	
	@FindBy(xpath="//label[contains(text(),'Introduction text')]//following-sibling::textarea")
	WebElement introduction_textfield;
	
	@FindBy(xpath="//button[contains(text(),'Submit')]")
	WebElement submit_btn;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	WebElement savebtn;
	
	
	public FormPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void validateFormPagefunctionality(String name, String introduction) {
		HomePage homepage = new HomePage();
		TestUtil util = new TestUtil();
		homepage.clickOnFormIcon();
		util.clickOutsideToClosePopup();
		boolean val= add_btn.isDisplayed();
		Assert.assertTrue(val, "Add button should display");
		add_btn.click();
		boolean val1=name_field.isDisplayed();
		Assert.assertTrue(val1, "Name field should display");
		boolean val2=introduction_textfield.isDisplayed();
		Assert.assertTrue(val2, "Introduction textarea should display");
		name_field.sendKeys(name);
		introduction_textfield.sendKeys(introduction);
		boolean val3= savebtn.isEnabled();
		Assert.assertTrue(val3, "Submit button should be enabled");
		savebtn.click();
	//	Assert.assertTrue(submit_btn.isDisplayed(), "Submit button should displayed");
		
		
		
		
	}
	

}
