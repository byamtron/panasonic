package com.gmail.sheremetevkiril17.tests.SmokeTest;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.gmail.sheremetevkiril17.pages.LoginAzureWithUploadNewEvidence;

import java.awt.*;
import java.awt.event.InputEvent;

public class _3_OpenPlayerTest {

    private static WebDriver driver;
    private static LoginAzureWithUploadNewEvidence loginAzureWithUploadNewEvidence;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
        loginAzureWithUploadNewEvidence = new LoginAzureWithUploadNewEvidence(driver);
    }

    @Test
    public void openInPlayerTest() throws Exception {

        loginAzureWithUploadNewEvidence.loginWithUploadNewEvidenceFlow();

        //Open video in player

        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new Exception(e);
        }

        WebElement buttonSearch = driver.findElement(By.xpath("//button[@kind = 'round']"));
        buttonSearch.click();

        try{
            Thread.sleep(2000);
        }
        catch(InterruptedException e){
            throw new Exception(e);
        }

        Robot robot = null;

        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        robot.mouseMove(500, 335);
        robot.delay(500);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(500);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(500);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);


        WebElement playerCloseButton = driver.findElement(By.cssSelector("div.VideoListItem__containerVideo__3u36t > div > button > img"));
        String playerCloseButtonSRC = playerCloseButton.getAttribute("src");
        Assert.assertEquals("https://panasonic-redaction-stage.oxagile.com/assets/images/icon-close-e026df331f3569ec28898ae5795876c4.png", playerCloseButtonSRC);

        //Open full screen video in player

        WebElement openFullScreen = driver.findElement(By.cssSelector("button.VideoListItem__controlBar__a_e--.video-react-icon-fullscreen.video-react-fullscreen-control.video-react-control.video-react-button.video-react-icon"));
        openFullScreen.click();

        WebElement closeFullScreen = driver.findElement(By.cssSelector("button.VideoListItem__controlBar__a_e--.video-react-icon-fullscreen-exit.video-react-fullscreen-control.video-react-control.video-react-button.video-react-icon"));
        String closeFullScreenAttribute = closeFullScreen.getAttribute("className");
        Assert.assertEquals("VideoListItem__controlBar__a_e-- video-react-icon-fullscreen-exit video-react-fullscreen-control video-react-control video-react-button video-react-icon", closeFullScreenAttribute);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new Exception(e);
        }

        //Close full screen video in player

        closeFullScreen.click();

        String openFullScreenAttribute = openFullScreen.getAttribute("className");
        Assert.assertEquals("VideoListItem__controlBar__a_e-- video-react-icon-fullscreen video-react-fullscreen-control video-react-control video-react-button video-react-icon", openFullScreenAttribute);

        //Close player

        WebElement closePlayer = driver.findElement(By.cssSelector("div.VideoListItem__containerVideo__3u36t > div > button > img"));
        closePlayer.click();

        if(driver.findElements(By.cssSelector("div.VideoListItem__containerVideo__3u36t > div > button > img")).isEmpty()) {
            System.out.println("Test Passed for OpenPlayerTests");
        }
        else {
            System.out.println("Test Failed for OpenPlayerTests");
        }

    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
