package com.gmail.sheremetevkiril17.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;

import com.gmail.sheremetevkiril17.pages.LoginAzure;

public class LoginTest {

    private static WebDriver driver;
    private static LoginAzure loginAzure;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
        loginAzure = new LoginAzure(driver);
    }

    @Test
    public void userLogin() throws Exception {

        loginAzure.loginFlow();

        WebElement buttonSearch = driver.findElement(By.xpath("//button[@kind = 'round']"));
        String loginResult = buttonSearch.getText();
        Assert.assertEquals("SEARCH", loginResult);

    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}