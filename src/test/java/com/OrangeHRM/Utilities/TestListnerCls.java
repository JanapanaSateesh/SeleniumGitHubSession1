package com.OrangeHRM.Utilities;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestListnerCls implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test Case :"+result.getName()+" "+"is started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Case :"+result.getName()+" "+"is success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Case :"+result.getName()+" "+"is failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Case :"+result.getName()+" "+"is skipped");
	}

}
