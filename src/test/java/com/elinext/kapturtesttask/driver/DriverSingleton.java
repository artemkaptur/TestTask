/**
 * 
 */
package com.elinext.kapturtesttask.driver;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author Артем
 *
 */
public class DriverSingleton {
	private static WebDriver driver;
	private static final Logger logger = LogManager.getLogger();
	private static final String WEBDRIVER_GECKO_DRIVER = "webdriver.gecko.driver";
	private static final String WEBDRIVER_GECKO_EXE_PATH = "C:\\MYPROGRAMS\\DRIVERS\\geckodriver.exe";

	private DriverSingleton() {
	}

	public static WebDriver getDriver() {
		if (driver == null) {
			System.setProperty(WEBDRIVER_GECKO_DRIVER, WEBDRIVER_GECKO_EXE_PATH);
			driver = new FirefoxDriver();
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();

			logger.info("Browser started");
		}

		return driver;
	}

	public static void closeDriver() {
		driver.quit();
		driver = null;
	}
}
