package com.ca.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ca.qa.base.TestBase;

public class FormPage extends TestBase{
	
	HomePage homepage;
	@FindBy(xpath="//button[contains(text(),'Add')]")
	WebElement add_btn;
	
	@FindBy(xpath="//input[@name='name']")
	WebElement name_field;
	
	@FindBy(xpath="//label[contains(text(),'Introduction text')]//following-sibling::textarea")
	WebElement introduction_textfield;
	
	@FindBy(xpath="//button[contains(text(),'Submit')]")
	WebElement submit_btn;
	
	
	public FormPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void validateFormPagefunctionality() {
		homepage.clickOnCalendarIcon();
		boolean val= add_btn.isDisplayed();
		Assert.assertTrue(val, "Add button should display");
		name_field.clear();
		boolean val1=name_field.isDisplayed();
		Assert.assertTrue(val1, "Name field should display");
		introduction_textfield.clear();
		boolean val2=introduction_textfield.isDisplayed();
		Assert.assertTrue(val2, "Introduction textarea should display");
		
		
	}
	

}
