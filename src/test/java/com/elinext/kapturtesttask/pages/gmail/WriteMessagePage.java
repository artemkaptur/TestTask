/**
 * 
 */
package com.elinext.kapturtesttask.pages.gmail;

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
public class WriteMessagePage extends AbstractPage {
	// Here I used absolute XPath, because there are dynamic id
	@FindBy(xpath = "/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div/div[2]/"
			+ "div/div[1]/div/div[2]/div/table/tr/td[1]/div[2]/div[2]/div/div[3]/"
			+ "div/div/div/div/div/div[2]/div/div/div/table/tbody/tr/td[2]/div/div")
	private WebElement writtingMessageField;

	@FindBy(xpath = "/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div/div[2]/"
			+ "div/div[1]/div/div[2]/div/table/tr/td[1]/div[2]/div[2]/div/div[3]/"
			+ "div/div/div/div/div/div[2]/div/div/div/div[4]/table/tbody/tr/td[2]/"
			+ "table/tbody/tr[1]/td/div/div[2]/div[1]/div/table/tbody/tr/td[2]/div[2]/div")
	private WebElement typingMessageField;

	@FindBy(id = "/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div/div[2]/"
			+ "div/div[1]/div/div[2]/div/table/tr/td[1]/div[2]/div[2]/div/div[3]/div/div/div/div/div/div[2]/"
			+ "div/div/div/div[4]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/div[2]/div[1]/div[4]/table/tbody/tr/td[1]/div/div[2]")
	private WebElement sendMessage;

	@FindBy(xpath = "/html/body/div[7]/div[3]/div/div[1]/div[5]/div[1]/div/div[3]/div/div/div[2]")
	private WebElement sendingProof;

	public WriteMessagePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public String sendAnswer(String text) {
		writtingMessageField.click();
		typingMessageField.sendKeys(text);
		sendMessage.click();
		return sendingProof.getText();
	}

	@Override
	public void openPage() throws OperationNotSupportedException {
		throw new OperationNotSupportedException();
	}
}
