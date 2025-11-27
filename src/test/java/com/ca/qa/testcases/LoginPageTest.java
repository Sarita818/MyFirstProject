package com.ca.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ca.qa.base.TestBase;
import com.ca.qa.pages.HomePage;
import com.ca.qa.pages.LoginPage;

public class LoginPageTest extends TestBase  {
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	
	
	
    @BeforeMethod
    public void setup() {
    	initialization();
       loginPage = new LoginPage();
    }
    
    @Test(priority=1)
    public void loginPagelogoValidation() {
    	loginPage.validatelogobeforelogin();
    }
    
    @Test(priority=2)
    public void vlaidateUserabletoNavigateToSignInForm() {
    	loginPage.clickonSigninbutton();
    }
    
    @Test(priority=3)
    public void validateUserabletoNavigatetoHomepagepostLogin() {
    	homePage= loginPage.validateUserAbleToLogintoTheApplication();
    }
    
    @AfterMethod
    public void tearDown() {
    	driver.quit();
    }


}


