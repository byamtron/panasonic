package com.gmail.sheremetevkiril17.tests;

import com.gmail.sheremetevkiril17.pages.LoginAzure;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;


public class _2_SearchTest {

    private static WebDriver driver;
    private static LoginAzure loginAzure;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
        loginAzure = new LoginAzure(driver);
    }

    @Test
    public void _0_basic_searchCheck() throws Exception {

        loginAzure.loginFlow();

        // Upload new video

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

        WebElement uploadedFile = driver.findElement(By.cssSelector("div .VideoListItem__name__2Pcaf[title = 'kiker_auto']"));
        String uploadedFileResult = uploadedFile.getText();
        Assert.assertEquals("kiker_auto", uploadedFileResult);

    }

    @Test
    public void _1_searchCheck() throws Exception {

        //Проверка поиска по File name

        WebElement fileName = driver.findElement(By.id("field-name"));
        fileName.sendKeys("kiker_auto");
        WebElement searchButton = driver.findElement(By.cssSelector("button.Button__button__3_Ozh.Button__round__2bChK"));
        searchButton.click();

        try{
            Thread.sleep(5000);
        }
        catch(InterruptedException e){
            throw new Exception(e);
        }

        WebElement searchFieldName = driver.findElement(By.cssSelector("div .VideoListItem__name__2Pcaf[title = 'kiker_auto']"));
        String searchFieldNameResult = searchFieldName.getText();
        Assert.assertEquals("kiker_auto", searchFieldNameResult);

    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
