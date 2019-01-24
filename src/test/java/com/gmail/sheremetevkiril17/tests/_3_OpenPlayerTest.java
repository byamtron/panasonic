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

        //Open video in player

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
            robot.delay(500);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        }
        catch (AWTException e)
        {
            throw new Exception(e);
        }

        if(!driver.findElements(By.cssSelector("div.VideoListItem__containerVideo__3u36t > div > button > img")).isEmpty()) {
            System.out.println("Test Passed for open in player check");
        }
        else {
            System.out.println("Test Failed for open in player check");
        }

        //Open full screen video in player

        WebElement openInFullScreen = driver.findElement(By.cssSelector("button.VideoListItem__controlBar__a_e--.video-react-icon-fullscreen.video-react-fullscreen-control.video-react-control.video-react-button.video-react-icon"));
        openInFullScreen.click();

        if(!driver.findElements(By.cssSelector("button.VideoListItem__controlBar__a_e--.video-react-icon-fullscreen-exit.video-react-fullscreen-control.video-react-control.video-react-button.video-react-icon")).isEmpty()) {
            System.out.println("Test Passed for open full screen in player check");
        }
        else {
            System.out.println("Test Failed for open full screen in player check");
        }

        //Close full screen video in player

        WebElement closeFullScreen = driver.findElement(By.cssSelector("button.VideoListItem__controlBar__a_e--.video-react-icon-fullscreen-exit.video-react-fullscreen-control.video-react-control.video-react-button.video-react-icon"));
        closeFullScreen.click();

        if(!driver.findElements(By.cssSelector("div.VideoListItem__containerVideo__3u36t > div > button > img")).isEmpty()) {
            System.out.println("Test Passed for close from full screen check");
        }
        else {
            System.out.println("Test Failed for close from full screen check");
        }

        //Close player

        WebElement closePlayer = driver.findElement(By.cssSelector("div.VideoListItem__containerVideo__3u36t > div > button > img"));
        closePlayer.click();

        if(driver.findElements(By.cssSelector("div.VideoListItem__containerVideo__3u36t > div > button > img")).isEmpty()) {
            System.out.println("Test Passed for close player check");
        }
        else {
            System.out.println("Test Failed for close player check");
        }

    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
