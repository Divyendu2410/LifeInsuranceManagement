package com.LifeInsurance.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;            // Global driver variable
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
		
		//declaration
		
		@FindBy(linkText = "CLIENTS")
		private WebElement clientsLink;
		
		@FindBy(linkText = "AGENTS")
		private WebElement agentsLink;
		
		@FindBy(linkText = "POLICY")
		private WebElement policyLink;
		
		@FindBy(linkText = "NOMINEE")
		private WebElement nomineeLink;
		
		@FindBy(linkText = "PAYMENTS")
		private WebElement paymentsLink;
		
		@FindBy(xpath = "//a[@title='Logout']")
		private WebElement logOutLink;

		//utilization

		public WebElement getClientsLink() {
			return clientsLink;
		}



		public WebElement getAgentsLink() {
			return agentsLink;
		}



		public WebElement getPolicyLink() {
			return policyLink;
		}



		public WebElement getNomineeLink() {
			return nomineeLink;
		}



		public WebElement getPaymentsLink() {
			return paymentsLink;
		}



		public WebElement getLogOutLink() {
			return logOutLink;
		}
		
		public void logout() {
			
			/*Actions a=new Actions(driver);
			a.moveToElement(logOutLink).perform();*/
			logOutLink.click();
			
		}

	}

	

