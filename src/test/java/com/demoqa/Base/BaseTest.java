package com.demoqa.Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.demoqa.Utils.ConfigReader;
import com.demoqa.reports.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    protected static final ExtentReports extent =
            ExtentManager.getInstance();

    public static WebDriver getDriver() {
        return driver.get();
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {

        try {

            String browser = ConfigReader.getProperty("browser");
            String url = ConfigReader.getProperty("url");
            int implicitWait = ConfigReader.getIntProperty("implicitWait");

            System.out.println("Browser from config = " + browser);
            System.out.println("URL from config = " + url);

            if (browser == null || browser.trim().isEmpty()) {
                throw new RuntimeException(
                        "Browser value is missing in config.properties");
            }

            if (url == null || url.trim().isEmpty()) {
                throw new RuntimeException(
                        "URL value is missing in config.properties");
            }

            WebDriver webDriver;

            switch (browser.toLowerCase().trim()) {

                case "chrome":
//                    WebDriverManager.chromedriver().setup();
                    webDriver = new ChromeDriver();
                    break;

                case "firefox":
//                    WebDriverManager.firefoxdriver().setup();
                    webDriver = new FirefoxDriver();
                    break;

                case "edge":
//                    WebDriverManager.edgedriver().setup();
                    webDriver = new EdgeDriver();
                    break;

                default:
                    throw new IllegalArgumentException(
                            "Unsupported browser: " + browser);
            }

            driver.set(webDriver);

            getDriver().manage().window().maximize();
            getDriver().manage().deleteAllCookies();

            getDriver().manage().timeouts()
                    .implicitlyWait(Duration.ofSeconds(implicitWait));

            getDriver().get(url);

            System.out.println("=================================");
            System.out.println("Browser : " + browser);
            System.out.println("URL     : " + url);
            System.out.println("=================================");

        } catch (Exception e) {

            System.out.println("SETUP FAILED");
            e.printStackTrace();

            throw new RuntimeException("Browser initialization failed", e);
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        try {

            if (getDriver() != null) {
                getDriver().quit();
            }

        } catch (Exception e) {

            System.out.println("Failed to close browser");
            e.printStackTrace();

        } finally {

            driver.remove();

            if (extent != null) {
                extent.flush();
            }
        }
    }
}