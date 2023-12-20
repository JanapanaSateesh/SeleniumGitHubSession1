package com.OrangeHRM.Pages;

import org.openqa.selenium.WebDriver;

import com.OrangeHRM.Commands.CommandsCls;
import com.OrangeHRM.Objects.ObjectsCls;
import com.OrangeHRM.Utilities.ExtentReportCls;

public class AddUserPageCls extends CommandsCls{

	ExtentReportCls extentreport;
	public AddUserPageCls(WebDriver driver) {
		
		super(driver);	
		extentreport=new ExtentReportCls();
	}
	
	public void addUser(String username, String password, String addusername, String addpassword, String addconfirmpassword) throws InterruptedException {
		sendKeys(ObjectsCls.username, username);
		extentreport.addlogs("Enetered username: "+username);
		sendKeys(ObjectsCls.password, password);
		extentreport.addlogs("Entered password: "+password);
		click(ObjectsCls.login_button);
		extentreport.addlogs("Clicked on login button");
	
		click(ObjectsCls.menuitem_admin);
		extentreport.addlogs("Clicked on menu item Admin");

		explicitWait(ObjectsCls.adduser_button);
		click(ObjectsCls.adduser_button);
		extentreport.addlogs("Clicked on add user button");

		click(ObjectsCls.userrole_click);

		click(ObjectsCls.selectuserrole);
		extentreport.addlogs("selected the user role ESS");

		
		
		sendKeys(ObjectsCls.adduser_username, addusername);
		extentreport.addlogs("Provided the username: "+addusername);
		sendKeys(ObjectsCls.adduser_password, addpassword);
		extentreport.addlogs("Provided the password: "+addpassword);
		sendKeys(ObjectsCls.adduser_confirmpassword, addconfirmpassword);
		extentreport.addlogs("Provided the confirm password: "+addconfirmpassword);

		
		
	}
}
