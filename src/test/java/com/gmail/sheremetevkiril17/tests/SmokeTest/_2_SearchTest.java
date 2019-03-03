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


public class _2_SearchTest {

    private static WebDriver driver;
    private static LoginAzureWithUploadNewEvidence loginAzureWithUploadNewEvidence;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
        loginAzureWithUploadNewEvidence = new LoginAzureWithUploadNewEvidence(driver);
    }

    @Test
    public void _0_basic_searchCheck() throws Exception {

        loginAzureWithUploadNewEvidence.loginWithUploadNewEvidenceFlow();


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
