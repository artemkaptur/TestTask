/**
 * 
 */
package com.elinext.kapturtesttask.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.elinext.kapturtesttask.steps.GmailSteps;

/**
 * @author Артем
 *
 */
public class GmailTest {
	private GmailSteps steps;
	private final String LOGIN = "userfortest876@gmail.com";
	private final String PASSWORD = "test1234test";
	private final String SENDED_MESSAGES_URL = "https://mail.google.com/mail/u/0/#sent";
	private final String SPAM_URL = "https://mail.google.com/mail/u/0/#spam";
	private final String INCOMING_MESSAGES_URL = "https://mail.google.com/mail/u/0/#inbox";
	private final String INCOMING_MESSAGES_SEARCH_KEY = "test";
	private final String MESSAGE_TEXT = "Hi buddy! How is it going?";
	private final String MESSAGE_SENDED_PROOF = "Письмо отправлено.";
	private final int EXPECTED_MESSAGES_COUNT = 3;

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		steps = new GmailSteps();
		steps.initBrowser();
	}

	@Test(groups = { "gmail.com" }, description = "Check switching between incoming and sended messages and spam")
	public void switchBetweenMessagesTest() throws InterruptedException {
		steps.login(LOGIN, PASSWORD);
		steps.goToSendedMessages();
		Thread.sleep(3000);
		Assert.assertEquals(steps.getCurrentUrl(), SENDED_MESSAGES_URL);
		steps.goToSpam();
		Thread.sleep(3000);
		Assert.assertEquals(steps.getCurrentUrl(), SPAM_URL);
		steps.goIncomingMessages();
		Thread.sleep(3000);
		Assert.assertEquals(steps.getCurrentUrl(), INCOMING_MESSAGES_URL);
	}

	@Test(groups = { "gmail.com" }, description = "Check searching in incoming messages by key")
	public void searchInIncomingMessagesTest() {
		steps.login(LOGIN, PASSWORD);
		Assert.assertEquals(steps.getSearchedIncomingMessages(INCOMING_MESSAGES_SEARCH_KEY).size(),
				EXPECTED_MESSAGES_COUNT);
	}

	@Test(groups = { "gmail.com" }, description = "Writing answer on one of searched messges")
	public void writeMessageTest() {
		steps.login(LOGIN, PASSWORD);
		Assert.assertEquals(steps.writeAnswer(MESSAGE_TEXT, INCOMING_MESSAGES_SEARCH_KEY), MESSAGE_SENDED_PROOF);
	}

	@Test(groups = { "gmail.com" }, description = "Check correct log out")
	public void logOutTest() {
		steps.login(LOGIN, PASSWORD);
		steps.logout();
		Assert.assertNotEquals(steps.getCurrentUrl(), INCOMING_MESSAGES_URL);
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser() {
		steps.closeDriver();
	}
}
