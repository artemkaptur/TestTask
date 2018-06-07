/**
 * 
 */
package com.elinext.kapturtesttask.pages.tutby;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.elinext.kapturtesttask.pages.AbstractPage;

/**
 * @author Артем
 *
 */
public class AutotestByPage extends AbstractPage {
	private final String BASE_URL = "http://www.autotest.by/";

	@FindBy(id = "sites-page-title")
	private WebElement pageTitle;

	public AutotestByPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public String getPageTitle() {
		return pageTitle.getText();
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
	}
}
