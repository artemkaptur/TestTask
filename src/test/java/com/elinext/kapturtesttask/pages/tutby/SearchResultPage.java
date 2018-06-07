/**
 * 
 */
package com.elinext.kapturtesttask.pages.tutby;

import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.elinext.kapturtesttask.pages.AbstractPage;

/**
 * @author Артем
 *
 */
public class SearchResultPage extends AbstractPage {

	public SearchResultPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public List<WebElement> getSearchResults() {
		List<WebElement> searchResults = driver
				.findElements(By.xpath("/html/body/div[3]/div/div[2]/div[2]/div/div[2]/ol/li"));
		return searchResults;
	}

	public void clickOnResult(int index) {
		WebElement result = driver
				.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[2]/div/div[2]/ol/li[" + index + "]/h3/a[2]"));
		result.click();
	}

	@Override
	public void openPage() throws OperationNotSupportedException {
		throw new OperationNotSupportedException();
	}
}
