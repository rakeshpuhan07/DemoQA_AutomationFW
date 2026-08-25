
package com.demoqa.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoqa.Utils.WaitUtils;

public class PracticeFormPage {

	private WebDriver driver;
	private JavascriptExecutor js;
	private WaitUtils waitUtils;

	public PracticeFormPage(WebDriver driver) {

		this.driver = driver;
		this.js = (JavascriptExecutor) driver;
		this.waitUtils = new WaitUtils(driver);

		PageFactory.initElements(driver, this);
	}

	// First Name
	@FindBy(id = "firstName")
	private WebElement txtFirstName;

	// Last Name
	@FindBy(id = "lastName")
	private WebElement txtLastName;

	// Email
	@FindBy(id = "userEmail")
	private WebElement txtEmail;

	// Gender Radio Buttons
	@FindBy(xpath = "//label[@for='gender-radio-1']")
	private WebElement radioMale;

	@FindBy(xpath = "//label[@for='gender-radio-2']")
	private WebElement radioFemale;

	@FindBy(xpath = "//label[@for='gender-radio-3']")
	private WebElement radioOther;

	// Mobile Number
	@FindBy(id = "userNumber")
	private WebElement txtMobile;

	// Hobbies Checkboxes
	@FindBy(xpath = "//label[@for='hobbies-checkbox-1']")
	private WebElement chkSports;

	@FindBy(xpath = "//label[@for='hobbies-checkbox-2']")
	private WebElement chkReading;

	@FindBy(xpath = "//label[@for='hobbies-checkbox-3']")
	private WebElement chkMusic;

	// Upload Picture
	@FindBy(id = "uploadPicture")
	private WebElement uploadPicture;

	// Submit Button
	@FindBy(id = "submit")
	private WebElement btnSubmit;

	/**
	 * Enter First Name
	 */
	public void enterFirstName(String firstName) {

		waitUtils.waitForVisibility(txtFirstName);

		txtFirstName.clear();
		txtFirstName.sendKeys(firstName);
	}

	/**
	 * Enter Last Name
	 */
	public void enterLastName(String lastName) {

		waitUtils.waitForVisibility(txtLastName);

		txtLastName.clear();
		txtLastName.sendKeys(lastName);
	}

	/**
	 * Enter Email
	 */
	public void enterEmail(String email) {

		waitUtils.waitForVisibility(txtEmail);

		txtEmail.clear();
		txtEmail.sendKeys(email);
	}

	/**
	 * Select Gender
	 */
	public void selectGender(String gender) {

		switch (gender.toLowerCase()) {

		case "male":
			jsClick(radioMale);
			break;

		case "female":
			jsClick(radioFemale);
			break;

		case "other":
			jsClick(radioOther);
			break;

		default:
			throw new IllegalArgumentException("Invalid Gender: " + gender);
		}
	}

	/**
	 * Enter Mobile Number
	 */
	public void enterMobileNumber(String mobileNumber) {

		waitUtils.waitForVisibility(txtMobile);

		txtMobile.clear();
		txtMobile.sendKeys(mobileNumber);
	}

	/**
	 * Select Hobby
	 */
	public void selectHobby(String hobby) {

		switch (hobby.toLowerCase()) {

		case "sports":
			jsClick(chkSports);
			break;

		case "reading":
			jsClick(chkReading);
			break;

		case "music":
			jsClick(chkMusic);
			break;

		default:
			throw new IllegalArgumentException("Invalid Hobby: " + hobby);
		}
	}

	/**
	 * Upload File
	 */
	public void uploadFile(String filePath) {

		waitUtils.waitForVisibility(uploadPicture);

		uploadPicture.sendKeys(filePath);
	}

	/**
	 * Click Submit
	 */
	public void clickSubmit() {

		jsClick(btnSubmit);
	}

	/**
	 * Common JS Click Method
	 */
	private void jsClick(WebElement element) {

		waitUtils.waitForClickability(element);

		js.executeScript("arguments[0].click();", element);
	}
}