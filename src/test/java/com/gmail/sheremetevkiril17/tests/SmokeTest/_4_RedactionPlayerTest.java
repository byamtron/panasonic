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

public class _4_RedactionPlayerTest {

    private static WebDriver driver;
    private static LoginAzureWithUploadNewEvidence loginAzureWithUploadNewEvidence;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
        loginAzureWithUploadNewEvidence = new LoginAzureWithUploadNewEvidence(driver);
    }

    @Test
    public void openInRedactionPlayerTest() throws Exception {

        loginAzureWithUploadNewEvidence.loginWithUploadNewEvidenceFlow();

        //Open video in redaction player

        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new Exception(e);
        }

        WebElement buttonSearch = driver.findElement(By.xpath("//button[@kind = 'round']"));
        buttonSearch.click();

        Robot robot = null;

        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        robot.mouseMove(580, 335);
        robot.delay(500);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(500);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(1000);


        WebElement titleVideo = driver.findElement(By.cssSelector("div.Editor__header__1pafx > div"));
        String titleVideoAttribute = titleVideo.getAttribute("innerHTML");
        Assert.assertEquals("kiker_auto", titleVideoAttribute);

        WebElement buttonPlayVideo = driver.findElement(By.cssSelector("button[title=Play]"));
        buttonPlayVideo.click();

        WebElement buttonPauseVideo = driver.findElement(By.cssSelector("button[title=Pause]"));
        String buttonPauseVideoAttribute = buttonPauseVideo.getAttribute("title");
        Assert.assertEquals("Pause", buttonPauseVideoAttribute);

        try{
            Thread.sleep(3000);
        }
        catch(InterruptedException e){
            throw new Exception(e);
        }

        buttonPauseVideo.click();

        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
            throw new Exception(e);
        }

        WebElement framesInfo = driver.findElement(By.cssSelector("span.ProgressIndicator__frameNumber__1woGj"));
        String framesInfoAttribute = framesInfo.getAttribute("innerText");
        Assert.assertEquals("(91)", framesInfoAttribute);

        WebElement previousFrame = driver.findElement(By.xpath("//button[@title = 'To the previous frame']"));
        previousFrame.click();

        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
            throw new Exception(e);
        }

        previousFrame.click();

        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
            throw new Exception(e);
        }

        framesInfoAttribute = framesInfo.getAttribute("innerText");
        Assert.assertEquals("(89)", framesInfoAttribute);

        WebElement nextFrame = driver.findElement(By.xpath("//button[@title = 'To the next frame']"));
        nextFrame.click();

        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
            throw new Exception(e);
        }

        nextFrame.click();

        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
            throw new Exception(e);
        }

        nextFrame.click();

        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
            throw new Exception(e);
        }

        framesInfoAttribute = framesInfo.getAttribute("innerText");
        Assert.assertEquals("(92)", framesInfoAttribute);

        WebElement endFrame = driver.findElement(By.xpath("//button[@title = 'To the end']"));
        endFrame.click();

        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
            throw new Exception(e);
        }

        framesInfoAttribute = framesInfo.getAttribute("innerText");
        Assert.assertEquals("(1296)", framesInfoAttribute);

        WebElement beginningFrame = driver.findElement(By.xpath("//button[@title = 'To the beginning']"));
        beginningFrame.click();

        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
            throw new Exception(e);
        }

        framesInfoAttribute = framesInfo.getAttribute("innerText");
        Assert.assertEquals("(1)", framesInfoAttribute);

    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

}