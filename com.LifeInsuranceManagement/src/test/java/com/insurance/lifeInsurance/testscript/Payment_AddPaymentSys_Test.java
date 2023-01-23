package com.insurance.lifeInsurance.testscript;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Payment_AddPaymentSys_Test {
	public static void main(String[] args) throws Throwable {
		// step1 : Get Common Data
				FileInputStream fis=new FileInputStream("./src/test/resources/CommonData.properties");
				Properties p=new Properties();
				p.load(fis);
				String Url= p.getProperty("url");
				String Username = p.getProperty("username");
				String Password = p.getProperty("password");
				
				// step2 : Read Data From Excel sheet
				FileInputStream fiss=new FileInputStream("./src/test/resources/TestData.xlsx");
				Workbook wb=WorkbookFactory.create(fiss);
		Sheet sh = wb.getSheet("PaymentDetails");
		Sheet sh1 = wb.getSheet("PaymentDetails2");
		
		// step 3: Launch the browser
		
        //WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Url);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		
		// step 4: Login to application
		driver.findElement(By.name("username")).sendKeys(Username);
		driver.findElement(By.name("password")).sendKeys(Password);
		driver.findElement(By.xpath("//button[text()='login']")).click();
		
		// step 5: click on Payments tab
		driver.findElement(By.linkText("PAYMENTS")).click();
		
		// step 6: add payment details
		driver.findElement(By.linkText("Add Payment")).click();
		Thread.sleep(1000);
		
		ArrayList<String> list=new ArrayList<String>();
		list.add("client_id");
		list.add("month");
		list.add("amount");
		list.add("due");
		list.add("fine");
		
		for(int i=0;i<list.size();i++)
		{
			String value=sh.getRow(i).getCell(1).getStringCellValue();
			driver.findElement(By.name(list.get(i))).sendKeys(value);
			
		}
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(1000);
        
		// step 7: check new payment is added successfully 
		String actualData = driver.findElement(By.xpath("//div[@class='col-md-12']")).getText();
		if(actualData.contains("New Payment"))
		{
			System.out.println("New Payment Added.");
		}
		else
		{
			System.out.println("Payment not added.");
		}
		
		// again add payment
		
		driver.findElement(By.linkText("Add Payment")).click();
		
		ArrayList<String> list1=new ArrayList<String>();
		list1.add("client_id");
		list1.add("month");
		list1.add("amount");
		list1.add("due");
		list1.add("fine");
		
		for(int j=0;j<list1.size();j++)
		{
			String value1=sh1.getRow(j).getCell(1).getStringCellValue();
			driver.findElement(By.name(list1.get(j))).sendKeys(value1);
			
		}
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		// step 7: check new payment is added successfully 
		String actualData1 = driver.findElement(By.xpath("//div[@class='col-md-12']")).getText();
		if(actualData1.contains("New Payment"))
		{
			System.out.println("New Payment Added.");
		}
		else
		{
			System.out.println("Payment not added.");
		}
		
		
		// step 8: logout from the app
		WebElement logout = driver.findElement(By.xpath("//a[@title='Logout']"));
		
		Actions a=new Actions(driver);
		a.moveToElement(logout);
		logout.click();
		
		// step 9: close the browser
		driver.close();
	


	}



}
