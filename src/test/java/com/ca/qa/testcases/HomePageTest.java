package com.ca.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ca.qa.base.TestBase;
import com.ca.qa.pages.HomePage;
import com.ca.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage=new LoginPage();
		homePage=loginPage.validateUserAbleToLogintoTheApplication();
	}
	
	@Test(priority=1)
	public void validateUserIsOnHomePage() {
		homePage.validateUserNavigatedtoHomePagePostLogin();
	}
	
	@Test(priority=2)
	public void validateCalanderFunctionalityOnHomePage() {
		homePage.clickOnCalendarIcon();
	}
	
	
	
	
	@AfterMethod
	public void teerDown() {
		driver.quit();
	}

}
