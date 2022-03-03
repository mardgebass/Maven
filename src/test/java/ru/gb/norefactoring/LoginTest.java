package ru.gb.norefactoring;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

                new WebDriverWait(webDriver,3).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//span[contains(@class, 'new-user-panel__name_with-shadow')]")));

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

                new WebDriverWait(webDriver,3).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//div[@class='validation-summary-errors text-danger']")));

        }

        @Test
        @DisplayName("Авторизация через куки")
        void cookieLoginTest() {

                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--blink-settings=imagesEnabled=false");

                webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
                webDriver.manage().window().setSize(new Dimension(1300, 720));

                webDriver.get("https://www.gastronom.ru/Account/Login?ReturnUrl=%2f");

                webDriver.manage().addCookie(new Cookie("__RequestVerificationToken", "uoRwihtWD2sSOpoSepyUx7JHM__dof0zoCrm9_F3u5jLnmMHX8VgTiNdqHakANOR"));

                webDriver.get(URL);

                new WebDriverWait(webDriver,3).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//span[contains(@class, 'new-user-panel__name_with-shadow')]")));

        }

}

