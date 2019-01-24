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
import java.awt.event.InputEvent;

public class _5_RedactionPlayerTest {

    private static WebDriver driver;
    private static LoginAzure loginAzure;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
        loginAzure = new LoginAzure(driver);
    }

    @Test
    public void redactionPlayerTest() throws Exception {

        loginAzure.loginFlow();

        //Play video in Redaction player

        WebElement buttonSearch = driver.findElement(By.xpath("//button[@kind = 'round']"));
        buttonSearch.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new Exception(e);
        }

        try {
            Robot robot = new Robot();
            robot.mouseMove(580, 335);
            robot.delay(500);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(500);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(1000);

        } catch (AWTException e) {
            throw new Exception(e);
        }

        try{
            Thread.sleep(3000);
        }
        catch(InterruptedException e){
            throw new Exception(e);
        }

        WebElement buttonPlayVideo = driver.findElement(By.cssSelector("button[title=Play]"));
        buttonPlayVideo.click();

        if (!driver.findElements(By.cssSelector("button[title=Pause]")).isEmpty()) {
            System.out.println("Test Passed for play video in Redaction player check");
        } else {
            System.out.println("Test Failed for play video in Redaction player check");
        }

        try{
            Thread.sleep(3000);
        }
        catch(InterruptedException e){
            throw new Exception(e);
        }

        WebElement buttonPauseVideo = driver.findElement(By.cssSelector("button[title=Pause]"));
        buttonPauseVideo.click();

        if (!driver.findElements(By.cssSelector("button[title=Play]")).isEmpty()) {
            System.out.println("Test Passed for pause video in Redaction player check");
        } else {
            System.out.println("Test Failed for pause video in Redaction player check");
        }

    }

    /*@AfterClass
    public static void tearDown() {
        driver.quit();
    }*/

}
