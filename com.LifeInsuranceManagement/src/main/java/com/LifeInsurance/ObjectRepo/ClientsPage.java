package com.LifeInsurance.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClientsPage {

	//Declaration
@FindBy(xpath="//a[text()='Add Client']")
private WebElement addCltLnk;

//Initialization
public ClientsPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

//Utilization
public WebElement getAddCltLnk() {
	return addCltLnk;
}

}
