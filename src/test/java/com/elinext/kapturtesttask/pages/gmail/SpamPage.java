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
public class SpamPage extends AbstractPage {
	private final String BASE_URL = "https://mail.google.com/mail/u/0/#sent";
	
	@FindBy(xpath = "//a[contains(text(),'Входящие')]")
	private WebElement incomingMessages;

	public SpamPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void clickOnIncomingMessages() {
		incomingMessages.click();
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
	}
}
