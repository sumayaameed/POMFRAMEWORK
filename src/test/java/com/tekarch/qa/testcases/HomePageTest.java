package com.tekarch.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.tekarch.base.TestBase;
import com.tekarch.qa.pages.HomePage;
import com.tekarch.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	
	LoginPage loginpage;	
	HomePage homepage;
	
	
public HomePageTest() {
		
		super();
	}


@BeforeMethod
public void setUp() {
	initialization() ;
	 loginpage=new LoginPage(); 
	homepage= loginpage.login(prop.getProperty("email"),prop.getProperty("password"));
	
}


@Test(priority=1)
public void verifyhomepagetitleTest() {
	
	String homepagetitle=homepage.verifyhomepagetitle();
	
}

@Test(priority=2)
public void verfifyCalculatorpage() {
	
	homepage.clickoncalculator();
}

@Test(priority=3)
public void verifyfileuploadpage() {
	homepage.clickonfileupload();
}


@AfterMethod

public void teardown() {
	driver.quit();
}












}


