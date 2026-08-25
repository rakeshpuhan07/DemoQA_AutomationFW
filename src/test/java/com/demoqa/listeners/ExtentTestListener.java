package com.demoqa.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.demoqa.Base.BaseTest;
import com.demoqa.reports.*;
import com.demoqa.Utils.*;

public class ExtentTestListener implements ITestListener {

    private static ExtentReports extent =
            ExtentManager.getInstance();

    private static ThreadLocal<ExtentTest> test =
            new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {

        System.out.println("Execution Started");
    }

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest extentTest = extent.createTest(
                result.getMethod().getMethodName());

        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.get().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.get().fail(result.getThrowable());

        try {

            String screenshotPath =
                    ScreenshotUtil.captureScreenshot(
                            BaseTest.getDriver(),
                            result.getMethod().getMethodName());

            test.get().addScreenCaptureFromPath(
                    screenshotPath,
                    "Failure Screenshot");

        } catch (Exception e) {

            test.get().fail(
                    "Failed to attach screenshot : "
                            + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        test.get().skip("Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {

        extent.flush();

        System.out.println("Execution Completed");
    }
}
