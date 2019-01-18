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


public class SearchTest {

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

        //Проверка на то, что поиск отрабатывает (если есть хоть оидн видос предзагруженный)
        WebElement buttonSearch = driver.findElement(By.xpath("//button[@kind = 'round']"));
        buttonSearch.click();

        try{
            Thread.sleep(3000);
        }
        catch(InterruptedException e){
            throw new Exception(e);
        }

        if(!driver.findElements(By.cssSelector("div .VideoList__content__Hy8XE")).isEmpty()) {
            System.out.println("Test Passed for Search check");
        }
        else {
            System.out.println("Test Failed for Search check");
        }

        //Проверка, что по дефолту сортировка по убыванию

        if(driver.findElements(By.cssSelector("img.VideoList__sortImage__2I0nO.VideoList__sortImageAsc__oNKk3")).isEmpty()) {
            System.out.println("Test Passed for Sorting");
        }
        else {
            System.out.println("Test Failed for Sorting");
        }

        /*WebElement buttonSearch = driver.findElement(By.xpath("//button[@kind = 'round']"));
        String loginResult = buttonSearch.getText();
        Assert.assertEquals("SEARCH", loginResult);*/

    }

    /*@AfterClass
    public static void tearDown() {
        driver.quit();
    }*/
}