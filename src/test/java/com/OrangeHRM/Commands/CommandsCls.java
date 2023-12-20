package com.OrangeHRM.Commands;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;



public class CommandsCls {
	public WebDriver driver;
	public final static Logger logger = LogManager.getLogger("rootLogger");
	
	public CommandsCls(WebDriver driver) {
		this.driver=driver;

	}
	public void click(By bylocator) throws InterruptedException {
		try {
			Thread.sleep(3000);
			driver.findElement(bylocator).click();
			logger.info("clicked on :"+bylocator);
		}catch (Exception e) {
			logger.error(e.getMessage());
			Assert.fail();
		}
		
	}

	public void sendKeys(By bylocator,String value) throws InterruptedException {
		try {
			Thread.sleep(2000);
			driver.findElement(bylocator).sendKeys(value);
			logger.info("Enter the value : "+" "+value+" "+"in : "+bylocator);
			
		}catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage());
			Assert.fail();
		}


	}
	public String  getTitle() {
		String actualtitle="";
		try {
			 actualtitle=driver.getTitle();
			 logger.info("Actual Title is: "+actualtitle);
			
		}catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage());
			Assert.fail();
		}
		return actualtitle;

	}
	public void validate(String actual,String expected) {
		
		try {
			Assert.assertEquals(actual, expected);
			
			logger.info("Validation passed");
		}catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage());
			Assert.fail();
		}
		

	}
	
	public String getText(By bylocator) {
		
		String actualuivalue="";
			
		try {
			 actualuivalue=driver.findElement(bylocator).getText();
			 logger.info("actualuivalue is  :"+actualuivalue);
		}catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage());
			Assert.fail();
		}
		
		return actualuivalue;
	}
	
	public void scrollDown(String scrollvalue) {
		
		try {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,"+scrollvalue+")");
			logger.info("Scroll down");
		}catch (Exception e) {
			// TODO: handle exception
			logger.error("Scroll down failed");
		}

	}

	public void explicitWait(By bylocator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(bylocator)));
	}
	
	
}