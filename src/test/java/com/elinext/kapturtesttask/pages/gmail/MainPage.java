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
public class MainPage extends AbstractPage {
	private final String BASE_URL = "https://www.gmail.com/mail/help/intl/ru/about.html?design=65";

	@FindBy(xpath = "//*[@id='gmail-sign-in']")
	private WebElement loginButton;

	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void clickOnLoginButton() {
		loginButton.click();
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
	}
}
