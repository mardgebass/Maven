package ru.gb;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class SearchTest {

    protected static final String URL = "https://www.gastronom.ru";

    @DisplayName("Поиск")
    @ParameterizedTest
    @ValueSource(strings = {"груш", "печен", "торт"})
    public void searchTest(String searchRequest){

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--blink-settings=imagesEnabled=false");

        WebDriver webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
        webDriver.manage().window().setSize(new Dimension(1300, 720));
        webDriver.get(URL);

        webDriver.findElement(By.xpath(".//input[@id='js-search-input']")).sendKeys(searchRequest);
        webDriver.findElement(By.xpath(".//input[contains(@class,'new-header__search-submit')]")).click();

        List<WebElement> events = webDriver.findElements(By.xpath(".//a[@class='material-anons__title']"));
        events.get(0).click();

        List<WebElement> results = webDriver.findElements(By.xpath(".//a[@class='material-anons__title']"));

        assertThat(results.contains(searchRequest));

    }

}
