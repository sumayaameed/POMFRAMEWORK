package com.tekarch.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.tekarch.base.TestBase;

public class HomePage  extends TestBase {
	
	
	
	@FindBy(xpath="//a[contains(text(),'Home')]")
	WebElement home;
	
	
	
	
	@FindBy(xpath="//a[contains(text(),'Calculator')]")
	WebElement calculator;
	
	
	@FindBy(xpath="//a[contains(text(),'File Upload')]")
	WebElement fileupload;
	
	//initializing the pageobjects
	public HomePage() {
		
		PageFactory.initElements(driver, this);
	}
			
	
	public String verifyhomepagetitle() {
		return driver.getTitle();
	}
	
	
public CalculatorPage clickoncalculator() {
	calculator.click();
	return new CalculatorPage();
	
}

public FileUploadPage clickonfileupload() {
	fileupload.click();
	return new FileUploadPage();
}








}
