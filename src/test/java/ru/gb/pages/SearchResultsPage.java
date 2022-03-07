package ru.gb.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchResultsPage extends BasePage{


    public SearchResultsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Клик на кнопку выход")
    public SearchResultsPage assertResults(String searchRequest){

        assertTrue(webDriver.findElement(By.xpath(".//a[@class='material-anons__title']")).getText().contains(searchRequest));

    return this;
    }








}
