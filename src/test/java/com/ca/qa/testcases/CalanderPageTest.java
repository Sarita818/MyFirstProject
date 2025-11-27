package com.ca.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ca.qa.base.TestBase;
import com.ca.qa.pages.CalanderPage;
import com.ca.qa.pages.HomePage;
import com.ca.qa.pages.LoginPage;

public class CalanderPageTest extends TestBase {
	LoginPage loginPage;
	CalanderPage calanderPage;
	HomePage homePage;
	
	public CalanderPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		LoginPage loginPage = new LoginPage();
	    homePage=loginPage.validateUserAbleToLogintoTheApplication();
		calanderPage=homePage.clickOnCalendarIcon();
		}
	
	@Test
	public void validateCalenderNavigationandFunctionality() {
		calanderPage.clickOnManageCalanderLink();
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	

}
