package ru.gb.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.gb.pages.AllEventsPage;

public class BookEventTest extends BaseTest{

    @Test
    @DisplayName("Добавить мероприятие в бронирование")
    void addEventTest(){

        webDriver.get("https://www.gastronom.ru/school/schedule");

        new AllEventsPage(webDriver).selectEvent()
                .addToCart()
                .checkBooking();
    }

}
