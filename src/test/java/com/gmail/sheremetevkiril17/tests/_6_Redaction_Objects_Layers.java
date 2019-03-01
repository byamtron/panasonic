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
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

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
    public void _0_redactionObjectsLayers() throws Exception {

        loginAzure.loginFlow();

        //Selected object is displayed in the Object's library

        WebElement uploadNewEvidance = driver.findElement(By.xpath("//label[text() = 'Upload new evidence']"));
        uploadNewEvidance.click();
        StringSelection clipboard = new StringSelection("D:\\kiker_auto.mp4");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(clipboard, null);

        Robot robot = null;

        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        robot.delay(250);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(150);
        robot.keyRelease(KeyEvent.VK_ENTER);

        // Check that upload was successfully via status message

        WebElement resultOfTheUpload = driver.findElement(By.xpath("//span[text() = 'Uploaded!']"));
        String resultsOfTheUpload = resultOfTheUpload.getText();
        Assert.assertEquals("Uploaded!", resultsOfTheUpload);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new Exception(e);
        }

        // Check that upload was successfully via search

        WebElement searchButton = driver.findElement(By.cssSelector("button.Button__button__3_Ozh.Button__round__2bChK"));
        searchButton.click();

        robot.mouseMove(580, 335);
        robot.delay(500);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(500);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(1000);


        try{
            Thread.sleep(4000);
        }
        catch(InterruptedException e){
            throw new Exception(e);
        }

        robot.mouseMove(830, 460);
        robot.delay(500);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseMove(870, 495);
        robot.delay(500);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        //Selected object is displayed in the layers list

        WebElement counterObjects = driver.findElement(By.cssSelector("div.Library__content__3E2Oo > div > div.Scrollable__container__3e-Q5 > div.simplebar-scroll-content > div"));
        String counterObjectsResult = counterObjects.getAttribute("childElementCount");
        Assert.assertEquals("1", counterObjectsResult);

        //Notification "In order to create a new object you need to unselect all the active objects"

        robot.mouseMove(580, 335);
        robot.delay(500);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(500);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(500);


        String notificationCheck = driver.findElement(By.cssSelector("div.Body__container__Lc5IM")).getText();
        Assert.assertEquals("In order to create a new object you need to unselect all the active objects", notificationCheck);

        //Create second object and check it in the Object's library

        WebElement closeNotification = driver.findElement(By.cssSelector("div.Header__container__IgwF0 > button"));
        closeNotification.click();
        WebElement stopEditingLayer1 = driver.findElement(By.cssSelector("div.simplebar-scroll-content > div > div > label > div"));
        stopEditingLayer1.click();

        robot.mouseMove(860, 470);
        robot.delay(500);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseMove(900, 510);
        robot.delay(500);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        //Create second object and check it in the layers list

        WebElement counterObjectsSecond = driver.findElement(By.cssSelector("div.Library__content__3E2Oo > div > div.Scrollable__container__3e-Q5 > div.simplebar-scroll-content > div"));
        String counterObjectsResultSecond = counterObjectsSecond.getAttribute("childElementCount");
        Assert.assertEquals("2", counterObjectsResultSecond);

        WebElement stopEditingLayer2 = driver.findElement(By.cssSelector("div.simplebar-scroll-content > div > div:nth-child(1) > label > div"));
        stopEditingLayer2.click();

        //Start - Stop track

        stopEditingLayer1.click();
        stopEditingLayer2.click();

        WebElement trackButton = driver.findElement(By.xpath("//span[text() = 'track']"));
        trackButton.click();

        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            throw new Exception(e);
        }

        WebElement trackingProgress = driver.findElement(By.xpath("//span[text() = 'stop tracking']"));
        String trackingProgressResult = trackingProgress.getText();
        Assert.assertEquals("stop tracking", trackingProgressResult);

        WebElement stopTrackButton = driver.findElement(By.xpath("//span[text() = 'stop tracking']"));
        stopTrackButton.click();

        //CROP

        WebElement cropButton = driver.findElement(By.cssSelector("button.Button__button__3_Ozh.Timeline__action__1Dma5.Timeline__cut__2Bs_-.Button__bordered__2brn_"));
        cropButton.click();

        robot.mouseMove(830, 860);
        robot.delay(500);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(500);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseMove(970, 860);
        robot.delay(500);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(500);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseMove(1070, 860);
        robot.delay(500);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(500);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseMove(1370, 860);
        robot.delay(500);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(500);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseMove(1570, 860);
        robot.delay(500);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(500);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseMove(1680, 860);
        robot.delay(500);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(500);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseMove(1760, 860);
        robot.delay(500);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(500);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseMove(1810, 860);
        robot.delay(500);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(500);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new Exception(e);
        }

        WebElement saveVideoButton = driver.findElement(By.xpath("//span[text() = 'Save']"));
        saveVideoButton.click();

        WebElement saveVideoResult = driver.findElement(By.xpath("//span[text() = 'Saved']"));
        String saveVideoResultSuccess = saveVideoResult.getText();
        Assert.assertEquals("Saved", saveVideoResultSuccess);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new Exception(e);
        }

        WebElement applyAndSave = driver.findElement(By.xpath("//span[text() = 'Apply and save as new']"));
        applyAndSave.click();

        WebElement videoName = driver.findElement(By.id("field-name"));
        videoName.sendKeys("auto_kiker");
        WebElement saveButton = driver.findElement(By.cssSelector("div.Group__container__3P5ab.ChildVideoForm__actions__1UARV > button"));
        saveButton.click();

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            throw new Exception(e);
        }

        WebElement refreshButton = driver.findElement(By.cssSelector("div.FileManager__title__2nHOs > button"));
        refreshButton.click();

        robot.mouseMove(280, 355);
        robot.delay(500);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new Exception(e);
        }

        robot.mouseMove(281, 356);
        robot.delay(500);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);


        WebElement startVA = driver.findElement(By.cssSelector("a.FileManagerItem__item__XUKtC.FileManagerItem__active__14jST > div > button:nth-child(2)"));
        startVA.click();

        WebElement vaProgress = driver.findElement(By.xpath("//span[text() = 'Please wait while the video file is processing']"));
        String checkVAProgress = vaProgress.getText();
        Assert.assertEquals("Please wait while the video file is processing", checkVAProgress);

        WebElement checkVA = driver.findElement(By.cssSelector("div.RedactionPage__disableEditorAndLibraryColumns__2W0s9 > div > button"));

        try {
            Thread.sleep(25000);
        } catch (InterruptedException e) {
            throw new Exception(e);
        }

        checkVA.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new Exception(e);
        }

        WebElement counterObjectsVA = driver.findElement(By.cssSelector("div.Library__content__3E2Oo > div > div.Scrollable__container__3e-Q5 > div.simplebar-scroll-content > div"));
        String counterObjectsResultVA = counterObjectsVA.getAttribute("childElementCount");
        Assert.assertEquals("2", counterObjectsResultVA);
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

}