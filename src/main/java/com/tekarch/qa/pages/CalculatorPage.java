package com.tekarch.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.tekarch.base.TestBase;

public class CalculatorPage extends TestBase {
	
	@FindBy(xpath="//body//input[1]")
	WebElement input10;
	
	@FindBy(xpath="//body//input[5]")
	WebElement input5;
	
	
	
	
public CalculatorPage() {
		
		PageFactory.initElements(driver, this);
	}

public boolean verifyinput1() {
	return input10.isDisplayed();
	
}

public boolean verifyinput5() {
	return input5.isDisplayed();
	
}

}
