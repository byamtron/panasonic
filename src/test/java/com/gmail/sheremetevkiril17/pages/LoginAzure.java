package com.gmail.sheremetevkiril17.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.concurrent.TimeUnit;

public class LoginAzure {

    public LoginAzure(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebDriver driver;

    @FindBy(id = "i0116")
    private WebElement loginField;

    @FindBy(id = "idSIButton9")
    private WebElement loginNext;

    @FindBy(id = "i0118")
    private WebElement passwordField;

    public void loginFlow() throws Exception {

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://panasonic-redaction-stage.oxagile.com");

        loginField.sendKeys("sheremetyevkv@oxagile.com");
        loginNext.click();
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
    }
}

