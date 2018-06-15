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
	private final String SENT_MESSAGES_URL = "https://mail.google.com/mail/u/0/#sent";
	private final String SPAM_URL = "https://mail.google.com/mail/u/0/#spam";
	private final String INCOMING_MESSAGES_URL = "https://mail.google.com/mail/u/0/#inbox";
	private final String INCOMING_MESSAGES_SEARCH_KEY = "test test";
	private final String MESSAGE_TEXT = "Hi buddy! How is it going?";
	private final String MESSAGE_SENT_PROOF = "Письмо отправлено.";
	private final int EXPECTED_MESSAGES_COUNT = 3;

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		steps = new GmailSteps();
		steps.initBrowser();
	}

	@Test(groups = { "gmail.com" }, description = "Check switching between incoming and sent messages and spam")
	public void switchBetweenMessagesTest() throws InterruptedException {
		steps.login(LOGIN, PASSWORD);
		steps.goToSentMessages();
		Thread.sleep(3000);
		Assert.assertEquals(steps.getCurrentUrl(), SENT_MESSAGES_URL, "Sent messages page isn't correct");
		steps.goToSpam();
		Thread.sleep(3000);
		Assert.assertEquals(steps.getCurrentUrl(), SPAM_URL, "Spam page isn't correct");
		steps.goIncomingMessages();
		Thread.sleep(3000);
		Assert.assertEquals(steps.getCurrentUrl(), INCOMING_MESSAGES_URL, "Incoming messages page isn't correct");
	}

	@Test(groups = { "gmail.com" }, description = "Check searching in incoming messages by key")
	public void searchInIncomingMessagesTest() {
		steps.login(LOGIN, PASSWORD);
		Assert.assertEquals(steps.getSearchedIncomingMessages(INCOMING_MESSAGES_SEARCH_KEY).size(),
				EXPECTED_MESSAGES_COUNT);
	}

	@Test(groups = { "gmail.com" }, description = "Writing answer to one of searched messges")
	public void writeMessageTest() {
		steps.login(LOGIN, PASSWORD);
		Assert.assertEquals(steps.writeAnswer(MESSAGE_TEXT, INCOMING_MESSAGES_SEARCH_KEY), MESSAGE_SENT_PROOF,
				"Answer wasn't sended");
	}

	@Test(groups = { "gmail.com" }, description = "Check correct log out")
	public void logOutTest() {
		steps.login(LOGIN, PASSWORD);
		steps.logout();
		Assert.assertNotEquals(steps.getCurrentUrl(), INCOMING_MESSAGES_URL, "Logout wasn't perfomed");
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser() {
		steps.closeDriver();
	}
}
