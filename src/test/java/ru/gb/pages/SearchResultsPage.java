package ru.gb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchResultsPage extends BasePage{


    public SearchResultsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public SearchResultsPage assertResults(String searchRequest){

        List<WebElement> results = webDriver.findElements(By.xpath(".//a[@class='material-anons__title']"));
        assertThat(results.contains(searchRequest));

    return this;
    }








}
