/**
 * 
 */
package com.elinext.kapturtesttask.pages.gmail;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.elinext.kapturtesttask.pages.AbstractPage;

/**
 * @author Артем
 *
 */
public class IncomingMessagesPage extends AbstractPage {
	private final String BASE_URL = "https://mail.google.com/mail/u/0/#inbox";

	@FindBy(xpath = "//*[@id=':a7']/div/div[2]/span/a")
	private WebElement sendedMessages;

	@FindBy(xpath = "//*[@id='gb']/div[1]/div[1]/div[2]/div[5]/div[1]/a/span")
	private WebElement accountButton;

	public IncomingMessagesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void clickOnSendedLetters() {
		sendedMessages.click();
	}

	public void clickOnAccountButton() {
		accountButton.click();
	}

	public void clickOnLogoutButton() {
		WebElement logoutButton = (new WebDriverWait(driver, 7)).until(ExpectedConditions.elementToBeClickable(By.xpath(
				"/html/body/div[7]/div[3]/div/div[1]/div[4]/div[1]/div[1]/div[1]/div[2]/div[5]/div[2]/div[4]/div[2]/a")));
		logoutButton.click();
	}

	public List<WebElement> getSearchedIncomingMessages(String key) {
		List<WebElement> searchedMessages = driver.findElements(
				By.xpath("//*[@id=':34']/tbody/tr/td[6]/div/div/div/span[2 and contains(text(),'" + key + "')]"));
		return searchedMessages;
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
	}
}
