package com.ca.qa.util;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ca.qa.base.TestBase;


public class TestUtil extends TestBase {
	public static long Page_load_Timeout=50;
	public static long Implicit_Wait=10;
	
	public void switchToFrame() {
		driver.switchTo().frame("");
	}
	
	public void clickOutsideToClosePopup() {
		Actions actions = new Actions(driver);
		actions.moveByOffset(0, 0)      // or some offset coordinates outside popup
		       .click()
		       .build()
		       .perform();

	}
	
	  public void waitForVisibility(WebElement element, int timeoutSeconds) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
	         wait.until(ExpectedConditions.visibilityOf(element));
	    }

}