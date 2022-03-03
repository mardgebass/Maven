package ru.gb.norefactoring;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

public class BaseTest {

        protected String login = "bonita_scavo";
        protected String password = "12280912";
        protected static final String URL = "https://www.gastronom.ru/";

        protected WebDriver webDriver;

        @BeforeEach
        void setUp() {

                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--blink-settings=imagesEnabled=false");

                webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
                webDriver.manage().window().setSize(new Dimension(1300, 720));
                webDriver.get(URL);

                webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        webDriver.findElement(By.xpath(".//span[contains(text(),'Вход')]")).click();
        webDriver.findElement(By.name("Login")).sendKeys(login);
        webDriver.findElement(By.name("Password")).sendKeys(password);
        webDriver.findElement(By.xpath(".//input[@value='ВОЙТИ']")).click();
        }

        @AfterEach
        void tearDown() {
                webDriver.quit();
        }

    }
