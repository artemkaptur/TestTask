/**
 * 
 */
package com.elinext.kapturtesttask.pages.delta;

import javax.naming.OperationNotSupportedException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.elinext.kapturtesttask.pages.AbstractPage;

/**
 * @author Артем
 *
 */
public class TripSummaryPage extends AbstractPage {

	@FindBy(id = "tripSummarySubmitBtn")
	private WebElement submitButton;

	public TripSummaryPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void clickOnSubmitButton() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
		submitButton.click();
	}

	@Override
	public void openPage() throws OperationNotSupportedException {
		throw new OperationNotSupportedException();
	}
}
