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


public class UploadTest {

    private static WebDriver driver;
    private static LoginAzure loginAzure;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
        loginAzure = new LoginAzure(driver);
    }

    @Test
    public void uploadTest() throws Exception {

        loginAzure.loginFlow();

        //Upload New Evidence via Robot class

        WebElement uploadNewEvidance = driver.findElement(By.cssSelector("div .Upload__button__1UKe8"));
        uploadNewEvidance.click();

        StringSelection clipboard = new StringSelection("D:\\kiker.mp4");
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

        if(!driver.findElements(By.cssSelector("div .UploadListItem__success__2-HA0")).isEmpty())
        {
            System.out.println("Test Passed for Upload New Evidence");
        }
        else {
            System.out.println("Test Failed for Upload New Evidence");
        }

        //Check uploaded file on the video list

        WebElement buttonSearch = driver.findElement(By.xpath("//button[@kind = 'round']"));
        buttonSearch.click();

        try{
            Thread.sleep(3000);
        }
        catch(InterruptedException e){
            throw new Exception(e);
        }

        if(!driver.findElements(By.cssSelector("div .VideoList__content__Hy8XE")).isEmpty()) {
            System.out.println("Test Passed for Uploaded Search check");
        }
        else {
            System.out.println("Test Failed for Uploaded Search check");
        }

    }


    /*@AfterClass
    public static void tearDown() {
        driver.quit();
    }*/
}
