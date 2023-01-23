package com.insurance.lifeInsurance.testscript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.LifeInsurance.GenericUtilities.ExcelUtilityClass;
import com.LifeInsurance.GenericUtilities.FileUtility;
import com.LifeInsurance.GenericUtilities.WebDriverUtility;

public class Payment_DeletePayment_Test {
	public static void main(String[] args) throws Throwable  {
		// step1 : Get Common Data
		/*FileInputStream fis=new FileInputStream("./src/test/resources/CommonData.properties");
		Properties p=new Properties();
		p.load(fis);
		String Url= p.getProperty("url");
		String Username = p.getProperty("username");
		String Password = p.getProperty("password");*/
		FileUtility f=new FileUtility();
		String Url = f.getPropertyData("url");
		String Username = f.getPropertyData("username");
		String Password = f.getPropertyData("password");
		
		// step2 : Read Data From Excel sheet
		/*FileInputStream fiss=new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fiss);
		Sheet s = wb.getSheet("Delete_Payments");*/
		ExcelUtilityClass e=new ExcelUtilityClass();
		String v = e.getExcelData("Delete_Payments", 0, 1);
		
		
		// step3 : Login To Application
		//WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		//driver.manage().window().maximize();
		WebDriverUtility w=new WebDriverUtility();
		w.maximizeWindow(driver);
		//driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		w.waitForPageLaod(driver);
		driver.get(Url);
		driver.findElement(By.name("username")).sendKeys(Username);
		driver.findElement(By.name("password")).sendKeys(Password);
		driver.findElement(By.xpath("//button[.='login']")).click();
		driver.findElement(By.linkText("PAYMENTS")).click();
		String value  = e.getExcelData("Delete_Payments", 0, 1);
		driver.findElement(By.xpath("//td[text()='"+value+"']/following-sibling::td[6]/child::a")).click();
		driver.findElement(By.name("recipt_no")).sendKeys(value);
		driver.findElement(By.linkText("Delete Payment")).click();
		
		// step4 : Check Payment Deleted or Not
		String actData = driver.findElement(By.xpath("//div[@class='col-md-12']")).getText();
		if(actData.contains("Record deleted"))
		{
		System.out.println("Record deleted successfully");
		}
		else 
		{
		System.out.println("Payment not deleted");
		}
		
		// step5 : Logout from Application
		  driver.findElement(By.xpath("//a[@title='Logout']")).click();
		  driver.close();
		

	}



}
