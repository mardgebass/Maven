package ru.gb;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest {

        protected String login = "bonita_scavo";
        protected String password = "12280912";
        protected String falsePassword = "11111111";
        protected static final String URL = "https://www.gastronom.ru/";

        protected WebDriver webDriver;

        @Test
        @DisplayName("Авторизация+")
        void LoginTest() {

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

                assertThat(webDriver.findElement(By.xpath(".//span[contains(@class, 'new-user-panel__name_with-shadow')]")));

        }

        @Test
        @DisplayName("Авторизация-")
        void falseLoginTest() {

                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--blink-settings=imagesEnabled=false");

                webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
                webDriver.manage().window().setSize(new Dimension(1300, 720));
                webDriver.get(URL);

                webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

                webDriver.findElement(By.xpath(".//span[contains(text(),'Вход')]")).click();
                webDriver.findElement(By.name("Login")).sendKeys(login);
                webDriver.findElement(By.name("Password")).sendKeys(falsePassword);
                webDriver.findElement(By.xpath(".//input[@value='ВОЙТИ']")).click();

                assertThat(webDriver.findElement(By.xpath(".//div[@class='validation-summary-errors text-danger']")));

        }

}

