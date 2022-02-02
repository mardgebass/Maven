package ru.gb;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginTest {

        @Test
        @DisplayName("Авторизация")
        void successfulAuthTest() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--blink-settings=imagesEnabled=false");

        WebDriver webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
        webDriver.get("https://www.gastronom.ru/");
        webDriver.manage().window().setSize(new Dimension(1300, 720));

        webDriver.findElement(By.xpath(".//span[contains(text(),'Вход')]")).click();
        webDriver.findElement(By.name("Login")).sendKeys("bonita_scavo");
        webDriver.findElement(By.name("Password")).sendKeys("12280912");
        webDriver.findElement(By.xpath(".//input[@value='ВОЙТИ']")).click();

        }

}

