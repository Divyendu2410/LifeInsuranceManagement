package com.PracticePackage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.LifeInsurance.GenericUtilities.ExcelUtilityClass;

public class DataProviderTest {

	@Test(dataProvider="getData")
	
	public void readData(String from,String to) {
		System.out.println(from+"---->"+to);
	}
	
	@DataProvider
	public Object[][] getData() throws Throwable{
		ExcelUtilityClass elib=new ExcelUtilityClass();
		Object[][] value = elib.readMultipleSetOfData("DataProvider");
		return value;
	}
}
