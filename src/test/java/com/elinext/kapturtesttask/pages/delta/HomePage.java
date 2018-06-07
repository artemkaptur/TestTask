/**
 * 
 */
package com.elinext.kapturtesttask.pages.delta;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.elinext.kapturtesttask.pages.AbstractPage;

/**
 * @author Артем
 *
 */
public class HomePage extends AbstractPage {
	private final String BASE_URL = "https://www.delta.com/";

	@FindBy(id = "book-air-content-trigger")
	private WebElement flightTab;

	@FindBy(id = "roundTripBtn")
	private WebElement roundTripButton;

	@FindBy(id = "originCity")
	private WebElement originCity;

	@FindBy(id = "destinationCity")
	private WebElement destinationCity;

	@FindBy(id = "depDateCalIcon")
	private WebElement depDate;

	@FindBy(id = "retDateCalIcon")
	private WebElement retDate;

	@FindBy(id = "exactDaysBtn")
	private WebElement exactDaysButton;

	@FindBy(id = "cashBtn")
	private WebElement cashButton;

	@FindBy(id = "findFlightsSubmit")
	private WebElement findFlightsSubmitButton;

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void clickOnFlightTab() {
		flightTab.click();
	}

	public void clickOnRoundTripButton() {
		roundTripButton.click();
	}

	public void fillDestinations(String from, String to) {
		originCity.clear();
		originCity.sendKeys(from);
		destinationCity.sendKeys(to);
	}

	public void fillDates(int dep, int ret) {
		depDate.click();
		driver.findElement(By.xpath("/html/body/div[7]/div[3]/table/tbody/tr/td/a[contains(text(),'" + dep + "')]"))
				.click();
		retDate.click();
		driver.findElement(By.xpath("/html/body/div[7]/div[3]/table/tbody/tr/td/a[contains(text(),'" + ret + "')]"))
				.click();
	}

	public void clickOnExactDates() {
		exactDaysButton.click();
	}

	public void clickOncashButton() {
		cashButton.click();
	}

	public void findFlights() {
		findFlightsSubmitButton.click();
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
	}
}
