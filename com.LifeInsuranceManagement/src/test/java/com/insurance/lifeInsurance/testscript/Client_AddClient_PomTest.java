package com.insurance.lifeInsurance.testscript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.LifeInsurance.GenericUtilities.ExcelUtilityClass;
import com.LifeInsurance.GenericUtilities.FileUtility;
import com.LifeInsurance.GenericUtilities.WebDriverUtility;
import com.LifeInsurance.ObjectRepo.AddClientPage;
import com.LifeInsurance.ObjectRepo.ClientsPage;
import com.LifeInsurance.ObjectRepo.HomePage;
import com.LifeInsurance.ObjectRepo.LoginPage;

public class Client_AddClient_PomTest {
	public static void main(String[] args) throws Throwable {
		//Step1: Get Common Data
		FileUtility f=new FileUtility();
		String Url = f.getPropertyData("url");
		String Username = f.getPropertyData("username");
		String Password = f.getPropertyData("password");
		
		//Step2: Read Excel Data
		ExcelUtilityClass e=new ExcelUtilityClass();
		String pwd=e.getExcelData("AddClient", 0, 1);
		String nam=e.getExcelData("AddClient", 1, 1);
		String img=e.getExcelData("AddClient", 2, 1);
		String gen=e.getExcelData("AddClient", 3, 1);
		String birth=e.getExcelData("AddClient", 4, 1);
		String mar=e.getExcelData("AddClient", 16, 1);
		String nd=e.getExcelData("AddClient", 5, 1);
		String phn=e.getExcelData("AddClient", 6, 1);
		String add=e.getExcelData("AddClient", 7, 1);
		String pid=e.getExcelData("AddClient", 8, 1);
		String nomn=e.getExcelData("AddClient", 9, 1);
		String nomg=e.getExcelData("AddClient", 10, 1);
		String nomb=e.getExcelData("AddClient", 11, 1);
		String nomni=e.getExcelData("AddClient", 12, 1);
		String nomr=e.getExcelData("AddClient", 13, 1);
		String prio=e.getExcelData("AddClient", 14, 1);
		String nomp=e.getExcelData("AddClient", 15, 1);
		
		// e.getExcelData("AddClient", 0, 1);
		
		// Login To Application
		WebDriver driver=new ChromeDriver();
		WebDriverUtility w=new WebDriverUtility();
		w.maximizeWindow(driver);
		w.waitForPageLaod(driver);
		driver.get(Url);
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(Username, Password);
		
		// Navigate to client Module
		HomePage hp=new HomePage(driver);
		hp.getClientsLink().click();
		
		// Navigate to Add Client button
		ClientsPage cp=new ClientsPage(driver);
		cp.getAddCltLnk().click();
		
		// Entering Data on AddClientPage
		AddClientPage acp=new AddClientPage(driver);
		acp.addClientDetails(pwd, nam, img, gen, birth, mar, nd, phn, add, pid, nomn, nomg, nomb, nomni, nomr, prio, nomp);
		acp.getSubmitBtn().click();
		
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
			hp.logout();
		 driver.close();
			
	

}


}

