package com.insurance.lifeInsurance.testscript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.LifeInsurance.GenericUtilities.ExcelUtilityClass;
import com.LifeInsurance.GenericUtilities.FileUtility;
import com.LifeInsurance.GenericUtilities.WebDriverUtility;
import com.LifeInsurance.ObjectRepo.ClientStatusPage;
import com.LifeInsurance.ObjectRepo.EditNomineePage;
import com.LifeInsurance.ObjectRepo.HomePage;
import com.LifeInsurance.ObjectRepo.LoginPage;
import com.LifeInsurance.ObjectRepo.NomineePage;

public class Nominee_EditNominee_PomTest {

	public static void main(String[] args) throws Throwable {
		// Step1: Get Common Data
				FileUtility f=new FileUtility();
				String Url = f.getPropertyData("url");
				String Username = f.getPropertyData("username");
				String Password = f.getPropertyData("password");
				
				// Step2: Read Excel(test) Data
				ExcelUtilityClass e=new ExcelUtilityClass();
				String value  = e.getExcelData("EditNominee1", 0, 1);
				String name=e.getExcelData("EditNominee", 0, 1);
				String gender=e.getExcelData("EditNominee", 1, 1);
				String birthd=e.getExcelData("EditNominee", 2, 1);
				String nid=e.getExcelData("EditNominee", 3, 1);
				String relation=e.getExcelData("EditNominee", 4, 1);
				String prior=e.getExcelData("EditNominee", 5, 1);
				String phn=e.getExcelData("EditNominee", 6, 1);
				
				
				// Step3: Login To Application
				WebDriver driver=new ChromeDriver();
				WebDriverUtility w=new WebDriverUtility();
				w.maximizeWindow(driver);
				w.waitForPageLaod(driver);
				driver.get(Url);
				LoginPage lp=new LoginPage(driver);
				lp.loginToApp(Username, Password);
				
				//Step4: Navigate to Nominee page
				HomePage hp=new HomePage(driver);
				hp.getNomineeLink().click();
				
				//Step5: Navigate to Client Status
				NomineePage np=new NomineePage(driver);
				np.clientStatusLink(driver, value);
				
				//Step6: Click on Edit link
				ClientStatusPage cp=new ClientStatusPage(driver);
				cp.clickEdit(driver);
				
				//Step7: Editing Fields
				EditNomineePage enp=new EditNomineePage(driver);
				enp.setEditNominee(name, gender, birthd, nid, relation, prior, phn);
				
				//Step8: Clicking Update Button
	
				enp.getUpdateBtn().click();
				
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
					
					  hp.logout();
					  driver.close();
			
	}



}
