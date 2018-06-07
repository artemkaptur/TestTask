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
public class MainPage extends AbstractPage {
	private final String BASE_URL = "https://www.tut.by/";

	@FindBy(id = "search_from_str")
	private WebElement searchField;

	@FindBy(xpath = "//*[@id='search']/div/div[1]/input[2]")
	private WebElement startSearchButton;

	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void searchSomething(String key) {
		searchField.sendKeys(key);
		startSearchButton.click();
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
	}
}
