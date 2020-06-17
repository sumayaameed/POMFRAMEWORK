package com.tekarch.qa.ExtentReportListener;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportListener{
	
	public static ExtentReports reports;
	public static ExtentTest logger;
	public static void main(String[]args) throws IOException {
    WebDriver driver;
		//we dont have any inbuilt function in java to create report
		//Using Extent Report we can generate reports
		//we have to tell them where this reports file need to store.
		
		String uniqueDateTime=new SimpleDateFormat("'SampleDemo_'yyyyMMddHHmm''").format(new Date());
		String sPath=System.getProperty("user.dir")+"//extentreport//sampleReport_"+uniqueDateTime+".html";//sampleReport_<timeStamp>.html
		
		
		reports =new ExtentReports(sPath);//it will start creating html files
		
		logger=reports.startTest("launching the browser");//execution started and assigned to logger object
		
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// implicit wait
		System.setProperty("webdriver.chrome.driver","C:\\Users\\shakul\\eclipse-workspace\\ExtentReport\\src\\config\\chromedriver.exe");
		driver = new ChromeDriver();
		
		logger.log(LogStatus.INFO, "Starting test case");
		
		driver.get("https://qa-tekarch.firebaseapp.com");
		logger.log(LogStatus.INFO, "Navigating to tekarch");
		
		driver.manage().window().maximize();
		logger.log(LogStatus.INFO, "maximise the screen");
	
		

		WebDriverWait wait = new WebDriverWait(driver, 30);// explicit wait
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("email_field"))));
		driver.findElement(By.id("email_field")).sendKeys("admin123@gmail.com");
		logger.log(LogStatus.PASS, "entered user name");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("password_field"))));
		driver.findElement(By.id("password_field")).sendKeys("admin123");
		logger.log(LogStatus.PASS, "entered password");
		
		driver.findElement(By.xpath("//button[contains(text(),'Login to Account')]")).click();
		logger.log(LogStatus.PASS, "login to account");
	
	logger.log(LogStatus.PASS, "closed the browser");
		
		//TakescreenShot :To acknowledge whether it is passed or failed.
		//always take screen shot for failed cases
		
		
        TakesScreenshot ts=((TakesScreenshot)driver);// synatx for taking screenshot
		
		File source=ts.getScreenshotAs(OutputType.FILE);//taken screenshot and saving it to source object
		
		String sPathofDestinationimage=System.getProperty("user.dir")+"//screenshot//1.png";
		
		File dest=new File(sPathofDestinationimage);
		
		FileUtils.copyFile(source, dest);
		
		logger.log(LogStatus.PASS, logger.addScreenCapture(sPathofDestinationimage));
		
		reports.endTest(logger);
		
		reports.flush();         //closes all the extent report object with proper shutdown
	
		System.out.println("Report done successfully");
		
		
		
	}
	
	
	
	
	
	
	
	
	

}
