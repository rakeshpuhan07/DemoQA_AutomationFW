package com.demoqa.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demoqa.Base.BaseTest;
import com.demoqa.PageObjects.PracticeFormPage;
import com.demoqa.Utils.ExcelUtils;

public class FormTest extends BaseTest {

    @DataProvider(name = "formData")
    public Object[][] getFormData() {

        return ExcelUtils.getTestData(
                "TestData.xlsx",
                "Sheet1");
    }

    @Test(dataProvider = "formData")
    public void submitPracticeForm(
            String testCaseID,
            String firstName,
            String lastName,
            String email,
            String mobile,
            String filePath) {

        getDriver().get(
                "https://demoqa.com/automation-practice-form");

        PracticeFormPage page =
                new PracticeFormPage(getDriver());

        page.enterFirstName(firstName);
        page.enterLastName(lastName);
        page.enterEmail(email);

        page.selectGender("Male");

        page.enterMobileNumber(mobile);

        page.selectHobby("Sports");

//        page.uploadFile(filePath);
        String completeFilePath =
                System.getProperty("user.dir")
                + "\\src\\test\\resources\\UploadFiles\\";
//                + fileName;

        page.uploadFile(completeFilePath);

        ((JavascriptExecutor) getDriver())
                .executeScript(
                        "window.scrollBy(0,500)");

        page.clickSubmit();

        WebDriverWait wait =
                new WebDriverWait(
                        getDriver(),
                        Duration.ofSeconds(10));

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(
                        By.id("example-modal-sizes-title-lg")));

        String successMessage =
                getDriver()
                .findElement(
                        By.id("example-modal-sizes-title-lg"))
                .getText();

        Assert.assertEquals(
                successMessage,
                "Thanks for submitting the form",
                "Form submission failed for "
                        + testCaseID);
    }
}