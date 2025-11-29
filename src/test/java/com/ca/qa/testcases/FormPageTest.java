package com.ca.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ca.qa.base.TestBase;
import com.ca.qa.pages.FormPage;
import com.ca.qa.pages.HomePage;
import com.ca.qa.pages.LoginPage;
import com.ca.qa.util.TestUtil;

public class FormPageTest extends TestBase {
	
	HomePage homePage;
	LoginPage loginPage;
	FormPage formPage;
	
	public FormPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage=new LoginPage();
		homePage=loginPage.validateUserAbleToLogintoTheApplication();
		formPage= homePage.clickOnFormIcon();
	}
	
	@DataProvider
	public Object[][] gettestData() throws IOException{
		Object data[][]=TestUtil.readExcelData(prop.getProperty("sheetname"));
		return data;
	}
	
	
	@Test(dataProvider="gettestData")
	public void validateformPagewithDataDrivenapproach(String name, String introduction_textfield) {
		formPage.validateFormPagefunctionality(name,introduction_textfield);
			}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	

}

	
	


