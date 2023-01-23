package com.LifeInsurance.GenericUtilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.LifeInsurance.ObjectRepo.HomePage;
import com.LifeInsurance.ObjectRepo.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public  WebDriver driver;
	public static WebDriver sdriver;
	public DatabaseUtility dlib=new DatabaseUtility();
	public ExcelUtilityClass elib=new ExcelUtilityClass();
	public FileUtility flib=new FileUtility();
	public WebDriverUtility wlib=new WebDriverUtility();
	public JavaUtility jlib=new JavaUtility();
	
	@BeforeSuite
	public void configDB() throws Throwable {
		//dlib.connectToDB();
		System.out.println("----Connect to DB---");
	}
	
	//@Parameters("Browser")
	@BeforeClass(groups= {"Smoke","Regression"})
	public void configBc() throws Throwable {
		//WebDriverManager.firefoxdriver().setup();
		//driver=new FirefoxDriver();
		String Browser=flib.getPropertyData("browser");
		String Url=flib.getPropertyData("url");
		
		if(Browser.equalsIgnoreCase("Chrome")) {
			//WebDriverManager.firefoxdriver().setup();
			driver=new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("Firefox")) {
			//WebDriverManager.chromedriver().setup();
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("Invalid Browser");
		}
		sdriver=driver;
		wlib.maximizeWindow(driver);
		wlib.waitForPageLaod(driver);
		driver.get(Url);
		System.out.println("---Launch the Browser--");
	}
	
	@BeforeMethod
	public void configBM() throws Throwable {
		String Username=flib.getPropertyData("username");
		String Password=flib.getPropertyData("password");
		
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(Username, Password);
		System.out.println("---Login To Application");
		
	}
	
	@AfterMethod
	public void configAM() {
		HomePage hp=new HomePage(driver);
		hp.logout();
		System.out.println("--Logout From The Application");
	}
	
	@AfterClass
	public void configAC() {
		driver.quit();
		System.out.println("---Close The Browser");
	}
	
	@AfterSuite
	public void disconnectDB() throws Throwable {
		//dlib.closeDB();
		System.out.println("--Disconnected from DB");
	}

}
