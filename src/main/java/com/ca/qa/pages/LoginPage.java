package com.ca.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ca.qa.base.TestBase;

public class LoginPage extends TestBase {

	//PgeFactory
	
	
	@FindBy(xpath="//span[contains(text(),'Log In')]")
	
	WebElement SigninInbutton;
	
	@FindBy(xpath="//input[@placeholder='Email']")
	
	WebElement username_input;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	
	WebElement password_input;
	
	@FindBy(xpath="//div[contains(text(),'Login')]")
	
	WebElement login_button;
	
	@FindBy(xpath="//img[@alt=\"free crm logo\"]")
	
	WebElement beforelogin_logo;
	
	//Initializing the Web Elements
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public void validatelogobeforelogin() {
	boolean val= beforelogin_logo.isDisplayed();
	Assert.assertTrue(val, "logo should be visible before login");
	}
	
	public void clickonSigninbutton() {
		boolean val= SigninInbutton.isDisplayed();
		Assert.assertTrue(val, "Login buuton should displayed");
		SigninInbutton.click();
		Assert.assertTrue(username_input.isEnabled(), "username_input should be enabled");
	}
	
	public HomePage validateUserAbleToLogintoTheApplication() {
		SigninInbutton.click();
		Assert.assertTrue(username_input.isEnabled(), "username_input should be enabled");
		Assert.assertTrue(password_input.isEnabled(), "password_input should be enabled");
		username_input.sendKeys(prop.getProperty("username"));
		password_input.sendKeys(prop.getProperty("password"));
		Assert.assertTrue(login_button.isEnabled(), "login button should be enabled");
		login_button.click();
		return new HomePage();
	}
	
	
	
}
