package com.demoqa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoqa.Base.BaseTest;
import com.demoqa.PageObjects.UploadDownloadPage;

public class UploadDownloadTest extends BaseTest {

    @Test
    public void verifyFileUpload() {

        getDriver().get("https://demoqa.com/upload-download");

        UploadDownloadPage uploadPage =
                new UploadDownloadPage(getDriver());

        String filePath =
                System.getProperty("user.dir")
                + "\\src\\test\\resources\\sample.pdf";

        uploadPage.uploadFile(filePath);

        Assert.assertTrue(
                uploadPage.getUploadedFilePath().contains("sample.pdf"));
    }
    
    @Test
    public void verifyFileDownload() throws InterruptedException {

        getDriver().get("https://demoqa.com/upload-download");

        UploadDownloadPage uploadPage =
                new UploadDownloadPage(getDriver());

        uploadPage.clickDownload();

        Thread.sleep(5000);

        String downloadFolder =
                System.getProperty("user.home")
                + "\\Downloads";

        Assert.assertTrue(
                uploadPage.isFileDownloaded(
                        downloadFolder,
                        "sampleFile.jpeg"));
    }
    
    
}
