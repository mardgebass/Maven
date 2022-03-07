package ru.gb.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage extends BasePage{

    public SearchPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Выбрать рубрику")
    public SearchResultsPage chooseRubric(){
        List<WebElement> events = webDriver.findElements(By.xpath(".//a[@class='material-anons__title']"));
        events.get(0).click();
    return new SearchResultsPage(webDriver);
    }

}
