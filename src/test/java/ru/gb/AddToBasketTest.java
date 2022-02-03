package ru.gb;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class AddToBasketTest {

    protected static final String URL = "https://www.gastronom.ru/school/schedule";

    @Test
    void add() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--blink-settings=imagesEnabled=false");

        WebDriver webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
        webDriver.manage().window().setSize(new Dimension(1300, 720));
        webDriver.get(URL);

        List<WebElement> events = webDriver.findElements(By.xpath(".//article[@class='list-lessons col-xs-12 col-sm-4']"));
        events.get(1).click();





    }

}
