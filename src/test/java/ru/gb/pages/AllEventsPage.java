package ru.gb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AllEventsPage extends BasePage {

    public AllEventsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public EventPage selectEvent(){

        List<WebElement> events = webDriver.findElements(By.xpath(".//div[@class='list-lessons__title']"));
        events.get(1).click();
        return new EventPage(webDriver);

    }

}
