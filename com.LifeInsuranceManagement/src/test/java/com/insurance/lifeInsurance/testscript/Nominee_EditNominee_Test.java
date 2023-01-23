package com.insurance.lifeInsurance.testscript;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.LifeInsurance.GenericUtilities.ExcelUtilityClass;
import com.LifeInsurance.GenericUtilities.FileUtility;
import com.LifeInsurance.GenericUtilities.WebDriverUtility;

public class Nominee_EditNominee_Test {
	public static void main(String[] args) throws Throwable {
		// Step1: Get Common Data
				FileUtility f=new FileUtility();
				String Url = f.getPropertyData("url");
				String Username = f.getPropertyData("username");
				String Password = f.getPropertyData("password");
				
				// Step2: Read Excel(test) Data
				ExcelUtilityClass e=new ExcelUtilityClass();
				
				// Step3: Login To Application
				WebDriver driver=new ChromeDriver();
				WebDriverUtility w=new WebDriverUtility();
				w.maximizeWindow(driver);
				w.waitForPageLaod(driver);
				driver.get(Url);
				driver.findElement(By.name("username")).sendKeys(Username);
				driver.findElement(By.name("password")).sendKeys(Password);
				driver.findElement(By.xpath("//button[.='login']")).click();
				
				
				//Step4: Navigate to Nominee page
				driver.findElement(By.xpath("//a[text()='NOMINEE']")).click();
				
				//Step5: Navigate to Client Status
				String value  = e.getExcelData("EditNominee1", 0, 1);
				driver.findElement(By.xpath("//td[text()='"+value+"']/following-sibling::td[7]/child::a")).click();
				
				
				//Step6: Click on Edit link
				driver.findElement(By.xpath("//a[text()='Edit']")).click();
				
				//Step7: Editing Fields
				 HashMap<String, String> m = e.getList("EditNominee", 0, 1);
				 for(Entry<String, String> entry:m.entrySet()) {
					 String key = entry.getKey();
					String val=entry.getValue();
					driver.findElement(By.name(key)).clear();
				driver.findElement(By.name(key)).sendKeys(val);
				 }
				
				//Step8: Clicking Update Button
	
				driver.findElement(By.xpath("//input[@value='UPDATE']")).click();
				
				
				//step9 : Check Client added or Not
					String actData = driver.findElement(By.xpath("//div[@class='col-md-12']")).getText();
					
					/*String expdata="Record updated successfully";
					Assert.assertEquals(actData, expdata);
				System.out.println(actData);*/
					
				if(actData.contains("Record Updated"))
				{
				System.out.println("Nominee Record Edited successfully");
				}
				else 
				{
				System.out.println("Nominee Record Not Updated");
				}
					
					// step10 : Logout from Application
					
					  driver.findElement(By.xpath("//a[@title='Logout']")).click();
					  driver.close();
			
	}




}
