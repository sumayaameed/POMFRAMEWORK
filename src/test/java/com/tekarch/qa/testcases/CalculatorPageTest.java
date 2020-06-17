package com.tekarch.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.tekarch.base.TestBase;
import com.tekarch.qa.pages.CalculatorPage;
import com.tekarch.qa.pages.HomePage;
import com.tekarch.qa.pages.LoginPage;
import com.tekarch.qa.util.TestUtil;

public class CalculatorPageTest extends TestBase {
	
	
	LoginPage loginpage;	
	HomePage homepage;
	CalculatorPage calculatorpage;
	TestUtil testutil;
	
	
public CalculatorPageTest() {
		
		super();
	}

@BeforeMethod
public void setUp() {
	initialization() ;
	 loginpage=new LoginPage(); 
	 calculatorpage=new CalculatorPage();
	 testutil=new TestUtil();
	homepage= loginpage.login(prop.getProperty("email"),prop.getProperty("password"));
	calculatorpage=homepage.clickoncalculator();
}

@Test(priority=1)
public void verifycalculatorinput1() {
	
}

@Test(priority=2)
public void verifycalculatorinput5() {
	
}


@AfterMethod

public void teardown() {
	driver.quit();
}















}
