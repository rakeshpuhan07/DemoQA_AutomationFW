package com.demoqa.tests;

import org.testng.annotations.Test;

import com.demoqa.Base.BaseTest;
import com.demoqa.PageObjects.PracticeFormPage;

public class PracticeFormTest extends BaseTest {

    @Test
    public void fillPracticeForm() {

        getDriver().get(
                "https://demoqa.com/automation-practice-form");

        PracticeFormPage form =
                new PracticeFormPage(getDriver());

        form.enterFirstName("Rakesh");
        form.enterLastName("Puhan");
        form.enterEmail("rakesh@test.com");
        form.selectGender("Male");
        form.enterMobileNumber("9876543210");
        form.selectHobby("Sports");

        form.uploadFile(
                System.getProperty("user.dir")
                        + "\\src\\test\\resources\\sample.pdf");

        form.clickSubmit();
    }
}
