package com.tekarch.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.tekarch.base.TestBase;
import com.tekarch.qa.pages.HomePage;
import com.tekarch.qa.pages.LoginPage;

public class LoginPageTest  extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	
	
	public LoginPageTest() {
		
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization() ;
		
		 loginpage=new LoginPage();
	}
	

	@Test()
	public void loginTest() {
		homepage=loginpage.login(prop.getProperty("email"),prop.getProperty("password"));
	}
	@AfterMethod
	public void teardown() {
		
		driver.quit();
		
	}
}
