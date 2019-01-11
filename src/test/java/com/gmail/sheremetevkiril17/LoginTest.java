package com.gmail.sheremetevkiril17;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.concurrent.TimeUnit;

public class LoginTest {

    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://panasonic-redaction-qa.oxagile.com");
    }

    @Test
    public void userLogin() throws Exception {
        WebElement loginField = driver.findElement(By.id("i0116"));
        loginField.sendKeys("sheremetyevkv@oxagile.com");
        WebElement loginNext = driver.findElement(By.id("idSIButton9"));
        loginNext.click();
        WebElement passwordField = driver.findElement(By.id("i0118"));
        passwordField.sendKeys("Rbhfrtyqwe1723");
        try {
            Robot robot = new Robot();
            robot.mouseMove(1100, 665);
            robot.delay(500);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(500);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        }
        catch (AWTException e)
        {
            throw new Exception(e);
        }

        /*WebElement profileUser = driver.findElement(By.cssSelector(".login-button__user"));
        String mailUser = profileUser.getText();
        Assert.assertEquals("autotestorgua@ukr.net", mailUser);*/

    }

/*    @AfterClass
    public static void tearDown() {
        WebElement menuUser = driver.findElement(By.cssSelector(".login-button__menu-icon"));
        menuUser.click();
        WebElement logoutButton = driver.findElement(By.id("login__logout"));
        logoutButton.click();
        driver.quit();
    }*/
}