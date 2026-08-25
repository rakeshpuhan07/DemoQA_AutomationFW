
package com.demoqa.PageObjects;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoqa.Utils.WaitUtils;

public class UploadDownloadPage {

	private WebDriver driver;
	private WaitUtils waitUtils;

	public UploadDownloadPage(WebDriver driver) {

		this.driver = driver;
		this.waitUtils = new WaitUtils(driver);

		PageFactory.initElements(driver, this);
	}

	// Download Button

	@FindBy(id = "downloadButton")
	private WebElement btnDownload;

	// Upload Input

	@FindBy(id = "uploadFile")
	private WebElement uploadFile;

	// Uploaded File Path Text

	@FindBy(id = "uploadedFilePath")
	private WebElement uploadedFilePath;

	/**
	 * Download File
	 */
	public void clickDownload() {

		waitUtils.waitForClickability(btnDownload);

		btnDownload.click();
	}

	/**
	 * Upload File
	 */
	public void uploadFile(String filePath) {

		waitUtils.waitForVisibility(uploadFile);

		uploadFile.sendKeys(filePath);
	}

	/**
	 * Get Uploaded File Path
	 */
	public String getUploadedFilePath() {

		waitUtils.waitForVisibility(uploadedFilePath);

		return uploadedFilePath.getText();
	}

	/**
	 * Verify Downloaded File Exists
	 */
	public boolean isFileDownloaded(String downloadPath, String fileName) {

		File file = new File(downloadPath + File.separator + fileName);

		return file.exists();
	}
}