
package com.demoqa.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoqa.Utils.WaitUtils;

public class ControlPage {

	private WebDriver driver;
	private Actions actions;
	private JavascriptExecutor js;
	private WaitUtils waitUtils;

	public ControlPage(WebDriver driver) {

		this.driver = driver;
		this.actions = new Actions(driver);
		this.js = (JavascriptExecutor) driver;
		this.waitUtils = new WaitUtils(driver);

		PageFactory.initElements(driver, this);
	}

	// Buttons Page Elements

	@FindBy(id = "doubleClickBtn")
	private WebElement btnDoubleClick;

	@FindBy(id = "rightClickBtn")
	private WebElement btnRightClick;

	@FindBy(xpath = "//button[text()='Click Me']")
	private WebElement btnDynamicClick;

	@FindBy(id = "doubleClickMessage")
	private WebElement txtDoubleClickMessage;

	@FindBy(id = "rightClickMessage")
	private WebElement txtRightClickMessage;

	@FindBy(id = "dynamicClickMessage")
	private WebElement txtDynamicClickMessage;

	// Checkbox Elements

	@FindBy(xpath = "//span[@role='checkbox']")
	private WebElement chkHome;

//    @FindBy(xpath = "//label[@for='tree-node-home']//span[@class='rct-checkbox']")
//    private WebElement chkHome;

	@FindBy(id = "result")
	private WebElement txtResult;

	// =========================
	// Button Actions
	// =========================

	public void performDoubleClick() {

		waitUtils.waitForClickability(btnDoubleClick);

		actions.doubleClick(btnDoubleClick).perform();
	}

	public void performRightClick() {

		waitUtils.waitForClickability(btnRightClick);

		actions.contextClick(btnRightClick).perform();
	}

	public void performDynamicClick() {

		waitUtils.waitForClickability(btnDynamicClick);

		btnDynamicClick.click();
	}

	public String getDoubleClickMessage() {

		waitUtils.waitForVisibility(txtDoubleClickMessage);

		return txtDoubleClickMessage.getText();
	}

	public String getRightClickMessage() {

		waitUtils.waitForVisibility(txtRightClickMessage);

		return txtRightClickMessage.getText();
	}

	public String getDynamicClickMessage() {

		waitUtils.waitForVisibility(txtDynamicClickMessage);

		return txtDynamicClickMessage.getText();
	}

	// =========================
	// Checkbox Actions
	// =========================

	public void selectHomeCheckbox() {

		waitUtils.waitForClickability(chkHome);

		js.executeScript("arguments[0].click();", chkHome);
	}

	public String getCheckboxResult() {

		waitUtils.waitForVisibility(txtResult);

		return txtResult.getText();
	}
}
