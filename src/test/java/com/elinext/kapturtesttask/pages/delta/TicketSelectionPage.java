/**
 * 
 */
package com.elinext.kapturtesttask.pages.delta;

import javax.naming.OperationNotSupportedException;

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
public class TicketSelectionPage extends AbstractPage {

	@FindBy(xpath = "//table[@class='flightResultTable']/tbody/tr[3]/td[2]/div/a")
	private WebElement firstTicket;

	public TicketSelectionPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void selectTickets() {
		firstTicket.click();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement secondTicket = (new WebDriverWait(driver, 8)).until(ExpectedConditions
				.elementToBeClickable(By.xpath("//table[@class='flightResultTable']/tbody/tr[3]/td[2]/div/a")));
		secondTicket.click();
	}

	@Override
	public void openPage() throws OperationNotSupportedException {
		throw new OperationNotSupportedException();
	}
}
