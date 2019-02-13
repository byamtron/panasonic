package com.gmail.sheremetevkiril17.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;

import com.gmail.sheremetevkiril17.pages.LoginAzure;

import java.awt.*;
import java.awt.event.InputEvent;

public class _6_Redaction_Objects_Layers {
    private static WebDriver driver;
    private static LoginAzure loginAzure;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
        loginAzure = new LoginAzure(driver);
    }

    @Test
    public void redactionObjectsLayers() throws Exception {

        loginAzure.loginFlow();

        //Selected object is displayed in the Object's library

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
            Thread.sleep(4000);
        }
        catch(InterruptedException e){
            throw new Exception(e);
        }

        try {
            Robot robot = new Robot();
            robot.mouseMove(830, 460);
            robot.delay(500);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseMove(870, 495);
            robot.delay(500);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        }
        catch (AWTException e)
        {
            throw new Exception(e);
        }


        if (!driver.findElements(By.cssSelector("div.simplebar-scroll-content > div > div > button")).isEmpty()) {
            System.out.println("Test Passed for selected object is displayed in the Object's library");
        } else {
            System.out.println("Test Failed for selected object is displayed in the Object's library");
        }


        //Selected object is displayed in the layers list

        if (!driver.findElements(By.cssSelector("div.LayerListItem__columnLeft__3RUV3 > div")).isEmpty()) {
            System.out.println("Test Passed for selected object is displayed in the layers list");
        } else {
            System.out.println("Test Failed for selected object is displayed in the layers list");
        }

        //Notification "In order to create a new object you need to unselect all the active objects"

        try {
            Robot robot = new Robot();
            robot.mouseMove(580, 335);
            robot.delay(500);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(500);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(500);

        } catch (AWTException e) {
            throw new Exception(e);
        }


        String notificationCheck = driver.findElement(By.cssSelector("div.Body__container__Lc5IM")).getText();
        Assert.assertEquals("In order to create a new object you need to unselect all the active objects", notificationCheck);

        //Create second object and check it in the Object's library

        WebElement closeNotification = driver.findElement(By.cssSelector("div.Header__container__IgwF0 > button"));
        closeNotification.click();
        WebElement stopEditingLayer1 = driver.findElement(By.cssSelector("div.simplebar-scroll-content > div > div > label > div"));
        stopEditingLayer1.click();

        try {
            Robot robot = new Robot();
            robot.mouseMove(860, 470);
            robot.delay(500);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseMove(900, 510);
            robot.delay(500);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        }
        catch (AWTException e)
        {
            throw new Exception(e);
        }

        int objectsCount = driver.findElements(By.cssSelector("div.simplebar-scroll-content > div > div > button")).size();
        Assert.assertEquals(2, objectsCount);

        //Create second object and check it in the layers list

        int layersCount = driver.findElements(By.cssSelector("div.LayerListItem__columnLeft__3RUV3 > div")).size();
        Assert.assertEquals(2, layersCount);

        WebElement stopEditingLayer2 = driver.findElement(By.cssSelector("div.simplebar-scroll-content > div > div:nth-child(1) > label > div"));
        stopEditingLayer2.click();

        //Start - Stop track

        WebElement selectAll = driver.findElement(By.cssSelector("div.Properties__control__24jBs > label"));
        selectAll.click();
        WebElement trackButton = driver.findElement(By.xpath("//span[text() = 'track']"));
        trackButton.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new Exception(e);
        }

        WebElement trackingProgress = driver.findElement(By.xpath("//span[text() = 'stop tracking']"));
        String trackingProgressResult = trackingProgress.getText();
        Assert.assertEquals("stop tracking", trackingProgressResult);

        WebElement stopTrackButton = driver.findElement(By.xpath("//span[text() = 'stop tracking']"));
        stopTrackButton.click();

        //VA

        try {
            Robot robot = new Robot();
            robot.mouseMove(380, 325);
            robot.delay(500);

        } catch (AWTException e) {
            throw new Exception(e);
        }


        WebElement startVA = driver.findElement(By.cssSelector("div.simplebar-scroll-content > div > a > div > button:nth-child(2)"));
        startVA.click();
        WebElement yesStartVA = driver.findElement(By.xpath("//span[text() = 'Yes']"));
        yesStartVA.click();

        WebElement vaProgress = driver.findElement(By.xpath("//span[text() = 'Please wait while the video file is processing']"));
        String checkVAProgress = vaProgress.getText();
        Assert.assertEquals("11Please wait while the video file is processing", checkVAProgress);


    }

    /*@AfterClass
    public static void tearDown() {
        driver.quit();
    }*/

}