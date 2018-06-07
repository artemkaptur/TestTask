/**
 * 
 */
package com.elinext.kapturtesttask.pages.gmail;

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
public class LoginPage extends AbstractPage {
	private final String BASE_URL = "https://accounts.google.com/signin/v2/sl/pwd?hl=ru&service=mail&flowName=GlifWebSignIn&flowEntry=ServiceLogin";

	@FindBy(xpath = "//*[@id='identifierId']")
	private WebElement login;

	@FindBy(xpath = "//*[@id='identifierNext']/content/span")
	private WebElement loginNextButton;

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void fillLoginPassw(String log, String passw) {
		login.sendKeys(log);
		loginNextButton.click();
		WebElement password = (new WebDriverWait(driver, 7)).until(
				ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='password']/div[1]/div/div[1]/input")));
		password.sendKeys(passw);

		WebElement passwNextButton = (new WebDriverWait(driver, 7))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='passwordNext']/content/span")));
		passwNextButton.click();
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
	}
}
