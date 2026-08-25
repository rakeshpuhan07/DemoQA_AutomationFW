package com.demoqa.Utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    private ScreenshotUtil() {
    }

    public static String captureScreenshot(WebDriver driver,
                                           String testName) {

        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

        String screenshotDir = System.getProperty("user.dir")
                + "/test-output/screenshots/";

        String screenshotPath = screenshotDir
                + testName + "_" + timestamp + ".png";

        try {

            File sourceFile =
                    ((TakesScreenshot) driver)
                            .getScreenshotAs(OutputType.FILE);

            File destinationFile = new File(screenshotPath);

            destinationFile.getParentFile().mkdirs();

            Files.copy(
                    sourceFile.toPath(),
                    destinationFile.toPath(),
                    StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return screenshotPath;
    }
}
