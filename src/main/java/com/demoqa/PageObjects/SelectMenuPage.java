
package com.demoqa.PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.demoqa.Utils.WaitUtils;

public class SelectMenuPage {

	private WebDriver driver;
	private WaitUtils waitUtils;

	public SelectMenuPage(WebDriver driver) {

		this.driver = driver;
		this.waitUtils = new WaitUtils(driver);

		PageFactory.initElements(driver, this);
	}

	// Old Style Select Menu

	@FindBy(id = "oldSelectMenu")
	private WebElement oldStyleDropdown;

	// Auto Suggestive Dropdown

	@FindBy(id = "react-select-2-input")
	private WebElement selectValueDropdown;

	// Multi Select Dropdown

	@FindBy(id = "react-select-4-input")
	private WebElement multiSelectDropdown;

	/**
	 * Select Old Style Dropdown
	 */
	public void selectOldStyleOption(String value) {

		waitUtils.waitForVisibility(oldStyleDropdown);

		Select select = new Select(oldStyleDropdown);

		select.selectByVisibleText(value);
	}

	/**
	 * Auto Suggestive Dropdown
	 */
	public void selectValue(String value) {

		waitUtils.waitForClickability(selectValueDropdown);

		selectValueDropdown.sendKeys(value);
		selectValueDropdown.sendKeys(Keys.ENTER);
	}

	/**
	 * Multi Select Dropdown
	 */
	public void selectMultipleValues(String... values) {

		waitUtils.waitForClickability(multiSelectDropdown);

		for (String value : values) {

			multiSelectDropdown.sendKeys(value);
			multiSelectDropdown.sendKeys(Keys.ENTER);
		}
	}

	/**
	 * Get Selected Value
	 */
	public String getSelectedValue() {

		waitUtils.waitForVisibility(selectValueDropdown);

		return selectValueDropdown.getAttribute("value");
	}
}