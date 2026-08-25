package com.demoqa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoqa.Base.BaseTest;
import com.demoqa.PageObjects.ControlPage;

public class ControlTest extends BaseTest {

    @Test(priority = 1)
    public void verifyDoubleClick() {

        getDriver().get("https://demoqa.com/buttons");

        ControlPage controlPage =
                new ControlPage(getDriver());

        controlPage.performDoubleClick();

        Assert.assertEquals(
                controlPage.getDoubleClickMessage(),
                "You have done a double click check fail");
    }

    @Test(priority = 2)
    public void verifyRightClick() {

        getDriver().get("https://demoqa.com/buttons");

        ControlPage controlPage =
                new ControlPage(getDriver());

        controlPage.performRightClick();

        Assert.assertEquals(
                controlPage.getRightClickMessage(),
                "You have done a right click");
    }

    @Test(priority = 3)
    public void verifyDynamicClick() {

        getDriver().get("https://demoqa.com/buttons");

        ControlPage controlPage =
                new ControlPage(getDriver());

        controlPage.performDynamicClick();

        Assert.assertEquals(
                controlPage.getDynamicClickMessage(),
                "You have done a dynamic click");
    }

    @Test(priority = 4)
    public void verifyCheckboxSelection() {

        getDriver().get("https://demoqa.com/checkbox");

        ControlPage controlPage =
                new ControlPage(getDriver());

//        controlPage.expandAllCheckboxes();

        controlPage.selectHomeCheckbox();

        Assert.assertTrue(
                controlPage.getCheckboxResult()
                           .contains("home"));
    }
}