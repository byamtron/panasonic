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

        //Open In Player

        WebElement buttonSearch = driver.findElement(By.xpath("//button[@kind = 'round']"));
        buttonSearch.click();

        try{
            Thread.sleep(3000);
        }
        catch(InterruptedException e){
            throw new Exception(e);
        }

        try {
            Robot robot = new Robot();
            robot.mouseMove(500, 335);
            robot.delay(500);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(500);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        }
        catch (AWTException e)
        {
            throw new Exception(e);
        }

        WebElement openInPlayer = driver.findElement(By.xpath("//button[@title = 'Open in player']"));
        openInPlayer.click();


    }


    /*@AfterClass
    public static void tearDown() {
        driver.quit();
    }*/
}
