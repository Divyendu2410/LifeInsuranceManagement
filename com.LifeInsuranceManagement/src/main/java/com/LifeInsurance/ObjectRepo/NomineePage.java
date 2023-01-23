package com.LifeInsurance.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NomineePage {
	// Declaration
	
	@FindBy(linkText ="Add Nominee")
	private WebElement AddNomlink;
	
	//initialization
	
	public NomineePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	

	// Utilization
	public WebElement getAddNomlink() {
		return AddNomlink;
	}
	
	public void clientStatusLink(WebDriver driver,String client_id) {
	driver.findElement(By.xpath("//td[text()='"+client_id+"']/following-sibling::td[7]/child::a")).click();
		
	}

}
