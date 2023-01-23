package com.PracticePackage;

import org.testng.annotations.Test;

public class SampleTestNG1 {
@Test(groups= {"Smoke"})
public void simple1() {
	System.out.println("-Am Groot-");
}

@Test(groups= {"Smoke","Regression"})
public void simple2() {
	System.out.println("--Am Am Groot--");
}
}
