package com.gmail.sheremetevkiril17.tests;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.gmail.sheremetevkiril17.pages.LoginAzure;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class _1_Login_Multitenancy_Localization {

    private static WebDriver driver;
    private static LoginAzure loginAzure;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
        loginAzure = new LoginAzure(driver);
    }

    @Test
    public void _0_userLogin() throws Exception {

        // Login to the application

        loginAzure.loginFlow();

        // Upload new video for the first Azure Directory

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
    public void _1_userLogout() {

        WebElement buttonLogOut = driver.findElement(By.xpath("//span[text() = 'Log out']"));
        buttonLogOut.click();

        // Check that logout was successfully

        WebElement loginHeader = driver.findElement(By.id("loginHeader"));
        String logoutResult = loginHeader.getText();
        Assert.assertEquals("Sign in", logoutResult);

    }

    @Test
    public void _2_anotherUserLogin() throws Exception {

        // Login by another user with incorrect credentials for the second Azure Directory

        WebElement loginField = driver.findElement(By.id("i0116"));
        loginField.sendKeys("user1@redadtest1.onmicrosoft.com");
        WebElement loginNext = driver.findElement(By.id("idSIButton9"));
        loginNext.click();
        WebElement passwordField = driver.findElement(By.id("i0118"));
        passwordField.sendKeys("Maba6422!");

        Robot robot = null;

        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        robot.mouseMove(1100, 665);
        robot.delay(500);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(500);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(500);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(500);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        // Check that user doesn't login with incorrect credentials

        WebElement passwordError = driver.findElement(By.id("passwordError"));
        String passwordErrorResult = passwordError.getText();
        Assert.assertEquals("Your account or password is incorrect. If you don't remember your password, reset it now.", passwordErrorResult);

        // Login by another user with correct credentials for the second Azure Directory

        WebElement passwordFieldAD = driver.findElement(By.id("i0118"));
        passwordFieldAD.sendKeys("Maba6421!");

        robot.mouseMove(1050, 685);
        robot.delay(500);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(500);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(500);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(500);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

    }

    @Test
    public void _3_differentAzureDirectoriesAndLocalization() throws Exception {

        // Check that users have different Azure Directories

        WebElement searchButton = driver.findElement(By.cssSelector("button.Button__button__3_Ozh.Button__round__2bChK"));
        WebElement fileName = driver.findElement(By.id("field-name"));
        fileName.sendKeys("kiker_auto");
        searchButton.click();

        try{
            Thread.sleep(3000);
        }
        catch(InterruptedException e){
            throw new Exception(e);
        }

        WebElement noResults = driver.findElement(By.xpath("//span[text() = 'No results.']"));
        String noResultsMessage = noResults.getText();
        Assert.assertEquals("No results.", noResultsMessage);

        // Localization

        driver.navigate().to("https://panasonic-redaction-stage.oxagile.com?lang=ru");

        try{
            Thread.sleep(3000);
        }
        catch(InterruptedException e){
            throw new Exception(e);
        }

        WebElement noResultsRU = driver.findElement(By.xpath("//span[text() = 'Нет результатов...']"));
        String noResultsMessageRU = noResultsRU.getText();
        Assert.assertEquals("Нет результатов...", noResultsMessageRU);
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}