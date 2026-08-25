package com.demoqa.reports;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    private ExtentManager() {
    }

    public static ExtentReports getInstance() {

        if (extent == null) {

            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

            String reportPath = System.getProperty("user.dir")
                    + "/test-output/ExtentReport_" + timestamp + ".html";

            ExtentSparkReporter sparkReporter =
                    new ExtentSparkReporter(reportPath);

            sparkReporter.config().setDocumentTitle("Automation Report");
            sparkReporter.config().setReportName("Selenium Test Execution");

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);

            extent.setSystemInfo("OS",
                    System.getProperty("os.name"));
            extent.setSystemInfo("Java Version",
                    System.getProperty("java.version"));
            extent.setSystemInfo("Tester", "Rakesh Ranjan Puhan");
        }

        return extent;
    }
}