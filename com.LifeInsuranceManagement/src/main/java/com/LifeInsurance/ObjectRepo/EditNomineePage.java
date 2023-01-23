package com.LifeInsurance.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditNomineePage {
	//declaration
	
	@FindBy(name="nominee_id")
	private WebElement nomIdTbx;
		
		@FindBy(name = "client_id")
		private WebElement clientIdTbx;
		
		@FindBy(name = "name")
		private WebElement nameTbx;
		
		@FindBy(name = "sex")
		private WebElement genderTbx;
		
		@FindBy(name = "birth_date")
		private WebElement birthDateTbx;
		
		@FindBy(name = "nid")
		private WebElement nidTbx;
		
		@FindBy(name="relationship")
		private WebElement relationTbx;
		
		@FindBy(name="priority")
		private WebElement priorityTbx;
		
		@FindBy(name="phone")
		private WebElement phnTbx;
		
		@FindBy(xpath = "//input[@type='submit']")
		private WebElement updateBtn;
		
		//initialization
		
		public EditNomineePage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		//utilization

		public WebElement getNomIdTbx() {
			return nomIdTbx;
		}

		public WebElement getClientIdTbx() {
			return clientIdTbx;
		}

		public WebElement getNameTbx() {
			return nameTbx;
		}

		public WebElement getGenderTbx() {
			return genderTbx;
		}

		public WebElement getBirthDateTbx() {
			return birthDateTbx;
		}

		public WebElement getNidTbx() {
			return nidTbx;
		}

		public WebElement getRelationTbx() {
			return relationTbx;
		}

		public WebElement getPriorityTbx() {
			return priorityTbx;
		}

		public WebElement getPhnTbx() {
			return phnTbx;
		}

		public WebElement getUpdateBtn() {
			return updateBtn;
		}

		public void setEditNominee(String name,String gender,String birthd,String nid,String relation,String prior,String phn) {
			
			nameTbx.clear();
			nameTbx.sendKeys(name);
			genderTbx.clear();
			genderTbx.sendKeys(gender);
			birthDateTbx.clear();
			birthDateTbx.sendKeys(birthd);
			nidTbx.clear();
			nidTbx.sendKeys(nid);
			relationTbx.clear();
			relationTbx.sendKeys(relation);
			priorityTbx.clear();
			priorityTbx.sendKeys(prior);
			phnTbx.clear();
			phnTbx.sendKeys(phn);
			
			
			
			
			
			
		}
		
	}



