package com.gmail.sheremetevkiril17.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.gmail.sheremetevkiril17.pages.LoginAzure;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;


public class _3_OpenPlayerTest {

    private static WebDriver driver;
    private static LoginAzure loginAzure;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
        loginAzure = new LoginAzure(driver);
    }

    @Test
    public void openInPlayerTest() throws Exception {

        loginAzure.loginFlow();

        //Upload New Evidence via Robot class

        WebElement uploadNewEvidance = driver.findElement(By.cssSelector("div .Upload__button__1UKe8"));
        uploadNewEvidance.click();


    }


    /*@AfterClass
    public static void tearDown() {
        driver.quit();
    }*/
}
