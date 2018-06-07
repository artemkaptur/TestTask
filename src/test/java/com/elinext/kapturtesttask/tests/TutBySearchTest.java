/**
 * 
 */
package com.elinext.kapturtesttask.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriverException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.elinext.kapturtesttask.steps.TutBySteps;

/**
 * @author Артем
 *
 */
public class TutBySearchTest {
	private TutBySteps steps;
	private final String FIRST_SEARCH_KEY = "automated testing";
	private final String SECOND_SEARCH_KEY = "Minsk Automated Testing Community";
	private final String AUTOTEST_BY_IS_REACHED = "Добро пожаловать на сайт Minsk Automated Testing Community";
	private final int RESULT_INDEX = 1;

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		steps = new TutBySteps();
		steps.initBrowser();
	}

	@Test(groups = { "tut.by" }, description = "Check tut.by search works or not")
	public void searchWorksOrNotTest() {
		steps.searchSomething(FIRST_SEARCH_KEY);
		int searchResultCount = steps.getSearchingResults().size();
		System.out.println(searchResultCount);
		assertTrue(searchResultCount != 0, "No such elements in search result");
	}

	@Test(groups = { "tut.by" }, description = "Check tut.by search correct working")
	public void correctSearchWorkingkTest() {
		steps.searchSomething(SECOND_SEARCH_KEY);
		int searchResultCount = steps.getSearchingResults().size();
		if (searchResultCount != 0) {
			steps.openResult(RESULT_INDEX);
			assertEquals(steps.getAutotestByProof(), AUTOTEST_BY_IS_REACHED, "Wrong page from search results is opned");
		} else {
			throw new WebDriverException();
		}
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser() {
		steps.closeDriver();
	}
}
