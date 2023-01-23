package com.PracticePackage;

import org.testng.annotations.Test;

public class SampleTestNG3 {
	@Test(groups={"Regression"})
	public void simple5() {
		System.out.println("-----Am Groot-----");
	}

	@Test(groups= {"Smoke","Regression"})
	public void simple6() {
		System.out.println("------Am Am Groot------");
	}

}
