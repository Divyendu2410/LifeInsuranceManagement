package com.PracticePackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MicCheckBoley {

	public static void main(String[] args) {
		// ChromeOptions object
		ChromeOptions op=new ChromeOptions();
		// Disable notification parameter
		op.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(op);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://mictests.com/");
		driver.findElement(By.xpath("//button[text()='Test my mic']")).click();

	}

}
