package com.OrangeHRM.Utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportCls {

	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentSparkReporter spark;
	public static CaptureScreenshotCls screencapturing;
	public WebDriver driver;
	
	public void startExtent() {
		
		
	/*	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
		LocalDateTime now = LocalDateTime.now();
		String date = dtf.format(now).toString();
	*/
		
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("./Reports/OrangeHRMReport.html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("OrangeHRM Summary Report");
		extent.attachReporter(spark);
	}
	
	public void endExtent() {
		extent.flush();
	}
	
	public void createTest(String scenarioname) {
		test = extent.createTest(scenarioname).assignAuthor("Sateesh").assignCategory("Web Testing");
	}
	
	public void addlogs(String log) {
		
		test.info(log);
	}
	
	public void addErrorOnFailure(WebDriver driver) {
		this.driver=driver;	
		
		test.fail("Failed");
		screencapturing= new CaptureScreenshotCls();
		String baseimg=screencapturing.takesnapShotOnFailure(driver);
		test.addScreenCaptureFromBase64String(baseimg);		
	}
}
