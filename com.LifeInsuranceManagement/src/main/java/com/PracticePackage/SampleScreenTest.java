package com.PracticePackage;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.LifeInsurance.GenericUtilities.BaseClass;

@Listeners(com.LifeInsurance.GenericUtilities.LisImpClass.class)

public class SampleScreenTest extends BaseClass {
	@Test
	public void baklol() {
		System.out.println("----Test Start----");
		Assert.assertEquals(false, true);
		System.out.println("----Test End----");
	}

}
