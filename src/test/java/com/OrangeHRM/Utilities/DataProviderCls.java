package com.OrangeHRM.Utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderCls {

	@DataProvider
	public String[][] testDataTC_003() throws IOException {
		ReadExcelCls readtestdata=new ReadExcelCls();
		String[][] data=readtestdata.getTestData("./Configuration/AddUserTestData.xlsx");
		return data;
	}
	
	
	@DataProvider
	public String[][] testDataTC_004() throws IOException {
		ReadExcelCls readtestdata=new ReadExcelCls();
		String[][] data=readtestdata.getTestData("./Configuration/AddUserTestData.xlsx");
		return data;
	}
	
	@DataProvider
	public String[][] testDataTC_005() throws IOException {
		ReadExcelCls readtestdata=new ReadExcelCls();
		String[][] data=readtestdata.getTestData("./Configuration/registrationtestdata.xlsx");
		return data;
	}
	
	
	
}
