package com.OrangeHRM.Objects;

import org.openqa.selenium.By;

public class ObjectsCls {

	
	//---------Login Page Locators ------------
	public static By username= By.name("username");
	public static By password=By.name("password");
	public static By login_button=By.xpath("//button[@type='submit']");
	public static By invalidlogin_error=By.xpath("//div[@class='orangehrm-login-error']//div[@role='alert']//p");
	
	
	//-------Add User---------------------
	public static By menuitem_admin=By.xpath("//span[text()='Admin1']/..");
	public static By adduser_button=By.xpath("//button[text()=' Add ']");
	public static By userrole_click=By.xpath("(//label[text()='User Role']/../..//div)[2]//div[text()='-- Select --']");
	public static By selectuserrole=By.xpath("//*[text()='ESS']");
	public static By adduser_username=By.xpath("//label[text()='Username']/../following-sibling::div//input");
	public static By adduser_password=By.xpath("(//input[@type='password'])[1]");
	public static By adduser_confirmpassword=By.xpath("(//input[@type='password'])[2]");
	

	
}
