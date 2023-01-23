package com.insurance.lifeInsurance.testscript;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.LifeInsurance.GenericUtilities.BaseClass;
import com.LifeInsurance.ObjectRepo.AddClientPage;
import com.LifeInsurance.ObjectRepo.ClientsPage;
import com.LifeInsurance.ObjectRepo.HomePage;

@Listeners(com.LifeInsurance.GenericUtilities.LisImpClass.class)

public class Client_AddClient_Annotation_Test extends BaseClass {
	@Test //(retryAnalyzer = com.LifeInsurance.GenericUtilities.RetryImpclass.class)
	public void addClient() throws Throwable {
		
			
			//Step2: Read Excel Data
			
			String pwd=elib.getExcelData("AddClient", 0, 1);
			String nam=elib.getExcelData("AddClient", 1, 1);
			String img=elib.getExcelData("AddClient", 2, 1);
			String gen=elib.getExcelData("AddClient", 3, 1);
			String birth=elib.getExcelData("AddClient", 4, 1);
			String mar=elib.getExcelData("AddClient", 16, 1);
			String nd=elib.getExcelData("AddClient", 5, 1);
			String phn=elib.getExcelData("AddClient", 6, 1);
			String add=elib.getExcelData("AddClient", 7, 1);
			String pid=elib.getExcelData("AddClient", 8, 1);
			String nomn=elib.getExcelData("AddClient", 9, 1);
			String nomg=elib.getExcelData("AddClient", 10, 1);
			String nomb=elib.getExcelData("AddClient", 11, 1);
			String nomni=elib.getExcelData("AddClient", 12, 1);
			String nomr=elib.getExcelData("AddClient", 13, 1);
			String prio=elib.getExcelData("AddClient", 14, 1);
			String nomp=elib.getExcelData("AddClient", 15, 1);
			
			// e.getExcelData("AddClient", 0, 1);
			
			// Login To Application
			
			
			// Navigate to client Module
			HomePage hp=new HomePage(driver);
			hp.getClientsLink().click();
			
			// Navigate to Add Client button
			ClientsPage cp=new ClientsPage(driver);
			cp.getAddCltLnk().click();
			
			// Entering Data on AddClientPage
			AddClientPage acp=new AddClientPage(driver);
			Assert.fail();
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
				
	}		

}
