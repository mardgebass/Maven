package ru.gb.pages;

import static com.codeborne.selenide.Selenide.$$x;

public class AllEventsPage extends BasePage {

    public EventPage selectEvent(){

        $$x(".//div[@class='list-lessons__title']")
        .get(1).click();
        return new EventPage();

    }

}
