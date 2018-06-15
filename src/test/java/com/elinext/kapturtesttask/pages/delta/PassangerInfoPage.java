/**
 * 
 */
package com.elinext.kapturtesttask.pages.delta;

import javax.naming.OperationNotSupportedException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.elinext.kapturtesttask.pages.AbstractPage;

/**
 * @author Артем
 *
 */
public class PassangerInfoPage extends AbstractPage {

	@FindBy(id = "firstName0")
	private WebElement name;

	@FindBy(id = "lastName0")
	private WebElement surname;

	@FindBy(id = "gender0-button")
	private WebElement gender;

	@FindBy(xpath = "//ul[@id='gender0-menu']")
	WebElement genderMenu;

	@FindBy(id = "month0-button")
	private WebElement birthMonth;

	@FindBy(xpath = "//ul[@id='month0-menu']")
	WebElement monthMenu;

	@FindBy(id = "day0-button")
	private WebElement birthDay;

	@FindBy(xpath = "//ul[@id='day0-menu']")
	WebElement dayMenu;

	@FindBy(xpath = "//ul[@id='year0-menu']")
	WebElement yearMenu;

	@FindBy(id = "year0-button")
	private WebElement birthYear;

	@FindBy(id = "ui-id-140")
	private WebElement twoThousand;

	@FindBy(id = "emgcFirstName_0")
	private WebElement emgcName;

	@FindBy(id = "emgcLastName_0")
	private WebElement emgcSurname;

	@FindBy(id = "emgcPhoneNumber_0")
	private WebElement emgcPhoneNumber;

	@FindBy(id = "telephoneNumber0")
	private WebElement phoneNumber;

	@FindBy(id = "email")
	private WebElement email;

	@FindBy(id = "reEmail")
	private WebElement reEmail;

	@FindBy(id = "paxReviewPurchaseBtn")
	private WebElement continueButton;

	public PassangerInfoPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void fillPassangerInfo(String name, String surname, String email) {
		this.name.sendKeys(name);
		this.surname.sendKeys(surname);
		gender.click();
		genderMenu.sendKeys("M");
		genderMenu.click();
		birthMonth.click();
		monthMenu.sendKeys("January");
		monthMenu.click();
		birthDay.click();
		dayMenu.sendKeys("1");
		dayMenu.click();
		birthYear.click();
		yearMenu.sendKeys("2000");
		yearMenu.click();

		emgcName.sendKeys(name);
		emgcSurname.sendKeys(surname);
		emgcPhoneNumber.sendKeys(generatePhoneNumber());
		phoneNumber.sendKeys(generatePhoneNumber());
		this.email.sendKeys(email);
		this.reEmail.sendKeys(email);
	}

	public void clickOnContinueButton() {
		continueButton.click();
	}

	private String generatePhoneNumber() {
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < 7; i++) {
			str.append(Math.round(Math.random() * 10));
		}
		return str.toString();
	}

	@Override
	public void openPage() throws OperationNotSupportedException {
		throw new OperationNotSupportedException();
	}
}
