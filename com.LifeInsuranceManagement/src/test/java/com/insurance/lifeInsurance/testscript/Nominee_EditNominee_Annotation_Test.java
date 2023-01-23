package com.insurance.lifeInsurance.testscript;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.LifeInsurance.GenericUtilities.BaseClass;
import com.LifeInsurance.ObjectRepo.ClientStatusPage;
import com.LifeInsurance.ObjectRepo.EditNomineePage;
import com.LifeInsurance.ObjectRepo.HomePage;
import com.LifeInsurance.ObjectRepo.NomineePage;

public class Nominee_EditNominee_Annotation_Test extends BaseClass{
	@Test
	public void editNominee() throws Throwable {
	// Step1: Get Common Data
	
	// Step2: Read Excel(test) Data

	String value  = elib.getExcelData("EditNominee1", 0, 1);
	String name=elib.getExcelData("EditNominee", 0, 1);
	String gender=elib.getExcelData("EditNominee", 1, 1);
	String birthd=elib.getExcelData("EditNominee", 2, 1);
	String nid=elib.getExcelData("EditNominee", 3, 1);
	String relation=elib.getExcelData("EditNominee", 4, 1);
	String prior=elib.getExcelData("EditNominee", 5, 1);
	String phn=elib.getExcelData("EditNominee", 6, 1);
	
	
	// Step3: Login To Application

	
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
		
	if(actData.contains("Record Updated"))
	{
	System.out.println("Nominee Record Edited successfully");
	}
	else 
	{
	System.out.println("Nominee Record Not Updated");
	}
		
		// step10 : Logout from Application
		
	}

}
