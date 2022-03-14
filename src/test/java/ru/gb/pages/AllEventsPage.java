package ru.gb.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AllEventsPage extends BasePage{

    public AllEventsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Выбрать мероприятие")
    public EventPage selectEvent(){
        webDriver.findElements(By.xpath(".//div[@class='list-lessons__title']"))
                .get(0).click();
        return new EventPage(webDriver);

    }


}
