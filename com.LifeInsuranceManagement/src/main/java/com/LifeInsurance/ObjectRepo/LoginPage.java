package com.LifeInsurance.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//Rule 1: Create a separate java class for every page in application

	public LoginPage(WebDriver driver) {
		//Rule 3: Execute all the elements & initialize the elements PageFactory.initElements [initialization]
		PageFactory.initElements(driver, this);
		}
	@FindBy(name="username")
	//Rule 2: Identify all the elements using @findBy & findBys ,findAll (Declaration)
	private WebElement userNameTbx;
	
	@FindBy(name="password")
	private WebElement passwordTbx;
	
	@FindBy(xpath ="//button[.='login']")
	private WebElement lgBtn;
	//Rule 4: Declare all the elements as private & provide getters method, business method for (Utilization)

	public WebElement getUserNameTbx() {
		return userNameTbx;
	}

	public WebElement getPasswordTbx() {
		return passwordTbx;
	}

	public WebElement getLgBtn() {
		return lgBtn;
	}
	

	public void loginToApp(String userName,String password) {
		// Step 1: Login To Application
	userNameTbx.sendKeys(userName);
	passwordTbx.sendKeys(password);
	lgBtn.click();
		}

}
