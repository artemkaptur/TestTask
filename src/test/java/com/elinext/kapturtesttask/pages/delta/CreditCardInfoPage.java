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
public class CreditCardInfoPage extends AbstractPage {

	@FindBy(id = "continue_button")
	private WebElement completePurchaseBtn;

	public CreditCardInfoPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public boolean isCompletePurchaseBtnActive() {
		return completePurchaseBtn.isEnabled();
	}

	@Override
	public void openPage() throws OperationNotSupportedException {
		throw new OperationNotSupportedException();
	}
}
