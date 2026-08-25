package com.demoqa.tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoqa.Base.BaseTest;
import com.demoqa.PageObjects.SelectMenuPage;

public class SelectMenuTest extends BaseTest {

    @Test(priority = 1)
    public void verifyOldStyleDropdown() {

        getDriver().get(
                "https://demoqa.com/select-menu");

        SelectMenuPage page =
                new SelectMenuPage(getDriver());

        page.selectOldStyleOption("Purple");

        Assert.assertTrue(true,
                "Old Style Dropdown Selected Successfully");
    }

    @Test(priority = 2)
    public void verifyAutoSuggestiveDropdown() {

        getDriver().get(
                "https://demoqa.com/select-menu");

        SelectMenuPage page =
                new SelectMenuPage(getDriver());

        page.selectValue("Group 1, option 1");

        Assert.assertTrue(true,
                "Auto Suggestive Dropdown Selected Successfully");
    }

    @Test(priority = 3)
    public void verifyMultiSelectDropdown() {

        getDriver().get(
                "https://demoqa.com/select-menu");

        SelectMenuPage page =
                new SelectMenuPage(getDriver());

        page.selectMultipleValues(
                "Red",
                "Green",
                "Blue");

        Assert.assertTrue(true,
                "Multi Select Values Selected Successfully");
    }
    
}
