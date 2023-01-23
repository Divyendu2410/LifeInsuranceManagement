package com.LifeInsurance.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddClientPage {
	//declaration
	
		@FindBy(name="client_password")
		private WebElement clientPwdTbx;
			
			@FindBy(name = "name")
			private WebElement nameTbx;
			
			@FindBy(name="fileToUpload")
			private WebElement imgBtn;
			
			@FindBy(name = "sex")
			private WebElement genderTbx;
			
			@FindBy(name = "birth_date")
			private WebElement birthDateTbx;
			
			@FindBy(name="maritial_status")
			private WebElement martialTbx;
			
			@FindBy(name ="nid")
			private WebElement nidTbx;
			
			@FindBy(name="phone")
			private WebElement phnnTbx;
			
			@FindBy(name="address")
			private WebElement addTbx;
		
			@FindBy(name="policy_id")
			private WebElement pidTbx;
			
			@FindBy(name="nominee_name")
			private WebElement nomnameTbx;
			
			@FindBy(name="nominee_sex")
			private WebElement nomgenderTbx;
			
			@FindBy(name="nominee_birth_date")
			private WebElement nombirthTbx;
			
			@FindBy(name="nominee_nid")
			private WebElement nomnidTbx;
			
			@FindBy(name="nominee_relationship")
			private WebElement nomrelationTbx;
			
			@FindBy(name="priority")
			private WebElement priorityTbx;
			
			@FindBy(name="nominee_phone")
			private WebElement nomphnTbx;
			
			@FindBy(xpath = "//input[@type='submit']")
			private WebElement submitBtn;
			
			//initialization
			
			public AddClientPage(WebDriver driver)
			{
				PageFactory.initElements(driver, this);
			}

			//Utilization
			
			public WebElement getClientPwdTbx() {
				return clientPwdTbx;
			}

			public WebElement getNameTbx() {
				return nameTbx;
			}

			public WebElement getImgBtn() {
				return imgBtn;
			}

			public WebElement getGenderTbx() {
				return genderTbx;
			}

			public WebElement getBirthDateTbx() {
				return birthDateTbx;
			}

			public WebElement getMartialTbx() {
				return martialTbx;
			}

			public WebElement getNidTbx() {
				return nidTbx;
			}

			public WebElement getPhnnTbx() {
				return phnnTbx;
			}

			public WebElement getAddTbx() {
				return addTbx;
			}

			public WebElement getPidTbx() {
				return pidTbx;
			}

			public WebElement getNomnameTbx() {
				return nomnameTbx;
			}

			public WebElement getNomgenderTbx() {
				return nomgenderTbx;
			}

			public WebElement getNombirthTbx() {
				return nombirthTbx;
			}

			public WebElement getNomnidTbx() {
				return nomnidTbx;
			}

			public WebElement getNomrelationTbx() {
				return nomrelationTbx;
			}

			public WebElement getPriorityTbx() {
				return priorityTbx;
			}

			public WebElement getNomphnTbx() {
				return nomphnTbx;
			}

			public WebElement getSubmitBtn() {
				return submitBtn;
			}
			
			public void addClientDetails(String pwd,String nam,String img,String gen,String birth,String mar,String nd,String phn,String add,String pid,String nomn,String nomg,String nomb,String nomni,String nomr,String prio,String nomp){
				clientPwdTbx.sendKeys(pwd);
				nameTbx.sendKeys(nam);
				imgBtn.sendKeys(img);
				genderTbx.sendKeys(gen);
				birthDateTbx.sendKeys(birth);
				martialTbx.sendKeys(mar);
				nidTbx.sendKeys(nd);
				phnnTbx.sendKeys(phn);
				addTbx.sendKeys(add);
				pidTbx.sendKeys(pid);
				nomnameTbx.sendKeys(nomn);
				nomgenderTbx.sendKeys(nomg);
				nombirthTbx.sendKeys(nomb);
				nomnidTbx.sendKeys(nomni);
				nomrelationTbx.sendKeys(nomr);
				priorityTbx.sendKeys(prio);
				nomphnTbx.sendKeys(nomp);
				
				}

}
