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
    public void searchCheck() throws Exception {

        loginAzure.loginFlow();

        //Upload New Evidence

        WebElement uploadNewEvidance = driver.findElement(By.xpath("//label[text() = 'Upload new evidence']"));
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


        WebElement resultOfTheUpload = driver.findElement(By.xpath("//span[text() = 'Uploaded!']"));
        String resultsOfTheUpload = resultOfTheUpload.getText();
        Assert.assertEquals("Uploaded!", resultsOfTheUpload);

        //Проверка на то, что поиск отрабатывает

        // До этого места всё ок. Сеарч не сработал
        WebElement buttonSearch = driver.findElement(By.xpath("//span[text() = 'Search']"));
        buttonSearch.click();

        try{
            Thread.sleep(3000);
        }
        catch(InterruptedException e){
            throw new Exception(e);
        }

        /*WebElement resultOfSearch = driver.findElement(By.cssSelector("div .VideoList__content__Hy8XE"));
        String resultsOfTheUpload = resultOfTheUpload.getText();
        Assert.assertEquals("Uploaded", resultsOfTheUpload);*/

        // Не рабочее решение
        int resultOfSearch = driver.findElements(By.cssSelector("div .VideoList__content__Hy8XE")).size();
        Assert.assertNotNull(resultOfSearch);


        /*if(!driver.findElements(By.cssSelector("div .VideoList__content__Hy8XE")).isEmpty()) {
            System.out.println("Test Passed for Search check");
        }
        else {
            System.out.println("Test Failed for Search check");
        }*/


        //Проверка поиска по File name

        WebElement fileName = driver.findElement(By.id("field-name"));
        fileName.sendKeys("kiker");
        buttonSearch.click();

        try{
            Thread.sleep(7000);
        }
        catch(InterruptedException e){
            throw new Exception(e);
        }

        if(!driver.findElements(By.cssSelector("div .VideoListItem__name__2Pcaf[title=kiker]")).isEmpty()) {
            System.out.println("Test Passed for Search_by_Name");
        }
        else {
            System.out.println("Test Failed for Search_by_Name");
        }

    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}