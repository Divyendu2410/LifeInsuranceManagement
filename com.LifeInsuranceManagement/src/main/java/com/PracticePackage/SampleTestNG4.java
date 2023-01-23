package com.PracticePackage;

import org.testng.annotations.Test;

public class SampleTestNG4 {
	@Test(groups= {"Smoke"})
	public void simple7() {
		System.out.println("-------Am Groot-------");
	}

	@Test(groups= {"Smoke","Regression"})
	public void simple8() {
		System.out.println("--------Am Am Groot--------");
	}

}
