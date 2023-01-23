package com.PracticePackage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DiffAnnotations {
	@BeforeClass
	public void launchBrowser() {
		System.out.println("-----Launch the Browser");
	}

	@BeforeMethod
	public void login() {
		System.out.println("-----Login to Application");
	}
	
	@Test
	public void intro() {
		System.out.println("It's me Dev");
	}
	
	@AfterMethod
	public void logout() {
		System.out.println("----Logout to Application");
	}
	
	@Test()
	public void display() {
		System.out.println("Am Hungry Rightnow");
	}
	
	@AfterClass
	public void closeBrowser() {
		System.out.println("---Close the Browser");
	}
	
}
