package com.demoqa.Utils;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

    private WebDriver driver;
    private WebDriverWait wait;

    public WaitUtils(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(6));
    }

    /**
     * Wait for element to be visible
     */
    public WebElement waitForVisibility(
            WebElement element) {

        return wait.until(
                ExpectedConditions.visibilityOf(
                        element));
    }

    /**
     * Wait for element to be clickable
     */
    public WebElement waitForClickability(
            WebElement element) {

        return wait.until(
                ExpectedConditions
                        .elementToBeClickable(
                                element));
    }

    /**
     * Wait for element to disappear
     */
    public boolean waitForInvisibility(
            WebElement element) {

        return wait.until(
                ExpectedConditions
                        .invisibilityOf(element));
    }

    /**
     * Wait for text to be present
     */
    public boolean waitForText(
            WebElement element,
            String text) {

        return wait.until(
                ExpectedConditions
                        .textToBePresentInElement(
                                element,
                                text));
    }

    /**
     * Wait for page title
     */
    public boolean waitForTitle(
            String title) {

        return wait.until(
                ExpectedConditions
                        .titleContains(title));
    }

    /**
     * Wait for URL
     */
    public boolean waitForUrl(
            String url) {

        return wait.until(
                ExpectedConditions
                        .urlContains(url));
    }

    /**
     * Scroll element into view
     */
    public void scrollIntoView(
            WebElement element) {

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].scrollIntoView(true);",
                        element);
    }

    /**
     * JavaScript Click
     */
    public void jsClick(
            WebElement element) {

        waitForVisibility(element);

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].click();",
                        element);
    }

    /**
     * Scroll + JS Click
     */
    public void scrollAndClick(
            WebElement element) {

        scrollIntoView(element);

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].click();",
                        element);
    }

    /**
     * Hard wait (use only if necessary)
     */
    public static void pause(
            int seconds) {

        try {

            Thread.sleep(seconds * 1000L);

        } catch (InterruptedException e) {

            Thread.currentThread()
                    .interrupt();
        }
    }
}
