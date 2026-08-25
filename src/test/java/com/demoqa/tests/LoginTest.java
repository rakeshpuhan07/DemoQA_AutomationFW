package com.demoqa.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import com.demoqa.Base.*;
import io.github.bonigarcia.wdm.WebDriverManager;
@Test
public class LoginTest extends BaseTest {

    @BeforeMethod
    public void setup() {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();


        getDriver().manage().window().maximize();
    }

    @Test
    public void googleTest() {

        getDriver().get("https://www.google.com");

        Assert.assertEquals(
                getDriver().getTitle(),
                "Incorrect Title");
    }

    @AfterMethod
    public void tearDown() {

        if (getDriver() != null) {
            getDriver().quit();
        }
    }
}
