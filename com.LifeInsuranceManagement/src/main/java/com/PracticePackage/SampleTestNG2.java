package com.PracticePackage;

import org.testng.annotations.Test;

public class SampleTestNG2 {
	@Test(groups= {"Smoke"})
	public void simple3() {
		System.out.println("---Am Groot---");
	}

	@Test(groups= {"Regression"})
	public void simple4() {
		System.out.println("----Am Am Groot----");
	}

}
