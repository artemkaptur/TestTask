/**
 * 
 */
package com.elinext.kapturtesttask.steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.elinext.kapturtesttask.driver.DriverSingleton;
import com.elinext.kapturtesttask.pages.delta.CreditCardInfoPage;
import com.elinext.kapturtesttask.pages.delta.HomePage;
import com.elinext.kapturtesttask.pages.delta.PassangerInfoPage;
import com.elinext.kapturtesttask.pages.delta.TicketSelectionPage;
import com.elinext.kapturtesttask.pages.delta.TripSummaryPage;

/**
 * @author Артем
 *
 */
public class DeltaComSteps {
	private WebDriver driver;

	private static Logger logger = LogManager.getLogger();

	public void initBrowser() {
		driver = DriverSingleton.getDriver();
	}

	public void closeDriver() {
		DriverSingleton.closeDriver();
	}

	public boolean checkAbilityToBookFlight(String from, String to, int depDay, int retDay, String name, String surname,
			String email) {
		HomePage homePage = new HomePage(driver);
		homePage.openPage();
		logger.info("Home page is opened");
		homePage.clickOnFlightTab();
		homePage.clickOnRoundTripButton();
		homePage.fillDestinations(from, to);
		homePage.fillDates(depDay, retDay);
		homePage.clickOnExactDates();
		homePage.clickOncashButton();
		homePage.findFlights();
		logger.info("Searching flights is started");
		selectFlights();
		fillPassangerInfo(name, surname, email);
		return isCompletePurchaseBtnActive();
	}

	private void selectFlights() {
		TicketSelectionPage ticketSelectionPage = new TicketSelectionPage(driver);
		ticketSelectionPage.selectTickets();
		logger.info("Tickets are selected");
		TripSummaryPage tripSummaryPage = new TripSummaryPage(driver);
		tripSummaryPage.clickOnSubmitButton();
	}

	private void fillPassangerInfo(String name, String surname, String email) {
		PassangerInfoPage passangerInfoPage = new PassangerInfoPage(driver);
		logger.info("PassangerInfoPage is opened");
		passangerInfoPage.fillPassangerInfo(name, surname, email);
		logger.info("Passanger info is filled");
		passangerInfoPage.clickOnContinueButton();
	}

	private boolean isCompletePurchaseBtnActive() {
		CreditCardInfoPage creditCardInfoPage = new CreditCardInfoPage(driver);
		logger.info("CreditCardInfoPage is opened");
		return creditCardInfoPage.isCompletePurchaseBtnActive();
	}

}
