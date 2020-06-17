package com.tekarch.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.tekarch.base.TestBase;

public class LoginPage extends TestBase {
	
	
	
	//Page Factory -Object Repository(OR)
	
	
	
	@FindBy(id="email_field")
	 WebElement emailfield;
	
	
	@FindBy(id="password_field")
	WebElement passwordfield;
	
	
	@FindBy(xpath="//button[contains(text(),'Login to Account')]")
	WebElement loginAccount;
	
	
	//initializing the pageobjects
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
			
	public HomePage login(String ef,String pwd) {
		emailfield.sendKeys(ef);
		passwordfield.sendKeys(pwd);
		loginAccount.click();
		
		return new HomePage();
		
	}

}
