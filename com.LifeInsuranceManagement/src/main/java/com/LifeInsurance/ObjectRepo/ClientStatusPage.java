package com.LifeInsurance.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClientStatusPage {
	
	public ClientStatusPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	// Declaration
	
	@FindBy(xpath="//a[text()='Edit']")
	private WebElement EditLnk;

	
	// Utilization
	public void clickEdit(WebDriver driver) {
		EditLnk.click();
	}

}
