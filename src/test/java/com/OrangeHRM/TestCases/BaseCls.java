package com.OrangeHRM.TestCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.OrangeHRM.Utilities.ExtentReportCls;
import com.OrangeHRM.Utilities.ReadConfig;

public class BaseCls {

	//---------WebDriver--------
	public static WebDriver driver;
	
	//-------Get the data from properties file-------
	public static String url;
	public static String username;
	public static String password;
	
	//-------------Initialize extent report and calling
	ExtentReportCls extentreport;
	
	@BeforeSuite(alwaysRun = true)
	public void befSuite() {
		System.out.println("This is before suite");
		extentreport=new ExtentReportCls();
		extentreport.startExtent();
	}
	
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws InterruptedException, IOException {
		
		ReadConfig readconfig = new ReadConfig();
		url= readconfig.url();
		username=readconfig.uname();
		password=readconfig.pwd();
		
		
		driver=new ChromeDriver();
		driver.get(url);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) {
		//driver.close();
		if(result.getStatus()==ITestResult.SUCCESS) {
			System.out.println("Test case is  passed");
			
		}
		if(result.getStatus()==ITestResult.FAILURE) {
			System.out.println("Test case is failed");
			extentreport.addErrorOnFailure(driver);
			//screenshot
		}
	}
	
	@AfterSuite(alwaysRun = true)
	public void aftSuite() {
		System.out.println("This is after suite");
		extentreport.endExtent();
	}
}
