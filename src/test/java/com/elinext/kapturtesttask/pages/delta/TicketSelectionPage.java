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

	@FindBy(xpath = "/html/body/app-root/div[3]/app-flight-result-view/div/div/main/div/div[2]/div/div[6]/table/tbody/tr/td/div[1]/table/tbody/tr[3]/td[2]/div/a")
	private WebElement firstTicket;

	public TicketSelectionPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void selectTickets() {
		firstTicket.click();
		WebElement secondTicket = (new WebDriverWait(driver, 8)).until(ExpectedConditions.elementToBeClickable(By.xpath(
				"/html/body/app-root/div[3]/app-flight-result-view/div/div/main/div/div[2]/div/div[6]/table/tbody/tr/td/div[1]/table/tbody/tr[3]/td[2]/div/a")));
		secondTicket.click();
	}

	@Override
	public void openPage() throws OperationNotSupportedException {
		throw new OperationNotSupportedException();
	}
}
