package ru.gb;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class BookEventTest {

    protected static final String URL = "https://www.gastronom.ru/school/schedule";

    @Test
    @DisplayName("Добавить мероприятие в бронирование")
    void addEvent(){

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--blink-settings=imagesEnabled=false");

        WebDriver webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
        webDriver.manage().window().setSize(new Dimension(1300, 720));
        webDriver.get(URL);

        List<WebElement> events = webDriver.findElements(By.xpath(".//div[@class='list-lessons__title']"));
        events.get(1).click();

        webDriver.findElement(By.xpath(".//a[@class='form__button  js-added-to-cart']")).click();

        assertThat(webDriver.findElement(By.xpath(".//a[@id='jsbasket-reserv']")));

    }

}
