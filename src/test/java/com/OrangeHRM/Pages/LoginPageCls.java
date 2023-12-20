package com.OrangeHRM.Pages;

import org.openqa.selenium.WebDriver;

import com.OrangeHRM.Commands.CommandsCls;
import com.OrangeHRM.Objects.ObjectsCls;
import com.OrangeHRM.Utilities.ExtentReportCls;

public class LoginPageCls extends CommandsCls {

	ExtentReportCls extentreport;
	public LoginPageCls(WebDriver driver) {
		super(driver);	
		extentreport=new ExtentReportCls();
	}
	
	public void loginWithValidCredentials(String username, String password, String expectedtitle) throws InterruptedException {
		sendKeys(ObjectsCls.username, username);
		extentreport.addlogs("Enetered username: "+username);
		sendKeys(ObjectsCls.password, password);
		extentreport.addlogs("Entered password: "+password);
		click(ObjectsCls.login_button);
		extentreport.addlogs("Clicked on login button");
		String actualtitle=getTitle();
		validate(actualtitle, expectedtitle);
		extentreport.addlogs("validated the title: "+expectedtitle);
	}
	
	public void loginWithInvalidCredentials(String username, String wrongpassword, String expectederror) throws InterruptedException {
		sendKeys(ObjectsCls.username, username);
		extentreport.addlogs("Enetered username: "+username);
		sendKeys(ObjectsCls.password, wrongpassword);
		extentreport.addlogs("Entered password: "+wrongpassword);
		click(ObjectsCls.login_button);
		extentreport.addlogs("Clicked on login button");
		Thread.sleep(5000);
		String actualerror= getText(ObjectsCls.invalidlogin_error);
		validate(actualerror, expectederror);
		extentreport.addlogs("Verified the error : "+expectederror);
	}
	
}
