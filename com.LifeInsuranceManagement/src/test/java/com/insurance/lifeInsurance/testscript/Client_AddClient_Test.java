package com.insurance.lifeInsurance.testscript;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.LifeInsurance.GenericUtilities.ExcelUtilityClass;
import com.LifeInsurance.GenericUtilities.FileUtility;
import com.LifeInsurance.GenericUtilities.WebDriverUtility;


public class Client_AddClient_Test {
	public static void main(String[] args) throws Throwable {
		//Step1: Get Common Data
		FileUtility f=new FileUtility();
		String Url = f.getPropertyData("url");
		String Username = f.getPropertyData("username");
		String Password = f.getPropertyData("password");
		
		//Step2: Read Excel Data
		ExcelUtilityClass e=new ExcelUtilityClass();
		String v = e.getExcelData("AddClient", 0, 1);
		
		// Login To Application
		WebDriver driver=new ChromeDriver();
		WebDriverUtility w=new WebDriverUtility();
		w.maximizeWindow(driver);
		w.waitForPageLaod(driver);
		driver.get(Url);
		driver.findElement(By.name("username")).sendKeys(Username);
		driver.findElement(By.name("password")).sendKeys(Password);
		driver.findElement(By.xpath("//button[.='login']")).click();
		
		// Navigate to client Module
		driver.findElement(By.xpath("//a[text()='CLIENTS']")).click();
		
		// Navigate to Add Client button
		driver.findElement(By.xpath("//a[text()='Add Client']")).click();
		
		// Entering Data on AddClientPage
		
		driver.findElement(By.xpath("//input[@name='client_password']")).sendKeys(v);
		HashMap<String, String> m = e.getList("AddClient", 0, 1);
		for(Entry<String, String> entry:m.entrySet()) {
		String key = entry.getKey();
		String value = entry.getValue();
		driver.findElement(By.name(key)).sendKeys(value);
		}
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	
	//step4 : Check Client added or Not
			String actData = driver.findElement(By.xpath("//div[@class='col-md-12']")).getText();
			if(actData.contains("New Client"))
			{
			System.out.println("New Client Added successfully");
			}
			else 
			{
			System.out.println("Client not Added");
			}
			
			// step5 : Logout from Application
			
			 driver.findElement(By.xpath("//a[@title='Logout']")).click();
			 driver.close();
			
	

}


}
