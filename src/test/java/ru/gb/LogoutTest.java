package ru.gb;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutTest extends BaseTest {

    @Test
    public void logout(){

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--blink-settings=imagesEnabled=false");

        WebDriver webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
        webDriver.manage().window().setSize(new Dimension(1300, 720));

        webDriver.findElement(By.cssSelector(".new-user-panel__avatar_mobile-no")).click();
        webDriver.findElement(By.linkText("Выход")).click();

    }

    }

