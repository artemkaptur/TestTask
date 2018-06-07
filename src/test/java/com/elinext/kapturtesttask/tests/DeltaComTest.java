/**
 * 
 */
package com.elinext.kapturtesttask.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.elinext.kapturtesttask.steps.DeltaComSteps;

/**
 * @author Артем
 *
 */
public class DeltaComTest {
	private DeltaComSteps steps;
	private final String FROM = "JFK";
	private final String TO = "SVO";
	private final int DEP_DAY = 10;
	private final int RET_DAY = 20;
	private final String NAME = "Blablabla";
	private final String SURNAME = "Blabla";
	private final String EMAIL = "Blablabla@mail.ru";

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		steps = new DeltaComSteps();
		steps.initBrowser();
	}

	@Test(groups = { "delta.com" }, description = "Check booking flights process correct working")
	public void searchWorksOrNotTest() {
		Assert.assertTrue(steps.checkAbilityToBookFlight(FROM, TO, DEP_DAY, RET_DAY, NAME, SURNAME, EMAIL));
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser() {
		steps.closeDriver();
	}
}
