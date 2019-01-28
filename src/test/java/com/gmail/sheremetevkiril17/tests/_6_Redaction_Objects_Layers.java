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
            Thread.sleep(3000);
        }
        catch(InterruptedException e){
            throw new Exception(e);
        }

        try {
            Robot robot = new Robot();
            robot.mouseMove(890, 485);
            robot.delay(500);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseMove(930, 520);
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

    }

    /*@AfterClass
    public static void tearDown() {
        driver.quit();
    }*/

}