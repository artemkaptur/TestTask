/**
 * 
 */
package com.elinext.kapturtesttask.steps;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.elinext.kapturtesttask.driver.DriverSingleton;
import com.elinext.kapturtesttask.pages.gmail.IncomingMessagesPage;
import com.elinext.kapturtesttask.pages.gmail.LoginPage;
import com.elinext.kapturtesttask.pages.gmail.MainPage;
import com.elinext.kapturtesttask.pages.gmail.SendedMessagesPage;
import com.elinext.kapturtesttask.pages.gmail.SpamPage;
import com.elinext.kapturtesttask.pages.gmail.WriteMessagePage;

/**
 * @author Артем
 *
 */
public class GmailSteps {
	private WebDriver driver;

	private static Logger logger = LogManager.getLogger();

	public void initBrowser() {
		driver = DriverSingleton.getDriver();
	}

	public void closeDriver() {
		DriverSingleton.closeDriver();
	}

	public void login(String log, String passw) {
		MainPage mainPage = new MainPage(driver);
		mainPage.openPage();
		mainPage.clickOnLoginButton();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.fillLoginPassw(log, passw);
		logger.info("Login performed");
	}

	public void logout() {
		IncomingMessagesPage incMessagesPage = new IncomingMessagesPage(driver);
		incMessagesPage.clickOnAccountButton();
		incMessagesPage.clickOnLogoutButton();
		logger.info("Logout performed");
	}

	public void goToSendedMessages() {
		IncomingMessagesPage incMessagesPage = new IncomingMessagesPage(driver);
		incMessagesPage.clickOnSendedLetters();
		logger.info("Sended messages are opened");
	}

	public void goToSpam() {
		SendedMessagesPage sendedMessagesPage = new SendedMessagesPage(driver);
		sendedMessagesPage.clickOnMoreButton();
		sendedMessagesPage.clickOnSpam();
		logger.info("Spam is opened");
	}

	public void goIncomingMessages() {
		SpamPage spamPage = new SpamPage(driver);
		spamPage.clickOnIncomingMessages();
		logger.info("Incoming messages are opened");
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public List<List<String>> getSearchedIncomingMessages(String key) {
		IncomingMessagesPage incMessagesPage = new IncomingMessagesPage(driver);
		List<WebElement> searchedMessages = incMessagesPage.getSearchedIncomingMessages(key);
		List<List<String>> searchedMessagesText = new ArrayList<>();

		for (WebElement elem : searchedMessages) {
			String[] array = elem.getText().split(" ");
			List<String> messageText = new ArrayList<String>();
			for (String str : array) {
				messageText.add(str);
			}
			searchedMessagesText.add(messageText);
		}
		logger.info("Searched messages with '" + key + "' are got");
		return searchedMessagesText;
	}

	public String writeAnswer(String text, String key) {
		IncomingMessagesPage incMessagesPage = new IncomingMessagesPage(driver);
		incMessagesPage.getSearchedIncomingMessages(key).get(0).click();
		WriteMessagePage writeLetterPage = new WriteMessagePage(driver);
		logger.info("Answer is sended");
		return writeLetterPage.sendAnswer(text);
	}
}
