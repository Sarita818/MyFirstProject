package com.ca.qa.util;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

public class WebEventListener implements WebDriverListener {

    @Override
    public void beforeGet(WebDriver driver, String url) {
        System.out.println("[Before GET] Navigating to: " + url);
    }

    @Override
    public void afterGet(WebDriver driver, String url) {
        System.out.println("[After GET] Navigated to: " + url);
    }

    @Override
    public void beforeClick(WebElement element) {
        System.out.println("[Before Click] About to click: " + element);
    }

    @Override
    public void afterClick(WebElement element) {
        System.out.println("[After Click] Clicked: " + element);
    }
    public void onException(Throwable error, WebDriver driver){
    	TestUtil util = new TestUtil();
    	System.out.println("Exception occurred:"+error);
    	try{
    	util.takeScreenshotAtEndOfTest();
    	}
    	catch(IOException e){
    	e.printStackTrace();
    	}
    	}


    // you can override more methods as needed — beforeFindElement, afterFindElement, onError, etc.
}
