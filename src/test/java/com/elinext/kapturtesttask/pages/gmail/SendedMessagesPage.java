/**
 * 
 */
package com.elinext.kapturtesttask.pages.gmail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.elinext.kapturtesttask.pages.AbstractPage;

/**
 * @author Артем
 *
 */
public class SendedMessagesPage extends AbstractPage {
	private final String BASE_URL = "https://mail.google.com/mail/u/0/#sent";

	@FindBy(id = ":a0")
	private WebElement moreButton;

	@FindBy(xpath = "//*[@id=':aa']/div/div[2]")
	private WebElement spamButton;

	public SendedMessagesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void clickOnMoreButton() {
		moreButton.click();
	}

	public void clickOnSpam() {
		spamButton.click();
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
	}
}
