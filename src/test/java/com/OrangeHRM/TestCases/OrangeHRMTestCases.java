package com.OrangeHRM.TestCases;

import java.io.IOException;

import org.testng.annotations.*;

import com.OrangeHRM.Pages.AddUserPageCls;
import com.OrangeHRM.Pages.LoginPageCls;
import com.OrangeHRM.Utilities.DataProviderCls;
import com.OrangeHRM.Utilities.ReadExcelCls;

public class OrangeHRMTestCases extends BaseCls{

	
	public LoginPageCls loginpage;
	
	
	
	@Test(priority = 1, enabled = true, groups = {"smoke"})
	public void loginWithValidCredentialsTC_001() throws InterruptedException {
		extentreport.createTest("TC_001 Login With ValidCredentials");
		
		 loginpage=new LoginPageCls(driver);
		loginpage.loginWithValidCredentials(username, password,"OrangeHRM");
	}
	
	
	@Test(priority = 2, enabled = true,groups = {"smoke"})
	public void loginWithInvalidCredentialsTC_002() throws InterruptedException {
		extentreport.createTest("TC_002 Login With InValidCredentials");
		loginpage=new LoginPageCls(driver);
		loginpage.loginWithInvalidCredentials(username, "12345", "Invalid credentials");
	}
	
	@Test(priority = 3, enabled = true, groups = {"regression"},dataProvider = "testDataTC_003", dataProviderClass = DataProviderCls.class)
	public void addUserTC_003(String usernametestdata, String passwordtestdata, String confirmpassword) throws InterruptedException {
		extentreport.createTest("TC_003 Add User");
		
		AddUserPageCls adduserpage=  new AddUserPageCls(driver);
		adduserpage.addUser(username, password, usernametestdata, passwordtestdata, confirmpassword);
	}
	
	@Test(priority = 4, enabled = true,groups = {"sanity"} ,dataProvider = "testDataTC_004", dataProviderClass = DataProviderCls.class)
	public void addUserTC_004(String usernametestdata, String passwordtestdata, String confirmpassword) throws InterruptedException {
		extentreport.createTest("TC_004 AddUser");
		
		AddUserPageCls adduserpage=  new AddUserPageCls(driver);
		adduserpage.addUser(username, password, usernametestdata, passwordtestdata, confirmpassword);
	}
	


	
}
