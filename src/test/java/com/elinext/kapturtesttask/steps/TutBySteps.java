/**
 * 
 */
package com.elinext.kapturtesttask.steps;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.elinext.kapturtesttask.driver.DriverSingleton;
import com.elinext.kapturtesttask.pages.tutby.AutotestByPage;
import com.elinext.kapturtesttask.pages.tutby.MainPage;
import com.elinext.kapturtesttask.pages.tutby.SearchResultPage;

/**
 * @author Артем
 *
 */
public class TutBySteps {
	private WebDriver driver;

	private static Logger logger = LogManager.getLogger();

	public void initBrowser() {
		driver = DriverSingleton.getDriver();
	}

	public void closeDriver() {
		DriverSingleton.closeDriver();
	}

	public void searchSomething(String key) {
		MainPage mainPage = new MainPage(driver);
		mainPage.openPage();
		logger.info("Main is page opened");
		mainPage.searchSomething(key);
		logger.info("Searching started");
	}

	public List<WebElement> getSearchingResults() {
		SearchResultPage searchResultPage = new SearchResultPage(driver);
		logger.info("Searching results are got");
		return searchResultPage.getSearchResults();
	}

	public void openResult(int index) {
		SearchResultPage searchResultPage = new SearchResultPage(driver);
		searchResultPage.clickOnResult(index);
		switchWindow();
		logger.info("Searched result is opened");
	}

	private void switchWindow() {
		String currentWindow = driver.getWindowHandle();		

		for (String handle : driver.getWindowHandles()) {
		    if(!handle.equalsIgnoreCase(currentWindow)){
		    	driver.switchTo().window(handle);
					try {
						Thread.sleep(2000,0);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
		    	break;
		    }
		}		
	}

	public String getAutotestByProof() {
		AutotestByPage autotestByPage = new AutotestByPage(driver);
		logger.info("'Autotest.by is reached' proof is got");
		return autotestByPage.getPageTitle();
	}

}
