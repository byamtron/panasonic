package com.gmail.sheremetevkiril17.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class LoginAzureWithUploadNewEvidence {

    public LoginAzureWithUploadNewEvidence(WebDriver driver) {
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

    @FindBy(xpath = "//label[text() = 'Upload new evidence']")
    private WebElement uploadNewEvidence;

    public void loginWithUploadNewEvidenceFlow() throws Exception {

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://panasonic-redaction-stage.oxagile.com");

        loginField.sendKeys("sheremetyevkv@oxagile.com");
        loginNext.click();
        passwordField.sendKeys("Rbhfrtyqwe1723");

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
        robot.mouseMove(1110, 675);
        robot.delay(500);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(500);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(1000);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(1000);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(1000);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(1000);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        uploadNewEvidence.click();
        StringSelection clipboard = new StringSelection("D:\\kiker_auto.mp4");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(clipboard, null);

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

    }
}

