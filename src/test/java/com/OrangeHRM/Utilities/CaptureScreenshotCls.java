package com.OrangeHRM.Utilities;

import java.util.Base64;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreenshotCls {

	public String takesnapShotOnFailure(WebDriver driver) {
		byte[] screenshotInBytes= ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		  String base64screenshot=Base64.getEncoder().encodeToString(screenshotInBytes);
		  return base64screenshot;
	}
}
